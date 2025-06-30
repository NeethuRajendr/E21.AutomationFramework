package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPractice {

	//Below is Hard Assert. Terminates when you encounter the error/Assert.
	@Test
	public void sampleHardAssert()
	{
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
		
		Assert.assertEquals(0, 1); //accessed using classname bcz hardassert has  static methods
		//Here we are checking ; LHS is the actual value and RHS is the expected value.
		
		System.out.println("Step 4");
		System.out.println("Step 5");
	}
	
	//Below is SoftAssert. It continues and finishes the program even when you encounter assert.
	
	@Test
	public void sampleSoftAssert()
	{
		SoftAssert sa = new SoftAssert(); // creating object inorder to access method.(non static methods)
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
		
		sa.assertEquals(0, 1);
		
		System.out.println("Step 4");
		System.out.println("Step 5");
		
		sa.assertAll(); // log the failures. This is mandatory for SoftAssert
		// If you dont give assertAll, this program will pass.It wont log the failure only using line 34.
		
	}
}
