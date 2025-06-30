package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryItemPage {

	@FindBy(id = "add-to-cart")
	private WebElement addtocart;
	
	public InventoryItemPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddtocart() {
		return addtocart;
	}
	
	/**
	 * This method will click on Add to cart button
	 */
	public void clickOnAddToCart()
	{
		addtocart.click();
	}
}
