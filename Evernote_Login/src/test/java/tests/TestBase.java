package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBase {
	
	public static WebDriver driver;
	@BeforeSuite
	@Parameters ({"browser"})
	public void startDriver (@Optional("chrome") String browserName)
	{
		if (browserName.equalsIgnoreCase("firefox")) {
			String PathFireFox= System.getProperty("user.dir")+"\\drivers\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", PathFireFox);
			driver = new FirefoxDriver();
		}
		
		else if (browserName.equalsIgnoreCase("chrome")) {
			String Pathchrome = System.getProperty("user.dir")+"\\drivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", Pathchrome);
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
		driver.navigate().to("https://evernote.com/");	
	}
	
	@AfterSuite
	public void stopDriver()
	{
		driver.quit();
	}
}
