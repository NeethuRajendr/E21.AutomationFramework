package practice;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class login {

	
	public static void main(String args[]) throws Exception {
		
	ChromeOptions options = new ChromeOptions();
    Map<String, Object> prefs = new HashMap<>();
    prefs.put("profile.password_manager_leak_detection", false);
    options.setExperimentalOption("prefs", prefs);
    
	WebDriver driver = new ChromeDriver(options);
	driver.manage().window().maximize();
	driver.get("https://www.saucedemo.com/");
	WebElement username = driver.findElement(By.xpath("//input[@id=\"user-name\"]"));
	username.sendKeys("standard_user");
	WebElement password = driver.findElement(By.xpath("//input[@id=\"password\"]"));
	password.sendKeys("secret_sauce");
	driver.findElement(By.xpath("//input[@id=\"login-button\"]")).click();
	System.out.println("Login Successfull");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@id=\"react-burger-menu-btn\"]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[@id=\"logout_sidebar_link\"]")).click();
	System.out.println("Logout Successfull!");
	}
}
