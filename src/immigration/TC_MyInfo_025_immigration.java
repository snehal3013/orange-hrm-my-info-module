package immigration;

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

public class TC_MyInfo_025_immigration {

	public static void main(String[] args) {
		WebDriver driver = WebDriverManager.chromedriver().create();
		try {
			FileInputStream f = new FileInputStream("D:\\ExcelR Project\\Immigration.xls");

			Workbook wb = Workbook.getWorkbook(f);

			Sheet s = wb.getSheet("TC_MyInfo_025");

			driver.get(s.getCell(1, 0).getContents());
			Thread.sleep(2000);
			driver.manage().window().maximize();

			// login
			driver.findElement(By.xpath(s.getCell(1, 3).getContents())).sendKeys(s.getCell(1, 24).getContents());
			driver.findElement(By.xpath(s.getCell(1, 4).getContents())).sendKeys(s.getCell(1, 25).getContents());
			driver.findElement(By.xpath(s.getCell(1, 5).getContents())).click();
			Thread.sleep(2000);
			// my info
			driver.findElement(By.linkText(s.getCell(1, 6).getContents())).click();
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,300)", "");
			Thread.sleep(2000);
			// immigration
			driver.findElement(By.linkText(s.getCell(1, 7).getContents())).click();
			Thread.sleep(2000);
			// add
			driver.findElement(By.xpath(s.getCell(1, 8).getContents())).click();
			Thread.sleep(2000);
			// passport radiobtn
			driver.findElement(By.xpath(s.getCell(1, 9).getContents())).click();
			// number
			driver.findElement(By.xpath(s.getCell(1, 10).getContents())).sendKeys(s.getCell(1, 26).getContents());
			Thread.sleep(2000);
			// issued date
			WebElement pissueddate = driver.findElement(By.xpath(s.getCell(1, 11).getContents()));
			pissueddate.click();
			Thread.sleep(2000);
			pissueddate.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			Thread.sleep(2000);
			pissueddate.sendKeys(s.getCell(1, 27).getContents());
			Thread.sleep(2000);

			// expiry date
			WebElement pexpirydate = driver.findElement(By.xpath(s.getCell(1, 12).getContents()));
			pexpirydate.click();
			Thread.sleep(2000);
			pexpirydate.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			Thread.sleep(2000);
			pexpirydate.sendKeys(s.getCell(1, 28).getContents());
			Thread.sleep(2000);
			// issued by
			driver.findElement(By.xpath(s.getCell(1, 13).getContents())).click();
			Thread.sleep(2000);
			List<WebElement> pissuedby = driver.findElements(By.xpath(s.getCell(1, 14).getContents()));
			Thread.sleep(2000);
			for (int i = 0; i <= pissuedby.size() - 1; i++) {

				if (pissuedby.get(i).getText().contains(s.getCell(1, 29).getContents())) {

					pissuedby.get(i).click();
					Thread.sleep(2000);
					break;
				}
			}
			// save
			driver.findElement(By.xpath(s.getCell(1, 15).getContents())).click();
			Thread.sleep(5000);

			// add
			driver.findElement(By.xpath(s.getCell(1, 16).getContents())).click();
			Thread.sleep(2000);
			// visa radiobtn
			driver.findElement(By.xpath(s.getCell(1, 17).getContents())).click();
			// number
			driver.findElement(By.xpath(s.getCell(1, 18).getContents())).sendKeys(s.getCell(1, 30).getContents());
			Thread.sleep(2000);
			// issued date
			WebElement vissueddate = driver.findElement(By.xpath(s.getCell(1, 19).getContents()));
			vissueddate.click();
			Thread.sleep(2000);
			vissueddate.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			Thread.sleep(2000);
			vissueddate.sendKeys(s.getCell(1, 31).getContents());
			Thread.sleep(2000);

			// expiry date
			WebElement vexpirydate = driver.findElement(By.xpath(s.getCell(1, 20).getContents()));
			vexpirydate.click();
			Thread.sleep(2000);
			vexpirydate.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			Thread.sleep(2000);
			vexpirydate.sendKeys(s.getCell(1, 32).getContents());
			Thread.sleep(2000);
			// issued by
			driver.findElement(By.xpath(s.getCell(1, 21).getContents())).click();
			Thread.sleep(2000);
			List<WebElement> vissuedby = driver.findElements(By.xpath(s.getCell(1, 22).getContents()));
			Thread.sleep(2000);
			for (int i = 0; i <= vissuedby.size() - 1; i++) {

				if (vissuedby.get(i).getText().contains(s.getCell(1, 33).getContents())) {

					vissuedby.get(i).click();
					Thread.sleep(2000);
					break;
				}
			}
			// save
			driver.findElement(By.xpath(s.getCell(1, 23).getContents())).click();
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println("Try with other locator");
		} finally {
			if (driver.getPageSource().contains("Successfully Saved")) {
				System.out.println(" Details are saved");
			} else {
				System.out.println(" Details are not saved");
			}

			driver.close();
		}

	}

}
