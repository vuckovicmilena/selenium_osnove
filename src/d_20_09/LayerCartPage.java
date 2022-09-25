package d_20_09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LayerCartPage {
//	LayerCartPage koja pribavlja:
//		continue shopping dugme
//		proced to checkout dugme
//		element koji vraca atrubute
//		 proizvoda (sa slike je to desno od devojke)
//		element koji cuva quantity
//		(takodje desno od devojke)
//		element koji cuva total price
//		metodu koja ceka da dijalog bude vidljiv
//		metodu koja ceka da dijalog bude nevidljiv

	private WebDriver driver;
	private WebDriverWait wait;

	public LayerCartPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
		
	

	public WebElement getProcedToCheckoutButton() {
		return driver.findElement(By.xpath("//span[contains(@title,'Continue shopping')]"));
	}

	public WebElement getContinueShoppingButton() {
		return driver.findElement(By.xpath("//a[contains(@title,'Proceed to checkout')]"));}
	
		
	public WebElement getProductAttribute() {
		return driver.findElement(By.id("layer_cart_product_attributes"));
	}

	public WebElement getQuantityNumber() {
		return driver.findElement(By.id("layer_cart_product_quantity"));
	}


	public WebElement getTotalPrice() {
		return driver.findElement(By.id("layer_cart_product_price"));
	}

	public void waitForElementVisibility() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("layer_cart")));
	}

	public void waitForElementInvisibility() {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("layer_cart")));
	}

	
}
	
	
	
	

