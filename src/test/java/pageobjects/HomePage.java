
package pageobjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;

public class HomePage extends BasePage {


	@FindBy(css = ".w3-example #customers")
	private WebElement table;

	@FindBy(css = "#customers tr:nth-of-type(1)")
	private WebElement headerRow;


	public HomePage(WebDriver driver) {
		super(driver);
	}

	public WebElement getTable() {
		return this.table;
	}



	public String getTableCellTextWithColumnName(WebElement table, String searchColumnName, String searchText, String returnColumnName) {
		int searchColumnIndex = getColumnIndex(table, searchColumnName);
		int returnColumnIndex = getColumnIndex(table, returnColumnName);

		if (searchColumnIndex == -1 || returnColumnIndex == -1) {
			return null;
		}

		return getTableCellText(table, searchColumnIndex, searchText, returnColumnIndex);
	}

	public boolean verifyTableCellTextWithColumnName(WebElement table, String searchColumnName, String searchText, String returnColumnName, String expectedText) {
		int searchColumnIndex = getColumnIndex(table, searchColumnName);
		int returnColumnIndex = getColumnIndex(table, returnColumnName);

		if (searchColumnIndex == -1 || returnColumnIndex == -1) {
			return false;
		}

		return verifyTableCellText(table, searchColumnIndex, searchText, returnColumnIndex, expectedText);
	}

	public String getTableCellTextByXpathWithColumnName(WebElement table, String searchColumnName, String searchText, String returnColumnName) throws Exception {
		int searchColumnIndex = getColumnIndex(table, searchColumnName);
		int returnColumnIndex = getColumnIndex(table, returnColumnName);

		if (searchColumnIndex == -1 || returnColumnIndex == -1) {
			throw new Exception("Search column or return column not found");
		}

		return getTableCellTextByXpath(table, searchColumnIndex, searchText, returnColumnIndex);
	}

	public int getColumnIndex(WebElement table, String columnName) {
		List<WebElement> headerCells = headerRow.findElements(By.tagName("th"));

		for (int i = 0; i < headerCells.size(); i++) {
			if (headerCells.get(i).getText().equals(columnName)) {
				return i + 1;
			}
		}

		return -1;
	}

	public String getTableCellText(WebElement table, int searchColumnIndex, String searchText, int returnColumnIndex) {
		List<WebElement> rows = table.findElements(By.tagName("tr"));

		for (WebElement row : rows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));

			if (cells.size() >= searchColumnIndex && cells.get(searchColumnIndex - 1).getText().equals(searchText)) {
				if (cells.size() >= returnColumnIndex) {
					return cells.get(returnColumnIndex - 1).getText();
				}
			}
		}

		return null;
	}

	public boolean verifyTableCellText(WebElement table, int searchColumnIndex, String searchText, int returnColumnIndex, String expectedText) {
		String actualText = getTableCellText(table, searchColumnIndex, searchText, returnColumnIndex);
		return expectedText.equals(actualText);
	}

	public String getTableCellTextByXpath(WebElement table, int searchColumnIndex, String searchText, int returnColumnIndex) throws Exception {
		String xpathExpression = "//tr[contains(td[" + searchColumnIndex + "],'" + searchText + "')]/td[" + returnColumnIndex + "]";
		WebElement cell = table.findElement(By.xpath(xpathExpression));
		return cell.getText();
	}
}
