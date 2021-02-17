package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Tests.TestBase;

public class MyPersonalInformationPage extends TestBase {

	WebDriver driver;
	WebElement firstNameField;
	WebElement lastNameField;
	WebElement eMailAddressField;
	WebElement currentPasswordField;
	WebElement saveButton;
	WebElement textassert;

	public MyPersonalInformationPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getFirstNameField() {
		return driver.findElement(By.id("firstname"));
	}

	public WebElement getLastNameField() {
		return driver.findElement(By.id("lastname"));
	}

	public WebElement geteMailAddressField() {
		return driver.findElement(By.id("email"));
	}

	public WebElement getCurrentPasswordField() {
		return driver.findElement(By.id("old_passwd"));
	}

	public WebElement getSaveButton() {
		return driver.findElement(By.name("submitIdentity"));
	}

	public WebElement getTextassert() {
		return driver.findElement(By.className("box"));
	}
	
	public void saveButtonClick() {
		this.getSaveButton().click(); 
	}

}
