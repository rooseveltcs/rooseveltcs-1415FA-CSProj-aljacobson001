package Assignment1;
import java.util.*;
import java.io.*;

/**
 * The Factor class which finds the factors and Greatest Common Denominator of given ints (not implemented yet)
 * @author ros_aljacobson001
 *	
 */
public class Factor {
	
	private ArrayList<Integer> theFactors;
	private int theInput;
	private String userInput = " ";
	
	public Factor(){
		theFactors = new ArrayList<Integer>();
		runProgram();
	}
	
	public void runProgram(){
		while(!userInput.equalsIgnoreCase("quit")){
			theFactors.clear();
			System.out.println("This program will give the factors of any given number to you.");
			System.out.println("Please enter your input, either give a number to get the factors, or \"quit\" to quit.");
			userInput = getInput();
			if(userInput.equalsIgnoreCase("quit")){
			}else{
				theInput = Integer.parseInt(userInput);
				if(theInput > 100){
					System.out.println("The Number is too big.");
				}else if(theInput < 1){
					System.out.println("The Number is too small.");
				}else{
					calcFactors();
					printFactors();
				}
			}
		}
	}
	private String getInput(){
		Scanner input = new Scanner(System.in);
		return input.next();
	}
	
	private void calcFactors(){
		ArrayList<Integer> theReturn = new ArrayList<Integer>();
		for(int currentPlace = 1;currentPlace <= theInput; currentPlace++){
			int intCheck = theInput / currentPlace;
			double dubCheck = (double)theInput / currentPlace;
			if(intCheck == dubCheck && !checkIfFound(intCheck)){
				if(!checkIfFound(currentPlace)){
					theReturn.add(currentPlace);
				}
			}
		}
		theFactors = theReturn;
		sortFactors();
	}
	
	private void sortFactors(){
		for(int currentPlace = 0;currentPlace < theFactors.size();currentPlace++){
			for(int currentCheck = currentPlace;currentCheck < theFactors.size();currentCheck++){
				if(theFactors.get(currentPlace) > theFactors.get(currentCheck)){
					int tempStore = theFactors.get(currentCheck);
					theFactors.set(currentCheck, theFactors.get(currentPlace));
					theFactors.set(currentPlace, tempStore);
				}else if(theFactors.get(currentPlace) == theFactors.get(currentCheck) && currentPlace != currentCheck){
					theFactors.remove(currentCheck);
				}
			}
		}
	}
	
	private boolean checkIfFound(int toCheck){
		for(int currentPlace = 0; currentPlace < theFactors.size();currentPlace++){
			if(toCheck == theFactors.get(currentPlace)){
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<Integer> getTheFactors(){
		return theFactors;
	}
	
	private String theFactorsString(){
		String theReturn = "";
		for(int currentPlace = 0;currentPlace < theFactors.size();currentPlace++){
			theReturn = theReturn + theFactors.get(currentPlace) + " ";
		}
		if(theFactors.size() == 0){
			theReturn = "Nothing";
		}
		return theReturn;
	}
	
	public void printFactors(){
		System.out.println(theFactorsString());
	}
}