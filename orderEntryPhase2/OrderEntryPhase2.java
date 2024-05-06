//Shante Watkins CIS406 Order Entry Phase 2
package orderEntryPhase2;

import java.lang.reflect.Method;
import java.util.Scanner;
import java.util.InputMismatchException;

public class OrderEntryPhase2 {

			
			private String itemNumber;
			private String itemDescription;
			private double itemPrice;
			private double gross = 0.0;
			private double totalTax = 0.0; 
			private double netAmount;
			private int quantityOrdered;
			private double totalDiscount;
			private double discountAmount = 0.0;
			private double taxPercent = 0.0;
			private double taxes = 0.0;
			
			public void getData() {
				Scanner input = new Scanner (System.in);
				
				System.out.print("Enter item number: ");
				itemNumber = input.nextLine();
				
				System.out.print("Enter item description: ");
				itemDescription = input.nextLine();
				
			
				
				try {
					
					System.out.print("Enter quantity ordered: ");
					quantityOrdered = input.nextInt();
					
					System.out.print("Enter item price: $");
					itemPrice = input.nextDouble();
					
					
					
					System.out.print("Enter tax percent for the item: %");
					totalTax = input.nextDouble();
					
					
					System.out.print("Enter the disount percentage for the item: ");
					totalDiscount = input.nextDouble();
					
					
					
				}
				catch(InputMismatchException e){
					System.out.println("Data entered is not valid entry format. Program ending.");
				}
				catch (Exception e) {
					System.out.println("An error has occured.");
				}
				
				gross = itemPrice * quantityOrdered;
			    taxes = (gross * totalTax) / 100.00;
			    double finalGross = gross += taxes;
			    discountAmount = (gross * totalDiscount) / 100.00;
			    netAmount = finalGross - discountAmount;
		        
				
				
			}
			public String toString() {
				return("\n Order Details: \n "+
					   "\n Item Number \tItem Description \tItem Price \tQuantity Ordered \tTax Percent \tTax Amount \tDiscount Percent \tDiscount Amount \tNet Amount\n" +
						
					   " " + itemNumber +
					    "\t\t" + itemDescription +
					   "\t\t$" + itemPrice +
					   "\t\t " + quantityOrdered +
					   "\t\t\t%  " + totalTax +
					   "\t\t$" + taxes +
					   "\t\t" + totalDiscount +
					   "\t\t\t$" + discountAmount +
					   "\t\t\t$" + netAmount );
			}
					   
					   
			
			

			public static void main(String[] args) {
			
				// TODO Auto-generated method stub
				OrderEntryPhase2 myOrder = new OrderEntryPhase2();
				
				//Get data for the order
				myOrder.getData();
				
				
			   //Display order
				System.out.println(myOrder.toString());
			}

		// TODO Auto-generated method stub


			
		}

	


