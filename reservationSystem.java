package FinalsProject;

import javax.swing.*;
import java.util.ArrayList;
import java.util.UUID;

class Ticket {
    String ticketID;
    String fullName;
    String origin;
    String destination;
    String travelDate;
    String seatNumber;

    public Ticket(String fullName, String origin, String destination, String travelDate, String seatNumber) {
        this.ticketID = UUID.randomUUID().toString().substring(0, 8); // short unique ID
        this.fullName = fullName;
        this.origin = origin;
        this.destination = destination;
        this.travelDate = travelDate;
        this.seatNumber = seatNumber;
    }

    public String toString() {
        return "Ticket ID: " + ticketID + "\nName: " + fullName + "\nFrom: " + origin +
                "\nTo: " + destination + "\nDate: " + travelDate + "\nSeat: " + seatNumber;
    }
}

public class reservationSystem {
	
	static ArrayList<Ticket> tickets = new ArrayList<>();
	
	public static void main(String[] args) {
		
		while (true) {
            String[] options = {"Book Ticket", "Cancel Ticket", "View Booked Tickets", "Exit"};
            int choice = JOptionPane.showOptionDialog(null, "Select an option:", "Travel Ticket Reservation",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0 -> bookTicket();
                case 1 -> cancelTicket();
                case 2 -> viewTickets();
                case 3 -> System.exit(0);
                default -> JOptionPane.showMessageDialog(null, "Invalid option.");
            }
	}
}
	static void bookTicket() {
        String name = JOptionPane.showInputDialog("Enter your full name:");
        String origin = JOptionPane.showInputDialog("Enter origin:");
        String destination = JOptionPane.showInputDialog("Enter destination:");
        String date = JOptionPane.showInputDialog("Enter date of travel (YYYY-MM-DD):");
        String seat = JOptionPane.showInputDialog("Enter preferred seat number:");

        Ticket newTicket = new Ticket(name, origin, destination, date, seat);
        tickets.add(newTicket);

        JOptionPane.showMessageDialog(null, "Ticket booked successfully!\n\n" + newTicket);
    }

    static void cancelTicket() {
        String id = JOptionPane.showInputDialog("Enter Ticket ID to cancel:");
        boolean found = false;

        for (int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i).ticketID.equals(id)) {
                tickets.remove(i);
                JOptionPane.showMessageDialog(null, "Ticket cancelled successfully.");
                found = true;
                break;
            }
        }

        if (!found) {
            JOptionPane.showMessageDialog(null, "Ticket ID not found.");
        }
    }

    static void viewTickets() {
        if (tickets.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No tickets booked yet.");
            return;
        }

        StringBuilder allTickets = new StringBuilder();
        for (Ticket t : tickets) {
            allTickets.append(t).append("\n\n");
        }

        JTextArea textArea = new JTextArea(allTickets.toString());
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new java.awt.Dimension(400, 300));

        JOptionPane.showMessageDialog(null, scrollPane, "Booked Tickets", JOptionPane.INFORMATION_MESSAGE);
    }
}
