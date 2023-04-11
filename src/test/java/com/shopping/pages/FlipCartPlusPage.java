package com.shopping.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipCartPlusPage {
    public WebDriver driver;
    public FlipCartPlusPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//div[@class='_3WcRHs']//div/img[2]")
    public WebElement flipcartExplore;
}
