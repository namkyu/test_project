package selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @FileName : JavascriptExsample.java
 * @Project : test_project
 * @Date : 2013. 9. 30.
 * @작성자 : nklee
 * @프로그램설명 :
 */
public class JavascriptExsample {

	@Test
	public void alertTest() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("window-size=1024,768");

		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		WebDriver driver = new ChromeDriver();
		driver.get("http://op.ncsoft.web/Login.do");

		WebElement element = driver.findElement(By.name("userid"));
		element.sendKeys("nklee");

		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("1111");

		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor) driver).executeScript("login();");
		}

	}
}
