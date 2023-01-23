package pojo;

public class LogInPojo {

    private String email;
    private String password;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LogInPojo(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public LogInPojo() {

    }

    @Override
    public String toString() {
        return "LogInPojo{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
