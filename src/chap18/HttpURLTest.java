package chap18;

import java.net.*;
import java.io.*;

public class HttpURLTest {
    public static void main(String[] args) throws Exception {

        String site = "https://www.google.com/search?q=java";
        URL url = new URL(site);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");

        int responseCode = con.getResponseCode();
        System.out.println("Response code : " + responseCode);

        BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));

        String line = reader.readLine();
        StringBuffer buf = new StringBuffer();
        while ((line = reader.readLine()) != null) {
            buf.append(line);
        }
        reader.close();

        System.out.println(buf);
    }
}
