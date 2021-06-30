package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(id="username")
	WebElement emailTxt;
	
	@FindBy(id="loginButton")
	WebElement ConBtn;
	
	@FindBy(id="password")
	WebElement passwordTxt;
	
	@FindBy(xpath="//*[@id=\"qa-NAV_USER\"]/div/div/span/div/div[1]/div")
	WebElement DropDownForLogout;
	
	@FindBy(xpath="//*[@id=\"qa-ACCOUNT_DROPDOWN_LOGOUT\"]/div/span/span")
	WebElement SignOutBtn;
	
	@FindBy(id="responseMessage")
	public WebElement ValidationMassage;
	
	
	
	public void UserLogin(String email, String Password) throws InterruptedException 
	{
		setTextElementText(emailTxt, email);
		clickButton(ConBtn);
		Thread.sleep(2000);
		setTextElementText(passwordTxt, Password);
		clickButton(ConBtn);
	}
	
	public void SignOut()
	{
		DropDownForLogout.click();
		SignOutBtn.click();
	}
	
	
	public void UserInvalid(String email, String Password) throws InterruptedException 
	{
		setTextElementText(emailTxt, email);
		clickButton(ConBtn);
		Thread.sleep(2000);
	}
}