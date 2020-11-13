/*
 * Name: Antonio Knight
 * 
 * Date:09/27/20
 * 
 * Assignment: Project partC (PartC.java)
 * 
 * Pseudocode:
 * 
 * Repeat (Until exit)
 * 		Initialize all variables ( F name, L name, hours worked, hourly rate, purchases) 
 *		Display menu (1. wage Calculator 2. coupon Calculator 3. Roman numeral Convetor 4. Wages report 5. Coupon Report 6. exit )
 *		Prompt user for menu option 
 *		if option is 1 
 *			call calc_wages 
 *		otherwise if option 2 
 *			call calc_coupon
 *		otherwise if option 3 
 *			call roman_convert 
 *		otherwise if option 4 
 *			call wage_Report 
 *		otherwise if option 5 
 *			call coupon_Report  
 *		otherwise call exit 
 *
 * Method calc_wages 
 *
 *		initialize all variables 
 *		prompt user for fname, L name 
 *		prompt user for hourly pay 
 *		prompt user for hours worked 
 *		display f name, L name 
 *		
 *		Repeat (for greater than 40 hours worked )
 *			prompt user for hours worked 
 *
 *		if hours work greater than 40 
 *			calculate overtime by subtracting 40 hours worked 
 * 			calculate overtime pay 
 *			display overtime hours, overtime pay 
 *			set hours work to 40 
 *			calculate regular pay 
 *			display hours worked , regular pay 
 *			display total pay 
 *		otherwise if hours wroked less than 40,
 *			Return rate multiplied by hours 
 *			Store values into array
 *			Display totalpay
 *		
 *	
 * Method roman_convert
 * 
 * 		Prompt user to enter roman numeral
 * 		Calculate weather add or subtract based on each char into valueOf 
 * 		in order to get decimal value
 * 		Display decimal number
 *
 *	
 * Method calc_coupon 
 * 
 *		initialize all variables 
 *		prompt user for purchase price 
 *		promt user menu (1.Auto Parts 2.Frangrances 3.Accessories
 *		count++
 *		Store total purchase and coupon ammount into array
 *		Display coupon ammount
 *		Display purchase ammount
 *		Display thank you
 *
 * Method coupon_Report 
 *
 *		Return user infomation from array
 *		Display total coupon ammount
 *		Display total purchases ammount
 *
 *
 * Method valueOf 
 *		if numeral = 'I'
 *			return 1; 
 *		otherwise if numeral = 'V'
 *			return 5;
 *		otherwise if numeral = 'X'
 *			return 10; 
 *		otherwise if numeral = 'L'
 *			return 50; 
 *		otherwise if numeral = 'C'
 *			return 100; 
 *		otherwise if numeral = 'D'
 *			return 500; 
 *		otherwise
 *			must be an M
 *			return 1000;
 *
 * Method wagesReport 
 *		initialize new file to wagesreport.txt
 *		allow program to create new file for information 
 *		
 * Method wage_Report
 *		write wage information to file in correct format
 *		Display output to user
 *
 * Method exit 
 *		prompt user for (1. confirm exit 2. cancel exit )
 *		if user selects one 
 *			display number of wages calculated 
 *			display total purchases sold 
 *			display thank you message 
 *		otherwise if user selects 2 
 *			return false and continue to menu
 * 
 */


import java.util.*;
import java.io.*;
import java.util.ArrayList;


public class PartC {
	//Global scanner
	public static Scanner in = new Scanner(System.in);
	//Global parameters
	static ArrayList<Double> coupons = new ArrayList<Double>();
    static ArrayList<Double> purchases = new ArrayList<Double>();
    static int count;
    
	public static void main(String[] args) {
		
		
		
	String menu="Calculator Menu \n 1) Wage calculator, \n 2) Coupon calculator \n 3) Roman Number Converter \n 4) Wages Report \n 5) Coupon Report \n 6) Exit.";
	boolean quit=false;
    	

    
		
        while(!quit) {
		 System.out.println(menu);
		
		System.out.println("Please enter your choice: ");
		 int option = in.nextInt(); 
		
		
		if(option==1) {
			calc_wages();
		}
		else if(option== 2) {
			calc_coupon();
		}
		else if(option== 3) {
			roman_convert();
			
		}
		else if(option== 4) {
			wagesReport();
			
		}
		else if(option== 5) {
			coupon_Report(coupons, purchases);
			
		}
		else if(option== 6) {
            if (exit(purchases, count)==true) {
                 quit=true; 
            }
            else {
            	quit=false;
            }
		}
    }
}//main

	/**
	Method valueOf - Gives the value of the Roman numeral @param numeral a single Roman numeral
	@return the decimal value of numeral
	*/
	public static int valueOf(char numeral) {
	
		if (numeral == 'I') {
			return 1; 
	}
		if (numeral == 'V') {
			return 5;
	}
		if (numeral == 'X') {
			return 10; 
	}
		if (numeral == 'L') {
			return 50; 
	}
		if (numeral == 'C') {
			return 100; 
	}
		if (numeral == 'D') {
			return 500; 
	}
	//must be an M
		return 1000;
}
	/**
	Method calc_wages - Gives us functions and all lets user input information  
	in order to calculate wages
	*/
	public static void calc_wages() {
		
		
		//Declare variables
		String fname = "";
		String lname = "";
		double workingHours = 0;
		double workingovertime = 0;
		double hourlyWage = 0;
		
		//checkInput();


		try 
		{
		System.out.println("Please enter your first and last name: ");
		if(in.hasNext()) {
			fname=in.next();
			lname=in.next();
		}
		System.out.println("Please enter hourly wage: ");
		if (in.hasNextDouble()) {
			hourlyWage = in.nextDouble();
		}
		
		System.out.println("Please enter your hours worked: ");
		if (in.hasNextDouble()) {
			workingHours=in.nextDouble();
			if(workingHours>=40) {
				
				System.out.println("Please enter up to work 40hrs of regular work hours. Try Again!");
				if (in.hasNextDouble()) {
					workingHours=in.nextDouble();
					workingHours=40;
					 System.out.println("Please enter overtime hours worked: ");
					    if (in.hasNextDouble()) {
					    	workingovertime=in.nextDouble();
					    }
				}
				else {
					workingovertime=0;
				}
			}
		}
		count++;
	}
			
		
		catch (InputMismatchException e) {
			System.out.print("Please Try Again..");
		}
				
		wage_Report(fname,lname, hourlyWage, workingHours, workingovertime,count);
				
		
	}
	/**
	Method wagesReport - prints wageReport.txt and all calculations from user input 
	in order to read wages.
	*/	
	 public static void wagesReport() {
		 
         String fileName = "wageReport.txt";
         Scanner in = new Scanner(fileName);
         
         
         while (in.hasNextLine()) {
              System.out.println(in.nextLine());
         }
         in.close();
     }
	/**
	Method wage_Report - calls print writter functions and prints all calculations from 
	method calc_wages in order to print wages.
	*/	
	public static String wage_Report(String fname,String lname, double hourlyWage, double workingHours, double workingovertime,int count) {
		
		
		//Declare varriables
		double minwage;
		double payAmount;
		double totalPay;

		
		try {
			
			File wageReport=new File("wageReport.txt");
			FileWriter FileWriter=new FileWriter(wageReport,true);
			BufferedWriter printWriter = new BufferedWriter(FileWriter);
			
			if(workingHours>=40) {
				//Calculation
				minwage =hourlyWage * workingHours;
				payAmount =hourlyWage*workingovertime*(1.5);
				totalPay=minwage+payAmount;
				
				//Write to file
				printWriter.write("Hello: " + fname +" "+lname+" Your regular hours worked are "+workingHours+". "+ "Your overtime hours worked are "+workingovertime+"."+			
				" Your regular pay: "+minwage+" Your overtime pay: "+payAmount+" Your total pay: "+totalPay);
				printWriter.newLine();
				
				//Print to user
				System.out.println("Hello: " + fname +" "+lname);
				System.out.println("Your regular hours worked are "+workingHours+". "+ "Your overtime hours worked are "+workingovertime+".");
				System.out.printf("Your regular pay: $%,.2f \n",minwage);
				System.out.printf("Your overtime pay: $%,.2f \n",payAmount);
				System.out.printf("Your total pay: $%,.2f \n",totalPay);
				System.out.println("");
				System.out.println("Thank you for using the Wage Calculator "+fname +" "+lname+"!");
				System.out.println("");
				System.out.println("Have a great day!");
				System.out.println("");
			    
				count++;
			}
			
			else {
				//Calculation
				minwage =hourlyWage * workingHours;
				totalPay=minwage;
				
				//Write to file
				printWriter.write("Hello: " + fname +" "+lname+" Your regular hours worked are "+workingHours+". "+"Your total pay: "+totalPay);
				printWriter.newLine();
				//Print to user
				System.out.println("Hello: " + fname +" "+lname);
				System.out.println("Your regular hours worked are "+workingHours+".");
				System.out.printf("Your total pay: $%,.2f \n",totalPay);
				System.out.println("");
				System.out.println("Thank you for using the Wage Calculator "+fname +" "+lname+"!");
				System.out.println("");
				System.out.println("Have a great day!");
				System.out.println("");
				
				count++;
			}
			printWriter.close();
			FileWriter.close();
		}
		catch (IOException e) {
			System.out.print("File Error, Try again later.");
			
		}
		return fname +" "+lname;
		
	}
	
	/**
	 * @param fname,lname,hourlywage,workinghours,workingovertime,count is passed into
	Method calc_coupon - calls functions and all calculations from user input 
	in order to coupon calculator
	*/
	public static void calc_coupon() {
		
		//Declare varribales
		double couponAmt = 0;
		double total = 0;
		
		//checkInput();

		System.out.println("Please enter purchase amount $: ");
		double purchaseAmount=in.nextDouble();
		System.out.println("Please enter purchase type (1=Auto Parts, 2=Frangrances, 3=Accessories): ");
		int type=in.nextInt();
		
		
		
		//Runs 10% discount if user types "1"
		if (type==1) {

			
			couponAmt=purchaseAmount*(.10);
			total=purchaseAmount-couponAmt;

			System.out.println("Your coupon amount is $"+couponAmt+ " (Auto Parts).");
			System.out.println("");
			System.out.printf("Your new total is $%,.2f \n",total);
			System.out.println("Thank you for using the Coupon Calculator!");
			System.out.println("");
			System.out.println("Have a great day!");
			System.out.println("");
		}
		//Runs 15% discount if user types "2"
		if (type==2) {

			couponAmt=purchaseAmount*(.15);
			total=purchaseAmount-couponAmt;

			System.out.println("Your coupon amount is $"+couponAmt+ " (Frangrances).");
			System.out.println("");
			System.out.printf("Your new total is $%,.2f \n",total);
			System.out.println("Thank you for using the Coupon Calculator!");
			System.out.println("");
			System.out.println("Have a great day!");
			System.out.println("");
		}
		//Runs 20% discount if user types "3"
		if (type==3) {

			couponAmt=purchaseAmount*(.20);
			total=purchaseAmount-couponAmt;

			System.out.println("Your coupon amount is $"+couponAmt+ " (Accessories).");
			System.out.println("");
			System.out.printf("Your new total is $%,.2f \n",total);
			System.out.println("Thank you for using the Coupon Calculator!");
			System.out.println("");
			System.out.println("Have a great day!");
			System.out.println("");
		}
		//Adding results to array
		coupons.add(couponAmt);
		purchases.add(total);
		
	}
	
	/**
	 * @param coupous and purchases are passed in to the Method 
	 * coupon_Report - reports coupon sun and purchase amount from user input using advanced for loops.
	*/
	public static void coupon_Report(ArrayList<Double> coupons,ArrayList<Double> purchases) {
		
		
		 //Declare varriables
		 double purchasSums = 0;
		 double couponSum=0;
		

		 
         for (Double couponAmt : coupons) {
        	 couponSum += couponAmt;
         }

         for (Double total : purchases) {
        	 purchasSums += total;
         }

         System.out.printf("Total coupon ammount collected: $%.2f. \n", couponSum);
         System.out.printf("Total amount of purchases sold: $%.2f.\n ", purchasSums);

     }
	/**
	Method roman_convert - Calculates user input and passes it through valueOf
	in order to calculate conversion.
	*/	
	public static void roman_convert() {
		
		//Declare Varribles
		int total=0,i=0;
		char str, next;
		String numeral;
		

		System.out.print("Please enter a Roman numeral: ");
		numeral=in.next();
			
		//Create looop 
		for (i=0; i<(numeral.length()-1); ++i) {
			
			str= numeral.charAt(i);
			next = numeral.charAt(i + 1);
		
		if(valueOf(str) >= valueOf(next)){
			total += valueOf(str);
		}
		else {
			total += (valueOf(next) - valueOf(str));
			i++;
			}  
		  }
		total += valueOf(numeral.charAt(i));
		System.out.println(total);
	}
	/**
	 * @param purchases,int are passes in the method in order to print requried statements  
	Method exit - makes sure user decideds to quit program.
	*/
	public static boolean exit(ArrayList<Double> purchases,int count) {
		double PurchasesSum = 0;
		int choice = 0;
		//checkInput();

        try {
        	System.out.println("Would you like to:\n 1. Confirm exit\n 2. Cancel exit");
             if (in.hasNextInt()){
                 choice = in.nextInt();
                 if (choice == 1){
                      for (int i = 0; i < purchases.size(); i++){
                    	  PurchasesSum += purchases.get(i);
                      }
             System.out.printf("Number of wages calculated: %d\n", count);
             System.out.printf("Total purchases sold: %.2f\n", PurchasesSum);
             System.out.println("Thank You for using the program.");
                      return true;
                 }
                 else if (choice == 2) {
                      in.nextLine();
                      return false;
                 } 
                 else {
             System.out.println("Invalid option. The program will now exit. Thank you for using the menu system.");
                      return true;
                 } 

             } 

        } 
        catch (InputMismatchException e){
             System.out.println("Invalid entry.");
        }
        return false;

    }
	
	
	
	public static void checkInput() {
		//int obj = in.hasNextInt()<0;
		
		
		if (in.useDelimiter("-") != null) 
			System.out.print("Must be greater than 0!");

		
	}
	
	
}//class	



