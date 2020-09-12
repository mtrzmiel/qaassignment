package pl.trzmiel.qaassignment.entities;

public class User {

    private final String username;
    private final String mail;
    private final String password;

    public User(String username, String mail, String password) {
        this.username = username;
        this.mail = mail;
        this.password = password;
    }


    public String getUsername() {
        return username;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }
}
