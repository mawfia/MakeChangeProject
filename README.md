##Make Change Project

This class was created on 28 September 2016 by Michael Andrew Williams.

This class calculates amount of change in USD currency after prompting user for item price and money tendered from customer.
The result is a message telling the user exact amount of dollars bills and coins using the largest dollar/coin possible (i.e. $10.00 in change
will result in one $10.00 bill not one $5.00 bill and five one $1.00 bills etc.).

How to Use Program:
----------------------------------------------------------------------------
Program accepts decimal (beyond two digits) and whole, as well as negative and positive numbers.  However, in order for the code to correctly process transactions price and amount tendered should be in true dollar and coin amounts, otherwise user will be prompted to enter in a valid dollar coin amount, or cancel the transaction.  Values entered with greater than 2 decimal places will be truncated to 2.  Responses to prompts can be in lowercase or uppercase and should be with the provided choices "y" of "n".

This class is comprised of four methods: main, requestPrice, moneyTendered, calculateChange, and displayChange.

public static void main(String[] args):
-----------------------------------------------
This methods only function is to call method requestPrice().

public static boolean requestPrice():
-----------------------------------------------
This method accepts no data, and returns true once complete processing a new transaction.

1.  Prompts user for the price of the item purchased.
2.  Tests to see if the amount entered for price is valid.  
	a.	If the amount entered is greater than size allocated for float data or a negative number, outputs error message and recalls requestPrice() method.
	b.	If the amount entered is a valid currency amount method moneyTendered() is called.
3.	Following return from method call, prompts user for another transaction.
4.  Checks for a "Y or N" entered by the user.
	a.	If the response is "Y", requestPrice() is called.
	b.	If the response is "N" this method closes the scanner object, terminates, and returns control to main().
	c.	Any other response will result in a prompt for "Y" or "N".


public static void moneyTendered(float itemPrice):
----------------------------------------------------
This method accepts price of item from customer as a float data type. No data is returned.

1.	Prompts user for amount tendered from customer.
2.	Tests to see if the amount entered for purchase of item is valid.  
	a.	If the amount entered is greater than size allocated for float data or a negative number, outputs error message and recalls moneyTendered() method.
3.	Checks to see if amount equals price, is less than price, or is greater than price of item.
	a.	If cash tendered equals price, outputs message and returns to requestPrice() method.
	b.	If cash tendered is less than price, outputs "Customer provided too little money." and prompts user asking,
		"Does the customer still want to purchase the item? (Y or N): ".  
			If "y" is entered moneyTendered is called.  If "n" is entered returns to requestPrice(). All other response will result in another prompt.
	c.	If money tendered is greater than price of item, calculates amount of change due and passes this calculation in call to calculateChange() method.

public static void calculateChange(float change):
--------------------------------------------------
This method accepts amount of change due as a float and returns amount of each USD currency to be given to customer.

1.	Compares change amount with each dollar/coin.
2.	Flag variable "int m" is set (line 73), whenever a currency is used as change.
3.	Amount of each dollars/coins is determined by dividing change amount by each dollar/coin.
	a.	If the dividend (or result) is greater or equal to one, displayChange() method is called and passed:
		number of currency to be displayed, number of currency to be given back, a message, and flag m.
	b.	If the dividend is less 1, next currency is evaluated.

public static void displayChange(int numCurrency, String nameCurrency, float total, int previousCurrency):
----------------------------------------------------------------------------------------------------------
This method accepts number of dollar(s)/coin(s) to be displayed, a message with the name of the dollar(s)/coin(s), the amount of change remaining
to be calculated, and a flag that checks to see if a previous dollar/coin was used.  This method does not return any data.

1.  If there is still change left to be processed, outputs message with requested dollar/coin amount.
2.	If there is no change left to be processed and another dollar/coin has been processed, outputs message with the word "and".
3.	If there is no change left to process and no other dollar/coins have been processed outputs message with requested dollar/coin amount.
