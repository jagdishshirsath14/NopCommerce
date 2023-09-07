package com.nopcommerce.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nopcommerce.baseclass.BaseClass;

public class PaymentPage extends BaseClass{
		
	Logger log = (Logger) LogManager.getLogger("PaymentPage.class");
	
//	Page Factory
	
	@FindBy(id = "paymentmethod_0")
	WebElement moneyOrderCheckbox;
	
	@FindBy(xpath = "//button[@onclick='PaymentMethod.save()']")
	WebElement continueBtn;
	
	public PaymentPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void selectPaymentMethod() {
		moneyOrderCheckbox.click();
		log.info("Checked money order checkbox");
	}
	
	public PaymentInfoPage clickOnContinue() {
		continueBtn.click();
		log.info("Click on Continue");
		return new PaymentInfoPage();
	}

}
