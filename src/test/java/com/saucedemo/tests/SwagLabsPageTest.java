package com.saucedemo.tests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.saucedemo.TestBase.TestBase;
import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.CheckoutPage;
import com.saucedemo.pages.SortingSwagLabsPage;
import com.saucedemo.pages.SwagLabsPage;

public class SwagLabsPageTest extends TestBase {
	SwagLabsPage page;
	SortingSwagLabsPage sorting;
	CartPage cart;
	CheckoutPage checkout;

	@BeforeMethod
	public void launchBrowser() {
		setUp();
		page = new SwagLabsPage();
	}
	@Test
    public void negativeLoginTest() {
		sorting = page.loginWithWrongCredentials();
		cart = sorting.sortByPriceLowToHigh();
		cart = sorting.addProductsToCart();
		cart = sorting.goToCart();
	}

	@Test()
	public void placeOrder() {
		sorting = page.login();
		cart = sorting.sortByPriceLowToHigh();
		cart = sorting.addProductsToCart();
		cart = sorting.goToCart();
		checkout = cart.verifyProductsInCart();
		checkout = cart.proceedToCheckout();
		page = checkout.fillCheckoutForm();
		page = checkout.extractPaymentInfoAndPrice();
		page = checkout.completeOrder();
		page = checkout.logout();
	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}
		
}
