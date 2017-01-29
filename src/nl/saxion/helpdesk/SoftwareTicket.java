package nl.saxion.helpdesk;

/**
 * Created by Михаил on 28.01.2017.
 */
public class SoftwareTicket extends Ticket {

    private String softwareName;

    /**
     * the constructor for SoftwareTicket
     * @param ticketNumber
     * @param description
     * @param username
     * @param ManagerName
     * @param managerResponse
     * @param softwareName
     */
    public SoftwareTicket(int ticketNumber, String description, String username, String ManagerName, String managerResponse, String softwareName) {
        super(ticketNumber, description, username, ManagerName, managerResponse);
        this.softwareName = softwareName;
    }
}
