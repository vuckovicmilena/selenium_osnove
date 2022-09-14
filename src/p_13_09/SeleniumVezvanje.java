package p_13_09;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumVezvanje {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://cms.demo.katalon.com/");
		WebElement searchInput = driver.findElement(By.xpath("//input[@ name = 's']"));
		searchInput.sendKeys("Flying Ninja");
		searchInput.sendKeys(Keys.ENTER);
		driver.close();
		
		WebDriver driver1 = new ChromeDriver();
		driver1.get("https://cms.demo.katalon.com/");
		driver1.findElement(By.xpath("//button[contains(@class, 'search-submit']"))
				.click();
		Thread.sleep(5000);
		driver1.close();
		

	}

}
