package Demo;

import org.junit.After;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG {
  @BeforeTest
  public void bt() {
	  System.out.println("I am good");
	  
	  String Expected = "Prabhat";
		String Actual = "Jain";
		Assert.assertEquals(Expected, Actual);
  }
  
  @Test
	public void tc1() {
		System.out.println("I am getting trained in API testing");
	}
	
	@AfterTest
	public void af() {
		System.out.println("I am very good");
	}
}
