package nl.saxion.helpdesk;

/**
 * Created by Михаил on 28.01.2017.
 */
public class HardwareTicket extends Ticket {

    private String machineCode;

    /**
     *Constructor for
     * @param ticketNumber
     * @param description
     * @param username
     * @param ManagerName
     * @param usernameResponse
     * @param machineCode
     */
    public HardwareTicket(int ticketNumber, String description, String username, String ManagerName, String usernameResponse, String machineCode) {
        super(ticketNumber, description, username, ManagerName, usernameResponse);
        this.machineCode = machineCode;
    }
}
