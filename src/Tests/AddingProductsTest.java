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
		addingProductsPage.js.executeScript("window.scrollBy(0,150)");
		Assert.assertTrue(addingProductsPage.getIdAssert1().isDisplayed());
	}
	@Test (priority = 1)
	public void addProductQuantity() throws InterruptedException {
		addingProductsPage.addProduct(addingProductsPage.getProduct1(),addingProductsPage.getAddToCart1());
		addingProductsPage.proceedToCheckoutClick();
		addingProductsPage.js.executeScript("window.scrollBy(0,150)");
		addingProductsPage.quantityAddClick();
		addingProductsPage.quantityAddClick();
		Thread.sleep(4000);
		Assert.assertEquals(addingProductsPage.getTextAssert2().getText(), excelreader.getData("AddingProducts", 7, 4));
	}
	@Test (priority = 2)
	public void addThreeProducts() throws InterruptedException {		
		addingProductsPage.addProduct(addingProductsPage.getProduct1(),addingProductsPage.getAddToCart1());
		Thread.sleep(2000);
		addingProductsPage.continueShoppingClick();
		Thread.sleep(2000);
		addingProductsPage.addProduct(addingProductsPage.getProduct2(),addingProductsPage.getAddToCart2());
		Thread.sleep(2000);
		addingProductsPage.continueShoppingClick();
		Thread.sleep(2000);
		addingProductsPage.addProduct(addingProductsPage.getProduct3(),addingProductsPage.getAddToCart3());
		Thread.sleep(2000);
		addingProductsPage.proceedToCheckoutClick();
		Thread.sleep(2000);
		addingProductsPage.js.executeScript("window.scrollBy(0,300)");
		Assert.assertTrue(addingProductsPage.getIdAssert1().isDisplayed());
		Assert.assertTrue(addingProductsPage.getIdAssert2().isDisplayed());
		Assert.assertTrue(addingProductsPage.getIdAssert3().isDisplayed());
	}
	@Test (priority = 3)
	public void removeProduct() throws InterruptedException {
		addOneProduct();
		addingProductsPage.proceedToCheckoutClick();
		addingProductsPage.js.executeScript("window.scrollBy(0,150)");
		Thread.sleep(2000);
		addingProductsPage.deleteClick();
		Thread.sleep(2000);
		Assert.assertEquals(addingProductsPage.getTextAssert().getText(), excelreader.getData("AddingProducts", 17, 4));
	}
	@AfterMethod
	public void theEndTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
}
