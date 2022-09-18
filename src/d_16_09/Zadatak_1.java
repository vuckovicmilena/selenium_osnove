package d_16_09;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Zadatak_1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// Zadatak
		// Napisati program koji ima:
		// Podesava:
		// implicitno cekanje za trazenje elemenata od 10s
		// implicitno cekanje za ucitavanje stranice od 10s
		// eksplicitno cekanje podeseno na 10s
		// Podaci:
		// Potrebno je u projektu ukljuciti 4 slike.
		// Imenovanje slika neka bude po pravilu
		// pozicija_ime_prezime_polaznika.ekstenzija
		// Npr: front_milan_jovanovic.jpg, left_milan_jovanovic.jpg …
		// Koraci:
		// Ucitava stranicu https://boomf.com/apps/proxy/boomf-bomb/i-bloody-love-you
		// Maksimizuje prozor
		// Selektuje Image - Front klikom na tu karticu u dnu ekrana
		// Klik na add photo iz levog navigacionog menia
		// Upload slike. Upload preko File objekta koristeci getAbsolutePath
		// Sacekati da broj prikazanih slika u donjem uglu navigacije bude za 1 veca
		// Kliknuti na poslednje dodatu sliku kako bi bila izabrana za postavljenje
		// Ceka da dijalog bude vidljiv
		// Klik na Use One Side Only dugme
		// Ponoviti proces za Left, Right i Back
		// Zatim iz desnog gornjeg ugla izabrati random jedan od ponudjenih konfeta
		// Kliknuti na Add To Cart dugme
		// Verifikovati postojanje greske Oops! It looks like you`ve not added an text
		// to this field, please add one before continuing.
		// Xpath: //*[@action='error']
		// Zatvorite pretrazivac

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		String url = "https://boomf.com/apps/proxy/boomf-bomb/i-bloody-love-you";

		driver.navigate().to(url);
		driver.manage().window().maximize();

		Thread.sleep(1000);

		File slika0 = new File("img/back_side.jpg");
		File slika1 = new File("img/front_side.jpg");
		File slika2 = new File("img/left_side.jpg");
		File slika3 = new File("img/right_side.jpg");

		ArrayList<File> nizSlika = new ArrayList<>();
		nizSlika.add(slika0);
		nizSlika.add(slika1);
		nizSlika.add(slika2);
		nizSlika.add(slika3);

		// List<WebElement> izaberiPoziciju = driver.findElements(
		// By.xpath("//img[contains(@alt, 'image')]"));

		// List<WebElement> izaberiUploadovanuSliku = driver.findElements(
		// By.xpath("//div[contains (@class,'sc-breuTD gmXCBU')]"));

		// System.out.println(izaberiUploadovanuSliku.size());

		for (int i = 0; i < nizSlika.size(); i++) {

			// izaberiPoziciju.get(i).click();

			driver.findElement(By.xpath("//*[@alt='image " + (i + 1) + "']")).click();

			Thread.sleep(1000);

			driver.findElement(By.xpath("//div[contains(text(), '+ Add photo')]")).click();

			Thread.sleep(1000);

			driver.findElement(By.xpath("//input[@type='file']")).sendKeys((nizSlika.get(i).getAbsolutePath()));

			wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//div[contains(@class, 'sc-ftvSup kAzmBp')]"),
					1));

			driver.findElement(By.xpath("//*[contains(@class, 'sc-ftvSup kAzmBp')]/div[last()]/div/img")).click();

			// izaberiUploadovanuSliku.get(i).click();

			driver.findElement(By.xpath("//button[contains (text(), 'Use One Side Only')]")).click();

			Thread.sleep(1000);
		}

		List<WebElement> konfete = driver.findElements(By.xpath("//div[contains (@class,'sc-gHLcSH fajlzv')]/div"));

		System.out.println(konfete.size());

		Random r = new Random();

		int x = r.nextInt(konfete.size());

		konfete.get(x).click();

		driver.findElement(By.xpath("//*[@type='submit']")).click();

		// System.out.println("Pop up atribut: " + driver.findElement(
		// By.xpath("//*[@action='error']")).getAttribute("action"));

		if (elementExists(driver, By.xpath("//*[@action='error']"))) {
			System.out.println("Error exists, ok");
		} else {
			System.out.println("Error doesn't exist, not ok");
		}

		driver.quit();

	}

	public static boolean elementExists(WebDriver driver, By by) {
		boolean elementExists = true;

		try {
			driver.findElement(by);
			elementExists = true;
		} catch (Exception e) {
			elementExists = false;
		}
		return elementExists;

	}

}
