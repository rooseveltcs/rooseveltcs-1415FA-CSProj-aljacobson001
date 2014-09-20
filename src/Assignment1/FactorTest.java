import static org.junit.Assert.*;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;


public class FactorTest {

	@Test
	public void testCalcGCD() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testOneTooHigh(){
		
	}
	
	@Test
	public void testOneTooLow(){
	}
	
	@Test
	public void testTooHigh(){
	}
	
	@Test
	public void testTooLow(){
	}

	@Test
	public void testFindGCD() {
		fail("Not yet implemented");
	}

	@Test
	public void testCalcFactors() {
		Factor toTest = new Factor();
		toTest.calcFactors(10);
		ArrayList<Integer> answer = new ArrayList<Integer>();
		answer.add(1);
		answer.add(2);
		answer.add(5);
		answer.add(10);
		Assert.assertEquals(answer, toTest.theFactors);
	}

}
