package Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddingProductsTest extends TestBase {

	@BeforeMethod
	public void startTest() {
		mainPage.navigateToHomePage();
	}	
	@Test (priority = 0)
	public void addOneProduct() {
		addingProductsPage.addProduct(addingProductsPage.getProduct1(),addingProductsPage.getAddToCart1());
		addingProductsPage.proceedToCheckoutClick();
		Assert.assertEquals(addingProductsPage.testForAssert(), excelreader.getData("AddingProducts", 4, 4));
	}
	@Test (priority = 1)
	public void addProductQuantity() throws InterruptedException {
		addingProductsPage.addProduct(addingProductsPage.getProduct1(),addingProductsPage.getAddToCart1());
		addingProductsPage.proceedToCheckoutClick();
		addingProductsPage.quantityAddClick();
		addingProductsPage.quantityAddClick();
		Thread.sleep(3000);
		Assert.assertEquals(addingProductsPage.testForAssert(), excelreader.getData("AddingProducts", 6, 4));
	}
	@Test (priority = 2)
	public void addThreeProducts() throws InterruptedException {		
		addingProductsPage.addProduct(addingProductsPage.getProduct1(),addingProductsPage.getAddToCart1());
		Thread.sleep(1000);
		addingProductsPage.continueShoppingClick();
		Thread.sleep(1000);
		addingProductsPage.addProduct(addingProductsPage.getProduct2(),addingProductsPage.getAddToCart2());
		Thread.sleep(1000);
		addingProductsPage.continueShoppingClick();
		Thread.sleep(1000);
		addingProductsPage.addProduct(addingProductsPage.getProduct3(),addingProductsPage.getAddToCart3());
		Thread.sleep(1000);
		addingProductsPage.proceedToCheckoutClick();
		Thread.sleep(1000);
		Assert.assertEquals(addingProductsPage.testForAssert(), excelreader.getData("AddingProducts", 14, 4));
	}
	@Test (priority = 3)
	public void removeProduct() throws InterruptedException {
		addingProductsPage.addProduct(addingProductsPage.getProduct1(),addingProductsPage.getAddToCart1());
		addingProductsPage.proceedToCheckoutClick();
		addingProductsPage.deleteClick();
		Thread.sleep(2000);
		Assert.assertEquals(addingProductsPage.testForAssert(), excelreader.getData("AddingProducts", 17, 4));
	}
	@AfterMethod
	public void theEndTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
}
