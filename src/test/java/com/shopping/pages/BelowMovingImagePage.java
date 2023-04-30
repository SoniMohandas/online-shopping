package com.shopping.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BelowMovingImagePage {
    public WebDriver driver;

    public BelowMovingImagePage(WebDriver driver){
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }

    // View all tab below moving images of main page
    @FindBy(xpath = "//div[@class = '_30kJiF']/a")
    public WebElement viewAll;
    @FindBy(xpath = "//div[@class = '_37K3-p']/div[1]")
    public WebElement laptop;
    @FindBy(xpath = "//div[@class = '_37K3-p']/div[2]")
    public WebElement camera;
}
