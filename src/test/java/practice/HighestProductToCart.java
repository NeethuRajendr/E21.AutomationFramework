package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import genericUtilities.FileUtility;
import genericUtilities.SeleniumUtility;

public class HighestProductToCart {

	public static void main(String[] args) throws IOException {
		
		//Create object of Utilities
		FileUtility fUtil = new FileUtility();
		SeleniumUtility sUtil = new SeleniumUtility();
		
		//Read data from Property file
		String URL = fUtil.readDataFromPropertyFile("url");
		String USERNAME = fUtil.readDataFromPropertyFile("username");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");

		
		//Read the data from excel file
		String SORTOPTION = fUtil.readDataFromExcelFile("Product", 4, 2);
		String PRODUCTNAME = fUtil.readDataFromExcelFile("Product", 4, 3);
		
		
		//Launch Browser
		WebDriver driver = new EdgeDriver();
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitlyWait(driver);
		
		//Access the URL
		driver.get(URL);
		
		//Login to Application
		WebElement username = driver.findElement(By.xpath("//input[@id=\"user-name\"]"));
		username.sendKeys(USERNAME);
		
		WebElement password = driver.findElement(By.xpath("//input[@id=\"password\"]"));
		password.sendKeys(PASSWORD);
		
		driver.findElement(By.xpath("//input[@id=\"login-button\"]")).click();
	
		//Choose sort option from dropdown
	//	driver.findElement(By.xpath("//select[@data-test=\"product-sort-container\"]")).click();
	//	driver.findElement(By.xpath("//option[text()=\"Price (high to low)\"]")).click();
		
		
		WebElement dropdownFilter = driver.findElement(By.className("product_sort_container"));
		sUtil.handleDropDown(dropdownFilter, SORTOPTION);
		
		
		//Add the product to cart
		driver.findElement(By.xpath("//div[text()='"+PRODUCTNAME+"']")).click();
		driver.findElement(By.id("add-to-cart")).click();
		
		//Navigate to Cart
		driver.findElement(By.className("shopping_cart_badge")).click();
		
		
		//Validate the product in cart
	
		String ProductInCart = driver.findElement(By.xpath("//div[text()=\'"+PRODUCTNAME+"']")).getText();
		//String ProductInCart = driver.findElement(By.className("\"inventory_item_name\"")).getText();
		String price = driver.findElement(By.xpath("//div[@class=\"inventory_item_price\"]")).getText();
		if(ProductInCart.equals(PRODUCTNAME)) {
			System.out.println("Testcase PASSED");
			System.out.println("Product details: "+ProductInCart);
			System.out.println("Product Price: "+ price);
			
		}
		else
		{
			System.out.println("FAILED");
			System.out.println("FAILED!!!!!!");
		}
		
		//Logout Application
		
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.xpath("//a[text()=\"Logout\"]")).click();

	}
}