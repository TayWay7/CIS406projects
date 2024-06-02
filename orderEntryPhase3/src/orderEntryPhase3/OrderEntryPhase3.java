package orderEntryPhase3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

class Item {
    String itemNumber;
    String itemDescription;
    double itemPrice;
    int quantityOrdered;
    double taxPercent;
    double discountPercent;
    double grossAmount;
    double taxAmount;
    double discountAmount;
    double netAmount;

    public Item(String number, String description, double price, int quantity, double taxRate, double discountRate) {
        itemNumber = number;
        itemDescription = description;
        itemPrice = price;
        quantityOrdered = quantity;
        taxPercent = taxRate;
        discountPercent = discountRate;
        calculateAmounts();
    }

    private void calculateAmounts() {
        grossAmount = itemPrice * quantityOrdered;
        taxAmount = (grossAmount * taxPercent) / 100.0;
        discountAmount = (grossAmount * discountPercent) / 100.0;
        netAmount = grossAmount + taxAmount - discountAmount;
    }
}

public class OrderEntryPhase3 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Item> items = new ArrayList<>();
        String continueInput = "y";

        while (!continueInput.equalsIgnoreCase("n")) {
            try {
                System.out.print("Enter item number: ");
                String number = input.nextLine();

                System.out.print("Enter item description: ");
                String description = input.nextLine();

                System.out.print("Enter item price: $");
                double price = input.nextDouble();

                System.out.print("Enter quantity ordered: ");
                int quantity = input.nextInt();

                System.out.print("Enter tax percent for the item: %");
                double taxRate = input.nextDouble();

                System.out.print("Enter the discount percent for the item: ");
                double discountRate = input.nextDouble();
                input.nextLine(); 

                items.add(new Item(number, description, price, quantity, taxRate, discountRate));

                System.out.print("Do you want to enter another item? (y/n): ");
                continueInput = input.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please try again.");
                input.nextLine(); 
            }
        }

        // Display all items
        System.out.println("\nOrder Details:");
        System.out.println("Index\tItem Number\tItem Description\tItem Price\tQuantity Ordered\tTax Percent\tTax Amount"
        		+ "\tDiscount Percent\tDiscount Amount\t\tNet Amount");

        double totalGrossAmount = 0.0;
        double totalTaxAmount = 0.0;
        double totalDiscountAmount = 0.0;
        double totalNetAmount = 0.0;

        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            System.out.printf("%d\t%s\t\t%s\t\t\t$%.2f\t\t%d\t\t\t%.2f%%\t\t$%.2f\t\t%.2f%%\t\t\t$%.2f\t\t\t$%.2f\n",
                    i + 1, item.itemNumber, item.itemDescription, item.itemPrice, item.quantityOrdered, item.taxPercent,
                    item.taxAmount, 
                    item.discountPercent, item.discountAmount, item.netAmount);
            totalGrossAmount += item.grossAmount;
            totalTaxAmount += item.taxAmount;
            totalDiscountAmount += item.discountAmount;
            totalNetAmount += item.netAmount;
        }

        // Display totals
        System.out.printf("\nTotal Items: %d\t\t", items.size());
        System.out.printf("Total Gross Amount: $%.2f\t\t\t\t", totalGrossAmount);
        System.out.printf("\tTotal Tax Amount: $%.2f\t\t", totalTaxAmount);
        System.out.printf("Total Discount Amount: $%.2f\t", totalDiscountAmount);
        System.out.printf("Total Net Amount: $%.2f\n", totalNetAmount);
    }
}
