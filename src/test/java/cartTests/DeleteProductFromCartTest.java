package cartTests;

import java.io.IOException;

import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import ObjectRepository.CartPage;
import ObjectRepository.InventoryItemPage;
import ObjectRepository.InventoryPage;
import genericUtilities.BaseClass;

@Listeners(genericUtilities.ListenerImplementationUtility.class)
public class DeleteProductFromCartTest extends BaseClass{

	@Test (groups = "RegressionSuite")
	public void tc_001_deleteProductFromCart() throws IOException
	{
		//Read the data from excel file
		String PRODUCTNAME = fUtil.readDataFromExcelFile("Product", 7, 2);
		
		//Click on the product
		InventoryPage ip = new InventoryPage(driver);
		ip.clickOnProduct(driver, PRODUCTNAME);
		
		//Add the product to cart
		InventoryItemPage iip = new InventoryItemPage(driver);
		iip.clickOnAddToCart();
		
		//Navigate to cart
		ip.clickOnCartBtn();
		
		//Capture the productname
		CartPage cp = new CartPage(driver);
		String productInCart = cp.captureProductName();
		
		//Validations
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(productInCart, PRODUCTNAME);
		cp.clickOnRemoveBtn();
		System.out.println("The product in Cart is removed----> "  +productInCart);
				
	}
}
