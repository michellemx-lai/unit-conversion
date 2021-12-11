import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pro2_laimic12 {


    //object to read user input at command line
    public static BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
   
    //constant used to convert inch to centimeter
    public static final double _IN_TO_CM_ = 2.54;
    public static void main(String[] args) throws IOException, NumberFormatException {
    	
    	//call displayMenu() to display the menu of options
        displayMenu();
        
        //call chooseOption() for user to choose their menu option
        chooseOption();
    }
    
    /*function to take in user input of a valid integer between the lower bound (LB) and upper bound (UB) set by the user. 
    Prints error messages if user input is invalid. Returns an integer.*/
    public static int getInteger(String prompt, int LB, int UB) throws IOException, NumberFormatException {
        boolean valid;
        int userInput = 0;
        
		//print an error message and ask user for a valid integer input each time the user provides an invalid input. 
        do {
        	valid = true;
        	System.out.print(prompt);
        	
        	//invalid if the input is not an integer
        	try {
        		userInput = Integer.parseInt(cin.readLine());
        	}
        	catch (NumberFormatException e) {
        		valid = false;
        	}
        	catch (IOException e) {
        		valid = false;
        	}
        	
		    //if UB is less than the maximum storable value of an int, then the actual UB value is displayed.
			if ((!valid || userInput < LB || userInput > UB) && UB < Integer.MAX_VALUE) {
				valid = false;
				System.out.print("ERROR: Input must be an integer in [" + LB + ", " + UB + "]!\n"
			        + "\n"
			        + "");
			}
			
			//Otherwise if UB is equal to the maximum storable value of a double, then “infinity” is displayed instead of the actual UB value.
			else if ((!valid || userInput < LB || userInput > UB) && UB >= Integer.MAX_VALUE) {
				valid = false;
				System.out.print("ERROR: Input must be an integer in [" + LB + ", infinity]!\n"
						+ "");
			}
        } while (!valid);
        return userInput;        
	} //end of getInteger()
    
    /*function to take in user input of a valid double between the lower bound (LB) and upper bound (UB) set by the user. 
    Prints error messages if user input is invalid. Returns a double.*/
    public static double getDouble(String prompt, double LB, double UB) throws IOException, NumberFormatException {
		boolean valid; 
		Double doubleInput = 0.0;
	
		//print an error message and ask user for a valid double input each time the user provides an invalid input.
		do {
			valid = true;
			System.out.print(prompt);
			
	    	//invalid if the input is not a real number
	    	try {
	    		doubleInput = Double.parseDouble(cin.readLine());
	    	}
	    	catch (NumberFormatException e) {
	    		valid = false;
	    	}
	    	catch (IOException e) {
	    		valid = false;
	    	}
			
			//if UB is less than the maximum storable value of a double, then the actual UB value is displayed.
			if ((!valid || doubleInput < LB || doubleInput > UB) && UB < Double.MAX_VALUE) {
				valid = false;
				System.out.print("ERROR: Input must be a real number in [" + LB + "0, " + UB + "]!\n"
					    + "\n"
					    + "");
			}
			
			//Otherwise if UB is equal to the maximum storable value of a double, then “infinity” is displayed instead of the actual UB value.
			else if ((!valid || doubleInput < LB || doubleInput > UB) && UB >= Double.MAX_VALUE) {
				valid = false;
				System.out.print("ERROR: Input must be a real number in [" + LB + "0, infinity]!\n"
						+ "");
			}
		} while (!valid);

		return doubleInput;
	} //end of getDouble()
    
    //function to display the menu with three options
    public static void displayMenu() throws IOException, NumberFormatException {
    	System.out.print("   JAVA CONVERSION PROGRAM\n"
    			+ "0 - Quit\n"
    			+ "1 - Convert feet and inches to centimeters\n"
    			+ "2 - Convert centimeters to feet and inches\n"
    			+ "\n"
    			+ "");
    }//end of displayMenu()
    
    //function to choose between three options in menu
    public static void chooseOption() throws IOException, NumberFormatException {
	    int option;
	    
		option = getInteger("Enter choice: ", 0, 2);
		
	    if (option == 0) {
	    	System.out.print("\n"
	    			+ "Goodbye!\n"
	    			+ "");
	    	System.exit(0);
	    }
	    
	    else if (option == 1) {
	    	feetInchesToCm();
	    }
	    
	    else if (option == 2) {
	    	cmToFeetInches();
	    } 
    }//end of chooseOption()
    
    //function to convert feet and inches to centimeters
    public static void feetInchesToCm() throws IOException, NumberFormatException {
    	double totalInches, inches, feet, cm;
    	
    	//call getDouble() to get a valid input for number of feet
    	feet = getDouble("\n"
    			+ "Enter feet: ", 0.00, Double.MAX_VALUE);
    	
    	//call getDouble() to get a valid input for number of inches
    	inches = getDouble("Enter inches: ", 0.00, Double.MAX_VALUE);
    	
    	//convert cm to feet and inches mathematically
    	totalInches = feet * 12 + inches; 
    	cm = totalInches * _IN_TO_CM_;
    	
    	//print result
    	System.out.printf("\n"
    	+ "%.2f feet %.2f inches equals %.2f centimeters.\n"
    	+ "\n"
    	+ "", feet, inches, cm);
    	
    	displayMenu();
        chooseOption();
    } //end of feetInchesToCm()
    
    
    //function to convert centimeters to feet and inches
    public static void cmToFeetInches() throws IOException, NumberFormatException {
    	double cm, inches, feet;
    	
    	//call getDouble() to get a valid input for number of centimeters
    	cm = getDouble("\n"
    			+ "Enter centimeters: ", 0.00, Double.MAX_VALUE);
    	inches = cm / _IN_TO_CM_; 
    	
    	//convert inches to feet by dividing by 12. Feet must be an integer
    	feet = (int) (inches / 12);
    	
    	//the conversion to feet and inches results in an integer number of feet, and any fractional component(the remainder) goes to the inches
    	inches = inches % 12;
    	
    	//print result    	
    	System.out.printf("\n"
    	+ "%.2f centimeters equals %.2f feet %.2f inches.\n"
    	+ "\n"
    	+ "", cm, feet, inches);
    	
    	displayMenu();
        chooseOption(); 
    } //end of cmToFeetInches() 
}




