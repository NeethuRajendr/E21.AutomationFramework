package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class consist of generic methods related to selenium
 * @author NR
 */


public class SeleniumUtility {

	/**
	 * This method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method will minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	/**
	 * This method will full-screen the window
	 * @param driver
	 */
	public void fullscreenWindow(WebDriver driver)
	{
		driver.manage().window().fullscreen();
	}
	
	/**
	 * This method will add implicit wait for 10seconds
	 * @param driver
	 */
	public void addImplicitlyWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
	 * This method will wait for 10sec for the element to be clickable 
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This method will handle drop down by Index
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element, int index)
	{
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	
	/**
	 * This method will handle drop down by value
	 * @param element
	 * @param valueattribute
	 */
	public void handleDropDown(String value, WebElement element)
	{
		Select s = new Select(element);
		s.selectByValue(value);
	}
	
	/**
	 * This method will handle drop down by visibleText
	 * @param element
	 * @param visibleText
	 */
	public void handleDropDown(WebElement element, String visibleText)
	{
		Select s = new Select(element);
		s.selectByVisibleText(visibleText);
		
	}
	/**
	 * This method will perform drag and drop action on web element
	 * @param driver
	 * @param srcElement
	 * @param tarElement
	 */
	public void dragAndDrop(WebDriver driver, WebElement srcElement, WebElement tarElement)
	{
		//WebDriver driver;
		Actions a = new Actions(driver);
		 a.dragAndDrop(srcElement,tarElement).perform();
	}
	
	public void doubleClick(WebDriver driver, WebElement element)
	{
		Actions a = new Actions(driver);
		a.doubleClick(element).perform();
		
	}
	
	public void contextClick(WebDriver driver, WebElement element)
	{
		Actions a = new Actions(driver);
		a.contextClick(element).perform();
		
	}
	
	public void clickOnHold(WebDriver driver, WebElement element)
	{

		Actions a = new Actions(driver);
		a.clickAndHold(element).perform();
		
	}
	
	public void release(WebDriver driver, WebElement element)
	{
		Actions a = new Actions(driver);
		a.release(element).perform();
	}
	
	public void scrollAction(WebDriver driver, WebElement element)
	{
		Actions a = new Actions(driver);
		a.scrollToElement(element).perform();
		
	}
	
	/**
	 * This method will switch to frame based on index
	 * @param driver
	 * @param frameIndex
	 */
	public void switchToFrame(WebDriver driver, int frameIndex)
	{
		driver.switchTo().frame(frameIndex);
	}
	
	/**
	 * This method will switch to frame based on Name or ID
	 * @param driver
	 * @param attribute
	 */
	public void switchToFrame(WebDriver driver, String frameNameorID)
	{
		driver.switchTo().frame(frameNameorID);
	}
	
	/**
	 * This method will switch to frame based on webElement
	 * @param driver
	 * @param frameElement
	 */
	public void switchToFrame(WebDriver driver, WebElement frameElement)
	{
		driver.switchTo().frame(frameElement);
	}
	

	/**
	 * This method will switch the control to parent frame
	 * @param driver
	 * @param frameElement
	 */
	public void switchToParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	
	/**
	 * This method will switch the control to main page
	 * @param driver
	 * @param frameElement
	 */
	public void switchToDefaultContent(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	/**
	 * This method will switch to window
	 * @param driver
	 * @param frameElement
	 */
	public void switchToWindow(WebDriver driver, String windowID)
	{
		driver.switchTo().window(windowID);
	}
	
	/**
	 * This method will accept alert pop-up
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method will dismiss alert pop up
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * This method will fetch the alert message and return to caller
	 * @param driver
	 */
	public void getTextAlert(WebDriver driver)
	{
		driver.switchTo().alert().getText();
		
	}
	/**
	 * This method will send the data to the alert pop up if any text field is there
	 * @param driver
	 * @param TextfieldValue
	 */
	public void sendKeysALert(WebDriver driver, String data)
	{
		driver.switchTo().alert().sendKeys(data);
	}
	
	/**
	 * This method will scroll down by 500 units
	 * @param driver
	 */
	public void scrollDown(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500);", "");
		
	}
	
	/**
	 * This method will capture screenshot and return absolute path to caller
	 * @param driver
	 * @param screenshotName
	 * @return
	 * @throws IOException
	 */
	public String captureScreenshot(WebDriver driver, String screenshotName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver; // TakeScreenshot is the interface
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\Screenshots\\"+screenshotName+".png");
		FileHandler.copy(src, dst);
		
		return dst.getAbsolutePath(); //For extent Reports
	}
}

