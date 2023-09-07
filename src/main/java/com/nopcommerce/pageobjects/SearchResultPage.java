package com.nopcommerce.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nopcommerce.baseclass.BaseClass;

public class SearchResultPage extends BaseClass{
	
	Logger log = (Logger) LogManager.getLogger("SearchResultPage.class");
	
//	Page Factory
	
	@FindBy(xpath = "//div//h2//a")
	WebElement productTitle;
	
	public SearchResultPage() {
		PageFactory.initElements(driver, this);
	}
	
	public ProductDetailsPage clickOnProduct() {
		productTitle.click();
		log.info("Click on product");
		return new ProductDetailsPage();
	}

}
