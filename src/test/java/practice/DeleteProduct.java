package practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import ObjectRepository.CartPage;
import ObjectRepository.InventoryItemPage;
import ObjectRepository.InventoryPage;
import ObjectRepository.LoginPage;
import genericUtilities.FileUtility;
import genericUtilities.SeleniumUtility;

public class DeleteProduct {

	public static void main(String[] args) throws IOException {
		
		//Create object of utilities
		FileUtility fUtil = new FileUtility();
		SeleniumUtility sUtil = new SeleniumUtility();
		
		//Read data from Property file
		String URL = fUtil.readDataFromPropertyFile("url");
		String USERNAME = fUtil.readDataFromPropertyFile("username");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");
		
		//Read data from Excel file
		String PRODUCTNAME = fUtil.readDataFromExcelFile("Product", 7, 2);
		String FIRSTNAME = fUtil.readDataFromExcelFile("Product", 7, 3);
		String LASTNAME = fUtil.readDataFromExcelFile("Product", 7, 4);
		//double POSTALCODE = fUtil.readNumericDataFromExcelFile("Product", 7, 5);
				
		//Launch Browser
		WebDriver driver = new EdgeDriver();
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitlyWait(driver);
		
		//Access URL
		driver.get(URL);
		
		//Login to Application
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		//Click on to the product and add the  Product to cart
		InventoryPage ip = new InventoryPage(driver);
		ip.clickOnProduct(driver, PRODUCTNAME);
		
		InventoryItemPage iip = new InventoryItemPage(driver);
		iip.clickOnAddToCart();
		
		//Navigate to Cart
		ip.clickOnCartBtn();
		
		//Delete the product from the cart
		
		

	}

}
