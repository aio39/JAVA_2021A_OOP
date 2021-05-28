package chap18;

import java.net.*;

import java.io.*;

public class URLConenctionReader {

    public static void main(String[] args) {
        BufferedReader reader = null;
        try {
            URL site = new URL("https://www.naver.com");
            URLConnection url = site.openConnection();
            reader = new BufferedReader(new InputStreamReader(url.getInputStream()));

            String line = "";
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println();
            reader.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                reader.close();
            } catch (Exception ignore) {
            }
        }
    }
}
