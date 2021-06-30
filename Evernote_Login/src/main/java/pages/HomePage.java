package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(linkText="Log In")
	WebElement loginLink;
	
	@FindBy(id="responseMessage")
	public WebElement ValidationMassege;
	
	public void OpenLoginPage() 
	{
		clickButton(loginLink);
	}

	

}
