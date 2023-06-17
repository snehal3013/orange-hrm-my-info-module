package qualifications;

import java.io.FileInputStream;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Sheet;
import jxl.Workbook;

public class TC_MyInfo_044_skills {

	public static void main(String[] args) {
		WebDriver driver = WebDriverManager.chromedriver().create();
		try {
			FileInputStream f = new FileInputStream("D:\\ExcelR Project\\Qualifications.xls");

			Workbook wb = Workbook.getWorkbook(f);

			Sheet s = wb.getSheet("TC_MyInfo_044");

			driver.get(s.getCell(1, 0).getContents());
			Thread.sleep(2000);
			driver.manage().window().maximize();
			// login
			driver.findElement(By.xpath(s.getCell(1, 3).getContents())).sendKeys(s.getCell(1, 13).getContents());
			driver.findElement(By.xpath(s.getCell(1, 4).getContents())).sendKeys(s.getCell(1, 14).getContents());
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
			js.executeScript("window.scrollBy(0,400)", "");
			Thread.sleep(2000);
			// add
			driver.findElement(By.xpath(s.getCell(1, 8).getContents())).click();
			Thread.sleep(2000);
			// skill
			driver.findElement(By.xpath(s.getCell(1, 9).getContents())).click();
			Thread.sleep(2000);
			List<WebElement> skill = driver.findElements(By.xpath(s.getCell(1, 10).getContents()));
			Thread.sleep(2000);
			for (int i = 0; i <= skill.size() - 1; i++) {

				if (skill.get(i).getText().contains(s.getCell(1, 15).getContents())) {

					skill.get(i).click();
					Thread.sleep(2000);
					break;
				}
			}
			// year
			driver.findElement(By.xpath(s.getCell(1, 11).getContents())).sendKeys(s.getCell(1, 16).getContents());
			Thread.sleep(2000);
			// save
			driver.findElement(By.xpath(s.getCell(1, 12).getContents())).click();
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
