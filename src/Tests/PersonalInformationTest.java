package Tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PersonalInformationTest extends TestBase{

	@BeforeMethod
	public void startTest() throws InterruptedException {
		mainPage.navigateToLoginPage();
		signIn();		
		Thread.sleep(2000);
		myAccountPage.myPersonalInformationClick();
	}
	
	@Test (priority = 0)
	public void editPersonalInformation() {
		myPersonalInformationPage.insertData(myPersonalInformationPage.getFirstNameField(), excelreader.getData("PersonalInformation", 3, 3));
		myPersonalInformationPage.insertData(myPersonalInformationPage.getLastNameField(), excelreader.getData("PersonalInformation", 4, 3));
		myPersonalInformationPage.insertData(myPersonalInformationPage.geteMailAddressField(), excelreader.getData("PersonalInformation", 5, 3));
		myPersonalInformationPage.insertData(myPersonalInformationPage.getCurrentPasswordField(), excelreader.getData("PersonalInformation", 6, 3));
		myPersonalInformationPage.saveButtonClick();
		
		Assert.assertEquals(driver.findElement(By.xpath("//p[@class='alert alert-success']")).getText(),excelreader.getData("PersonalInformation", 7, 4));
		
	}
	@AfterMethod
	public void theEndTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
}
