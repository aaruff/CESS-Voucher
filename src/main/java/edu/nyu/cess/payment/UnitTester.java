package edu.nyu.cess.payment;

import java.util.regex.Pattern;

public class UnitTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		unitTest();
	}
	private static boolean unitTest(){
		String amountInWords;
		Dollar dollar = new Dollar();
		
		 Pattern pattern = Pattern.compile("null");
		for(double i = 0; i < 2000; i++){
			i = i + 0.01;
			dollar.setAmount(i);
			amountInWords = dollar.getInWords();
			if(pattern.matcher(amountInWords).find()){
				System.out.print("ERROR: ");
				System.out.println(i);
				System.out.println(amountInWords);
				System.out.println("Dollar Amount: " +  dollar.getNumericalValue());
				return false;
			}
			else{
				System.out.println("*****************************************************");
				System.out.println(i);
				System.out.println(amountInWords);
				System.out.println("Dollar Amount: " +  dollar.getNumericalValue());
				System.out.println("*****************************************************");
			}
		}
		return true;
	}

}
