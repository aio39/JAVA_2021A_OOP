package chap18;

import java.net.*;
import java.util.List;
import java.io.*;
import java.sql.*;
import com.google.gson.*;

public class RemoteJSON {

    public static void main(String[] args) throws Exception {
        String site = "https://jsonplaceholder.typicode.com/posts";
        URL url = new URL(site);
        URLConnection con = url.openConnection();

        InputStream stream = con.getInputStream();
        InputStreamReader reader = new InputStreamReader(stream);
        BufferedReader buffReader = new BufferedReader(reader);
        StringBuffer sb = new StringBuffer();

        String line = null;
        while ((line = buffReader.readLine()) != null) {
            System.out.println(line);
            sb.append(line);
        }
        buffReader.close();
        String json = sb.toString();
        Gson gson = new Gson();
        Post[] posts = gson.fromJson(json, Post[].class);

        insertIntoDB(posts);

    }

    private static void insertIntoDB(Post[] posts) throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://aio392.com:33061/oop";
        Connection con = DriverManager.getConnection(url, "root", "epdlxj9898");

        String sql = "insert into posts(userId, id, title, body) values(?, ?, ?, ?)";

        PreparedStatement pstmt = con.prepareStatement(sql);
        for (Post post : posts) {
            pstmt.setInt(1, post.getUserId());
            pstmt.setInt(2, post.getId());
            pstmt.setString(3, post.getTitle());
            pstmt.setString(4, post.getBody());

            pstmt.executeUpdate();

        }

    }

}
