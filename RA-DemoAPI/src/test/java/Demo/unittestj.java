package Demo;

import org.junit.After;
import org.junit.Before;
import org.testng.Assert;
import org.testng.annotations.Test;


public class unittestj {
	
	@Before
	public void bt() {
		String Expected ="Sunil";
		String Actual="Sunila";
		
		Assert.assertEquals(Expected, Actual);
	}
	
	@Test
	public void tc1() {
		System.out.println("I am getting trained in API testing");
	}
	
	@After
	public void af() {
		System.out.println("I am very good");
	}
}