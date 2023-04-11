package com.shopping.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MissingCart {
    WebDriver driver;
    public MissingCart(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Flipcart link locator
    @FindBy(xpath = "//a[1][@class = '_2hJxpa']/div")
    public WebElement flipcart;

    // Missing cart login
    @FindBy(tagName = "//div[@class='Vy94J0']/button/span")
    public WebElement nillCartLogin;
}
