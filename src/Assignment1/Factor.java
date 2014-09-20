
import java.util.*;
import java.io.*;

/**
 * The Factor class which finds the factors and Greatest Common Denominator of given ints (not implemented yet)
 * @author ros_aljacobson001
 *	
 */
public class Factor {
	
	public ArrayList<Integer> theFactors;
	public ArrayList<Integer> secondFactors;
	public ArrayList<Integer> GCD;
	public int theGCD;
	public int theInput;
	public String userInput = " ";
	public boolean isGCD = false;
	public String state = "GOOD";
	
	public final class FactorStates{
		public static final String ONE_TOO_HIGH = "Error, one of the numbers is too high.";
		public static final String ONE_TOO_LOW = "Error, one of the numbers is too low.";
		public static final String TOO_HIGH = "Error, the number is too high";
		public static final String TOO_LOW = "Error, the number is too low";
		public static final String GOOD = "GOOD";
	}
	
	public Factor(){
		theFactors = new ArrayList<Integer>();
		secondFactors = new ArrayList<Integer>();
		secondFactors.add(1);
		GCD = new ArrayList<Integer>();
		theGCD = 1;
		//runProgram();
	}
	
	public void runProgram(){
		while(!userInput.equalsIgnoreCase("quit")){
			userInput = getInput();
			if(userInput.equalsIgnoreCase("quit")){
				
			}else{
				Scanner stringScanner = new Scanner(userInput);
				int first = stringScanner.nextInt();
				if(stringScanner.hasNextInt()){
					int second = stringScanner.nextInt();
					if(first > 100 || second > 100){
						state = FactorStates.ONE_TOO_HIGH;
						System.out.println("One of the numbers is too big.");
					}else if(first < 1 || second < 1){
						state = FactorStates.ONE_TOO_LOW;
						System.out.println("One of the numbers is too small.");
					}else{
						calcFactors(first);
						isGCD = true;
						calcFactors(second);
						calcGCD();
						findGCD();
						printGCD();
					}
				}else{
					if(first > 100){
						state = FactorStates.TOO_HIGH;
						System.out.println("The number is too big.");
					}else if(first < 1){
						state = FactorStates.TOO_LOW;
						System.out.println("The number is too small.");
					}else{
						isGCD = false;
						calcFactors(first);
						printFactors();
					}
				}
			}
			
			secondFactors.clear();
			theFactors.clear();
			GCD.clear();
			theGCD = 1;
			isGCD = false;
		}
	}
	
	public void calcGCD(){
		System.out.println("Calculating GCD.");
		for(int currentFirst = 0;currentFirst < theFactors.size()-1;currentFirst++){
			for(int currentSecond = 0;currentSecond < secondFactors.size();currentSecond++){
				if(theFactors.get(currentFirst) == secondFactors.get(currentSecond)){
					GCD.add(theFactors.get(currentFirst));
				}
			}
		}
	}
	
	public void checkInput(){
			/*if(userInput.equalsIgnoreCase("quit")){
				
			}else{
				Scanner stringScanner = new Scanner(userInput);
				int first = stringScanner.nextInt();
				if(stringScanner.hasNextInt()){
					int second = stringScanner.nextInt();
					if(first > 100 || second > 100){
						state = FactorStates.ONE_TOO_HIGH;
						System.out.println("One of the numbers is too big.");
					}else if(first < 1 || second < 1){
						state = FactorStates.ONE_TOO_LOW;
						System.out.println("One of the numbers is too small.");
					}else{
						calcFactors(first);
						isGCD = true;
						calcFactors(second);
						calcGCD();
						findGCD();
						printGCD();
					}
				}else{
					if(first > 100){
						state = FactorStates.TOO_HIGH;
						System.out.println("The number is too big.");
					}else if(first < 1){
						state = FactorStates.TOO_LOW;
						System.out.println("The number is too small.");
					}else{
						isGCD = false;
						calcFactors(first);
						printFactors();
					}
				}
			}*/
		if(
	}
	
	public void findGCD(){
		for(int currentPlace = 0;currentPlace < GCD.size();currentPlace++){
			if(GCD.get(currentPlace) > theGCD){
				theGCD = GCD.get(currentPlace);
			}
		}
	}
	
	public String getInput(){
		System.out.println("This program will give the factors of any given number to you.");
		System.out.println("Please enter your input, either give a number to get the factors, or \"quit\" to quit.");
		Scanner input = new Scanner(System.in);
		return input.nextLine();
	}
	
	public void calcFactors(int input){
		ArrayList<Integer> theReturn = new ArrayList<Integer>();
		for(int currentPlace = 1;currentPlace <= input; currentPlace++){
			int intCheck = input / currentPlace;
			double dubCheck = (double)input / currentPlace;
			if(intCheck == dubCheck && !checkIfFound(intCheck)){
				if(!checkIfFound(currentPlace)){
					theReturn.add(currentPlace);
				}
			}
		}
		if(!isGCD){
			System.out.println(theFactorsString(theReturn));
			theFactors = theReturn;
			sortFactors(theFactors);
		}else{
			System.out.println(theFactorsString(theReturn));
			secondFactors = theReturn;
		}
	}
	
	public void sortFactors(ArrayList<Integer> toSort){
		for(int currentPlace = 0;currentPlace < toSort.size();currentPlace++){
			for(int currentCheck = currentPlace;currentCheck < toSort.size();currentCheck++){
				if(toSort.get(currentPlace) > toSort.get(currentCheck)){
					int tempStore = toSort.get(currentCheck);
					toSort.set(currentCheck, toSort.get(currentPlace));
					toSort.set(currentPlace, tempStore);
				}else if(theFactors.get(currentPlace) == toSort.get(currentCheck) && currentPlace != currentCheck){
					toSort.remove(currentCheck);
				}
			}
		}
	}
	
	public boolean checkIfFound(int toCheck){
		for(int currentPlace = 0; currentPlace < theFactors.size();currentPlace++){
			if(isGCD){
				return false;
			}else{
				if(toCheck == theFactors.get(currentPlace)){
					return true;
				}
				
			}
		}
		return false;
	}
	
	public ArrayList<Integer> getTheFactors(){
		return theFactors;
	}
	
	public String theFactorsString(ArrayList<Integer> toPrint){
		String theReturn = "";
		for(int currentPlace = 0;currentPlace < toPrint.size();currentPlace++){
			theReturn = theReturn + toPrint.get(currentPlace) + " ";
		}
		if(toPrint.size() == 0){
			theReturn = "Nothing";
		}
		return theReturn;
	}
	
	public void printFactors(){
		System.out.println(theFactorsString(theFactors));
	}
	
	public void printGCD(){
		System.out.println(theGCD);
	}
}