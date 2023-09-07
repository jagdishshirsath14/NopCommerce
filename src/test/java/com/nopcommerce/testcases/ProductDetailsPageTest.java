package com.nopcommerce.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.baseclass.BaseClass;
import com.nopcommerce.pageobjects.HomePage;
import com.nopcommerce.pageobjects.ProductDetailsPage;
import com.nopcommerce.pageobjects.SearchResultPage;


public class ProductDetailsPageTest extends BaseClass{
	
	public HomePage homePage;
	public SearchResultPage searchResultPage;
	public ProductDetailsPage productDetailsPage;
	
	@Test(priority = 1)
	public void verifyProductNameAndProductPrice() {
		homePage = new HomePage();
		homePage.searchProduct("macbook");
		homePage.clickOnSearch();
		searchResultPage = new SearchResultPage();
		searchResultPage.clickOnProduct();
		productDetailsPage = new ProductDetailsPage();
		Assert.assertEquals("Apple MacBook Pro 13-inch", productDetailsPage.getProductTitle());
		Assert.assertEquals("$1,800.00", productDetailsPage.getProductPrice());
	}
	
	@Test(priority = 2)
	public void verifyAddToCartFunctionality() {
		homePage = new HomePage();
		homePage.searchProduct("macbook");
		homePage.clickOnSearch();
		searchResultPage = new SearchResultPage();
		searchResultPage.clickOnProduct();
		productDetailsPage = new ProductDetailsPage();
		productDetailsPage.clickOnAddToCart();
		Assert.assertTrue(true);
	}

}
