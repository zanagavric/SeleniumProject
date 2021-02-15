package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Tests.TestBase;

public class AddressesPage extends TestBase{

	WebDriver driver;
	WebElement updateButton;
	WebElement deleteButton;
	WebElement addAnewAddressButton;
	WebElement addressField;
	WebElement cityField;
	WebElement zipCodeField;
	WebElement homePhoneField;
	WebElement myAddressField;
	WebElement saveButton;
	WebElement stateField;
	WebElement addressForCompare;
	Alert alert;
	
	public AddressesPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public Alert getAlert() {
		return driver.switchTo().alert();
	}

	public WebElement getUpdateButton() {
		return driver.findElement(By.xpath("//a[@title='Update']"));
	}

	public WebElement getDeleteButton() {
		return driver.findElement(By.xpath("//a[@href='http://automationpractice.com/index.php?controller=address&id_address=447707&delete=']"));
	}

	public WebElement getAddAnewAddressButton() {
		return driver.findElement(By.xpath("//a[@title='Add an address']"));
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

	public WebElement getAddressForCompare() {
		return driver.findElement(By.xpath("//span[@class='address_address1']"));
	}

	public void updateButtonClick() {
		this.getUpdateButton().click();
	}
	
	public void deleteButtonClick() {
		this.getDeleteButton().click();
	}
	
	public void addAnewAddressButtonClick() {
		this.getAddAnewAddressButton().click();
	}
	public void alertClickOK() {
		this.getAlert().accept();
	}	
	
	public void saveButtonClick() {
		this.getSaveButton().click();
	}
	
	public void chooseState(WebElement element, String value) {
		Select selectElement = new Select(element);
		selectElement.selectByVisibleText(value);
	}
		
	public void changeAddress(String value1,String value2 ) {
		if(this.getAddressField().getText().equals(value1)) {
			this.getAddressField().clear();
			this.getAddressField().sendKeys(value2);
		}else {
			this.getAddressField().clear();
		    this.getAddressField().sendKeys(value1);
		}
	}

	
}
