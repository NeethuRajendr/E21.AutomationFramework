package genericUtilities;

import java.io.IOException;
import java.lang.reflect.Parameter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import ObjectRepository.InventoryPage;
import ObjectRepository.LoginPage;

/**
 * This class consist of basic configuration annotations of TestNG
 * @author NR
 */
public class BaseClass {

	public FileUtility fUtil = new FileUtility();
	public JavaUtility jUtil = new JavaUtility();
	public SeleniumUtility sUtil = new SeleniumUtility();
	
	
	//Listeners only
	public static WebDriver sdriver;
	
	
	public WebDriver driver;
	
	@BeforeSuite(alwaysRun = true)
	public void bsConfig()
	{
		System.out.println("----DB Connection Successful-----");
	}
	
	
	
	@BeforeClass(alwaysRun = true)
	//@BeforeTest // --> for parallel execution
	public void bcConfig() throws IOException
	{
		String URL = fUtil.readDataFromPropertyFile("url");
		//driver = new EdgeDriver();
		driver = new FirefoxDriver();
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitlyWait(driver);
		driver.get(URL);
		
		//For listeners only
		sdriver = driver; // we assign it after browser launching bcoz driver holds a value. if you give before it will be null.
		
		
		System.out.println("----------Browser Launch Successful-----------");
	}
	
	
	//for CrossBrowser Execution
	/*
	@Parameters("Browser")
	@BeforeTest
	public void bcConfig(String pValue) throws IOException
	{
		String URL = fUtil.readDataFromPropertyFile("url");
		
		if(pValue.equals("edge"))
		{
			driver = new EdgeDriver();
		}
		else if(pValue.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			driver= new EdgeDriver();
		}
		
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitlyWait(driver);
		driver.get(URL);
		
		System.out.println("----------Browser Launch Successful-----------");
			
	}
	*/
	
	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws IOException
	{
		String USERNAME = fUtil.readDataFromPropertyFile("username");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		System.out.println("-----------Login to Application Successful----------");
	}
	
	@AfterMethod(alwaysRun = true)
	public void amconfig()
	{
		InventoryPage ip = new InventoryPage(driver);
		ip.logoutOfApp();
		System.out.println("-----Logout of the Application Successful-----");
	}
	
	
	@AfterClass(alwaysRun = true)
	//@AfterTest //--> for parallel execution
	public void acConfig()
	{
		driver.close();
		System.out.println("------Browser Closure Successful---------");
	}
	
	@AfterSuite(alwaysRun = true)
	public void asCongif()
	{
		System.out.println("---------Database connection Closed----------");
	}
	
}
