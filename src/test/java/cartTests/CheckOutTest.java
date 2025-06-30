package cartTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ObjectRepository.CartPage;
import ObjectRepository.CheckOutPage;
import ObjectRepository.InventoryItemPage;
import ObjectRepository.InventoryPage;
import genericUtilities.BaseClass;

@Listeners(genericUtilities.ListenerImplementationUtility.class)
public class CheckOutTest extends BaseClass {
	@Test
	public void tc_002_checkOut() throws Exception, IOException
	{
		//Read the data from xml file
		String PRODUCTNAME = fUtil.readDataFromExcelFile("Product", 10, 2);
		String FIRSTNAME = fUtil.readDataFromExcelFile("Product", 10, 3);
		String LASTNAME = fUtil.readDataFromExcelFile("Product", 10, 4);
		String POSTALCODE = fUtil.readDataFromExcelFile("Product", 10, 5);
		
		//Select the product
		InventoryPage ip = new InventoryPage(driver);
		ip.clickOnProduct(driver, PRODUCTNAME);
		
		//Add the product to cart
		InventoryItemPage iip = new InventoryItemPage(driver);
		iip.clickOnAddToCart();
		
		//navigate to cart
		ip.clickOnCartBtn();
		
		//capture  the product and print it
		CartPage cp = new CartPage(driver);
		String productInCart = cp.captureProductName();
		System.out.println("Product in Cart " +productInCart);
		
		//Proceed to checkout
		cp.clickOnCheckout();
		CheckOutPage cop = new CheckOutPage(driver);
		cop.checkOutPage(FIRSTNAME, LASTNAME, POSTALCODE);
		
	}

}
