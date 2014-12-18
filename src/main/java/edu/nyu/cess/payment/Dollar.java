package edu.nyu.cess.payment;

import java.util.HashMap;

public class Dollar implements Currency {
	private Double amount;
	private String symbol = "$";
	private String type = "Dollars";
	private String dollar;
	private String cents;
	private Integer dollarValue;
	private Double centValue;
	
	private static final Double MAX_AMOUNT = 999.99;
	
	public Dollar(){
		this.amount = 0.0;
	}
	
	public Dollar(Double amount){
		// 
		if(amount > MAX_AMOUNT){
			// Throw max amount exception
		}
		this.amount = amount;
		// Split dollar amount into dollars and cents 
		String[] tokenizedDollar = this.amount.toString().split("\\.");
		this.dollar = tokenizedDollar[0];
		this.cents = tokenizedDollar[1];
		this.dollarValue = Integer.parseInt(this.dollar, 10);
		this.centValue = Double.parseDouble("00." + this.cents);
	}
	
	private HashMap<String, Integer> getDollarPlaceValues(Integer maxPlaceValue){
		HashMap<String, Integer> amountInPlaceValues = new HashMap<String, Integer>();
		
		// Dollar amount is in the hundredthsDollarValue
		if(maxPlaceValue >= 3){
			amountInPlaceValues.put("100", Integer.valueOf(String.valueOf(dollar.charAt(0))));
			amountInPlaceValues.put("10", Integer.valueOf(String.valueOf(dollar.charAt(1))));
			amountInPlaceValues.put("1", Integer.valueOf(String.valueOf(dollar.charAt(2))));
		}

		// Dollar amount is in the TENS
		if(maxPlaceValue == 2){
			amountInPlaceValues.put("10",  Integer.valueOf(String.valueOf(dollar.charAt(0))));
			amountInPlaceValues.put("1", Integer.valueOf(String.valueOf(dollar.charAt(1))));
		}

		// Dollar amount is in the ONES
		if(maxPlaceValue == 1){
			amountInPlaceValues.put("1", Integer.valueOf(String.valueOf(dollar.charAt(0))));
		}
		return amountInPlaceValues;
	}
	
	private HashMap<String, Integer> getCentPlaceValues(Integer maxPlaceValue){
		HashMap<String, Integer> amountInPlaceValues = new HashMap<String, Integer>();
		
		// Cent amount is TENS
		if(maxPlaceValue >= 2){
			amountInPlaceValues.put("10",  Integer.valueOf(String.valueOf(cents.charAt(0))));
			amountInPlaceValues.put("100", Integer.valueOf(String.valueOf(cents.charAt(1))));
		}

		// Cent amount is in the ONES
		if(maxPlaceValue == 1){
			amountInPlaceValues.put("10", Integer.valueOf(String.valueOf(cents.charAt(0))));
			amountInPlaceValues.put("100", 0);
		}
		
		return amountInPlaceValues;
	}
	
	private String constructDollarsToWords(){
		String dollarAmountInWords = "";
		
		HashMap<Integer, String> oneToNineteen = new HashMap<Integer, String>();
		oneToNineteen.put(1, "One");
		oneToNineteen.put(2, "Two");
		oneToNineteen.put(3, "Three");
		oneToNineteen.put(4, "Four");
		oneToNineteen.put(5, "Five");
		oneToNineteen.put(6, "Six");
		oneToNineteen.put(7, "Seven");
		oneToNineteen.put(8, "Eight");
		oneToNineteen.put(9, "Nine");
		oneToNineteen.put(10, "Ten");
		oneToNineteen.put(11, "Eleven");
		oneToNineteen.put(12, "Twelve");
		oneToNineteen.put(13, "Thirteen");
		oneToNineteen.put(14, "Fourteen");
		oneToNineteen.put(15, "Fifteen");
		oneToNineteen.put(16, "Sixteen");
		oneToNineteen.put(17, "Seventeen");
		oneToNineteen.put(18, "Eighteen");
		oneToNineteen.put(19, "Nineteen");
		
		HashMap<Integer, String> multiplesOfTen = new HashMap<Integer, String>();
		multiplesOfTen.put(1, "Ten");
		multiplesOfTen.put(2, "Twenty");
		multiplesOfTen.put(3, "Thirty");
		multiplesOfTen.put(4, "Forty");
		multiplesOfTen.put(5, "Fifty");
		multiplesOfTen.put(6, "Sixty");
		multiplesOfTen.put(7, "Seventy");
		multiplesOfTen.put(8, "Eighty");
		multiplesOfTen.put(9, "Ninety");
		
		HashMap<String, Integer> dollarPlaceValues = getDollarPlaceValues(this.dollar.length());

		// dollar amount contains 999-100 
		if(dollarPlaceValues.containsKey("100") && dollarPlaceValues.get("100") >= 1 ){
			dollarAmountInWords = dollarAmountInWords + oneToNineteen.get(dollarPlaceValues.get("100")) + " Hundred";
		}
		
		// dollar amount contains 20-99
		if(dollarPlaceValues.containsKey("10") && dollarPlaceValues.get("10") >= 2){
			dollarAmountInWords = dollarAmountInWords + ((!dollarAmountInWords.equals(""))?" ":"") + multiplesOfTen.get(dollarPlaceValues.get("10"));
		}
		
		// dollar amount contains 10-19 
		if(dollarPlaceValues.containsKey("10") && dollarPlaceValues.get("10") == 1){
			Integer tensValue = dollarPlaceValues.get("10")*10 + dollarPlaceValues.get("1");
			dollarAmountInWords = dollarAmountInWords + ((!dollarAmountInWords.equals(""))?" ":"") + oneToNineteen.get(tensValue);
		}
		
		// dollar amount contains 1-9 
		if(dollarPlaceValues.containsKey("1") && dollarPlaceValues.containsKey("10") && dollarPlaceValues.get("1") >= 1 && dollarPlaceValues.get("10") != 1){
			dollarAmountInWords = dollarAmountInWords + ((!dollarAmountInWords.equals(""))?" ":"") + oneToNineteen.get(dollarPlaceValues.get("1"));
		}
		else if(dollarPlaceValues.containsKey("1") && !dollarPlaceValues.containsKey("10") && dollarPlaceValues.get("1") >= 1){
			dollarAmountInWords = dollarAmountInWords + ((!dollarAmountInWords.equals(""))?" ":"") + oneToNineteen.get(dollarPlaceValues.get("1"));
		}

		// add the word "dollars" to the end of the string if there were any
		if(this.dollarValue > 0){
			dollarAmountInWords = dollarAmountInWords + " " + this.type;
		}
		
		return dollarAmountInWords;
	}
	
	private String constructCentsToWords(){
		String centsInWords = "";
		
		HashMap<Integer, String> oneToNineteen = new HashMap<Integer, String>();
		oneToNineteen.put(1, "One");
		oneToNineteen.put(2, "Two");
		oneToNineteen.put(3, "Three");
		oneToNineteen.put(4, "Four");
		oneToNineteen.put(5, "Five");
		oneToNineteen.put(6, "Six");
		oneToNineteen.put(7, "Seven");
		oneToNineteen.put(8, "Eight");
		oneToNineteen.put(9, "Nine");
		oneToNineteen.put(10, "Ten");
		oneToNineteen.put(11, "Eleven");
		oneToNineteen.put(12, "Twelve");
		oneToNineteen.put(13, "Thirteen");
		oneToNineteen.put(14, "Fourteen");
		oneToNineteen.put(15, "Fifteen");
		oneToNineteen.put(16, "Sixteen");
		oneToNineteen.put(17, "Seventeen");
		oneToNineteen.put(18, "Eighteen");
		oneToNineteen.put(19, "Nineteen");
		
		HashMap<Integer, String> multiplesOfTen = new HashMap<Integer, String>();
		multiplesOfTen.put(1, "Ten");
		multiplesOfTen.put(2, "Twenty");
		multiplesOfTen.put(3, "Thirty");
		multiplesOfTen.put(4, "Forty");
		multiplesOfTen.put(5, "Fifty");
		multiplesOfTen.put(6, "Sixty");
		multiplesOfTen.put(7, "Seventy");
		multiplesOfTen.put(8, "Eighty");
		multiplesOfTen.put(9, "Ninety");
		
		HashMap<String, Integer> centPlaceValues = getCentPlaceValues(this.cents.length());
	
		// Cents value is between 20 and 99
		if(centPlaceValues.containsKey("10") && centPlaceValues.get("10") > 1){
			centsInWords = centsInWords + ((!centsInWords.equals(""))?" ":"") + multiplesOfTen.get(centPlaceValues.get("10"));
		}

		// Cents value is between  10 and 19
		if(centPlaceValues.containsKey("10") && centPlaceValues.get("10") == 1){
			Integer tensValue = centPlaceValues.get("10")*10 + centPlaceValues.get("100");
			centsInWords = centsInWords + ((!centsInWords.equals(""))?" ":"") + oneToNineteen.get(tensValue);
		}
		
		// Cents value is between 01 and 09
		if(centPlaceValues.containsKey("100") && centPlaceValues.containsKey("10") && centPlaceValues.get("10") != 1 && centPlaceValues.get("100") > 0){
			centsInWords = centsInWords + ((!centsInWords.equals(""))?" ":"") + oneToNineteen.get(centPlaceValues.get("100"));
		}
	
		if(this.centValue > 0){
			centsInWords = centsInWords + " " + "Cents";
		}
		
		return centsInWords;
	}

	@Override
	public String getInWords(){
		String dollarsInWords = constructDollarsToWords();
		String centsInWords = constructCentsToWords();

		return dollarsInWords + " " + centsInWords;
		
	}

	@Override
	public Double getNumericalValue() {
		return this.amount;
	}
	
	public String getInCurrency(){
		String currency = this.symbol + this.dollar + ".";
		if(this.cents.length() >= 2){
			currency = currency+this.cents.charAt(0)+this.cents.charAt(1);
		}else if(this.cents.length() == 1){
			currency = currency+this.cents.charAt(0)+"0";
		}else{
			currency = currency+"00";
		}
		
		return currency;
	}

	public String toString(){
		return this.symbol+amount.toString();
	}
	
	public void setAmount(Double amount){
		this.amount = amount;
		
		// Split dollar amount into dollars and cents 
		String[] tokenizedDollar = this.amount.toString().split("\\.");
		this.dollar = tokenizedDollar[0];
		this.cents = tokenizedDollar[1];
		this.dollarValue = Integer.parseInt(this.dollar, 10);
		this.centValue = Double.parseDouble("."+this.cents);
	}
	
}
