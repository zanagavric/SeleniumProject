package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Tests.TestBase;

public class Registration extends TestBase {

	WebDriver driver;
	WebElement firstNameField;
	WebElement lastNameField;
	WebElement addressField;
	WebElement cityField;
	WebElement stateField;
	WebElement zipCodeField;
	WebElement homePhoneField;
	WebElement myAddressField;
	WebElement saveButton;

	public Registration(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getFirstNameField() {
		return driver.findElement(By.id("firstname"));
	}

	public WebElement getLastNameField() {
		return driver.findElement(By.id("lastname"));
	}

	public WebElement getAddressField() {
		return driver.findElement(By.id("address1"));
	}

	public WebElement getCityField() {
		return driver.findElement(By.id("city"));
	}

	public WebElement getStateField() {
		return driver.findElement(By.id("id_state"));
	}

	public WebElement getZipCodeField() {
		return driver.findElement(By.id("postcode"));
	}

	public WebElement getHomePhoneField() {
		return driver.findElement(By.id("phone"));
	}

	public WebElement getMyAddressField() {
		return driver.findElement(By.id("alias"));
	}

	public WebElement getSaveButton() {
		return driver.findElement(By.id("submitAddress"));
	}

	public void saveButtonClick() {
		this.getSaveButton().click();
	}

	public void firstNameField(String firstName) {
		this.getFirstNameField().clear();
		this.getFirstNameField().sendKeys(firstName);
	}

	public void lastNameField(String lastName) {
		this.getLastNameField().clear();
		this.getLastNameField().sendKeys(lastName);
	}

	public void addressField(String address) {
		this.getAddressField().clear();
		this.getAddressField().sendKeys(address);
	}

	public void cityField(String city) {
		this.getCityField().clear();
		this.getCityField().sendKeys(city);
	}

	public void stateField(String state) {
		this.getStateField().clear();
		this.getStateField().sendKeys(state);
	}

	public void homePhoneField(String homePhone) {
		this.getHomePhoneField().clear();
		this.getHomePhoneField().sendKeys(homePhone);
	}

	public void myAddressField(String myAddress) {
		this.getMyAddressField().clear();
		this.getMyAddressField().sendKeys(myAddress);
	}

	public void zipCodeField(String code) {
		this.getZipCodeField().clear();
		this.getZipCodeField().sendKeys(code);
	}

	public void choosestate(WebElement element, String value) {
		Select selectElement = new Select(element);
		selectElement.selectByVisibleText(value);
	}

}
