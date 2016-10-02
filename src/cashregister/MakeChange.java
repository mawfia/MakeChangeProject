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
		if( !(input.hasNextFloat()) || (amountTendered = input.nextFloat()) < 0.00F ) {
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
			
		float sum = change; // 
	
		for(int i = 0, k = 0, m = 0; i < 8 && sum > 0; i++){
			if(k > 0) m = k;
			switch(i){
			case 0:
				if((k = ((int)(sum/20.00F))) == 1) displayChange(k, " twenty dollar bill", (sum = (int)(((sum%20.00F)+.005F)*100F)/100F), m);				
				else if ((k = ((int)(sum/20.00F))) > 1) displayChange(k, " twenty dollar bills", (sum = (int)(((sum%20.00F)+.005F)*100F)/100F), m);
				break;
			case 1:
				if((k = ((int)(sum/10.00F))) == 1) displayChange(k, " ten dollar bill", (sum = (int)(((sum%10.00F)+.005F)*100F)/100F), m);				
				else if ((k = ((int)(sum/10.00F))) > 1) displayChange(k, " ten dollar bills", (sum = (int)(((sum%10.00F)+.005F)*100F)/100F), m);
				break;
			case 2:
				if((k = ((int)(sum/5.00F))) == 1) displayChange(k, " five dollar bill", (sum = (int)(((sum%5.00F)+.005F)*100F)/100F), m);				
				else if ((k = ((int)(sum/5.00F))) > 1) displayChange(k, " five dollar bills", (sum = (int)(((sum%5.00F)+.005F)*100F)/100F), m);
				break;
			case 3:
				if((k = ((int)(sum/1.00F))) == 1) displayChange(k, " one dollar bill", (sum = (int)(((sum%1.00F)+.005F)*100F)/100F), m);				
				else if ((k = ((int)(sum/1.00F))) > 1) displayChange(k, " one dollar bills", (sum = (int)(((sum%1.00F)+.005F)*100F)/100F), m);
				break;
			case 4:
				if((k = ((int)(sum/.25F))) == 1) displayChange(k, " quarter", (sum = (int)(((sum%.25F)+.005F)*100F)/100F), m);				
				else if ((k = ((int)(sum/.25F))) > 1) displayChange(k, " quarters", (sum = (int)(((sum%.25F)+.005F)*100F)/100F), m);
				break;
			case 5:
				if((k = ((int)(sum/.10F))) == 1) displayChange(k, " dime", (sum = (int)(((sum%.10F)+.005F)*100F)/100F), m);				
				else if ((k = ((int)(sum/.10F))) > 1) displayChange(k, " dimes", (sum = (int)(((sum%.10F)+.005F)*100F)/100F), m);
				break;
			case 6:
				if((k = ((int)(sum/.05F))) == 1) displayChange(k, " nickel", (sum = (int)(((sum%.05F)+.005F)*100F)/100F), m);				
				else if ((k = ((int)(sum/.05F))) > 1) displayChange(k, " nickels", (sum = (int)(((sum%.05F)+.005F)*100F)/100F), m);
			case 7:
				if((k = ((int)(sum/.01F))) == 1) displayChange(k, " penny", (sum = (int)(((sum%.01F)+.005F)*100F)/100F), m);				
				else if ((k = ((int)(sum/.01F))) > 1) displayChange(k, " pennies", (sum = (int)(((sum%.01F)+.005F)*100F)/100F), m);
			default: break;
			}
		}

	}
	
	public static void displayChange(int numCurrency, String nameCurrency, float total, int previousCurrency){
		
		if(total > 0) System.out.print(numCurrency + nameCurrency + ", ");
		else if(previousCurrency > 0 && total == 0) System.out.println("and " + numCurrency + nameCurrency + ".");
		else System.out.println(numCurrency + nameCurrency + ".");
	}
}