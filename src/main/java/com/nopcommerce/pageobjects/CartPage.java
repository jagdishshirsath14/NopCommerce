package com.nopcommerce.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nopcommerce.baseclass.BaseClass;

public class CartPage extends BaseClass{
	
	Logger log = (Logger) LogManager.getLogger("CartPage.class");
		
//	Page Factory
	
	@FindBy(xpath = "//span[@class='value-summary']//strong")
	WebElement totalPrice;
	
	@FindBy(id = "termsofservice")
	WebElement termsCheckbox;
	
	@FindBy(id = "checkout")
	WebElement checkoutBtn;
	
	public CartPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getTotalPrice() {
		String totlPrice = totalPrice.getText();
		return totlPrice;
	}
	
	public LoginPage clickOnCheckout() {
		termsCheckbox.click();
		log.info("Checked terms and condition");
		checkoutBtn.click();
		log.info("Click on Continue");
		return new LoginPage();
	}
	
	public CheckoutPage clickOnCheckout2() {
		termsCheckbox.click();
		log.info("Checked terms and condition");
		checkoutBtn.click();
		log.info("Click on Checkout");
		return new CheckoutPage();
	}

}
