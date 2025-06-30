package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	@FindBy(className = "inventory_item_name")
	private WebElement productInfo;
	
	@FindBy(xpath = "//button[.=\"Remove\"]")
	private WebElement removeBtn;
	
	@FindBy(id = "checkout")
	private WebElement checkoutBtn;
	
	public CartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getProductInfo() {
		return productInfo;
	}

	public WebElement getRemoveBtn() {
		return removeBtn;
	}

	public WebElement getCheckoutBtn() {
		return checkoutBtn;
	}
	
	/**
	 * This method will click on checkout button
	 */
	public void clickOnCheckout()
	{
		checkoutBtn.click();
	}
	
	/**
	 * This method will click on remove button
	 */
	public void clickOnRemoveBtn()
	{
		removeBtn.click();
	}
	/**
	 * This method will capture the Product name and return to the caller
	 * @return ProductName
	 */
	public String captureProductName()
	{
		return productInfo.getText();
	}
	
}
