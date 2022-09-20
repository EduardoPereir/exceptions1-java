package application;

import model.entities.Reservation;
import model.exeptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args)  {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter the room number: ");
            int roomNumber = scanner.nextInt();
            System.out.println("Enter the Check-In date (dd/mm/yyyy); ");
            Date checkIn = sdf.parse(scanner.next());
            System.out.println("Enter the Check-Out date (dd/mm/yyyy); ");
            Date checkOut = sdf.parse(scanner.next());

            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter the date to update the reservation: ");
            System.out.println("Enter the Check-In date (dd/mm/yyyy); ");
            checkIn = sdf.parse(scanner.next());
            System.out.println("Enter the Check-Out date (dd/mm/yyyy); ");
            checkOut = sdf.parse(scanner.next());
            reservation.updateDate(checkIn, checkOut);

            System.out.println("Reservation: " + reservation);
        }
        catch (ParseException e ){
            System.out.println("Invalid date format !");
        }
        catch (DomainException e ){
            System.out.println("Error in reservation: " + e.getMessage());
        }
        catch (RuntimeException e ){
            System.out.println("Unexpected error!");
        }

        scanner.close();
    }
}
