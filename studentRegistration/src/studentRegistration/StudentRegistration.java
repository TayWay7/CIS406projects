// Shante' Watkins CIS406 Vacation diary lab //
package studentRegistration;

import java.util.*;

import java.io.*;


public class StudentRegistration {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter date vacation started (mm/dd/yyyy): ");
		String vacationStart = scanner.nextLine();
		
		System.out.print("Enter the city visited: ");
		String city = scanner.nextLine();
		
		System.out.print("Enter the country visited: ");
		String country = scanner.nextLine();
		
		System.out.print("Enter the number of days: ");
		String numDays = scanner.nextLine();
		
		System.out.print("Enter the mode of travel-car, airplane, ship, train, bus: ");
		String travelMode = scanner.nextLine();
		
		System.out.println(" ");
		System.out.println(" ");
		
		System.out.println("Details of your trip: ");
		System.out.println("Date: " + vacationStart);
		System.out.println("City: " + city);
		System.out.println("Country: " + country);
		System.out.println("Number of Days: " + numDays);
		System.out.println("Traveled by: " + travelMode);
		System.out.println("Bye!!");
		
		
		// TODO Auto-generated method stub

	}

}
