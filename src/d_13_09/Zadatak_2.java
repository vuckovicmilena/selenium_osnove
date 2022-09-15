package d_13_09;



import java.util.ArrayList;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak_2 {

	public static void main(String[] args) throws InterruptedException {
//		Zadatak 
//		Maksimizirati prozor
//		Ucitati stranicu https://s.bootsnipp.com/iframe/WaXlr
//		Dohvatite dugmice za rejting kao listu. XPath za trazenje treba da bude preko id atributa i za ovo trebace vam 
//		contains u xpath-u
//		Od korisnika ucitati broj (preko scannera) na koju zvezdicu je potrebno kliknuti (u rasponu od 1 do 5)
//		I izvrsite akciju klik na odgovarajuci element preko indeksa
//		Na kraju programa ugasite pretrazivac.

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://s.bootsnipp.com/iframe/WaXlr");
		Thread.sleep(2000);
		ArrayList<WebElement> rejtingDugmad = (ArrayList<WebElement>) driver
				.findElements(By.xpath("//*[contains(@id, 'rating-star')]"));

		Scanner s = new Scanner(System.in);
		System.out.print("Unesite broj od 1 do 5 za klik na zvezdicu: ");
		int broj = s.nextInt();

		rejtingDugmad.get(broj - 1).click();

		Thread.sleep(5000);
		driver.quit();
		
	}

}
