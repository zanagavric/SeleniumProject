package Pages;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Tests.TestBase;

public class WishListPage extends TestBase {

	WebDriver driver;
	WebElement nameNewWishList;
	WebElement saveButton;
	WebElement tableElement;
	WebElement deleteIcon;
	Alert alert;

	public WishListPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getNameNewWishList() {
		return driver.findElement(By.id("name"));
	}
	
	public WebElement getSaveButton() {
		return driver.findElement(By.id("submitWishlist"));
	}
	
	public WebElement getTableElement() {
		return driver.findElement(By.xpath("//tr[starts-with(@id,'wishlist')]"));
	}
	
	public Alert getAlert() {
		return driver.switchTo().alert();
	}
	
	public WebElement getDeleteIcon() {
		return driver.findElement(By.xpath("//a[@class='icon']"));
	}
	
	public void deleteIconClick() {
		this.getDeleteIcon().click();
	}
	
	public void saveButtonClick() {
		this.getSaveButton().click();
	}
	
	public void alertClickOK() {
		this.getAlert().accept();
	}
	
	public boolean isElementPresent() {
		try {
			getTableElement();
			return true;
		} catch(org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}
}
