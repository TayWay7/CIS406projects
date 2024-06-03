package orderEntryPhase4;

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

public class OrderEntryPhase4 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Item> items = new ArrayList<>();
        String continueInput = "y";

        // Invoice variables
        StringBuilder invoice = new StringBuilder();
        String invoiceDate = "";
        String customerName = "";
        String customerAddress = "";
        String customerCity = "";
        String customerState = "";
        String customerZip = "";

        // Enter invoice date
        System.out.print("Enter invoice date: ");
        invoiceDate = input.nextLine();
        invoice.append("Invoice Date: ").append(invoiceDate).append("\n");

        // Enter customer information
        System.out.print("Enter customer name: ");
        customerName = input.nextLine();
        System.out.print("Enter customer street address: ");
        customerAddress = input.nextLine();
        System.out.print("Enter customer city: ");
        customerCity = input.nextLine();
        System.out.print("Enter customer state: ");
        customerState = input.nextLine();
        System.out.print("Enter customer zip code: ");
        customerZip = input.nextLine();

        invoice.append("\nCustomer Name: ").append(customerName).append("\n")
                .append("Address: ").append(customerAddress).append(" ")
                .append(customerCity).append(", ")
                .append(customerState).append(" ").append(customerZip)
                .append("\n\n");

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

                items.add(new Item(number, description, price, quantity, 
                		taxRate, discountRate));

                System.out.print("Do you want to enter another item? (y/n): ");
                continueInput = input.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please try again.");
                input.nextLine();
            }
        }

        // Append item details to the invoice
        invoice.append("Order Details:\n")
                .append("Item Number\tItem Description\tItem Price\t"
                		+ "Quantity Ordered\tTax Percent\tTax Amount"
                        + "\tDiscount Percent\tDiscount Amount\t\tNet Amount\n");

        double totalGrossAmount = 0.0;
        double totalTaxAmount = 0.0;
        double totalDiscountAmount = 0.0;
        double totalNetAmount = 0.0;

        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            invoice.append(item.itemNumber).append("\t\t")
                    .append(item.itemDescription).append("\t\t")
                    .append("$").append(item.itemPrice).append("\t\t")
                    .append(item.quantityOrdered).append("\t\t\t")
                    .append(item.taxPercent).append("%\t\t")
                    .append("$").append(item.taxAmount).append("\t\t")
                    .append(item.discountPercent).append("%\t\t\t")
                    .append("$").append(item.discountAmount)
                    .append("\t\t\t")
                    .append("$").append(item.netAmount).append("\n");

            totalGrossAmount += item.grossAmount;
            totalTaxAmount += item.taxAmount;
            totalDiscountAmount += item.discountAmount;
            totalNetAmount += item.netAmount;
        }

        // Append totals to the invoice
        invoice.append("\nTotal Items: ").append(items.size())
        .append("\t\t\t\t")
                .append("$").append(totalGrossAmount)
                .append("\t\t\t\t\t\t\t")
                .append("$").append(totalTaxAmount)
                .append("\t\t\t\t\t")
                .append("$")
                .append(totalDiscountAmount).append("\t\t\t")
                .append("$").append(totalNetAmount)
                .append("\n");

        // Display invoice
        System.out.println(invoice.toString());
    }
}
