package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
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

import com.google.j2objc.annotations.Property;

import ObjectRepository.CartPage;
import ObjectRepository.InventoryItemPage;
import ObjectRepository.InventoryPage;
import ObjectRepository.LoginPage;
import genericUtilities.FileUtility;
import genericUtilities.SeleniumUtility;

public class AddProductUsingDDT {

	public static void main(String[] args) throws IOException {
		
		//Create object of Utilities
		FileUtility fUtil = new FileUtility();
		SeleniumUtility sUtil = new SeleniumUtility();
		
		
		//Read the common data from property file
				
		//String URL = p.getProperty("url"); // anything you give in complete capital letters is considered as Data in automation testing.
		String URL = fUtil.readDataFromPropertyFile("url");
		
		//String USERNAME = p.getProperty("username");
		String USERNAME = fUtil.readDataFromPropertyFile("username");
		
		//String PASSWORD = p.getProperty("password");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");
		
		/*
		
		FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		Sheet sh = wb.getSheet("Product");
		Row rw = sh.getRow(1);
		Cell c1 = rw.getCell(2);
		String PRODUCTNAME = c1.getStringCellValue();
		
		*/
		
		//Read the common data from Excel File
		String PRODUCTNAME = fUtil.readDataFromExcelFile("Product", 1, 2);
			
		
		 //Launch Browser
	    WebDriver driver = new EdgeDriver();
		//driver.manage().window().maximize();
		sUtil.maximizeWindow(driver);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		sUtil.addImplicitlyWait(driver);
		
		//Load the URL
		driver.get(URL);
		
		//Login to Application
		/*
		WebElement username = driver.findElement(By.xpath("//input[@id=\"user-name\"]"));
		username.sendKeys(USERNAME);
		
		WebElement password = driver.findElement(By.xpath("//input[@id=\"password\"]"));
		password.sendKeys(PASSWORD);
		
		driver.findElement(By.xpath("//input[@id=\"login-button\"]")).click();
	*/
		
		/*
		LoginPage lp = new LoginPage(driver);
		lp.getUsernameEdt().sendKeys(USERNAME);
		lp.getPasswordEdt().sendKeys(PASSWORD);
		lp.getLoginBtn().click();
				
		*/
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME,PASSWORD);
		
		//Add product to Cart
		//driver.findElement(By.xpath("//button[@id=\"add-to-cart-sauce-labs-bike-light\"]")).click();
		
		driver.findElement(By.xpath("//div[text()='"+PRODUCTNAME+"']")).click();
		driver.findElement(By.xpath("//button[text()=\"Add to cart\"]")).click();
		
		//Navigate to Cart
		driver.findElement(By.xpath("//span[@data-test=\"shopping-cart-badge\"]")).click();
				
		// Validate the product in cart
		//String expectedString = "Sauce Labs Bike Light";
		
		String productInCart = driver.findElement(By.xpath("//div[text()='"+PRODUCTNAME+"']")).getText();
		if(productInCart.equals(PRODUCTNAME)) {
			System.out.println(productInCart);
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
			System.out.println("FAIL");
			System.out.println("FAIL");
		}
		
		//Logout of Application
		driver.findElement(By.xpath("//button[@id=\"react-burger-menu-btn\"]")).click();
		driver.findElement(By.xpath("//a[text()=\"Logout\"]")).click();	

	}

}
