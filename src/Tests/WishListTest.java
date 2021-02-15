package Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WishListTest extends TestBase {

	int counter = 0;
	
	@BeforeMethod
	public void startTest() {
		mainPage.navigateToLoginPage();
		signIn();
		myAccountPage.myWishlistClick();
	}	
	@Test (priority = 0)
	public void addWishList() {
		wishListPage.insertData(wishListPage.getNameNewWishList(), excelreader.getData("WishList", 3, 4));
		wishListPage.saveButtonClick();		
		Assert.assertTrue(wishListPage.getTableElement().isDisplayed());
	}	
	@Test (priority = 1)
	public void removeWishList() throws InterruptedException {
		wishListPage.deleteIconClick();
		Thread.sleep(2000);
		wishListPage.alertClickOK();
		Thread.sleep(2000);		
		Assert.assertFalse(wishListPage.isElementPresent());			
	}	
	@Test (priority = 2)
	public void addMultipleWishList() {		
		for(int row = 6; row<10; row++) {
			wishListPage.insertData(wishListPage.getNameNewWishList(), excelreader.getData("WishList", row, 4));	
			wishListPage.saveButtonClick();
			++counter;			
		}
		Assert.assertEquals(String.valueOf(counter), excelreader.getData("WishList", 10, 5));		
	}
	@Test (priority = 3)
	public void removeAllWishList() throws InterruptedException {
		for( int i = counter; i>0; i-- ){
		removeWishList();
		Thread.sleep(2000);
		}
		Assert.assertFalse(wishListPage.isElementPresent());
	}	
	@AfterMethod
	public void theEndTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
}
