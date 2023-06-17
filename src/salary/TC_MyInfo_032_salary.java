package salary;

import java.io.FileInputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Sheet;
import jxl.Workbook;

public class TC_MyInfo_032_salary {

	public static void main(String[] args) {
		WebDriver driver = WebDriverManager.chromedriver().create();
		try {
			FileInputStream f = new FileInputStream("D:\\ExcelR Project\\Salary.xls");

			Workbook wb = Workbook.getWorkbook(f);

			Sheet s = wb.getSheet("TC_MyInfo_032");

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
			js.executeScript("window.scrollBy(0,300)", "");
			Thread.sleep(2000);
			// salary
			driver.findElement(By.linkText(s.getCell(1, 7).getContents())).click();
			Thread.sleep(2000);
			// Salary Component
			boolean salcomponent = driver.findElement(By.xpath(s.getCell(1, 8).getContents())).isEnabled();
			Thread.sleep(2000);
			if (salcomponent == false) {
				System.out.println("Salary Component field is disabled");
			} else {
				System.out.println("Salary Component field is enabled");
			}
			// Amount
			boolean amount = driver.findElement(By.xpath(s.getCell(1, 9).getContents())).isEnabled();
			Thread.sleep(2000);
			if (amount == false) {
				System.out.println("Amount field is disabled");
			} else {
				System.out.println("Amount field is enabled");
			}
			// currency
			boolean currency = driver.findElement(By.xpath(s.getCell(1, 10).getContents())).isEnabled();
			Thread.sleep(2000);
			if (currency == false) {
				System.out.println("Currency field is disabled");
			} else {
				System.out.println("Currency field is enabled");
			}
			// Payfrequency
			boolean payfrequency = driver.findElement(By.xpath(s.getCell(1, 11).getContents())).isEnabled();
			Thread.sleep(2000);
			if (payfrequency == false) {
				System.out.println("Payfrequency field is disabled");
			} else {
				System.out.println("Payfrequency field is enabled");
			}
			// Direct Deposit Amount
			boolean dirdepoamount = driver.findElement(By.xpath(s.getCell(1, 12).getContents())).isEnabled();
			Thread.sleep(2000);
			if (dirdepoamount == false) {
				System.out.println("Direct Deposit Amount field is disabled");
			} else {
				System.out.println("Direct Deposit Amount field is enabled");
			}
		} catch (Exception e) {
			System.out.println("Try with other locator");
		} finally {
			driver.close();
		}
	}

}
