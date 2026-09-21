package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class excecoes {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			IO.print("Room Number: ");
			int number = sc.nextInt();
			IO.print("Check-in date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			IO.print("Check-out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
			
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			IO.println("Reservation: " + reservation);
			
			IO.println();
			IO.println("Enter data to update the reservation: ");
			IO.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			IO.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			reservation.updateDates(checkIn, checkOut);
			IO.println("Reservation: " + reservation);
		}
		catch(ParseException e) {
			IO.println("Inavlid date format");
		}
		catch(DomainException e) {
			IO.println("Error in reservation: " + e.getMessage());
		}
		catch(RuntimeException e) {
			IO.println("Unexpected error");
		}
		
		sc.close();

	}

}
