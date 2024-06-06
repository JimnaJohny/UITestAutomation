package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.saucedemo.TestBase.TestBase;

public class SwagLabsPage extends TestBase {
	public SwagLabsPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input[id='user-name']")
	WebElement userName;

	@FindBy(css = "input[id='password']")
	WebElement passWord;

	@FindBy(css = "input[id='login-button']")
	WebElement loginButton;

	public void useCredentials() {
		//String username = driver.findElement(By.className("login_credentials")).getText().split("\n")[1];
		//String password = driver.findElement(By.className("login_password")).getText().split("\n")[1];
		//enterUserName(username);
		//enterPassword(password);
	}

	//private void enterUserName(String username) {
		//userName.sendKeys(username);
	//}
	private void enterUserName() {
		userName.sendKeys("standard_user");
	}
	private void enterWrongUserName() {
		userName.sendKeys("Wrong UserName");
	}

	//private void enterPassword(String password) {
		//passWord.sendKeys(password);
	//}
	private void enterPassword() {
		passWord.sendKeys("secret_sauce");
	}
	private void enterWrongPassword() {
		passWord.sendKeys("Wrong Password");
	}

	public void clickLoginButton() {
		loginButton.click();
	}

	public SortingSwagLabsPage login() {
		//useCredentials();
		enterUserName();
		enterPassword();
		clickLoginButton();
		return new SortingSwagLabsPage();
	}
	public SortingSwagLabsPage loginWithWrongCredentials() {
		enterWrongUserName();
		enterWrongPassword();
		clickLoginButton();
		return new SortingSwagLabsPage();
	}
}
