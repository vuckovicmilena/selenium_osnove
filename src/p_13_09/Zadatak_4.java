package p_13_09;

import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		4.Zadatak
//		Napisti proram koji :
//		Ucitava stranicu https://s.bootsnipp.com/iframe/oV91g
//		Hvatamo sve page-eve iz paginacije tabele
//		Zatim petljom prolazimo kroz paginaciju tako sto kliknemo na svaki broj
//		Izmedju iteracija napravite pauzu od 1s
//		Zatvorite pretrazivac

		
		
		
		
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://s.bootsnipp.com/iframe/oV91g");
		java.util.List<WebElement> list= driver.findElements(By.xpath("//div[contains(@class,'col-md-12 text-center')]")
		for(i=0; i<list.size(); i++) {
			list.get(i).get);
		}
		
		
			}

}
