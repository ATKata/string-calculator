package kata.stringcalculator;

import java.util.Arrays;

public class StringCalculator {

	public int add(String string) {
		if(string.isEmpty()){
			return 0;
		}
		
		String delimiter = ",";
		if(string.startsWith("//")){
			delimiter = "" + string.charAt(2);
			string = string.substring(4);
		}
		
		String[] numberStrings = splitStringOnNewlineAndDelimiter(string, delimiter);
		
		int[] numbers = convertToIntegers(numberStrings);
		
		int total = 0;
		for(int number: numbers){
			if (number < 0) {
				throw new NegativeNumbersAreBannedException(number);
			}
			total += number;
		}
		return total;
	}

	private int[] convertToIntegers(String[] numberStrings) {
		return Arrays.asList(numberStrings).stream()
				.mapToInt((string) -> Integer.parseInt(string))
				.toArray();
	}

	private String[] splitStringOnNewlineAndDelimiter(String string,
			String delimiter) {
		String[] numberStrings = string.replaceAll("\n",delimiter).split(delimiter);
		return numberStrings;
	}
}
