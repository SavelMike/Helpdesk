package nl.saxion.helpdesk;

/**
 * Created by Михаил on 28.01.2017.
 */
public class Ticket {

    private int ticketNumber;
    private String username;
    private String description;
    private String usernameManager;
    private String usernameResponse;

    /**
     * Constructor for tickets, initialise all instance variables
     * @param ticketNumber
     * @param description
     * @param username
     * @param ManagerName;
     * @param usernameResponse
     */
    public Ticket(int ticketNumber, String description, String username, String ManagerName , String usernameResponse) {
        this.ticketNumber = ticketNumber;
        this.description = description;
        this.username = username;
        this.usernameManager = ManagerName;
        this.usernameResponse = usernameResponse;
    }
}
