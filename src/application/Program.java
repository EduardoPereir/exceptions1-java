package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the room number: ");
        int roomNumber = scanner.nextInt();
        System.out.println("Enter the Check-In date (dd/mm/yyyy); ");
        Date checkIn = sdf.parse(scanner.next());
        System.out.println("Enter the Check-Out date (dd/mm/yyyy); ");
        Date checkOut = sdf.parse(scanner.next());

        if (!checkOut.after(checkIn)) {
            System.out.println("Error in reservation: Check-out date must be after check-in date!");
        } else {
            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter the date to update the reservation: ");
            System.out.println("Enter the Check-In date (dd/mm/yyyy); ");
            checkIn = sdf.parse(scanner.next());
            System.out.println("Enter the Check-Out date (dd/mm/yyyy); ");
            checkOut = sdf.parse(scanner.next());

            String error = reservation.updateDate(checkIn, checkOut);
            if ( error != null ){
                System.out.println("Error reservation: " + error);
            }
            else {
                System.out.println("Reservation: " + reservation);
            }
        }
        scanner.close();
    }
}
