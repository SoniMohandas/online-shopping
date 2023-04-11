package com.shopping.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
    public WebDriver driver;
    public SignUpPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Login button in the opening page
    @FindBy(xpath = "//a[@class = '_1_3w1N']")
    public WebElement login;

    //New Frame - New to Flipcart? locator
    @FindBy(partialLinkText = "New to Flipkart")
    public WebElement newUser;

    // Enter email/password locator
    @FindBy(xpath = "//label[@class='_1fqY3P']")
    public WebElement loginEmail;

    // New Frame - Text locator
    @FindBy(xpath = "//div[@class = '_2MlkI1']//div/span")
    public WebElement newHere;

    // Input field phone number locator
    @FindBy(xpath = "//div[@class = '_2MlkI1']//div/form/div/input")
    public WebElement phoneNumber;

    //Signup continue button locator
    @FindBy(xpath = "//div[@class = '_1D1L_j']/button")
    public WebElement signUpContinue;

    @FindBy(xpath = "//span[@class = '_2YULOR']/span")
    public WebElement invalidNo;

    // Login page title
    @FindBy(xpath = "//div[@class = 'rvsx1l']/div/h3/span[2]")
    public WebElement loginPageHeader;

    // Login/SignUp email input field locator
    @FindBy(xpath = "//div[@class='_1XHoKS']/form//div/input")
    public WebElement email;

    //phone number input field locator for login or signup
    @FindBy(xpath = "//div[@class='_1XHoKS']/form/div/input")
    public WebElement phone;

    //OTP input field locator
    @FindBy(xpath = "//div[@class = '_1XHoKS']/form/div/input")
    public WebElement OTP;

    // Sign in closing button
    @FindBy(xpath = "//div[@class = '_2QfC02']/button")
    public WebElement Xclose;
}
