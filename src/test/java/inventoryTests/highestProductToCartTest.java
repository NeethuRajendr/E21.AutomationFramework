package inventoryTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import ObjectRepository.CartPage;
import ObjectRepository.InventoryItemPage;
import ObjectRepository.InventoryPage;
import ObjectRepository.LoginPage;
import genericUtilities.FileUtility;
import genericUtilities.SeleniumUtility;

public class highestProductToCartTest {

	//public static void main(String[] args) throws IOException 
	@Test
	public void tc_002_highestProductToCartTest() throws IOException
	{
		
		//Create object of Utilities
		FileUtility fUtil = new FileUtility();
		SeleniumUtility sUtil = new SeleniumUtility();
		
		//Read common data from property file
		String URL = fUtil.readDataFromPropertyFile("url");
		String USERNAME = fUtil.readDataFromPropertyFile("username");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");
		
		//Read common data from Excel File
		String SORTOPTION = fUtil.readDataFromExcelFile("Product", 4, 2);
		String PRODUCTNAME = fUtil.readDataFromExcelFile("Product", 4, 3);
		
		//Launch Browser
		WebDriver driver = new EdgeDriver();
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitlyWait(driver);
		
		//Load URL
		driver.get(URL);
		
		//Login to Application
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		//Sort the list from high to low select the product
		InventoryPage ip = new InventoryPage(driver);
		ip.sortDropDown(driver, SORTOPTION, PRODUCTNAME);
		
		//Add the product to Cart
		InventoryItemPage iip = new InventoryItemPage(driver);
		iip.clickOnAddToCart();
		
		//Navigate to cart
		ip.clickOnCartBtn();
		
		//Validate the product in cart
		CartPage cp = new CartPage(driver);
		String ProductInCart = cp.captureProductName();
		
		if(ProductInCart.equals(PRODUCTNAME))
		{
			System.out.println("TEST PASSED"); 
			System.out.println("Product Name: " +ProductInCart);
		}
		else
		{
			System.out.println("Test Failed");
		}
		
		//Logout of the Application
		ip.logoutOfApp();
		
		driver.close();
	}

}
