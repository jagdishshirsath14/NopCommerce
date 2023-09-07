package com.nopcommerce.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nopcommerce.baseclass.BaseClass;

public class ConfirmOrderPage extends BaseClass{
	
	Logger log = (Logger) LogManager.getLogger("ConfirmOrderPage.class");
	
//	Page Factory
	
	@FindBy(xpath = "//div[@class='billing-info']//ul")
	WebElement billingAddress;
	
	@FindBy(xpath = "//div[@class='shipping-info']//ul")
	WebElement shippingAddress;
	
	@FindBy(xpath = "//button[.='Confirm']")
	WebElement confirmBtn;
	
	public ConfirmOrderPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getBillingAddress() {
		String billingAdd = billingAddress.getText();
		return billingAdd;
	}
	
	public String getShippingAddress() {
		String shippingAdd = shippingAddress.getText();
		return shippingAdd;
	}
	
	public OrderPlacePage clickOnConfirm() {
		confirmBtn.click();
		log.info("Click on Confirm");
		return new OrderPlacePage();
	}

}
