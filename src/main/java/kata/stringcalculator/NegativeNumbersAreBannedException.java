package kata.stringcalculator;

public class NegativeNumbersAreBannedException extends RuntimeException{

	public NegativeNumbersAreBannedException(int number) {
		super(Integer.toString(number));
	}

}
