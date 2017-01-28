package nl.saxion.helpdesk;
import nl.saxion.helpdesk.data.*;

public class Helpdesk {
    /**
     * Contains the user that is currently logged in.
     */
	private User currentUser;

    /**
     * Reads in a file and creates users and tickets in the system
     * @param filename Filename
     * @return Number of created objects
     * @throws HelpdeskException An exception is thrown when the file cannot be read, or when a line is incomplete
     */
	public int importData(String filename) throws HelpdeskException {
        // TODO: Implement this method
        return -1;
	}

    /**
     * Processes a CSV line from an input file and tries to create a user object
     * @param line Line of text
     * @return User object
     * @throws HelpdeskException If the line is incorrect an exception is thrown
     */
	private User importUser(String line) throws HelpdeskException {
        // TODO: Implement this method
        return null;
	}

    /**
     * Processes a CSV line from an input file and tries to create a ticket object
     * @param line Line of text
     * @return User object
     * @throws HelpdeskException If the line is incorrect an exception is thrown
     */
	private Ticket importTicket(String line) throws HelpdeskException {
        // TODO: Implement this method
        return null;
	}

    /**
     * Helper method for finding a user using a username
     * @param username Username of the user
     * @return Returns the User object that corresponds to the current username, otherwise null is returned
     */
	private User findUserByUsername(String username) {
        // TODO: Implement this method
        return null;
	}

	/**
	 * Export the data in the system (users and tickets) to the CSV format (semicolon separated!!!)
     * IMPORTANT: EXPORT FIRST THE USERS AND THEN THE TICKETS, OTHERWISE THE FILE CANNOT BE IMPORTED ANYMORE!!!
	 * @param filename Filename of the export file
	 */
	public void exportData(String filename) {
        // TODO: Implement this method
	}
	
	/**
	 * Login a user/employee
	 * @param username Username of the user/employee
	 * @param password Password of the user/employee
	 * @return True, if the user is logged on successfully
	 */
	public boolean login(String username, String password) {
        // TODO: Implement this method
		return false;
	}
	
	/**
	 * Logout a user
	 */
	public void logout() {
        // TODO: Implement this method
	}
	
	/**
	 * Returns true if the user is logged on
	 * @return True, if the user is logged on
	 */
	public boolean isLoggedOn() {
        // TODO: Implement this method
        return false;
	}
	
	/**
	 * Returns true if the user that is currently logged in is a manager
	 * @return True, if the user is a manager
	 */
	public boolean isManager() {
	    // TODO: Implement this method
        return false;
	}

	/**
	 * Add a hardwareticket to the helpdesk
	 * @param description description of the problem
	 * @param machineCode Code of the computer
	 */
	public int addHardwareTicket(String description, String machineCode) {
        // TODO: Implement this method
        return -1;
	}

	/**
	 * Add a softwareticket to the helpdesk
	 * @param description description of the problem
	 * @param softwareName Name of the piece of software
	 */
	public int addSoftwareTicket(String description, String softwareName) {
        // TODO: Implement this method
        return -1;
	}

	/**
	 * Resolve a ticket
	 * @param ticketNumber Number of the ticket
	 * @param response Response text
	 * @throws HelpdeskException When the ticket is not found, the current user is no manager or the ticket is already resolved
	 */
	public void resolveTicket(int ticketNumber, String response) throws HelpdeskException {
        // TODO: Implement this method
	}

    /**
     * Print all my tickets
     */
	public void printMyTickets() {
        // TODO: Implement this method
	}

    /**
     * Print all the open tickets in the system (only available for managers of the helpdesk)
     * @throws HelpdeskException Exception is thrown when the user that is logged on has not enough privileges
     */
	public void printOpenTickets() throws HelpdeskException {
        // TODO: Implement this method
	}

    /**
     * Print all the tickets in the system (only available for managers of the helpdesk)
     * @throws HelpdeskException Exception is thrown when the user that is logged on has not enough privileges
     */
    public void printAllTickets() throws HelpdeskException {
        // TODO: Implement this method
    }

    /**
     * Print all users in the system (only available for employees of the helpdesk)
     * @throws HelpdeskException Exception is thrown when the user that is logged is not employee of the helpdesk
     */
	public void printUsers() throws HelpdeskException {
        // TODO: Implement this method
	}
}