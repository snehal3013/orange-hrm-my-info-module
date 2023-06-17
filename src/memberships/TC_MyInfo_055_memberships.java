package memberships;

import java.io.FileInputStream;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Sheet;
import jxl.Workbook;

public class TC_MyInfo_055_memberships {

	public static void main(String[] args) {
		WebDriver driver = WebDriverManager.chromedriver().create();
		try {
			FileInputStream f = new FileInputStream("D:\\ExcelR Project\\Memberships.xls");

			Workbook wb = Workbook.getWorkbook(f);

			Sheet s = wb.getSheet("TC_MyInfo_058");

			driver.get(s.getCell(1, 0).getContents());
			Thread.sleep(2000);
			driver.manage().window().maximize();
			// login
			driver.findElement(By.xpath(s.getCell(1, 3).getContents())).sendKeys(s.getCell(1, 19).getContents());
			driver.findElement(By.xpath(s.getCell(1, 4).getContents())).sendKeys(s.getCell(1, 20).getContents());
			driver.findElement(By.xpath(s.getCell(1, 5).getContents())).click();
			Thread.sleep(2000);
			// my info
			driver.findElement(By.linkText(s.getCell(1, 6).getContents())).click();
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,400)", "");
			Thread.sleep(2000);
			// memberships
			driver.findElement(By.linkText(s.getCell(1, 7).getContents())).click();
			Thread.sleep(2000);
			// add
			driver.findElement(By.xpath(s.getCell(1, 8).getContents())).click();
			Thread.sleep(2000);
			// membership
			driver.findElement(By.xpath(s.getCell(1, 9).getContents())).click();
			Thread.sleep(2000);
			List<WebElement> membership = driver.findElements(By.xpath(s.getCell(1, 10).getContents()));
			Thread.sleep(2000);
			for (int i = 0; i <= membership.size() - 1; i++) {

				if (membership.get(i).getText().contains(s.getCell(1, 21).getContents())) {

					membership.get(i).click();
					Thread.sleep(2000);
					break;
				}
			}
			// Subscription Paid By
			driver.findElement(By.xpath(s.getCell(1, 11).getContents())).click();
			Thread.sleep(2000);
			List<WebElement> subpaidby = driver.findElements(By.xpath(s.getCell(1, 12).getContents()));
			Thread.sleep(2000);
			for (int i = 0; i <= subpaidby.size() - 1; i++) {

				if (subpaidby.get(i).getText().contains(s.getCell(1, 22).getContents())) {

					subpaidby.get(i).click();
					Thread.sleep(2000);
					break;
				}
			}
			// Subscription Amount
			driver.findElement(By.xpath(s.getCell(1, 13).getContents())).sendKeys(s.getCell(1, 23).getContents());
			Thread.sleep(2000);
			// Currency
			driver.findElement(By.xpath(s.getCell(1, 14).getContents())).click();
			Thread.sleep(2000);
			List<WebElement> currency = driver.findElements(By.xpath(s.getCell(1, 15).getContents()));
			Thread.sleep(2000);
			for (int i = 0; i <= currency.size() - 1; i++) {

				if (currency.get(i).getText().contains(s.getCell(1, 24).getContents())) {

					currency.get(i).click();
					Thread.sleep(2000);
					break;
				}
			}
			// Subscription Commence Date
			WebElement subcommencedate = driver.findElement(By.xpath(s.getCell(1, 16).getContents()));
			subcommencedate.click();
			Thread.sleep(2000);
			subcommencedate.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			Thread.sleep(2000);
			subcommencedate.sendKeys(s.getCell(1, 25).getContents());
			Thread.sleep(2000);
			// Subscription Renewal Date
			WebElement subrenewaldate = driver.findElement(By.xpath(s.getCell(1, 17).getContents()));
			subrenewaldate.click();
			Thread.sleep(2000);
			subrenewaldate.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			Thread.sleep(2000);
			subrenewaldate.sendKeys(s.getCell(1, 26).getContents());
			Thread.sleep(2000);

			// save
			driver.findElement(By.xpath(s.getCell(1, 18).getContents())).click();
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println("Try with other locator");
		} finally {
			if (driver.getPageSource().contains("Successfully Saved")) {
				System.out.println("Details are Saved");
			} else {
				System.out.println("Details are not Saved");
			}
			driver.close();
		}
	}

}
