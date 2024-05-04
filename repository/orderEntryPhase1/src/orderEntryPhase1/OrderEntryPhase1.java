//Shante Watkins 	CIS406 Order Entry Phase 1
package orderEntryPhase1;
import java.lang.reflect.Method;
import java.util.Scanner;
import java.util.InputMismatchException;

public class OrderEntryPhase1 {
	
	private String itemNumber;
	private String itemDescription;
	private double itemPrice;
	private double totalTax;
	private double netAmount;
	private int quantityOrdered;
	private double totalDiscount;
	
	private void getData() {
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
			
			System.out.print("Enter total tax for the item: ");
			totalTax = input.nextDouble();
			
			System.out.print("Enter the total disount for the item: ");
			totalDiscount = input.nextDouble();
			
			System.out.print("Enter the net amount for the item: ");
			netAmount = input.nextDouble();
			
		}
		catch(InputMismatchException e){
			System.out.println("Data entered is not valid entry format. Program ending.");
		}
		catch (Exception e) {
			System.out.println("An error has occured.");
		}
		
		
		
	}
	public String toString() {
		return("\n Order Details: \n "+
			   "\n Item Number \tItem Description \tItem Price \tQuantity Ordered \tTax \t\tDiscount \tNet Amount\n" +
				
			   " " + itemNumber +
			    "\t\t" + itemDescription +
			   "\t\t$" + itemPrice +
			   "\t\t " + quantityOrdered +
			   "\t\t\t$" + totalTax +
			   "\t\t$" + totalDiscount +
			   "\t\t$" + netAmount );
	}
			   
			   
	
	

	public static void main(String[] args) {
	
		// TODO Auto-generated method stub
		OrderEntryPhase1 myOrder = new OrderEntryPhase1();
		
		//Get data for the order
		myOrder.getData();
        
	   //Display order
		System.out.println(myOrder.toString());
	}

}
