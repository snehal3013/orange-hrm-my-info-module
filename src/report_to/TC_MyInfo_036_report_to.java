package report_to;

import java.io.FileInputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Sheet;
import jxl.Workbook;

public class TC_MyInfo_036_report_to {

	public static void main(String[] args) {
		WebDriver driver = WebDriverManager.chromedriver().create();
		try {
			FileInputStream f = new FileInputStream("D:\\ExcelR Project\\Report-to.xls");

			Workbook wb = Workbook.getWorkbook(f);

			Sheet s = wb.getSheet("TC_MyInfo_036");

			driver.get(s.getCell(1, 0).getContents());
			Thread.sleep(2000);
			driver.manage().window().maximize();
			// login
			driver.findElement(By.xpath(s.getCell(1, 3).getContents())).sendKeys(s.getCell(1, 11).getContents());
			driver.findElement(By.xpath(s.getCell(1, 4).getContents())).sendKeys(s.getCell(1, 12).getContents());
			driver.findElement(By.xpath(s.getCell(1, 5).getContents())).click();
			Thread.sleep(2000);
			// my info
			driver.findElement(By.linkText(s.getCell(1, 6).getContents())).click();
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,300)", "");
			Thread.sleep(2000);
			// report-to
			driver.findElement(By.linkText(s.getCell(1, 7).getContents())).click();
			Thread.sleep(2000);
			// Name
			boolean name = driver.findElement(By.xpath(s.getCell(1, 8).getContents())).isEnabled();
			Thread.sleep(2000);
			if (name == false) {
				System.out.println("Name field is disabled");
			} else {
				System.out.println("Name field is enabled");
			}
			// Reporting Method
			boolean reportingmethod = driver.findElement(By.xpath(s.getCell(1, 9).getContents())).isEnabled();
			Thread.sleep(2000);
			if (reportingmethod == false) {
				System.out.println("Reporting Method field is disabled");
			} else {
				System.out.println("Reporting Method field is enabled");
			}
		} catch (Exception e) {
			System.out.println("Try with other locator");
		} finally {

			driver.close();
		}
	}

}
