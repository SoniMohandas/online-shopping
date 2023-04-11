package com.revature.runners;

import com.revature.pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;


public class FlipCartDriver{
    public WebDriver driver;
    public CustomerCarePage customerCarePage;
    public FasionPage fashionPage;
    public FlipCartPlusPage flipCartPlusPage;
    public FlipCartSellerPage flipCartSellerPage;
    public GroceryPage groceryPage;
    public MainPage mainPage;
    public MissingCart missingCart;
    public MobileElectronicPage mobileElectronicPage;
    public PlaceOrderPage placeOrderPage;
    public SelectProductPage selectProductPage;
    public SignUpPage signUpPage;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins= *");
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com");

        customerCarePage = new CustomerCarePage(driver);
        fashionPage = new FasionPage(driver);
        flipCartPlusPage = new FlipCartPlusPage(driver);
        flipCartSellerPage = new FlipCartSellerPage(driver);
        groceryPage = new GroceryPage(driver);
        mainPage = new MainPage(driver);
        missingCart = new MissingCart(driver);
        mobileElectronicPage = new MobileElectronicPage(driver);
        placeOrderPage = new PlaceOrderPage(driver);
        selectProductPage = new SelectProductPage(driver);
        signUpPage = new SignUpPage(driver);
    }
    @AfterClass
    public void teardown(){
        driver.quit();
    }
    @AfterTest
    public void testResult(){
        System.out.println("Test Results Following");
    }
}
