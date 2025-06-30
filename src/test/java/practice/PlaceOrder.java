package practice;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class PlaceOrder {

	public static void main(String[] args) {
		
	
		
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.saucedemo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement username = driver.findElement(By.xpath("//input[@id=\"user-name\"]"));
		username.sendKeys("standard_user");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement password = driver.findElement(By.xpath("//input[@id=\"password\"]"));
		password.sendKeys("secret_sauce");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@id=\"login-button\"]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//button[@id=\"add-to-cart-sauce-labs-bike-light\"]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//span[@class=\"shopping_cart_badge\"]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//button[@name=\"checkout\"]")).click();
		driver.findElement(By.xpath("//input[@id=\"first-name\"]")).sendKeys("Dyuvan");
		driver.findElement(By.xpath("//input[@id=\"last-name\"]")).sendKeys("Shibin");
		driver.findElement(By.xpath("//input[@id=\"postal-code\"]")).sendKeys("560094");
		driver.findElement(By.xpath("//input[@id=\"continue\"]")).click();
		driver.findElement(By.xpath("//button[@name=\"finish\"]")).click();
		
		String expectedString = "Thank you for your order!";
		String result = driver.findElement(By.xpath("//h2[text()=\"Thank you for your order!\"]")).getText();
		
		if(result.equals(expectedString)) {
			System.out.println(result);
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}
	}
}
