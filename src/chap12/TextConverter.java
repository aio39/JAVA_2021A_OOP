package chap12;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class TextConverter extends JFrame {
    JButton converter;
    JButton canceler;
    JTextArea textIn;
    JTextArea textOut;
    public String translatedString;

    public String jsonParsingAndGetTranslated(String json) {
        try {
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObj = (JSONObject) jsonParser.parse(json);
            System.out
                    .println(((JSONObject) ((JSONObject) jsonObj.get("message")).get("result")).get("translatedText"));
            translatedString = (String) ((JSONObject) ((JSONObject) jsonObj.get("message")).get("result"))
                    .get("translatedText");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return translatedString;
    }

    public static String papago(String korea) {
        Properties myprops = new Properties();
        try {
            File file = new File("src/chap12/papago.properties");
            myprops.load(new FileReader(file));
        } catch (Exception e) {
            // TODO: handle exception
        }

        String clientId = myprops.getProperty("CLIENT_ID");// 애플리케이션 클라이언트 아이디값";
        String clientSecret = myprops.getProperty("SECRET_KEY");// 애플리케이션 클라이언트 시크릿값";

        String apiURL = "https://openapi.naver.com/v1/papago/n2mt";
        String text;
        try {
            text = URLEncoder.encode(korea, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("인코딩 실패", e);
        }

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("X-Naver-Client-Id", clientId);
        requestHeaders.put("X-Naver-Client-Secret", clientSecret);

        String responseBody = post(apiURL, requestHeaders, text);

        return responseBody;
    }

    private static String post(String apiUrl, Map<String, String> requestHeaders, String text) {
        HttpURLConnection con = connect(apiUrl);
        String postParams = "source=ko&target=en&text=" + text; // 원본언어: 한국어 (ko) -> 목적언어: 영어 (en)
        try {
            con.setRequestMethod("POST");
            for (Map.Entry<String, String> header : requestHeaders.entrySet()) {
                con.setRequestProperty(header.getKey(), header.getValue());
            }

            con.setDoOutput(true);
            try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
                wr.write(postParams.getBytes());
                wr.flush();
            }

            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 응답
                return readBody(con.getInputStream());
            } else { // 에러 응답
                return readBody(con.getErrorStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("API 요청과 응답 실패", e);
        } finally {
            con.disconnect();
        }
    }

    private static HttpURLConnection connect(String apiUrl) {
        try {
            URL url = new URL(apiUrl);
            return (HttpURLConnection) url.openConnection();
        } catch (MalformedURLException e) {
            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
        } catch (IOException e) {
            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
        }
    }

    private static String readBody(InputStream body) {
        InputStreamReader streamReader = new InputStreamReader(body);

        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
            StringBuilder responseBody = new StringBuilder();

            String line;
            while ((line = lineReader.readLine()) != null) {
                responseBody.append(line);
            }

            return responseBody.toString();
        } catch (IOException e) {
            throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
        }
    }

    public TextConverter() {
        super("텍스트 변환 "); // ??

        textIn = new JTextArea(10, 14); // row column
        textOut = new JTextArea(10, 14);
        textIn.setLineWrap(true); // 자동 줄 바꿈
        textOut.setLineWrap(true);
        textOut.setEnabled(false); // 출력 창은 조작 불가로 한다 .

        JPanel textAreaPanel = new JPanel(new GridLayout(1, 2, 20, 20)); // row column gap gap
        textAreaPanel.add(textIn);
        textAreaPanel.add(textOut);

        converter = new JButton("Translate");
        canceler = new JButton("Cancel");
        converter.addActionListener(new ButtonActionListener());
        canceler.addActionListener(new ButtonActionListener());

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(converter);
        buttonPanel.add(canceler);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10)); // 갭
        mainPanel.add(BorderLayout.CENTER, textAreaPanel);
        mainPanel.add(BorderLayout.SOUTH, buttonPanel);

        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        add(mainPanel);
        pack(); // 내용물에 알 맞게 창 사이즈를 조절 해준다.
        setDefaultCloseOperation(3);
        setVisible(true);
    }

    private class ButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == converter) {
                textOut.setText("");
                String result = papago(textIn.getText());
                String translated = jsonParsingAndGetTranslated(result);
                textOut.append(translated);
            }
            if (e.getSource() == canceler) {
                textOut.setText("");
            }

        }

        // private String toEnglish(String korean) {
        // String result = korean;
        // result = result.replace("텍스트", "Text");
        // result = result.replace("영어", "English");
        // return result;
        // }
    }

    public static void main(String[] args) {
        TextConverter translate = new TextConverter();
    }
}
