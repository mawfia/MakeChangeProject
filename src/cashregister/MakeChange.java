package cashregister;
import java.util.Scanner;


public class MakeChange {

	public static void main(String[] args) {
		
		requestPrice();
		
	}
	public static void moneyTendered(float itemPrice){
		Scanner input = new Scanner(System.in);
		float amountTendered;
		String tenderAgain;

		System.out.print("Enter the amount of money tendered: ");
		if( !(input.hasNextFloat()) || (amountTendered = input.nextFloat()) < 0.00F ){
			System.err.println("Invalid amount entered.");
			moneyTendered(itemPrice);
		}
		else if(amountTendered == itemPrice) System.out.println("Customer provided the exact amount. No change due.");
		else if(amountTendered < itemPrice){ 
			System.out.println("Customer provided too little money."); 
			
			do{
				System.out.print("Does the customer still want to purchase the item? (Y or N): ");
				if( (tenderAgain = input.next().toUpperCase()).equals("Y") ) {
					moneyTendered(itemPrice); 
					return;
				}
				else if( (tenderAgain.equals("N")) ) return;
				else System.err.println("Invalid response.");
			} while( true ) ;
		}
		else calculateChange((int)(((amountTendered - itemPrice)+.005F)*100F)/100F);
	}
	
	public static void requestPrice(){
		Scanner input = new Scanner(System.in);
		float price;
				
		System.out.print("Enter the the price of the item: ");
		if( !(input.hasNextFloat()) || (price = input.nextFloat()) < 0.00F ){
				System.err.println("Invalid price entered.");
				requestPrice();
		}
		else moneyTendered(price);
		
		String tenderAgain;
		System.out.print("Would you like to process another transaction? (Y or N): ");
		if( (tenderAgain = input.next().toUpperCase()).equals("Y") ) {
				requestPrice();
				input.close();
				return;
			}
			else if( (tenderAgain.equals("N")) ){
				input.close();
				return;
			}
			else {
				System.err.println("Invalid response.");
				requestPrice();
				return;
			}
		
	}
	
	public static void calculateChange(float change){
		//int twenty = 0; ten = 0, five = 0, one = 0, quarter = 0, dime = 0, nickel = 0, penny = 0;
		float sum = change;
		/*for ( ; penny < change/.01F; penny++) {
			for ( ; nickel < change/.05F; nickel++) {
				for ( ; dime < change/.10F; dime++) {
					for ( ; quarter < change/.25F; quarter++){
						for ( ; one < change/1.00F; one++ ){
							for ( ; five < change/5.00F; five++ ){
								for ( ; ten < change/10.00F ; ){
									
									for ( int twenty = 0 ; twenty < (int)(sum/20.00F); twenty++, sum = (int)(((sum%20.00F)+.005F)*100F)/100F){											
											System.out.println(twenty + " " + sum);
											if(twenty > 1) displayChange( twenty, " twenty dollar bills", sum);
											else displayChange( twenty, " twenty dollar bill", sum);
											if(sum == 0) return;
									}
								}
							}
						}
					}
				}
			}
		}*/
		
		if(((int)(sum/20.00F)) > 0){
			int twenty = (int)(sum/20.00F);
			sum = (int)(((sum%20.00F)+.005F)*100F)/100F;
			if(twenty > 1) displayChange( twenty, " twenty dollar bills", sum);
			else displayChange( twenty, " twenty dollar bill", sum);
		}
		if( ((int)(sum/10.00F)) > 0 ){
			int ten = (int)(sum/10.00F);
			sum = (int)(((sum%10.00F)+.005F)*100F)/100F;
			if(ten > 1)displayChange( ten, " ten dollar bills", sum);
			else displayChange( ten, " ten dollar bill", sum);
		}
		if( ((int)(sum/5.00F) > 0 ) ){
			int five = (int)(sum/5.00F);
			sum = (int)(((sum%5.00F)+.005F)*100F)/100F;
			if(five > 1)displayChange( five, " five dollar bills", sum);
			else displayChange( five, " five dollar bill", sum);
		}
		if( (int)(sum/1.00F) > 0 ){
			int one = (int)(sum/1.00F);
			sum = (int)(((sum%1.00F)+.005F)*100F)/100F;
			if(one > 1)displayChange( one, " one dollar bills", sum);
			else displayChange( one, " one dollar bill", sum);
		}
		if( (int)(sum/.25F) > 0 ){
			int quarter = (int)(sum/.25F);
			sum = (int)(((sum%.25F)+.005F)*100F)/100F;
			if(quarter > 1)displayChange( quarter, " quarters", sum);
			else displayChange( quarter, " quarter", sum);
		}
		if( ((int)(sum/.10F)) > 0 ){
			int dime = (int)(sum/.10F);
			sum = (int)(((sum%.10F)+.005F)*100F)/100F;
			if(dime > 1)displayChange( dime, " dimes", sum);
			else displayChange( dime, " dime", sum);
		}
		if( (int)(sum/.05F) > 0 ){

			int nickel = (int)(sum/.05F);
			sum = (int)(((sum%.05F)+.005F)*100F)/100F;
			if(nickel > 1)displayChange( nickel, " nickels", sum);
			else displayChange( nickel, " nickel", sum);
		}
		if( sum > 0F ){			
			int penny = (int)(sum/.01F);
			if(penny > 1)displayChange( penny, " pennies", 0F);
			else displayChange( penny, " penny", 0F);
		}
	

		//displayChange(twenty, ten, five, one, quarter, dime, nickel, penny);
		//System.out.println(twenty + " twenty/twenties, " + ten + " ten(s), " + five + " five(s), " + one + " one(s), " + 
			//			   quarter + " quarter(s), " + dime + " dime(s), " + nickel + " nickel(s), and " + penny + " penny/pennies.");
	}
	
	public static void displayChange(int numCurrency, String nameCurrency, float total){
		if(total > 0) System.out.print(numCurrency + nameCurrency + ", ");
		else System.out.println(numCurrency + nameCurrency + ".");
	}

}