package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {

	//Declaration 
	@FindBy(id = "first-name")
	private WebElement firstNameEdt;
	
	@FindBy(id = "last-name")
	private WebElement lastNameEdt;
	
	@FindBy(id = "postal-code")
	private WebElement postalCodeEdt;
	
	@FindBy(id = "continue")
	private WebElement continueBtn;
	
	@FindBy(name = "cancel")
	private WebElement cancelBtn;
	
	//Initialization
	public CheckOutPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getFirstNameEdt() {
		return firstNameEdt;
	}

	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getPostalCodeEdt() {
		return postalCodeEdt;
	}

	public WebElement getContinueBtn() {
		return continueBtn;
	}

	public WebElement getCancelBtn() {
		return cancelBtn;
	}

	//Business-Generic-Methods 
	//Business Library
	public void clickOnContinue()
	{
		continueBtn.click();
	}
	
	public void clickOnCancel()
	{
		cancelBtn.click();
	}
	
	public void checkOutPage(String fn, String ln, String pc)
	{
		firstNameEdt.sendKeys(fn);
		lastNameEdt.sendKeys(ln);
		postalCodeEdt.sendKeys(pc);
	}
	
	
	
	
}
