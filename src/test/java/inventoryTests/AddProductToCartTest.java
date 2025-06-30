package inventoryTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import ObjectRepository.CartPage;
import ObjectRepository.InventoryItemPage;
import ObjectRepository.InventoryPage;
import ObjectRepository.LoginPage;
import genericUtilities.FileUtility;
import genericUtilities.SeleniumUtility;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class AddProductToCartTest {

	//public static void main(String[] args) throws IOException {
	@Test
	public void tc_001_AddProductToCartTest() throws IOException
	{
		
		//Create object of Utilities
		FileUtility fUtil = new FileUtility();
		SeleniumUtility sUtil = new SeleniumUtility();
		
		//Read the common data from property file
		String URL = fUtil.readDataFromPropertyFile("url");
		String USERNAME = fUtil.readDataFromPropertyFile("username");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");
		
		//Read the common data from Excel File
		String PRODUCTNAME = fUtil.readDataFromExcelFile("Product", 1, 2);
		
		//Launch Browser
	    WebDriver driver = new EdgeDriver();
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitlyWait(driver);
		
		//Load the URL
		driver.get(URL);
		
		//Login to Application
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME,PASSWORD);
		
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
		
		if(productInCart.equals(PRODUCTNAME)) {
			System.out.println(productInCart);
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}
		
		//Logout
		ip.logoutOfApp();
		
		driver.close();
}

}
