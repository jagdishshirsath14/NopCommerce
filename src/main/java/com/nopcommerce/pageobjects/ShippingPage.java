package com.nopcommerce.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nopcommerce.baseclass.BaseClass;

public class ShippingPage extends BaseClass{
		
	Logger log = (Logger) LogManager.getLogger("CheckoutPage.class");
	
//	Page Factory
	
	@FindBy(xpath = "//button[@onclick='ShippingMethod.save()']")
	WebElement continueBtn;
	
	public ShippingPage() {
		PageFactory.initElements(driver, this);
	}
	
	public PaymentPage clickOnContinue() {
		continueBtn.click();
		log.info("Click on Continue");
		return new PaymentPage();
	}

}
