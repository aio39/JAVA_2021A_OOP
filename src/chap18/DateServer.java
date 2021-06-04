package chap18;

import java.net.*;
import java.io.*;
import java.util.*;

public class DateServer {

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(9100)) {
            Socket socket = null;
            while (true) {
                try {
                    System.out.println("waiting for client connection");
                    socket = serverSocket.accept();
                    System.out.println("새로운 클라이언트가 접속 :" + socket.getRemoteSocketAddress());

                    OutputStream oStream = socket.getOutputStream();
                    PrintWriter writer = new PrintWriter(oStream, true);
                    writer.println(Calendar.getInstance().getTime());

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    socket.close();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
