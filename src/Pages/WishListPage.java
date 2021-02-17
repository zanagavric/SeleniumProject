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
	WebElement table;
	Alert alert;

	public WishListPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getNameNewWishList() {
		return driver.findElement(By.id("name"));
	}
		
	public WebElement getTable() {
		return driver.findElement(By.id("block-history"));
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
		return driver.findElement(By.className("icon"));
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
	public void remove() throws InterruptedException {
		Thread.sleep(1000);
		deleteIconClick();
		Thread.sleep(1000);
		alertClickOK();
		Thread.sleep(2000);	
	}
	
	public boolean isElementPresent() {
		try {
			getTable();
			return true;
		} catch(org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}
}
