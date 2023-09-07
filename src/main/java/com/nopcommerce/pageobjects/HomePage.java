package com.nopcommerce.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nopcommerce.baseclass.BaseClass;

public class HomePage extends BaseClass {

	Logger log = (Logger) LogManager.getLogger("HomePage.class");
	
//	Page Factory

	@FindBy(xpath = "//input[@name='q']")
	WebElement productSearchBox;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement searchBtn;
	
	@FindBy(xpath = "//img[@alt='nopCommerce demo store']")
	WebElement logo;
	
	@FindBy(xpath = "//a[@class='ico-register']")
	WebElement registerTab;
	
	@FindBy(xpath = "//a[@class='ico-login']")
	WebElement LogInTab;
	
	@FindBy(xpath = "//a[@class='ico-logout']")
	WebElement LogOutTab;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void checkLogo() {
		if (logo.isDisplayed()) {
			System.out.println("Logo is present");
		}else {
			System.out.println("Logo is not present");
		}
	}
	
	public String getTitle() {
		String title = driver.getTitle();
		log.info("Get the page title");
		return title;
		
	}
	
	public void searchProduct(String productName) {
		productSearchBox.sendKeys(productName);
		log.info("Entered product name");
	}
	
	public SearchResultPage clickOnSearch() {
		searchBtn.click();	
		log.info("Click on the search");
		return new SearchResultPage();
		
	}
	
	public RegisterPage clickOnRegister() {
		registerTab.click();
		log.info("Click on Register Tab");
		return new RegisterPage();
	}
	
	public LoginPage clickOnLogin() {
		LogInTab.click();
		log.info("Click on LogIn Tab");
		return new LoginPage();
	}
	
}
