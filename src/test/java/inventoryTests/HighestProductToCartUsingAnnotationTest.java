package inventoryTests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import ObjectRepository.CartPage;
import ObjectRepository.InventoryItemPage;
import ObjectRepository.InventoryPage;
import genericUtilities.BaseClass;

public class HighestProductToCartUsingAnnotationTest extends BaseClass{

	@Test(groups = "SmokeSuite")
	public void tc_002__highestProductToCart() throws IOException
	{
		//Read data from files
		String SORTOPTION = fUtil.readDataFromExcelFile("Product", 4, 2);
		String PRODUCTNAME = fUtil.readDataFromExcelFile("Product", 4, 3);
		
		//select the dropdown
		InventoryPage ip = new InventoryPage(driver);
		ip.sortDropDown(driver, SORTOPTION, PRODUCTNAME);
		ip.clickOnProduct(driver, PRODUCTNAME);
		
		//Add the product to cart
		InventoryItemPage iip = new InventoryItemPage(driver);
		iip.clickOnAddToCart();
		
		//navigate to cart
		ip.clickOnCartBtn();
		
		//Validate the product in cart
		CartPage cp = new CartPage(driver);
		String ProductInCart = cp.captureProductName();
		
		Assert.assertEquals(ProductInCart, PRODUCTNAME);
		System.out.println("TESTCASE PASSED--> "+ProductInCart);
		
		
	}
}
