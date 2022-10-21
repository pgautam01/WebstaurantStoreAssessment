package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.Constants;

public class CartPage {
	
	@FindBy(css = "button.emptyCartButton")
	WebElement emptyCartButton;
	
	public CartPage() {
		PageFactory.initElements(Constants.driver, this);
	}
	
	public void clickEmptyCart() {
		emptyCartButton.click();
	}
	
	public void clickVerificationButtonForEmptyCart() {
		Constants.driver.findElement(By.cssSelector("footer.border-gray-300 button.text-white")).click();
	}
}
