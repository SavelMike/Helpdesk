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

    public int getTicketNumber() {
        return ticketNumber;
    }

    public String getUsername() {
        return username;
    }

    public String getDescription() {
        return description;
    }

    public String getUsernameManager() {
        return usernameManager;
    }

    public String getUsernameResponse() {
        return usernameResponse;
    }

    public void setUsernameManager(String usernameManager) {
        this.usernameManager = usernameManager;
    }

    public void setUsernameResponse(String usernameResponse) {
        this.usernameResponse = usernameResponse;
    }

    @Override
    public String toString() {
        return "Ticket; " + ticketNumber + ';' + username + ';' + description + ';' + usernameManager + ';' + usernameResponse;
    }

    public String toHumanString() {
        return "Ticket " + ticketNumber + ", username: " + username + ", description: " + description + "/n"
                + "Name of manger: " + usernameManager + ", manager's response: " + usernameResponse;
    }
}
