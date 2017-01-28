package nl.saxion.helpdesk;

/**
 * Created by Михаил on 28.01.2017.
 */
public class Ticket {

    private int ticketNumber;
    private String description;
    private String username;
    private String usernameResponse;

    /**
     * Constructor for tickets, initialise all instance variables
     * @param ticketNumber
     * @param description
     * @param username
     * @param usernameResponse
     */
    public Ticket(int ticketNumber, String description, String username, String usernameResponse) {
        this.ticketNumber = ticketNumber;
        this.description = description;
        this.username = username;
        this.usernameResponse = usernameResponse;
    }
}
