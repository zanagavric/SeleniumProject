package Tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInTests extends TestBase{
	
	@BeforeMethod
	public void startTest(){
		mainPage.navigateToLoginPage();
	}
	@Test (priority = 0)
	public void loginWithValidCredentials(){
		signIn();
		Assert.assertEquals(driver.findElement(By.className("page-heading")).getText(), excelreader.getData("login", 7, 6));
	}	
	@Test (priority = 1)
	public void loginWithInvalidEmail(){
		String emailaddress = excelreader.getData("login", 13, 5);
		String password = excelreader.getData("login", 14, 5);
		loginPage.login(emailaddress, password);
		Assert.assertEquals(driver.findElement(By.xpath("//li[text()='Invalid email address.']")).getText(), excelreader.getData("login", 15, 6));
	}	
	@Test (priority = 2)
	public void loginWithInvalidPassword(){
		String emailaddress = excelreader.getData("login", 21, 5);
		String password = excelreader.getData("login", 22, 5);
		loginPage.login(emailaddress, password);
		Assert.assertEquals(driver.findElement(By.xpath("//li[text()='Authentication failed.']")).getText(), excelreader.getData("login", 23, 6));
	}
	@Test (priority = 3)
	public void loginWithEmptyCredentials(){
		String emailaddress = "";
		String password = "";
		loginPage.login(emailaddress, password);
		Assert.assertEquals(driver.findElement(By.xpath("//li[text()='An email address required.']")).getText(), excelreader.getData("login", 30, 6));
	}
	@Test (priority = 4)
	public void logout(){
		loginWithValidCredentials();
		loginPage.signOutButtonClick();
		Assert.assertEquals(loginPage.getSigninButton().getText(), excelreader.getData("login", 34, 6));		
	}	
	@AfterMethod
	public void theEndTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}
	
}

