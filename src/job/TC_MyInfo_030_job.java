package job;

import java.io.FileInputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Sheet;
import jxl.Workbook;

public class TC_MyInfo_030_job {

	public static void main(String[] args) {
		WebDriver driver = WebDriverManager.chromedriver().create();
		try {
			FileInputStream f = new FileInputStream("D:\\ExcelR Project\\Job.xls");

			Workbook wb = Workbook.getWorkbook(f);

			Sheet s = wb.getSheet("TC_MyInfo_030");

			driver.get(s.getCell(1, 0).getContents());
			Thread.sleep(2000);
			driver.manage().window().maximize();
			// login
			driver.findElement(By.xpath(s.getCell(1, 3).getContents())).sendKeys(s.getCell(1, 15).getContents());
			driver.findElement(By.xpath(s.getCell(1, 4).getContents())).sendKeys(s.getCell(1, 16).getContents());
			driver.findElement(By.xpath(s.getCell(1, 5).getContents())).click();
			Thread.sleep(2000);
			// my info
			driver.findElement(By.linkText(s.getCell(1, 6).getContents())).click();
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,300)", "");
			Thread.sleep(2000);
			// job
			driver.findElement(By.linkText(s.getCell(1, 7).getContents())).click();
			Thread.sleep(2000);
			// joined Date
			boolean joinedDate = driver.findElement(By.xpath(s.getCell(1, 8).getContents())).isEnabled();
			Thread.sleep(2000);
			if (joinedDate == false) {
				System.out.println("Joined Date field is disabled");
			} else {
				System.out.println("Joined Date field is enabled");
			}
			// job title
			boolean jobtitle = driver.findElement(By.xpath(s.getCell(1, 9).getContents())).isEnabled();
			Thread.sleep(2000);
			if (jobtitle == false) {
				System.out.println("Job title field is disabled");
			} else {
				System.out.println("Job title field is enabled");
			}
			// job category
			boolean jobcategory = driver.findElement(By.xpath(s.getCell(1, 10).getContents())).isEnabled();
			Thread.sleep(2000);
			if (jobcategory == false) {
				System.out.println("Job Category field is disabled");
			} else {
				System.out.println("Job Category field is enabled");
			}
			// Sub unit
			boolean subunit = driver.findElement(By.xpath(s.getCell(1, 11).getContents())).isEnabled();
			Thread.sleep(2000);
			if (subunit == false) {
				System.out.println("Sub unit field is disabled");
			} else {
				System.out.println("Sub unit field is enabled");
			}
			// location
			boolean location = driver.findElement(By.xpath(s.getCell(1, 12).getContents())).isEnabled();
			Thread.sleep(2000);
			if (location == false) {
				System.out.println("Location field is disabled");
			} else {
				System.out.println("Location field is enabled");
			}
			// Employment status
			boolean empstatus = driver.findElement(By.xpath(s.getCell(1, 13).getContents())).isEnabled();
			Thread.sleep(2000);
			if (empstatus == false) {
				System.out.println("Employment status field is disabled");
			} else {
				System.out.println("Employment status field is enabled");
			}
		} catch (Exception e) {
			System.out.println("Try with other locator");
		} finally {
			driver.close();
		}
	}

}
