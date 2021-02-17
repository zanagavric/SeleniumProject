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
import Pages.Registration;
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
	Registration registration;
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
		this.registration = new Registration(driver);
		this.excelreader = new ExcelReader("data/test plan.xlsx");
		this.waitW = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
	}

	@AfterClass
	public void theEnd() {	
		backData();
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

	public void backData() {
		String firstName = excelreader.getData("RegistrationData", 1, 2);
		String lastName = excelreader.getData("RegistrationData", 2, 2);
		String address = excelreader.getData("RegistrationData", 3, 2);
		String city = excelreader.getData("RegistrationData", 4, 2);
		String state = excelreader.getData("RegistrationData", 5, 2);
		String code = excelreader.getData("RegistrationData", 6, 2);
		String homePhone = excelreader.getData("RegistrationData", 8, 2);
		String myAddress = excelreader.getData("RegistrationData", 9, 2);
		
		mainPage.navigateToLoginPage();
		signIn();
		myAccountPage.myAddressesClick();
		addressesPage.updateButtonClick();
		registration.firstNameField(firstName);
		registration.lastNameField(lastName);
		registration.addressField(address);
		registration.cityField(city);
		registration.choosestate(registration.getStateField(),state);
		registration.zipCodeField(code);
		registration.homePhoneField(homePhone);
		registration.myAddressField(myAddress);
		registration.saveButtonClick();
	}
}
