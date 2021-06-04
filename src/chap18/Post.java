package chap18;

public class Post {
    // JavaBean 형태로 클래스를 정의
    // 1. private member 변수에 대한 public getter와 setter를 가진다.
    // 2. default 생성자를 가진다.
    private int userId;
    private int id;
    private String title;
    private String body;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Post(int userId, int id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    @Override
    public String toString() {
        return "Post [body=" + body + ", id=" + id + ", title=" + title + ", userId=" + userId + "]";
    }

}
