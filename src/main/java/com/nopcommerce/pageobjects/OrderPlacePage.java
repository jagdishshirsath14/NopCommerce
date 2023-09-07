package com.nopcommerce.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nopcommerce.baseclass.BaseClass;

public class OrderPlacePage extends BaseClass {
	
	Logger log = (Logger) LogManager.getLogger("OrderPlacePage.class");
	
//	Page Factory
	
	@FindBy(xpath = "(//div[@class='section order-completed']//strong)[1]")
	WebElement orderMsg;
	
	@FindBy(xpath = "//div[@class='buttons']//button")
	WebElement continueBtn;
	
	public OrderPlacePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getOrderSuccessMessage() {
		String orderPlaceMsg = orderMsg.getText();
		return orderPlaceMsg;
	}
	
	public HomePage clickOnContinue() {
		continueBtn.click();
		log.info("Click on Continue");
		return new HomePage();
	}
	
}
