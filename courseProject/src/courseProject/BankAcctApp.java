package courseProject;

import java.util.ArrayList;
import java.util.Scanner;

public class BankAcctApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Customer> customers = new ArrayList<>();
        String addAnotherCustomer;

        do {
            Customer customer = new Customer();

            // Data Entry for a Customer
            System.out.println("Enter details for the Customer:");
            customer.setCustomerId(DataEntry.entryStringWithLimit("\nCustomer ID", 5));
            customer.setCustomerSSN(DataEntry.entryNumericString("Customer SSN", 9));
            customer.setLastName(DataEntry.entryStringWithLimit("Last Name", 20));
            customer.setFirstName(DataEntry.entryStringWithLimit("First Name", 15));
            customer.setStreet(DataEntry.entryStringWithLimit("Street", 20));
            customer.setCity(DataEntry.entryStringWithLimit("City", 20));
            customer.setState(DataEntry.entryStringWithLimit("State", 2));
            customer.setZip(DataEntry.entryNumericString("Zip", 5));
            customer.setPhone(DataEntry.entryNumericString("Phone", 10));

       
            customers.add(customer);


            System.out.print("\nWould you like to add another customer? (y/n): ");
            addAnotherCustomer = scanner.nextLine().trim();

        } while (addAnotherCustomer.equalsIgnoreCase("y"));


        System.out.println("\nCustomer Information:");
        System.out.println("======================");
        for (Customer customer : customers) {
            System.out.println(customer);
            System.out.println("======================");
        }

        scanner.close();
    }
}
