package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Tests.TestBase;

public class AddingProductsPage extends TestBase {

	WebDriver driver;
	WebElement addToCart1;
	WebElement addToCart2;
	WebElement addToCart3;
	WebElement proceedToCheckout;
	WebElement continueShopping;
	WebElement quantityAdd;
	WebElement quantity;
	WebElement product;
	WebElement idAssert1;
	WebElement idAssert2;
	WebElement idAssert3;
	WebElement textAssert;
	WebElement textAssert2;
	WebElement delete;
	WebDriverWait wait;
	public JavascriptExecutor js;
	Actions actions;

	public AddingProductsPage(WebDriver driver) {
		this.driver = driver;
		this.js = (JavascriptExecutor) driver;
		this.actions = new Actions(driver);
		this.wait = new WebDriverWait(driver, 5);
	}

	public WebElement getQuantityAdd() {
		return driver.findElement(By.xpath("//a[@title='Add']"));
	}

	public WebElement getProceedToCheckout() {
		return driver.findElement(By.xpath("//a[@title='Proceed to checkout']"));
	}

	public WebElement getContinueShopping() {
		return driver.findElement(By.xpath("//span[@title='Continue shopping']"));
	}

	public WebElement getAddToCart1() {
		return driver.findElement(By.xpath("//a[@data-id-product='2']"));
	}

	public WebElement getAddToCart2() {
		return driver.findElement(By.xpath("//a[@data-id-product='3']"));
	}

	public WebElement getAddToCart3() {
		return driver.findElement(By.xpath("//a[@data-id-product='4']"));
	}

	public WebElement getProduct1() {
		return driver.findElement(
				By.xpath("//li[@class='ajax_block_product col-xs-12 col-sm-4 col-md-3 last-item-of-mobile-line']"));
	}

	public WebElement getProduct2() {
		return driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[3]/div"));
	}

	public WebElement getProduct3() {
		return driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[4]/div"));
	}

	public WebElement getIdAssert1() {
		return driver.findElement(By.id("product_2_7_0_0"));
	}
	
	public WebElement getIdAssert2() {
		return driver.findElement(By.id("product_3_13_0_0"));
	}

	public WebElement getIdAssert3() {
		return driver.findElement(By.id("product_4_16_0_0"));
	}
	
	public WebElement getTextAssert() {
		return driver.findElement(By.xpath("p[@class='alert alert-warning']"));
	}
	
	public WebElement getTextAssert2() {
		return driver.findElement(By.xpath("//span[@id='summary_products_quantity']"));
	}
	
	public WebElement getDelete() {
		return driver.findElement(By.xpath("//a[@title='Delete']"));
	}

	public void addToCartClick(WebElement element) {
		element.click();
	}

	public void deleteClick() {
		getDelete().click();
	}
	public void continueShoppingClick() {
		getContinueShopping().click();
	}
	
	public void proceedToCheckoutClick() {
		this.getProceedToCheckout().click();
	}

	public void quantityAddClick() {
		this.getQuantityAdd().click();
	}

	public void addProduct(WebElement element1, WebElement element2) {
		js.executeScript("window.scrollBy(0,900)");
		actions.moveToElement(element1).perform();
		actions.moveToElement(element2);
		actions.click().build().perform();
	}

}
