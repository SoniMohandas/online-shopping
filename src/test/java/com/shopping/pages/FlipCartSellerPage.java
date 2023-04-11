package com.shopping.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipCartSellerPage {
    public WebDriver driver;
    public FlipCartSellerPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//div[@id='app']//div/a/img")
    public WebElement sellerHub;
}
