package com.nopecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nopecommerce.seleniumdrivers.WebElementActions;

public class HomePage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath = "//a[text()='Log in']")
	private WebElement loginLnk;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void clickLoginLink() {
		WebElementActions.clickOnElement(loginLnk, "click on login link in Homepage");
	}
	
}
