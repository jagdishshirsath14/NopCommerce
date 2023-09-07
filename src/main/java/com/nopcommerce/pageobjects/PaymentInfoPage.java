package com.nopcommerce.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nopcommerce.baseclass.BaseClass;

public class PaymentInfoPage extends BaseClass{

	Logger log = (Logger) LogManager.getLogger("PaymentInfoPage.class");
	
//	Page Factory

	@FindBy(xpath = "//button[@onclick='PaymentInfo.save()']")
	WebElement continueBtn;

	public PaymentInfoPage() {
		PageFactory.initElements(driver, this);
	}
	
	public ConfirmOrderPage clickOnContinue() {
		continueBtn.click();
		log.info("Click on Continue");
		return new ConfirmOrderPage();
	}
}
