package com.nopcommerce.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nopcommerce.baseclass.BaseClass;

public class ProductDetailsPage extends BaseClass{
		
	Logger log = (Logger) LogManager.getLogger("ProductDetailsPage.class");
	
//	Page Factory 
	
	@FindBy(xpath = "//div//h1")
	WebElement productTitle;
	
	@FindBy(xpath = "//a[.='Add your review']")
	WebElement addReviewLink;
	
	@FindBy(xpath = "//span[contains(@id,'price-value')]")
	WebElement productPrice;
	
	@FindBy(xpath = "//div[@class='add-to-cart-panel']//button")
	WebElement addToCart;
	
	@FindBy(xpath = "//div[@class='add-to-wishlist']//button")
	WebElement wishListBtn;
	
	@FindBy(xpath = "//div[@class='bar-notification success']//p")
	WebElement cartSuccessMsg;
	
	@FindBy(xpath = "//p//a[@href='/cart']")
	WebElement shoppingCart;
	
	public ProductDetailsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getProductTitle() {
		String prodctTitle = productTitle.getText();
		return prodctTitle;
	}
	
	public String getProductPrice() {
		String prodctPrice = productPrice.getText();
		return prodctPrice;
	}
		
	public CartPage clickOnAddToCart() {
		addToCart.click();
		log.info("Click on add to cart");
		if (cartSuccessMsg.isDisplayed()) {
			System.out.println("Product is added successfully");
		}
		shoppingCart.click();
		log.info("Click on shopping cart");
		return new CartPage();
	}
	
}
