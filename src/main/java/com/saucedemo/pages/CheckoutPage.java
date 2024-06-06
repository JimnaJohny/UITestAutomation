package com.saucedemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.apache.commons.lang3.RandomStringUtils;
import com.saucedemo.TestBase.TestBase;

public class CheckoutPage extends TestBase {

	public CheckoutPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "first-name")
	WebElement firstName;

	@FindBy(id = "last-name")
	WebElement lastName;

	@FindBy(id = "postal-code")
	WebElement postalCode;

	@FindBy(id = "continue")
	WebElement continueButton;
	
	public SwagLabsPage fillCheckoutForm() {
        firstName.sendKeys(RandomStringUtils.randomAlphabetic(5));
        lastName.sendKeys(RandomStringUtils.randomAlphabetic(5));
        postalCode.sendKeys(RandomStringUtils.randomNumeric(6));
        continueButton.click();
		return null;
    }
	 @FindBy(className = "summary_value_label")
	    WebElement paymentInfoLabel;

	    @FindBy(className = "summary_total_label")
	    WebElement totalPriceLabel;

	    @FindBy(id = "finish")
	    WebElement finishButton;
	    
	    public SwagLabsPage extractPaymentInfoAndPrice() {
	        String paymentInfo = paymentInfoLabel.getText();
	        String totalPrice = totalPriceLabel.getText();
	        Assert.assertNotNull(paymentInfo, "Payment information should be present");
	        Assert.assertNotNull(totalPrice, "Total price should be present");
	        return null;
	    }

	    public SwagLabsPage completeOrder() {
	        finishButton.click();
			return null;
	    }
	    @FindBy(id = "react-burger-menu-btn")
	    WebElement menuButton;

	    @FindBy(id = "logout_sidebar_link")
	    WebElement logoutLink;
	    
	    public SwagLabsPage logout() {
	        menuButton.click();
	        logoutLink.click();
			return new SwagLabsPage();
	    }

}
