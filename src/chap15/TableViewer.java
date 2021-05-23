package chap15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.text.SimpleDictionary;

public class TableViewer extends JFrame implements ActionListener {

    private JTextField idField, titleField, publisherField, yearFiled, priceField, authorField;
    private JButton previousBtn, nextBtn, insertBtn, finishBtn;
    private ResultSet rs;
    private PreparedStatement pstmt;
    private Connection con = null;

    public TableViewer() {
        super("Database Viewer");

        con = null;
        try {
            con = makeConnection();
        } catch (Exception e) {
            System.out.println("데이터 베이스에 연결 할 수 없습니다.");
            System.out.println(e.getMessage());
            return;
        }
        try {
            String sql = "select * from books";
            pstmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        } catch (Exception e) {
            System.out.println("SQL 문을 실행에 문제가 발생");
            System.out.println(e.getMessage());
            System.out.println("프로그램을 종료합니다.");
            return;
        }

        this.setLayout(new GridLayout(0, 2));

        this.add(new JLabel("ID", JLabel.CENTER));

        idField = new JTextField();
        this.add(idField);

        this.add(new JLabel("Title", JLabel.CENTER));
        titleField = new JTextField();
        this.add(titleField);

        this.add(new JLabel("Publisher", JLabel.CENTER));
        publisherField = new JTextField();
        this.add(publisherField);

        this.add(new JLabel("Year", JLabel.CENTER));
        yearFiled = new JTextField();
        this.add(yearFiled);

        this.add(new JLabel("Price", JLabel.CENTER));
        priceField = new JTextField();
        this.add(priceField);

        previousBtn = new JButton("Previous");
        previousBtn.addActionListener(this);

        nextBtn = new JButton("Next");
        nextBtn.addActionListener(this);

        this.add(nextBtn);
        this.add(previousBtn);

        insertBtn = new JButton("Insert");
        insertBtn.addActionListener(this);
        this.add(insertBtn);

        finishBtn = new JButton("Finish");
        finishBtn.addActionListener(this);
        this.add(finishBtn);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setSize(350, 200);
        this.setResizable(false);

        this.setVisible(true);

    }

    private static Connection makeConnection() throws Exception {
        String url = "jdbc:mysql://localhost:3306/oop";
        String id = "root";
        String password = "epdlxj9898";

        Connection con = null;

        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("드라이버 적재 성공");

        con = DriverManager.getConnection(url, id, password);
        System.out.println("데이터 베이스에 연결 성공");

        return con;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == nextBtn || e.getSource() == previousBtn) {
                if (e.getSource() == nextBtn) {
                    rs.next();
                } else if (e.getSource() == previousBtn) {
                    rs.previous();
                }

                int bookId = rs.getInt("book_id");
                idField.setText(String.valueOf(bookId));

                String title = rs.getString("title");
                titleField.setText(title);

                String publisher = rs.getString("publisher");
                publisherField.setText(publisher);

                Date date = rs.getDate("year");
                yearFiled.setText(String.valueOf(date));

                int price = rs.getInt("price");
                priceField.setText(String.valueOf(price));
            } else if (e.getSource() == insertBtn) {

                String title = titleField.getText();
                String publisher = publisherField.getText();
                String year = yearFiled.getText();
                String price = priceField.getText();

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date date = new Date(sdf.parse(year).getTime());

                String sql = "insert into books(title, publisher, year, price) values(?, ?, ?, ?)";
                PreparedStatement pstmt = con.prepareStatement(sql);

                pstmt.setString(1, title);
                pstmt.setString(2, publisher);
                pstmt.setDate(3, date);
                pstmt.setInt(4, Integer.parseInt(price));

                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(this, "책 등록 성공", "성공", JOptionPane.INFORMATION_MESSAGE);

            } else {
                System.out.println("프로그램을 종료합니다.");
                rs.close();
                con.close();
                this.dispose();
                System.exit(0);
            }

        } catch (Exception err) {
            err.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        new TableViewer();
    }

}