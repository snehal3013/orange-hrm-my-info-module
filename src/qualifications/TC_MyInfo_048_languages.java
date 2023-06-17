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

public class TC_MyInfo_048_languages {

	public static void main(String[] args) {
		WebDriver driver = WebDriverManager.chromedriver().create();
		try {
			FileInputStream f = new FileInputStream("D:\\ExcelR Project\\Qualifications.xls");

			Workbook wb = Workbook.getWorkbook(f);

			Sheet s = wb.getSheet("TC_MyInfo_048");

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
			// qualifications
			driver.findElement(By.linkText(s.getCell(1, 7).getContents())).click();
			Thread.sleep(2000);
			js.executeScript("window.scrollBy(0,500)", "");
			Thread.sleep(2000);
			// add
			driver.findElement(By.xpath(s.getCell(1, 8).getContents())).click();
			Thread.sleep(2000);
			// language
			driver.findElement(By.xpath(s.getCell(1, 9).getContents())).click();
			Thread.sleep(2000);
			List<WebElement> language = driver.findElements(By.xpath(s.getCell(1, 10).getContents()));
			Thread.sleep(2000);
			for (int i = 0; i <= language.size() - 1; i++) {

				if (language.get(i).getText().contains(s.getCell(1, 26).getContents())) {

					language.get(i).click();
					Thread.sleep(2000);
					break;
				}
			}
			// fluency
			driver.findElement(By.xpath(s.getCell(1, 11).getContents())).click();
			Thread.sleep(2000);
			List<WebElement> fluency = driver.findElements(By.xpath(s.getCell(1, 12).getContents()));
			Thread.sleep(2000);
			for (int i = 0; i <= fluency.size() - 1; i++) {

				if (fluency.get(i).getText().contains(s.getCell(1, 27).getContents())) {

					fluency.get(i).click();
					Thread.sleep(2000);
					break;
				}
			}
			// competency
			driver.findElement(By.xpath(s.getCell(1, 13).getContents())).click();
			Thread.sleep(2000);
			List<WebElement> competency = driver.findElements(By.xpath(s.getCell(1, 14).getContents()));
			Thread.sleep(2000);
			for (int i = 0; i <= competency.size() - 1; i++) {

				if (competency.get(i).getText().contains(s.getCell(1, 28).getContents())) {

					competency.get(i).click();
					Thread.sleep(2000);
					break;
				}
			}
			// save
			driver.findElement(By.xpath(s.getCell(1, 15).getContents())).click();
			Thread.sleep(2000);

			Thread.sleep(4000);
			// add
			driver.findElement(By.xpath(s.getCell(1, 16).getContents())).click();
			Thread.sleep(2000);
			// language
			driver.findElement(By.xpath(s.getCell(1, 17).getContents())).click();
			Thread.sleep(2000);
			List<WebElement> language1 = driver.findElements(By.xpath(s.getCell(1, 18).getContents()));
			Thread.sleep(2000);
			for (int i = 0; i <= language1.size() - 1; i++) {

				if (language1.get(i).getText().contains(s.getCell(1, 29).getContents())) {

					language1.get(i).click();
					Thread.sleep(2000);
					break;
				}
			}
			// fluency
			driver.findElement(By.xpath(s.getCell(1, 19).getContents())).click();
			Thread.sleep(2000);
			List<WebElement> fluency1 = driver.findElements(By.xpath(s.getCell(1, 20).getContents()));
			Thread.sleep(2000);
			for (int i = 0; i <= fluency1.size() - 1; i++) {

				if (fluency1.get(i).getText().contains(s.getCell(1, 30).getContents())) {

					fluency1.get(i).click();
					Thread.sleep(2000);
					break;
				}
			}
			// competency
			driver.findElement(By.xpath(s.getCell(1, 21).getContents())).click();
			Thread.sleep(2000);
			List<WebElement> competency1 = driver.findElements(By.xpath(s.getCell(1, 22).getContents()));
			Thread.sleep(2000);
			for (int i = 0; i <= competency1.size() - 1; i++) {

				if (competency1.get(i).getText().contains(s.getCell(1, 31).getContents())) {

					competency1.get(i).click();
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
				System.out.println("Details are Saved");
			} else {
				System.out.println("Details are not Saved");
			}
			driver.close();
		}

	}

}
