package personal_details;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Sheet;
import jxl.Workbook;

public class TC_MyInfo_008_personal_details {

	public static void main(String[] args) {

		WebDriver driver = WebDriverManager.chromedriver().create();
		try {
			FileInputStream f = new FileInputStream("D:\\ExcelR Project\\Personal_Details.xls");

			Workbook wb = Workbook.getWorkbook(f);

			Sheet s = wb.getSheet("TC_MyInfo_008");

			driver.get(s.getCell(1, 0).getContents());
			Thread.sleep(2000);
			driver.manage().window().maximize();

			// login
			driver.findElement(By.xpath(s.getCell(1, 3).getContents())).sendKeys(s.getCell(1, 14).getContents());
			driver.findElement(By.xpath(s.getCell(1, 4).getContents())).sendKeys(s.getCell(1, 15).getContents());
			driver.findElement(By.xpath(s.getCell(1, 5).getContents())).click();
			Thread.sleep(2000);
			// my info
			driver.findElement(By.linkText(s.getCell(1, 6).getContents())).click();
			Thread.sleep(2000);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,900)", "");
			Thread.sleep(2000);

			// add
			driver.findElement(By.cssSelector(s.getCell(1, 7).getContents())).click();
			Thread.sleep(2000);
			// browse
			driver.findElement(By.xpath(s.getCell(1, 8).getContents())).click();
			Thread.sleep(7000);

			js.executeScript("window.scrollBy(0,1000)", "");
			Thread.sleep(2000);

			// save
			driver.findElement(By.xpath(s.getCell(1, 9).getContents())).click();
			Thread.sleep(4000);

		} catch (Exception e) {
			System.out.println("Try with other locator");
		} finally {
			if (driver.getPageSource().contains("Successfully Saved")) {
				System.out.println("File is uploaded");
			} else {
				System.out.println("File is not uploaded");
			}
			driver.close();

		}
	}

}
