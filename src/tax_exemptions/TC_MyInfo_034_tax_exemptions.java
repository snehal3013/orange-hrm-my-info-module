package tax_exemptions;

import java.io.FileInputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Sheet;
import jxl.Workbook;

public class TC_MyInfo_034_tax_exemptions {

	public static void main(String[] args) {
		WebDriver driver = WebDriverManager.chromedriver().create();
		try {
			FileInputStream f = new FileInputStream("D:\\ExcelR Project\\Tax_Exemptions.xls");

			Workbook wb = Workbook.getWorkbook(f);

			Sheet s = wb.getSheet("TC_MyInfo_034");

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
			// tax exemptions
			driver.findElement(By.linkText(s.getCell(1, 7).getContents())).click();
			Thread.sleep(2000);
			// Status
			boolean status = driver.findElement(By.xpath(s.getCell(1, 8).getContents())).isEnabled();
			Thread.sleep(2000);
			if (status == false) {
				System.out.println("Status field is disabled");
			} else {
				System.out.println("Status field is enabled");
			}
			// exemptions
			boolean exemptions = driver.findElement(By.xpath(s.getCell(1, 9).getContents())).isEnabled();
			Thread.sleep(2000);
			if (exemptions == false) {
				System.out.println("Exemptions field is disabled");
			} else {
				System.out.println("Exemptions field is enabled");
			}
			// state
			boolean state = driver.findElement(By.xpath(s.getCell(1, 10).getContents())).isEnabled();
			Thread.sleep(2000);
			if (state == false) {
				System.out.println("State field is disabled");
			} else {
				System.out.println("State field is enabled");
			}
			// State IT
			boolean statestatus = driver.findElement(By.xpath(s.getCell(1, 11).getContents())).isEnabled();
			Thread.sleep(2000);
			if (statestatus == false) {
				System.out.println("State IT status field is disabled");
			} else {
				System.out.println("State IT status  field is enabled");
			}
			// State Exemptions
			boolean stateexemptions = driver.findElement(By.xpath(s.getCell(1, 12).getContents())).isEnabled();
			Thread.sleep(2000);
			if (stateexemptions == false) {
				System.out.println("State Exemptions field is disabled");
			} else {
				System.out.println("State Exemptions field is enabled");
			}
			// Unemployment
			boolean unemploystatus = driver.findElement(By.xpath(s.getCell(1, 13).getContents())).isEnabled();
			Thread.sleep(2000);
			if (unemploystatus == false) {
				System.out.println("Unemployment status field is disabled");
			} else {
				System.out.println("Unemployment status field is enabled");
			}
			// Work State
			boolean workstate = driver.findElement(By.xpath(s.getCell(1, 14).getContents())).isEnabled();
			Thread.sleep(2000);
			if (workstate == false) {
				System.out.println("Work State field is disabled");
			} else {
				System.out.println("Work State field is enabled");
			}
		} catch (Exception e) {
			System.out.println("Try with other locator");
		} finally {
			driver.close();
		}
	}

}
