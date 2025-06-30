package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage { //Rule 1
	
	//Rule 1
	//Declaration
	@FindBy(id = "user-name") // Identify single web element using single locator
	private WebElement usernameEdt;
	
	//@FindAll - Identify single webElement using multiple locators.
	//OR operator 
	//Auto healing Process -
	//@FindAll({@FindBy(id = "user-name"),@FindBy(name = "user-name")})
	//private WebElement usernameEdt;
	
	
	//FindBys - Identify single webElement using multiple locators.
	//AND operator
	//@FindBys({@FindBy(id = "user-name"),@FindBy(name = "user-name")})
	//private WebElement usernameEdt;
		
	
	@FindBy(id = "password")
	private WebElement passwordEdt;
	
	@FindBy(id = "login-button")
	private WebElement loginBtn;
	
	
	//Rule3
	//Initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Rule 4
	//Utilization
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}


	public WebElement getPasswordEdt() {
		return passwordEdt;
	}


	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//Business - generic method - project specific
	/**
	 * This method will perform login operation
	 * @param un
	 * @param pwd
	 */
	public void loginToApp(String un, String pwd)
	{
		usernameEdt.sendKeys(un);
		passwordEdt.sendKeys(pwd);
		loginBtn.click();
	}
	
}
