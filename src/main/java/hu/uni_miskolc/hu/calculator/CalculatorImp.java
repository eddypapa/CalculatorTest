package hu.uni_miskolc.hu.calculator;

import hu.uni_miskolc.hu.calculator.exceptions.DividedByZero;

public class CalculatorImp 
{
    public double addition(double first, double secound) {
    		return first+secound;
    }
    
    public double subtraction(double first, double secound) {
    		return first-secound;
    }
    
    public double multiply(double first, double secound) {
    		return first*secound;
    }
    
    public double divide(double first, double secound) throws DividedByZero{
    		if (secound == 0.0) {
    			throw new DividedByZero();
    		} else {
    			return first/secound;
    		}
    }
    
    
    
}
