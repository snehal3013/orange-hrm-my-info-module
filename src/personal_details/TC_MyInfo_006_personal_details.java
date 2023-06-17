package personal_details;

import java.io.FileInputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Sheet;
import jxl.Workbook;

public class TC_MyInfo_006_personal_details {

	public static void main(String[] args) {
		WebDriver driver = WebDriverManager.chromedriver().create();
		try {
			FileInputStream f = new FileInputStream("D:\\ExcelR Project\\Personal_Details.xls");

			Workbook wb = Workbook.getWorkbook(f);

			Sheet s = wb.getSheet("TC_MyInfo_006");

			driver.get(s.getCell(1, 0).getContents());
			Thread.sleep(2000);
			driver.manage().window().maximize();

			// login
			driver.findElement(By.xpath(s.getCell(1, 3).getContents())).sendKeys(s.getCell(1, 19).getContents());
			driver.findElement(By.xpath(s.getCell(1, 4).getContents())).sendKeys(s.getCell(1, 20).getContents());
			driver.findElement(By.xpath(s.getCell(1, 5).getContents())).click();
			Thread.sleep(2000);

			// my info module
			driver.findElement(By.linkText(s.getCell(1, 6).getContents())).click();
			Thread.sleep(2000);

			// first name
			WebElement fname = driver.findElement(By.name(s.getCell(1, 7).getContents()));
			fname.click();
			fname.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			fname.sendKeys(s.getCell(1, 21).getContents());
			Thread.sleep(2000);

			// middle name
			WebElement midname = driver.findElement(By.name(s.getCell(1, 8).getContents()));
			fname.click();
			fname.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			midname.sendKeys(s.getCell(1, 22).getContents());
			Thread.sleep(2000);

			// last name
			WebElement lname = driver.findElement(By.name(s.getCell(1, 9).getContents()));
			fname.click();
			fname.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			lname.sendKeys(s.getCell(1, 23).getContents());
			Thread.sleep(2000);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,350)", "");
			Thread.sleep(2000);

			// license expiry date
			WebElement licensedate = driver.findElement(By.xpath(s.getCell(1, 10).getContents()));
			licensedate.click();
			Thread.sleep(2000);
			licensedate.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			Thread.sleep(2000);
			licensedate.sendKeys(s.getCell(1, 24).getContents());
			Thread.sleep(2000);

			// nationality
			driver.findElement(By.xpath(s.getCell(1, 11).getContents())).click();
			Thread.sleep(2000);
			List<WebElement> cnames = driver.findElements(By.xpath(s.getCell(1, 12).getContents()));
			Thread.sleep(2000);
			for (int i = 0; i <= cnames.size() - 1; i++) {

				if (cnames.get(i).getText().contains(s.getCell(1, 25).getContents())) {

					cnames.get(i).click();
					Thread.sleep(2000);
					break;
				}
			}

			// marital status
			driver.findElement(By.xpath(s.getCell(1, 13).getContents())).click();
			Thread.sleep(2000);
			List<WebElement> maritalstatus = driver.findElements(By.xpath(s.getCell(1, 14).getContents()));
			Thread.sleep(2000);
			for (int i = 0; i <= maritalstatus.size() - 1; i++) {

				if (maritalstatus.get(i).getText().contains(s.getCell(1, 26).getContents())) {

					maritalstatus.get(i).click();
					Thread.sleep(2000);
					break;
				}
			}

			// gender
			driver.findElement(By.xpath(s.getCell(1, 15).getContents())).click();
			Thread.sleep(2000);

			js.executeScript("window.scrollBy(0,450)", "");
			Thread.sleep(2000);

			// blood type
			driver.findElement(By.xpath(s.getCell(1, 16).getContents())).click();
			Thread.sleep(2000);
			List<WebElement> bloodtype = driver.findElements(By.xpath(s.getCell(1, 17).getContents()));
			Thread.sleep(2000);
			for (int i = 0; i <= bloodtype.size() - 1; i++) {

				if (bloodtype.get(i).getText().contains(s.getCell(1, 27).getContents())) {

					bloodtype.get(i).click();
					Thread.sleep(2000);
					break;
				}
			}

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
