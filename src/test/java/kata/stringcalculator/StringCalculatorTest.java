package kata.stringcalculator;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class StringCalculatorTest {
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
    @Test public void testAddEmptyString() {
        StringCalculator classUnderTest = new StringCalculator();
        assertEquals(0, classUnderTest.add(""));
    }
    
    @Test public void testAdd1() {
        StringCalculator classUnderTest = new StringCalculator();
        assertEquals(1, classUnderTest.add("1"));
    }
    
    @Test public void testAdd1And1() {
        StringCalculator classUnderTest = new StringCalculator();
        assertEquals(2, classUnderTest.add("1,1"));
    }
    
    @Test public void testAddMultipleNumbers() {
        StringCalculator classUnderTest = new StringCalculator();
        assertEquals(10, classUnderTest.add("1,2,3,4"));
    }
    
    @Test public void testAddNumbersWithNewline() {
        StringCalculator classUnderTest = new StringCalculator();
        assertEquals(6, classUnderTest.add("1\n2,3"));
    }
    
    @Test public void testAddNumbersWithNewDelimiter() {
        StringCalculator classUnderTest = new StringCalculator();
        assertEquals(3, classUnderTest.add("//;\n1;2"));
    }
    
    @Test
    public void shouldThrowExceptionWhenAddingNegitiveNumbers() {
    	exception.expect(NegativeNumbersAreBannedException.class);
    	exception.expectMessage("-1");
    	
        StringCalculator classUnderTest = new StringCalculator();
        classUnderTest.add("-1");
    }
}