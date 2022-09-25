package d_20_09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BuyBoxPage {
	
//	BuyBoxPage koja pribavlja:
//		input za kolicinu
//		select za velicinu
//		add to cart dugme
//		add to wishlist dugme
//		metodu koja vraca element boje. 
//		Metoda kao parametar prima naziv boje 
//		(npr: “Orange”, “Blue”) a vraca link koji ima atribut title
//		prema trazenoj vrednosti.
//		metodu koja skrola do ovog dela stranice

	private WebDriver driver;
	public BuyBoxPage(WebDriver driver) {
		this.driver=driver;
	
	
}
	public WebElement getQuantityInput() {
		return driver.findElement(By.id("quantity_wanted"));
	}

	public WebElement getSizeSelect() {
		return driver.findElement(By.id("group_1"));
		}

	public WebElement getAddToCartButton() {
		return driver.findElement(By.name("Submit"));
		}
	
	public WebElement getAdToWishListButton() {
		return driver.findElement(By.id("wishlist_button"));
		}
	

	public WebElement getElementColorButton(String color) {
		if (color.equals("Orange")) {return driver.findElement(By.xpath("//a[contains(@title,'Orange')]"));}
		else {return driver.findElement(By.xpath("//a[contains(@title,'Blue')]"));}
		}
	
	public void scrollToColorButton() {
		WebElement colorButton = driver.findElement(By.xpath("//a[contains(@title,'Blue')]"));
		Actions actions = new Actions(driver);
		actions.scrollToElement(colorButton);
		actions.perform();


	}
}
