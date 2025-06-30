package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;

public class InventoryPage extends SeleniumUtility {
	
	//Declaration
	//@FindBy(className ="inventory_item_name ") // you cannot do this bcoz product name is dynamic() keeps on changing.
	//private WebElement productnameEdt; // instead you make use of business library.(the method clickOnAProduct() you see below)

	@FindBy(className = "product_sort_container")
	private WebElement sortDropDown;
	
	@FindBy(className = "shopping_cart_badge")
	private WebElement cartBtn;
	
	@FindBy(id = "react-burger-menu-btn")
	private WebElement menuBtn;
	
	@FindBy(linkText = "Logout")
	private WebElement logoutLnk;
	
	//Initialization
	public InventoryPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	
	public WebElement getSortDropDown() {
		return sortDropDown;
	}

	public WebElement getCartBtn() {
		return cartBtn;
	}

	public WebElement getMenuBtn() {
		return menuBtn;
	}

	public WebElement getLogoutLnk() {
		return logoutLnk;
	}
	
	// Business Library
	
	/**
	 * This method will perform logout operation
	 */
	public void logoutOfApp()
	{
		menuBtn.click();
		logoutLnk.click();
	}
	
	/**
	 * This method will click on cart container button
	 */
	public void clickOnCartBtn()
	{
		cartBtn.click();
	}
	
	/**
	 * This method will click on a product
	 * @param driver
	 * @param ProductName
	 */
	public void clickOnProduct(WebDriver driver, String ProductName)
	{
		driver.findElement(By.xpath("//div[.='"+ProductName+"']")).click();
	}
	
	/**
	 * This method will sort the products and click on it
	 * @param driver
	 * @param sortOption
	 * @param ProductName
	 */
	public void sortDropDown(WebDriver driver, String sortOption, String ProductName)
	{
		handleDropDown(sortDropDown, sortOption);
		driver.findElement(By.xpath("//div[.='"+ProductName+"']")).click();
	}
}
