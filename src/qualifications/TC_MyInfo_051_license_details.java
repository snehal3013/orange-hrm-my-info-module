package qualifications;

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

public class TC_MyInfo_051_license_details {

	public static void main(String[] args) {
		WebDriver driver = WebDriverManager.chromedriver().create();
		try {
			FileInputStream f = new FileInputStream("D:\\ExcelR Project\\Qualifications.xls");

			Workbook wb = Workbook.getWorkbook(f);

			Sheet s = wb.getSheet("TC_MyInfo_051");

			driver.get(s.getCell(1, 0).getContents());
			Thread.sleep(2000);
			driver.manage().window().maximize();
			// login
			driver.findElement(By.xpath(s.getCell(1, 3).getContents())).sendKeys(s.getCell(1, 20).getContents());
			driver.findElement(By.xpath(s.getCell(1, 4).getContents())).sendKeys(s.getCell(1, 21).getContents());
			driver.findElement(By.xpath(s.getCell(1, 5).getContents())).click();
			Thread.sleep(2000);
			// my info
			driver.findElement(By.linkText(s.getCell(1, 6).getContents())).click();
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,300)", "");
			Thread.sleep(2000);
			// qualifications
			driver.findElement(By.linkText(s.getCell(1, 7).getContents())).click();
			Thread.sleep(2000);
			js.executeScript("window.scrollBy(0,700)", "");
			Thread.sleep(2000);
			// add
			driver.findElement(By.xpath(s.getCell(1, 8).getContents())).click();
			Thread.sleep(2000);
			// license type
			driver.findElement(By.xpath(s.getCell(1, 9).getContents())).click();
			Thread.sleep(2000);
			List<WebElement> lictype = driver.findElements(By.xpath(s.getCell(1, 10).getContents()));
			Thread.sleep(2000);
			for (int i = 0; i <= lictype.size() - 1; i++) {

				if (lictype.get(i).getText().contains(s.getCell(1, 22).getContents())) {

					lictype.get(i).click();
					Thread.sleep(2000);
					break;
				}
			}
			// issued date
			WebElement issueddate = driver.findElement(By.xpath(s.getCell(1, 11).getContents()));
			issueddate.click();
			Thread.sleep(2000);
			issueddate.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			Thread.sleep(2000);
			issueddate.sendKeys(s.getCell(1, 23).getContents());
			Thread.sleep(2000);
			// expiry date
			WebElement expdate = driver.findElement(By.xpath(s.getCell(1, 12).getContents()));
			expdate.click();
			Thread.sleep(2000);
			expdate.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			Thread.sleep(2000);
			expdate.sendKeys(s.getCell(1, 24).getContents());
			Thread.sleep(2000);

			// save
			driver.findElement(By.xpath(s.getCell(1, 13).getContents())).click();
			Thread.sleep(2000);

			Thread.sleep(4000);
			// add
			driver.findElement(By.xpath(s.getCell(1, 14).getContents())).click();
			Thread.sleep(2000);
			// license type
			driver.findElement(By.xpath(s.getCell(1, 15).getContents())).click();
			Thread.sleep(2000);
			List<WebElement> lictype1 = driver.findElements(By.xpath(s.getCell(1, 16).getContents()));
			Thread.sleep(2000);
			for (int i = 0; i <= lictype1.size() - 1; i++) {

				if (lictype1.get(i).getText().contains(s.getCell(1, 25).getContents())) {

					lictype1.get(i).click();
					Thread.sleep(2000);
					break;
				}
			}
			// issued date
			WebElement issueddate1 = driver.findElement(By.xpath(s.getCell(1, 17).getContents()));
			issueddate1.click();
			Thread.sleep(2000);
			issueddate1.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			Thread.sleep(2000);
			issueddate1.sendKeys(s.getCell(1, 26).getContents());
			Thread.sleep(2000);
			// expiry date
			WebElement expdate1 = driver.findElement(By.xpath(s.getCell(1, 18).getContents()));
			expdate1.click();
			Thread.sleep(2000);
			expdate1.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			Thread.sleep(2000);
			expdate1.sendKeys(s.getCell(1, 27).getContents());
			Thread.sleep(2000);

			// save
			driver.findElement(By.xpath(s.getCell(1, 19).getContents())).click();
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
