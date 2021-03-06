package nl.saxion.helpdesk;
import nl.saxion.helpdesk.data.*;
import java.io.File;
import java.io.FileNotFoundException;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Helpdesk {
    /**
     * Contains the user that is currently logged in.
     */
	private User currentUser;
	private ArrayList<User> users = new ArrayList<User>();
	private ArrayList<Ticket> tickets = new ArrayList<Ticket>();


	/**
     * Reads in a file and creates users and tickets in the system
     * @param filename Filename
     * @return Number of created objects
     * @throws HelpdeskException An exception is thrown when the file cannot be read, or when a line is incomplete
     */
	public int importData(String filename) throws HelpdeskException, FileNotFoundException {

		File f = new File(filename);
		Scanner in = new Scanner(f);
		int countObjects = 0;

		while (in.hasNextLine()) {

			String line = in.nextLine();
			if (line.isEmpty()) {
				continue;
			}
			if ((line.charAt(0) == '#')) {
				continue;
			}
			Scanner sc = new Scanner(line);
			sc.useDelimiter(";");
			String word = sc.next();

			if ((word.equals("User")) || (word.equals("Manager"))) {
				users.add(importUser(line));
				countObjects++;
				continue;
			}

			if (word.equals("Ticket")) {
				tickets.add(importTicket(line));
				countObjects++;
				continue;
			}
		}
		return countObjects;
	}



    /**
     * Processes a CSV line from an input file and tries to create a user object
     * @param line Line of text
     * @return User object
     * @throws HelpdeskException If the line is incorrect an exception is thrown
     */
	private User importUser(String line) throws HelpdeskException {

		// 0. associate scanner with input string and set delimiter
		Scanner in = new Scanner(line);
		in.useDelimiter(";");

		// 1. read first word from input string
		String firstWord = in.next();

		// 2. read second word (username)
		String secondWord = "";
		if (in.hasNext()) {
			secondWord = in.next();
		}
		// 3. read third word (passwd)
		String thirdWord = "";
		if (in.hasNext()) {
			thirdWord = in.next();
		}

		if (firstWord.equals("User")) {
			if (!in.hasNext()) {
				User user = new User(secondWord, thirdWord);
				return user;
			}
		}

		/* here first word is Manager */
		// 5. read 4th word
		String fourthWord = "";
		if (in.hasNext()) {
			fourthWord = in.next();
		}
		/* 6. read 5th word */
		String fifthWord = "";
		if (in.hasNext()) {
			fifthWord = in.next();
		}
		if (!in.hasNext()) {
			Manager manager = new Manager(secondWord, thirdWord, fourthWord, fifthWord);
			return manager;
		} else {
			return null;
		}
	}

    /**
     * Processes a CSV line from an input file and tries to create a ticket object
     * @param line Line of text
     * @return User object
     * @throws HelpdeskException If the line is incorrect an exception is thrown
     */
	private Ticket importTicket(String line) throws HelpdeskException {

		// 0. associate scanner with input string and set delimiter
		Scanner in = new Scanner(line);
		in.useDelimiter(";");

        // 1. read first word from input string
		String objectType = in.next();

		// 2. read second word (ticket number)
		int ticketNumber = 0;
		if (in.hasNextInt()) {
			ticketNumber = in.nextInt();
		}

		// 3. read third word (typeOfTicket)
		String ticketType = "";
		if (in.hasNext()) {
			ticketType = in.next();
		}

		// 4. read fourth word (userName)
		String userName = "";
		if (in.hasNext()) {
			userName = in.next();
		}


		// 5. read fifth word (machineCode or SoftwareName)
		String employeeInput = "";
		if (in.hasNext()) {
			employeeInput = in.next();
		}

		// 6. read  6 word
		String description = "";
		if (in.hasNext()) {
			description = in.next();
		}

		// 7.
		String usernameManager = "";
		String response = "";
		if (in.hasNext()) {
			usernameManager = in.next();
			if (in.hasNext()) {
				response = in.next();
			}
		}

		if (!in.hasNext()) {
			if (ticketType == "Software") {
				SoftwareTicket Softwareticket = new SoftwareTicket(ticketNumber, description, userName, usernameManager, response, employeeInput);
				return Softwareticket;
			}
			HardwareTicket Hardwareticket = new HardwareTicket(ticketNumber, description, userName, usernameManager, response, employeeInput);
			return Hardwareticket;
		}
		return null;
	}

    /**
     * Helper method for finding a user using a username
     * @param username Username of the user
     * @return Returns the User object that corresponds to the current username, otherwise null is returned
     */
	private User findUserByUsername(String username) {

		// ArrayList<User> users;
		for (int i = 0; i < users.size(); i++) {
			User u = users.get(i);
			String curname = u.getUsername();
			if (curname.equals(username)) {
				return u;
			}
		}
        return null;
	}

	/**
	 * Export the data in the system (users and tickets) to the CSV format (semicolon separated!!!)
     * IMPORTANT: EXPORT FIRST THE USERS AND THEN THE TICKETS, OTHERWISE THE FILE CANNOT BE IMPORTED ANYMORE!!!
	 * @param filename Filename of the export file
	 */
	public void exportData(String filename) throws FileNotFoundException {
		// open file by object printwriter
		PrintWriter pr = new PrintWriter(filename);
		for (int i = 0; i < users.size(); i++) {
			pr.println(users.get(i));
		}
		for (int i = 0; i < tickets.size(); i++) {
			pr.println(tickets.get(i));
		}
		pr.close();
	}
	
	/**
	 * Login a user/employee
	 * @param username Username of the user/employee
	 * @param password Password of the user/employee
	 * @return True, if the user is logged on successfully
	 */
	public boolean login(String username, String password) {
		for (int i = 0; i < users.size(); i++) {
			if ((users.get(i).getUsername().equals(username)) && (users.get(i).getPassword().equals(password))) {
				currentUser = users.get(i);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Logout a user
	 */
	public void logout() {

		currentUser = null;
	}
	
	/**
	 * Returns true if the user is logged on
	 * @return True, if the user is logged on
	 */
	public boolean isLoggedOn() {

        return currentUser != null;
	}
	
	/**
	 * Returns true if the user that is currently logged in is a manager
	 * @return True, if the user is a manager
	 */
	public boolean isManager() {

		return currentUser instanceof Manager;
	}

	/**
	 * Add a hardwareticket to the helpdesk
	 * @param description description of the problem
	 * @param machineCode Code of the computer
	 */
	public int addHardwareTicket(String description, String machineCode) {

		HardwareTicket hardwareTicket = new HardwareTicket(tickets.size() + 1, description, currentUser.getUsername(), null, null, machineCode);
        tickets.add(hardwareTicket);
		return hardwareTicket.getTicketNumber();
	}

	/**
	 * Add a softwareticket to the helpdesk
	 * @param description description of the problem
	 * @param softwareName Name of the piece of software
	 */
	public int addSoftwareTicket(String description, String softwareName) {

		SoftwareTicket softwareTicket = new SoftwareTicket(tickets.size() + 1, description, currentUser.getUsername(), null, null, softwareName);
		tickets.add(softwareTicket);
        return softwareTicket.getTicketNumber();
	}

	/**
	 * Resolve a ticket
	 * @param ticketNumber Number of the ticket
	 * @param response Response text
	 * @throws HelpdeskException When the ticket is not found, the current user is no manager or the ticket is already resolved
	 */
	public void resolveTicket(int ticketNumber, String response) throws HelpdeskException {

		if (tickets.size() < ticketNumber) {
			throw new HelpdeskException();
		}
		if (!isManager()) {
			throw new HelpdeskException();
		}

		Ticket ticket = tickets.get(ticketNumber - 1);

		if ((ticket.getUsernameManager() != null) && (ticket.getUsernameResponse() != null)) {
			throw new HelpdeskException();
		}
		ticket.setUsernameManager(currentUser.getUsername());
		ticket.setUsernameResponse(response);
	}


    /**
     * Print all my tickets
     */
	public void printMyTickets() {

		for (int i = 0; i < tickets.size(); i++) {
			if (currentUser.getUsername().equals(tickets.get(i).getUsername())) {
				System.out.println(tickets.get(i).toHumanString());
			}
		}

	}

    /**
     * Print all the open tickets in the system (only available for managers of the helpdesk)
     * @throws HelpdeskException Exception is thrown when the user that is logged on has not enough privileges
     */
	public void printOpenTickets() throws HelpdeskException {

		if (!isManager()) {
			throw new  HelpdeskException();
		}
		for (int i = 0; i < tickets.size(); i++) {
			if (tickets.get(i).getUsernameResponse().equals(null) && tickets.get(i).getUsernameManager() == null) {
				System.out.println(tickets.get(i).toHumanString());
			}
		}
	}

    /**
     * Print all the tickets in the system (only available for managers of the helpdesk)
     * @throws HelpdeskException Exception is thrown when the user that is logged on has not enough privileges
     */
    public void printAllTickets() throws HelpdeskException {

		if (!isManager()) {
			throw new HelpdeskException();
		}
		for (int i = 0; i < tickets.size(); i++) {
			System.out.println(tickets.get(i).toHumanString());
		}
    }

    /**
     * Print all users in the system (only available for employees of the helpdesk)
     * @throws HelpdeskException Exception is thrown when the user that is logged is not employee of the helpdesk
     */
	public void printUsers() throws HelpdeskException {

		if (isManager()) {
			throw new HelpdeskException();
		}
		for (int i = 0; i < users.size(); i++) {
			System.out.println(users.get(i).toHumanString());
		}
	}

}