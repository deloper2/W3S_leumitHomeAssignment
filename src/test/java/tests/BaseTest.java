package tests;
import org.testng.annotations.BeforeClass;
import utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;



public class BaseTest {

	public WebDriver driver;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/Users/alteclansing/Downloads/QA/Automation/Selenium/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Utils.readProperty("url"));

	}
	
	
		@AfterClass
		public void tearDown() {
			driver.quit();
		}
}