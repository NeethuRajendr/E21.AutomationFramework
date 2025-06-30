package practice;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TesNGPractice {

	@Test(invocationCount = 3, priority = 2)
	public void create() //create a customer failed
	{
		Assert.fail(); //Failing the test script
		System.out.println("Create");
	}
	
	//@Test(enabled = false)
	@Test(dependsOnMethods = "create")
	public void modify() //update a customer
{
		System.out.println("Modify");
}
	
	@Test()
	public void delete() //delete a customer
	{
		System.out.println("Delete");
	}
}
