package selenium;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebHardTest {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "http://op.ncsoft.web/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void test() throws Exception {
		driver.get(baseUrl + "/Login.do");
		driver.findElement(By.name("userid")).clear();
		driver.findElement(By.name("userid")).sendKeys("nklee");
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("rbdn2001!nc");
		driver.findElement(By.cssSelector("img[alt=\"로그인버튼\"]")).click();
		driver.findElement(By.cssSelector("p > img")).click();

		driver.findElement(By.name("http_upload_yn")).clear();
		driver.findElement(By.name("http_upload_yn")).click();


		driver.findElement(By.id("http_file")).clear();
		driver.findElement(By.id("http_file")).sendKeys("C:\\Users\\nklee\\Desktop\\test.html");
		driver.findElement(By.cssSelector("img.input_image")).click();
	}

	@After
	public void tearDown() throws Exception {
//		driver.quit();
//		String verificationErrorString = verificationErrors.toString();
//		if (!"".equals(verificationErrorString)) {
//			fail(verificationErrorString);
//		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}
