package nl.saxion.helpdesk;

/**
 * Created by Михаил on 28.01.2017.
 */
public class SoftwareTicket extends Ticket {

    private String softwareName;

    /**
     * Call the constructor for SoftwareTicket
     * @param ticketNumber
     * @param description
     * @param username
     * @param usernameResponse
     * @param softwareName
     */
    public SoftwareTicket(int ticketNumber, String description, String username, String usernameResponse, String softwareName) {
        super(ticketNumber, description, username, usernameResponse);
        this.softwareName = softwareName;
    }
}
