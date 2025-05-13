package FinalsProject;

import javax.swing.*;
import java.util.ArrayList;

public class travelTicketReservation {
	
	static ArrayList<String> reservations = new ArrayList<>();
	
	public static void main(String[] args) {
		
		while (true) {
            String[] options = {"Book Ticket", "Cancel Ticket", "View Reservations", "Exit"};
            int choice = JOptionPane.showOptionDialog(null,
                    "Welcome to Travel Ticket Reservation System",
                    "Main Menu",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options,
                    options[0]);

            switch (choice) {
                case 0:
                    bookTicket();
                    break;
                case 1:
                    cancelTicket();
                    break;
                case 2:
                    viewReservations();
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Thank you for using the system!");
                    System.exit(0);
                    break;
                default:
                    break;
         }
	}
}
		public static void bookTicket() {
	        String name = JOptionPane.showInputDialog("Enter your full name:");
	        String destination = JOptionPane.showInputDialog("Enter destination:");
	        String date = JOptionPane.showInputDialog("Enter travel date (YYYY-MM-DD):");

	        if (name != null && destination != null && date != null &&
	            !name.isEmpty() && !destination.isEmpty() && !date.isEmpty()) {
	            String ticket = "Name: " + name + " | Destination: " + destination + " | Date: " + date;
	            reservations.add(ticket);
	            JOptionPane.showMessageDialog(null, "Ticket booked successfully!\n" + ticket);
	        } else {
	            JOptionPane.showMessageDialog(null, "Booking canceled. All fields are required.");
	        }
	    }

	    // Cancel an existing ticket
	    public static void cancelTicket() {
	        if (reservations.isEmpty()) {
	            JOptionPane.showMessageDialog(null, "No reservations to cancel.");
	            return;
	        }

	        StringBuilder list = new StringBuilder();
	        for (int i = 0; i < reservations.size(); i++) {
	            list.append(i + 1).append(". ").append(reservations.get(i)).append("\n");
	        }

	        String input = JOptionPane.showInputDialog("Enter the number of the reservation to cancel:\n" + list);
	        try {
	            int index = Integer.parseInt(input) - 1;
	            if (index >= 0 && index < reservations.size()) {
	                String removed = reservations.remove(index);
	                JOptionPane.showMessageDialog(null, "Cancelled reservation:\n" + removed);
	            } else {
	                JOptionPane.showMessageDialog(null, "Invalid selection.");
	            }
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(null, "Invalid input.");
	        }
	    }

	    // View all reservations
	    public static void viewReservations() {
	        if (reservations.isEmpty()) {
	            JOptionPane.showMessageDialog(null, "No current reservations.");
	            return;
	        }

	        StringBuilder message = new StringBuilder("Current Reservations:\n");
	        for (int i = 0; i < reservations.size(); i++) {
	            message.append(i + 1).append(". ").append(reservations.get(i)).append("\n");
	        }

	        JOptionPane.showMessageDialog(null, message.toString());
	    }
	}
