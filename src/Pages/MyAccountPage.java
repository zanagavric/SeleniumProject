package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Tests.TestBase;

public class MyAccountPage extends TestBase{

	WebDriver driver;
	WebElement myAddresses;
	WebElement myPersonalInformation;
	WebElement myWishlist;

	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getMyAddresses() {
		return driver.findElement(By.xpath("//a[@title='Addresses']"));
	}

	public WebElement getMyPersonalInformation() {
		return driver.findElement(By.xpath("//a[@title='Information']"));
	}

	public WebElement getMyWishlist() {
		return driver.findElement(By.xpath("//a[@title='My wishlists']"));
	}
	
	public void myAddressesClick() {
		this.getMyAddresses().click();
	}
	
	public void myPersonalInformationClick() {
		this.getMyPersonalInformation().click();
	}
	
	public void myWishlistClick() {
		this.getMyWishlist().click();
	}
	
}
