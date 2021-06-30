package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	HomePage homeObject;
	LoginPage LoginObject;
	String Email="raeedsalah2@gmail.com";
	String Password="raeedsalah123456789";
	
	//Valid Email and valid password 
	@Test(priority=1)
	public void UserLoginSuccessfully() throws InterruptedException 
	{
		homeObject = new HomePage(driver);
		homeObject.OpenLoginPage();
		LoginObject = new LoginPage(driver);
		LoginObject.UserLogin(Email,Password);
		LoginObject.SignOut();
	}	
	
	//invalid Email valid password
	@Test(priority=2)
	public void UserLoginUnsuccessfully() throws InterruptedException 
	{
		homeObject.OpenLoginPage();
		LoginObject.UserInvalid("raeedsalah2987536@gmail.com", Password);
		Assert.assertTrue(LoginObject.ValidationMassage
				.getText()
				.contains("There is no account for the username or email you entered"));
	}	

	
	

}