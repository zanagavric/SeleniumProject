package Pages;

import org.openqa.selenium.By;
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
	WebElement textAssert;
	WebElement textAssert2;
	WebElement delete;
	WebElement product1;
	WebElement product2;
	WebElement product3;
	WebDriverWait wait;
	Actions actions;

	public AddingProductsPage(WebDriver driver) {
		this.driver = driver;
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
		return driver.findElement(By.xpath("//a[@data-id-product='1']"));
	}

	public WebElement getProduct1() {
		return driver.findElement(
				By.xpath("//li[@class='ajax_block_product col-xs-12 col-sm-4 col-md-3 last-item-of-mobile-line']"));
	}

	public WebElement getProduct2() {
		return driver.findElement(By.xpath("//a[@href='http://automationpractice.com/index.php?id_product=3&controller=product']"));
	}

	public WebElement getProduct3() {
		return driver.findElement(By.xpath("//a[@title='Faded Short Sleeve T-shirts']"));
	}

	public WebElement getTextAssert() {
		return driver.findElement(By.xpath("//a[@title='View my shopping cart']"));
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

	public String testForAssert() {
		return getTextAssert().getText();
	}
	public void deleteClick() {
		getDelete().click();
	}
	public void continueShoppingClick() {
		wait.until(ExpectedConditions.visibilityOf(getContinueShopping()));
		this.getContinueShopping().click();
	}
	
	public void proceedToCheckoutClick() {
		wait.until(ExpectedConditions.visibilityOf(getProceedToCheckout()));
		this.getProceedToCheckout().click();
	}

	public void quantityAddClick() {
		this.getQuantityAdd().click();
	}

	public void addProduct(WebElement element1, WebElement element2) {
		wait.until(ExpectedConditions.visibilityOf(element1));
		actions.moveToElement(element1).perform();
		actions.moveToElement(element2);
		actions.click().build().perform();
	}

}
