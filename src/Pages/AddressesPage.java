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
	WebElement street2;
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
	
	public WebElement getStreet2() {
		return driver.findElement(By.xpath("//h3[text()='STREET 2']"));
	}

	public WebElement getDeleteButton() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div[2]/ul/li[9]/a[2]"));
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
		
	public String changeAddress(String value1,String value2 ) {
		if((this.getAddressField().getAttribute("value")).equals(value2)) {
			this.getAddressField().clear();
			this.getAddressField().sendKeys(value1);
			return value1;
		}else {
			this.getAddressField().clear();
		    this.getAddressField().sendKeys(value2);
		    return value2;
		}
	}
	
	public boolean isElementPresent() {
		try {
			getStreet2();
			return true;
		} catch(org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

}
