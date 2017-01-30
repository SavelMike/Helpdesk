package nl.saxion.helpdesk;

/**
 * Created by Михаил on 28.01.2017.
 */
public class User {

    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User;" + username + ';' + password;
    }
}
