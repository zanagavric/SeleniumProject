package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Tests.TestBase;

public class LoginPage extends TestBase{

	WebDriver driver;
	WebElement emailAddressField;
	WebElement passwordField;
	WebElement signinButton;
	WebElement signOut;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getEmailAddressField() {
		return driver.findElement(By.id("email"));
	}

	public WebElement getPasswordField() {
		return driver.findElement(By.id("passwd"));
	}

	public WebElement getSigninButton() {
		return driver.findElement(By.id("SubmitLogin"));
	}
	
	public WebElement getSignOut() {
		return driver.findElement(By.className("logout"));
	}
	
	public void signinButtonClick() {
		this.getSigninButton().click();
	}
	
	public void signOutButtonClick() {
		this.getSignOut().click();
	}

	public void insertEmailAddress(String emailaddress) {
		this.getEmailAddressField().clear();
		this.getEmailAddressField().sendKeys(emailaddress);
	}
	
	public void insertPassword(String password) {
		this.getPasswordField().clear();
		this.getPasswordField().sendKeys(password);
	}
	
	public void login(String emailaddress, String password) {
		this.insertEmailAddress(emailaddress);
		this.insertPassword(password);
		this.signinButtonClick();
	}
}
