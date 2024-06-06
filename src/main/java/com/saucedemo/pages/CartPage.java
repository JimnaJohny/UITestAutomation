package com.saucedemo.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.saucedemo.TestBase.TestBase;

public class CartPage extends TestBase {

	public CartPage() {
		PageFactory.initElements(driver, this);
	}

	 @FindBy(className = "cart_item")
	    List<WebElement> cartItems;
	 @FindBy(id = "checkout")
	    WebElement checkoutButton;
	 public CheckoutPage verifyProductsInCart() {
	        Assert.assertEquals(cartItems.size(),2, "Two items should be in the cart");
			return null;    
	    }
	 public CheckoutPage proceedToCheckout() {
	        checkoutButton.click();
	        return new CheckoutPage();
	    }
}