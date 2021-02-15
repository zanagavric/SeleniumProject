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
	
	public void InsertFirstName(String firstname) {
		this.getFirstNameField().clear();
		this.getFirstNameField().sendKeys(firstname);
	}
	
	public void InsertLastName(String lastname) {
		this.getLastNameField().clear();
		this.getLastNameField().sendKeys(lastname);
	}
	
	public void InsertEmailAddressField(String email) {
		this.geteMailAddressField().clear();
		this.geteMailAddressField().sendKeys(email);
	}
	
	public void currentPasswordField(String password) {
		this.getCurrentPasswordField().clear();
		this.getCurrentPasswordField().sendKeys(password);
	}
	
	public void saveButtonClick() {
		this.getSaveButton().click(); 
	}
	
	public void insertData(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}
}
