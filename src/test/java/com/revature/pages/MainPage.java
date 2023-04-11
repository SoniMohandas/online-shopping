package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage {
    public WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    // Flip cart logo
    @FindBy(xpath = "//div[@class='_3qX0zy']/a/img")
    public WebElement logo;

    //Explore link locator
    @FindBy(xpath = "//div[@class = '_3qX0zy']/a[2]")
    public WebElement flipcartExplore;
    //Main page product guest product search input field
    @FindBy(className = "_3704LK")
    public WebElement productSearch;

    //Become a seller link
    @FindBy(xpath = "//div[@class='go_DOp']/a")
    public WebElement becomeSeller;
    // More button locator
    @FindBy(xpath = "//div[@class='exehdJ']")
    public WebElement more;

    // Main page product search submit button locator
    @FindBy(className = "L0Z3Pu")
    public WebElement submitButton;

    // Whole listed product locator
//    @FindBy(className = "_1YokD2 _3Mn1Gg")
//    public List<WebElement> allProducts;

    // All the product locator with Name, Color, ROM
    @FindBy(className = "_4rR01T")
    public List<WebElement> listProducts;

    //Selected product click button
    @FindBy(className = "_396cs4")
    public WebElement selectProduct;

    @FindBy(xpath = "//div[@id = 'container']/div/div[3]/div/div")
    public List<WebElement> shirtList;

    //Cart icon main page
    @FindBy(xpath = "//a[@class = '_3SkBxJ']")
    public WebElement mainPageCart;

    // Grocery link locator
    @FindBy(xpath = "//div[@class='_37M3Pb']/div[1]")
    public WebElement groceryImg;

    //Mobile image link locator
    @FindBy(xpath = "//div[@class = '_37M3Pb']/div[2]")
    public WebElement mobileImg;
    //Fashion link locator
    @FindBy(xpath = "//div[@class = '_37M3Pb']/div[3]")
    public WebElement fashion;
    @FindBy(xpath = "//div[@class = '_37M3Pb']/div[4]")
    public WebElement electronics;
    @FindBy(xpath = "//div[@class = '_37M3Pb']/div[5]")
    public WebElement home;
}
