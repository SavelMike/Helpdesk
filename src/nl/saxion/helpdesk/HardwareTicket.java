package nl.saxion.helpdesk;

/**
 * Created by Михаил on 28.01.2017.
 */
public class HardwareTicket extends Ticket {

    private String machineCode;

    /**
     * Constructor for Hardware ticket
     * @param ticketNumber
     * @param description
     * @param username
     * @param ManagerName
     * @param managerResponse
     * @param machineCode
     */
    public HardwareTicket(int ticketNumber, String description, String username, String ManagerName, String managerResponse, String machineCode) {
        super(ticketNumber, description, username, ManagerName, managerResponse);
        this.machineCode = machineCode;
    }

    @Override
    public String toString() {
        return "HardwareTicket;" + getTicketNumber() + ";" + getUsername() + ";" + machineCode + ";"
                + getDescription() + ";" + getUsernameManager() + ";" + getUsernameResponse();
    }
}
