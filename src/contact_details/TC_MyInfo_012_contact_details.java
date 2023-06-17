package contact_details;

import java.io.FileInputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Sheet;
import jxl.Workbook;

public class TC_MyInfo_012_contact_details {

	public static void main(String[] args) {
		WebDriver driver = WebDriverManager.chromedriver().create();
		try {
			FileInputStream f = new FileInputStream("D:\\ExcelR Project\\Contact_Details.xls");

			Workbook wb = Workbook.getWorkbook(f);

			Sheet s = wb.getSheet("TC_MyInfo_012");
			driver.get(s.getCell(1, 0).getContents());
			Thread.sleep(3000);
			driver.manage().window().maximize();

			// login
			driver.findElement(By.xpath(s.getCell(1, 3).getContents())).sendKeys(s.getCell(1, 19).getContents());
			driver.findElement(By.xpath(s.getCell(1, 4).getContents())).sendKeys(s.getCell(1, 20).getContents());
			driver.findElement(By.xpath(s.getCell(1, 5).getContents())).click();
			Thread.sleep(2000);

			// my info
			driver.findElement(By.linkText(s.getCell(1, 6).getContents())).click();
			Thread.sleep(2000);
			// contact details
			driver.findElement(By.linkText(s.getCell(1, 7).getContents())).click();
			Thread.sleep(2000);

			// street1
			driver.findElement(By.xpath(s.getCell(1, 8).getContents())).sendKeys(s.getCell(1, 21).getContents());
			Thread.sleep(2000);
			// street2
			driver.findElement(By.xpath(s.getCell(1, 9).getContents())).sendKeys(s.getCell(1, 22).getContents());
			Thread.sleep(2000);
			// city
			driver.findElement(By.xpath(s.getCell(1, 10).getContents())).sendKeys(s.getCell(1, 23).getContents());
			Thread.sleep(2000);
			// state
			driver.findElement(By.xpath(s.getCell(1, 11).getContents())).sendKeys(s.getCell(1, 24).getContents());
			Thread.sleep(2000);
			// zipcode
			driver.findElement(By.xpath(s.getCell(1, 12).getContents())).sendKeys(s.getCell(1, 25).getContents());
			Thread.sleep(2000);
			// country
			driver.findElement(By.xpath(s.getCell(1, 13).getContents())).click();
			Thread.sleep(2000);
			List<WebElement> cnames = driver.findElements(By.xpath(s.getCell(1, 14).getContents()));
			Thread.sleep(2000);
			for (int i = 0; i <= cnames.size() - 1; i++) {

				if (cnames.get(i).getText().contains(s.getCell(1, 26).getContents())) {

					cnames.get(i).click();
					Thread.sleep(2000);
					break;
				}
			}
			// mobile
			driver.findElement(By.xpath(s.getCell(1, 15).getContents())).sendKeys(s.getCell(1, 27).getContents());
			Thread.sleep(2000);
			// email
			driver.findElement(By.xpath(s.getCell(1, 16).getContents())).sendKeys(s.getCell(1, 28).getContents());
			Thread.sleep(2000);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,350)", "");
			Thread.sleep(2000);
			// save
			driver.findElement(By.xpath(s.getCell(1, 17).getContents())).click();
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println("Try with other locator");
		} finally {
			driver.close();
		}

	}

}
