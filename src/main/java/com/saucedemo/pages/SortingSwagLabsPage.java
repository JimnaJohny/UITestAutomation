package com.saucedemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.TestBase.TestBase;

public class SortingSwagLabsPage extends TestBase {

	public SortingSwagLabsPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "product_sort_container")
	WebElement sortDropdown;
	@FindBy(css = "option[value='lohi']")
	WebElement lowToHighBtn;
	@FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
	WebElement product1;
	@FindBy(id = "add-to-cart-test.allthethings()-t-shirt-(red)")
	WebElement product2;
	@FindBy(css = "a[class=shopping_cart_link]")
	WebElement shoppingCartBtn;

	public CartPage sortByPriceLowToHigh() {
		sortDropdown.click();
		lowToHighBtn.click();
		return null;
	}

	public CartPage addProductsToCart() {
		product1.click();
		product2.click();
		return null;
	}

	public CartPage goToCart() {
		shoppingCartBtn.click();
		return new CartPage();
	}
}
