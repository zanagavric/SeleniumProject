package Tests;

import org.testng.annotations.Test;

public class LogInTests extends TestBase{

	@Test
	public void login() throws InterruptedException {
		driver.navigate().to("https://demoqa.com/");
		Thread.sleep(2000);
	}
}

