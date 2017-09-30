package hu.uni_miskolc.hu.calculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import hu.uni_miskolc.hu.calculator.exceptions.DividedByZero;
import hu.uni_miskolc.hu.calculator.exceptions.WrongFormatException;

public class CalcualtorTest {
	
	static CalculatorImp calculator;
	ConvertString converter;

	@Ignore
	public void test() {
		fail("Not yet implemented");
	}
	
	@BeforeClass
	public static void setUpCalculator() {
		calculator = new CalculatorImp();
	}
	
	@Before
	public void setUpConverter() throws WrongFormatException {
		converter = EasyMock.mock(ConvertString.class);
		EasyMock.expect(converter.convert("21,2")).andReturn(new double[] {21,2}).anyTimes();
		EasyMock.expect(converter.convert("Cica")).andThrow(new WrongFormatException()).anyTimes();
		EasyMock.replay(converter);
	}
	
	@Test
	public void testAdditionValidValues() {
		
		double first = 5.0;
		double secound = 3.5;
		double expected = 8.5;
		assertEquals(expected, calculator.addition(first, secound) , 1e-10 );
	}
	
	@Test
	public void testSubtractionValidValues() {
		
		double first = 5.0;
		double secound = 3.5;
		double expected = 1.5;
		assertEquals(expected, calculator.subtraction(first, secound) , 1e-10 );
	}
	
	@Test
	public void testMultiplyValidValues() {
		
		double first = 5.0;
		double secound = 5.0;
		double expected = 25.0;
		assertEquals(expected, calculator.multiply(first, secound) , 1e-10 );
	}
	
	@Test
	public void testDivideValidValues() throws DividedByZero {
		
		double first = 15.0;
		double secound = 5;
		double expected = 3;
		assertEquals(expected, calculator.divide(first, secound) , 1e-10 );
	}
	
	@Test(expected = DividedByZero.class)
	public void testDivideWithZero() throws DividedByZero {
		
		double first = 15.0;
		double secound = 0;
		calculator.divide(first, secound);
	}
	
	@Test
	public void testMock() throws WrongFormatException{
		String s = "21,2";
		double expected = 19.0;
		double[] mockResoult = converter.convert(s);
		assertEquals(expected, calculator.subtraction(mockResoult[0], mockResoult[1]), 1e-10);
	}
	
	@Test(expected = WrongFormatException.class)
	public void testMockCica() throws WrongFormatException {
		String s = "Cica";
		double[] mockResoult = converter.convert(s);
	}


}
