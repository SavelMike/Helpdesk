package nl.saxion.helpdesk;

/**
 * Created by Михаил on 28.01.2017.
 */
public class Manager extends User {

    private String expertise;
    private String department;

    public Manager(String username, String password, String expertise, String department) {
        super(username, password);
        this.expertise = expertise;
        this.department = department;
    }
}
