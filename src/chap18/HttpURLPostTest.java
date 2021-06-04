package chap18;

import java.net.*;
import java.io.*;

public class HttpURLPostTest {

    public static void main(String[] args) {

        String site = "null";

        try {
            URL url = new URL(site);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setDefaultUseCaches(false);
            con.setDoInput(true);
            con.setDoOutput(true);
            con.setRequestMethod("POST");

            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            StringBuffer buffer = new StringBuffer();

            // + 연산 보다 버퍼로 append 하는 게 속도가 빠르다.
            buffer.append("id=scpark");

            // OutputStream 으로는 문자 집합 지정이 불가
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(con.getOutputStream(), "UTF-8"));
            writer.println(buffer.toString()); // 네트워크로 보냄.
            writer.flush();

            BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
            String line = "";
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
