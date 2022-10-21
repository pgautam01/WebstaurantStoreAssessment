package pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.Constants;

public class MainPage {
	@FindBy(id = "searchval")
	WebElement searchBox;
	
	@FindBy(xpath = "//button[@value='Search']")
	WebElement searchButton;
	
	
	public MainPage() {
		PageFactory.initElements(Constants.driver, this);
	}
	
	public void enterSearchString(String search) {
		searchBox.sendKeys(search);
	}
	
	public void clickSearchButton() {
		searchButton.click();
	}
	
	
}
