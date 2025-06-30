package inventoryTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import ObjectRepository.CartPage;
import ObjectRepository.InventoryItemPage;
import ObjectRepository.InventoryPage;
import ObjectRepository.LoginPage;
import genericUtilities.BaseClass;
import genericUtilities.FileUtility;
import genericUtilities.SeleniumUtility;

@Listeners(genericUtilities.ListenerImplementationUtility.class)
public class AddProductToCartTestUsingAnnotation extends BaseClass{

	
	@Test(groups = "RegressionSuite")
	public void tc_001_AddProductToCartTest() throws IOException
	{
		
		//Read the common data from Excel File
		String PRODUCTNAME = fUtil.readDataFromExcelFile("Product", 1, 2);
		
		
		//Click on a product
		InventoryPage ip = new InventoryPage(driver);
		ip.clickOnProduct(driver, PRODUCTNAME);
		
		//Add product to Cart
		InventoryItemPage iip = new InventoryItemPage(driver);
		iip.clickOnAddToCart();
		
		//navigate to cart
		ip.clickOnCartBtn();
		
		//Validate the product in cart
		CartPage cp = new CartPage(driver);
		String productInCart = cp.captureProductName();
		
	//	Assert.assertEquals(productInCart, PRODUCTNAME); // to compare two 
		Assert.assertTrue(productInCart.equals(PRODUCTNAME)); // You go for this condition when its is like checking 'contains'
			System.out.println(productInCart);
			System.out.println("PASS");
		
	}	
	//Used as an example for <exclude>
	@Test(groups = "SmokeSuite")
	public void demo()
	{
		//Assert.fail();
		System.out.println("Hello Demo");
		
	}

}
