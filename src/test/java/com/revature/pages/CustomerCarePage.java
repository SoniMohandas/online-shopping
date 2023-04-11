package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerCarePage {
    public WebDriver driver;
    public CustomerCarePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h1[@class='icmw6p']")
    public WebDriver helpCenter;
}
