package pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	WebDriver driver;
	
	private Actions action;
	private WebDriverWait wait;
	

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		setAction(new Actions(driver));
		//wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	

	public void fillText(WebElement el, String text) {
		el.clear();
		el.sendKeys(text);

	}

	public void click(WebElement el) {
		waiting(2000);
		el.click();
	}

	public String getText(WebElement el) {
		return el.getText();
	}
	// Wait
	void waitForVisibilityOf(WebElement el) {
		wait.until(ExpectedConditions.visibilityOf(el));
	}

	void waitForInVisibilityOf(WebElement el) {
		wait.until(ExpectedConditions.invisibilityOf(el));
	}

	void waitForClickable(WebElement el) {
		wait.until(ExpectedConditions.elementToBeClickable(el));
	}

	public void waiting(long milis) {
		try {
			Thread.sleep(milis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	public void alertOK(String text) {
		driver.switchTo().alert().sendKeys(text);
		driver.switchTo().alert().accept();
	}


	public void scrollDown(WebElement element) {
		for (int i = 0; i < element.getLocation().getY(); i += 5) {
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0," + i + ")");
		}
		
		
	}
	public void dragAndDropBy(WebElement el, int y, int x) {
		getAction().moveToElement(el).clickAndHold().build().perform(); // click and hold
		waiting(1000);
		getAction().dragAndDropBy(el, y, x).release().build().perform(); // drag and drop
	}
	public Actions getAction() {
		return action;
	}

	public void setAction(Actions action) {
		this.action = action;
	}
}


