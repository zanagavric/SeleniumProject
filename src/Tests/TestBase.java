package Tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import Pages.AddingProductsPage;
import Pages.AddressesPage;
import Pages.LoginPage;
import Pages.MainPage;
import Pages.MyAccountPage;
import Pages.MyPersonalInformationPage;
import Pages.WishListPage;

public class TestBase {

	WebDriver driver;
	LoginPage loginPage;
	MainPage mainPage;
	ExcelReader excelreader;
	MyAccountPage myAccountPage;
	AddressesPage addressesPage;
	MyPersonalInformationPage myPersonalInformationPage;
	WishListPage wishListPage;
	AddingProductsPage addingProductsPage;
	WebDriverWait waitW;
	
	@BeforeClass
	public void setUp() throws IOException {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.loginPage = new LoginPage(driver);
		this.mainPage = new MainPage(driver);
		this.myAccountPage = new MyAccountPage(driver);
		this.addressesPage = new AddressesPage(driver);
		this.myPersonalInformationPage = new MyPersonalInformationPage(driver);
		this.wishListPage = new WishListPage(driver);
		this.addingProductsPage = new AddingProductsPage(driver);
		this.excelreader = new ExcelReader("data/test plan.xlsx");
		this.waitW = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
	}

	@AfterClass
	public void theEnd() {
		driver.quit();

	}

	public void insertData(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}
	
	public void signIn() {
		String emailaddress = excelreader.getData("login", 5, 5);
		String password = excelreader.getData("login", 6, 5);
		loginPage.insertEmailAddress(emailaddress);
		loginPage.insertPassword(password);
		loginPage.signinButtonClick();
	}
}
