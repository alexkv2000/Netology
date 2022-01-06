package day11.Exception;

public class User {
    String login;
    String password;
    int age;
    String email;

    public User(String login, String password, int ageUser, String email) {
        this.login = login;
        this.password = password;
        this.age = ageUser;
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }
}
