package steps;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.CartPage;
import pages.MainPage;
import pages.SearchPage;
import util.Constants;

public class StepDefinitions extends Constants {
	@Given("Set up the chrome driver and navigate to the application url")
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	@When("Search for {string}")
	public void search(String searchStr) {
		mainPage = new MainPage();
		mainPage.enterSearchString(searchStr);
		mainPage.clickSearchButton();
	}
	
	@When("Make sure each product title has {string} in it")
	public void check(String title) {
		searchPage = new SearchPage();
		List<WebElement> titles = searchPage.getTitles();
				
		for (WebElement titleElement : titles) {
			Assert.assertTrue(titleElement.getText().contains(title)); // make sure titles contains 'Table'
		}
	}
	
	@When("Add the last of found elements to Cart")
	public void addLastItemToCart() {
		List<WebElement> results = searchPage.getResults();
		int length = results.size();
		WebElement last = results.get(length - 1); // get the last element
		
		String xpath = ".//input[@name='addToCartButton']";
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // explicit wait
		wait.until(ExpectedConditions.visibilityOf(last.findElement(By.xpath(xpath))));
		WebElement addButton = last.findElement(By.xpath(xpath)); // get the add to cart button from the current element
		addButton.click();
	}
	
	@When("Navigate to the Cart page")
	public void navigateToCart() {
		searchPage.clickViewCart();
	}
	
	@When("Empty cart")
	public void emptyCart() {
		cartPage = new CartPage();
		cartPage.clickEmptyCart();
		cartPage.clickVerificationButtonForEmptyCart();
	}
	
	@Then("tear down the driver session")
	public void tearDown() throws InterruptedException {
//		Thread.sleep(5000);
		driver.quit();
	}
}
