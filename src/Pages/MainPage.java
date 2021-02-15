package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Tests.TestBase;

public class MainPage extends TestBase{

	WebDriver driver;
	WebElement signINavBar;
	WebElement homePage;
	
	public MainPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getSignINavBar() {
		return driver.findElement(By.xpath("//a[@class='login']"));
	}
	
	public WebElement getHomePage() {
		return driver.findElement(By.xpath("//a[@title='My Store']"));
	}

	public void navigateToHomePage() {
		this.getHomePage().click();
	}
	public void navigateToLoginPage() {
		this.getSignINavBar().click();
	}
}
