package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectProductPage {
    public WebDriver driver;
    public SelectProductPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    //  Add product to the cart button
    @FindBy(xpath = "//ul[@class = 'row']/li[1]/button")
    public WebElement addCart;

    @FindBy(xpath = "//a[@class='_3SkBxJ']")
    public WebElement cartIcon;

    // Product order locator
    @FindBy(xpath = "//ul[@class = 'row']/li[2]/form/button")
    public WebElement buyNow;
}
