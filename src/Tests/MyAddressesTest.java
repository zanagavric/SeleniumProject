package Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyAddressesTest extends TestBase {

	@BeforeMethod
	public void startTest(){
		mainPage.navigateToLoginPage();
		signIn();
		myAccountPage.myAddressesClick();
	}
	@Test (priority = 1)
	public void addAddress() {
		addressesPage.addAnewAddressButtonClick();
		addressesPage.insertData(addressesPage.getAddressField(), excelreader.getData("MyAddress", 4, 3));
		addressesPage.insertData(addressesPage.getCityField(), excelreader.getData("MyAddress", 5, 3));
		addressesPage.chooseState(addressesPage.getStateField(), excelreader.getData("MyAddress", 6, 3));
		addressesPage.insertData(addressesPage.getZipCodeField(), excelreader.getData("MyAddress", 7, 3));
		addressesPage.insertData(addressesPage.getHomePhoneField(), excelreader.getData("MyAddress", 8, 3));
		addressesPage.insertData(addressesPage.getMyAddressField(), excelreader.getData("MyAddress", 9, 3));
		addressesPage.saveButtonClick();
		
		Assert.assertEquals(addressesPage.getAddAnewAddressButton().isDisplayed(),true);
	}
	@Test (priority = 2)
	public void updataAddress() throws InterruptedException {
		String temp = addressesPage.getAddressForCompare().getText();
		addressesPage.updateButtonClick();
		String value1 = excelreader.getData("RegistrationData", 3, 2);
		String value2 = excelreader.getData("MyAddress", 4, 5);
		addressesPage.changeAddress(value1,value2);
		addressesPage.saveButtonClick();
		
		Assert.assertNotEquals(addressesPage.getAddressForCompare().getText(), temp);
	}	
	@Test (priority = 3)
	public void remuveAddress() {
		boolean check = addressesPage.isElementPresent();
		addressesPage.deleteButtonClick();
		addressesPage.alertClickOK();
		
		Assert.assertFalse(check);
	}
	@AfterMethod
	public void theEndTest() {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}
}
