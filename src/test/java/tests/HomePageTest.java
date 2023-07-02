package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebElement;
import pageobjects.HomePage;

public class HomePageTest extends BaseTest {

	@Test
	public void tc01_getTableCellText() {
		HomePage hp = new HomePage(driver);
		WebElement table = hp.getTable();
		String cellText = hp.getTableCellText(table, 1, "Island Trading", 3);
		AssertJUnit.assertEquals(cellText, "UK");
	}

	@Test
	public void tc02_verifyTableCellText() {
		HomePage hp = new HomePage(driver);
		WebElement table = hp.getTable();
		boolean isTextVerified = hp.verifyTableCellText(table, 1, "Centro comercial Moctezuma", 3, "Mexico");
		AssertJUnit.assertTrue(isTextVerified);
	
	}
	@Test
	public void tc03_getTableCellTextByXpath()throws Exception {
		HomePage hp = new HomePage(driver);
		WebElement table = hp.getTable();
		String cellText = hp.getTableCellTextByXpath(table, 1, "Ernst Handel", 3);
		AssertJUnit.assertEquals(cellText, "Austria");
	
	}
	
	@Test
	public void tc04_getTableCellTextWithColumnName() {
		HomePage hp = new HomePage(driver);
		WebElement table = hp.getTable();
		String cellText = hp.getTableCellTextWithColumnName(table, "Company", "Island Trading", "Country");
		AssertJUnit.assertEquals(cellText, "UK");
	}

	@Test
	public void tc05_verifyTableCellTextWithColumnName() {
		HomePage hp = new HomePage(driver);
		WebElement table = hp.getTable();
		boolean isTextVerified = hp.verifyTableCellTextWithColumnName(table, "Company", "Centro comercial Moctezuma", "Country", "Mexico");
		AssertJUnit.assertTrue(isTextVerified);
	
	}
	@Test
	public void tc06_getTableCellTextByXpathWithColumnName()throws Exception {
		HomePage hp = new HomePage(driver);
		WebElement table = hp.getTable();
		String cellText = hp.getTableCellTextByXpathWithColumnName(table, "Company", "Ernst Handel","Country");
		AssertJUnit.assertEquals(cellText, "Austria");
	
	}

}

