package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.Constants;

public class SearchPage {
	@FindBy(xpath = "//div[@id='ProductBoxContainer']")
	List<WebElement> results;
	
	@FindBy(xpath = "//div[@id='ProductBoxContainer']//a[@data-testid='itemDescription']")
	List<WebElement> titles;
	
	public SearchPage() {
		PageFactory.initElements(Constants.driver, this);
	}
	
	public List<WebElement> getResults() {
		return results;
	}
	
	public List<WebElement> getTitles() {
		return titles;
	}
	
	public void clickViewCart() {
		WebDriverWait wait = new WebDriverWait(Constants.driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("View Cart")));
		Constants.driver.findElement(By.linkText("View Cart")).click();
	}
}
