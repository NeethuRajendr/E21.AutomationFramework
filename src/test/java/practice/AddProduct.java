package practice;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class AddProduct {

	public static void main(String[] args){
		
		
	    //Launch Browser
	    WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Access URL
		driver.get("https://www.saucedemo.com/");
		
		//Login to Application
		WebElement username = driver.findElement(By.xpath("//input[@id=\"user-name\"]"));
		username.sendKeys("standard_user");
		
		WebElement password = driver.findElement(By.xpath("//input[@id=\"password\"]"));
		password.sendKeys("secret_sauce");
		
		driver.findElement(By.xpath("//input[@id=\"login-button\"]")).click();
	
		//Add product to Cart
		driver.findElement(By.xpath("//button[@id=\"add-to-cart-sauce-labs-bike-light\"]")).click();
		
		
		//Navigate to Cart
		driver.findElement(By.xpath("//span[@class=\"shopping_cart_badge\"]")).click();
	
		
		// Validate the product in cart
		String expectedString = "Sauce Labs Bike Light";
		
		String productInCart = driver.findElement(By.xpath("//div[text()=\"Sauce Labs Bike Light\"]")).getText();
		if(productInCart.equals(expectedString)) {
			System.out.println(productInCart);
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}
		
		//Logout of Application
		driver.findElement(By.xpath("//button[@id=\"react-burger-menu-btn\"]")).click();
		driver.findElement(By.xpath("//a[text()=\"Logout\"]")).click();	
	}
}

//Disadvantages
//1.Hardcoded Scripts ------>solution----------> DDT
//2.WebElements and Locators are hardcoded.---------->solution-----> Object Repository--->POM classes
//3. Syntaxes are hardcoded --------->solution-------->Generic Utility--> reusable methods
//4. Repetative actions ---------> solution -------> Base Class--> TestNG

// All these solutions together makes up a framework. Because of this we achieve code reusability, code 
//modifications, scripting time is reduceed,code maintanance, its ia structured,any changes can be handled
//easily.

//what you write and handle in a specific manner is a framework.


// In this data is hardcoded, means even all small information is scripted. so any changes means
//you have to come and make changes in the script.

// softcoded values can be modified where you have actually written them.; say a generic utility


