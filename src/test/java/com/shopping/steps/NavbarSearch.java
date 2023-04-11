package com.shopping.steps;

import com.shopping.runners.FlipCartDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import static org.testng.AssertJUnit.*;

@Test(priority = 0)
public class NavbarSearch extends FlipCartDriver {
    String parent;
    @Test(priority = 1)
    @Then("User can see Flipcart logo")
    public void User_can_see_Flipcart_logo(){
        assertTrue(mainPage.logo.isDisplayed());
        parent = driver.getCurrentUrl();
    }
    @Test(priority = 2)
    @When("User clicks Explore plus")
    public void User_clicks_Explore_plus(){
        signUpPage.Xclose.click();
        new WebDriverWait(driver, Duration.ofSeconds(30))
        .until(ExpectedConditions
                .visibilityOfAllElements(mainPage.flipcartExplore));
        System.out.println(mainPage.flipcartExplore.isEnabled());
        mainPage.flipcartExplore.click();
    }
    @Test(priority = 3)
    @Then("User can see Flipcart Explore page")
    public void User_can_see_Flipcart_Explore_page() {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOf(
                        flipCartPlusPage.flipcartExplore));
        assertTrue(flipCartPlusPage.flipcartExplore.isDisplayed());
    }
    @Test(priority = 4)
    @When("User clicks search text form")
    public void User_clicks_search_text_form(){
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(
                        mainPage.productSearch)).click();
    }
    @Test(priority = 5)
    @When("User inputs search product")
    public void User_inputs_search_product(){
        mainPage.productSearch.sendKeys("Shirts");
        try {
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File("./image.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    @Test(priority = 6)
    @When("User clicks search icon")
    public void User_clicks_search_icon(){
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(
                        mainPage.submitButton)).click();
    }
    @Test(priority = 7)
    @Then("User can see the products with details")
    public void User_can_see_the_products_with_details() throws InterruptedException {
        Thread.sleep(8000);
        assertTrue(mainPage.shirtList.size()>0);
        System.out.println("Shirt List: "+mainPage.shirtList.size());
    }
    @Test(priority = 8)
    @When("User clicks login button")
    public void User_clicks_login_button(){
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(
                        signUpPage.login)).click();
    }
    @Test(priority = 9)
    @Then("User can see login page")
    public void User_can_see_login_page(){
        assertEquals(signUpPage.loginEmail.getText(), "Enter Email/Mobile number");
    }
    @Test(priority = 10)
    @When("User hover over login field and clicks orders")
    public void User_hover_over_login_field_then_clicks_orders() throws InterruptedException {
        try {
            Actions act = new Actions(driver);
            WebElement hover = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(MoveTargetOutOfBoundsException.class)
                .until(ExpectedConditions.visibilityOfElementLocated(By
                .linkText("Login")));
            signUpPage.Xclose.click();
            act.moveToElement(hover).build().perform();
            Thread.sleep(3000);

            WebElement order = driver.findElement(By.linkText("My Profile"));
            act.moveToElement(order).build().perform();
            Thread.sleep(3000);
            act.moveToElement(order).click().build().perform();

        }catch(NoSuchElementException e){
            System.out.println("Hover over not working");
            fail();
        }
    }
    @Test(priority = 11)
    @Then("User can see login page or orders page")
    public void User_can_see_login_page_or_orders_page(){
        String str = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//label[@class='_1fqY3P']")))
                .getText();
        assertEquals(str, "Enter Email/Mobile number");
    }
    @Test(priority = 12)
    @When("User clicks Become a seller link")
    public void User_clicks_Become_a_seller_link(){
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath( "//div[@class='go_DOp']/a"))).click();
    }
    @Test(priority = 13)
    @Then("User can see Flipcart Seller Hub")
    public void User_can_see_Flipcart_Seller_Hub() throws InterruptedException {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOf(flipCartSellerPage.sellerHub));
        assertTrue(flipCartSellerPage.sellerHub.isDisplayed());
    }
    @Test(priority = 14)
    @When("User clicks more button and clicks Customer Care link")
    public void User_clicks_more_button(){
        driver.get("https://www.flipkart.com");
        Actions action = new Actions(driver);
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOf(mainPage.more));
       action.moveToElement(mainPage.more).perform();
       WebElement list = new WebDriverWait(driver, Duration
               .ofSeconds(30)).until(ExpectedConditions
               .presenceOfElementLocated(By.xpath("//a[@href = '/helpcentre']")));
       System.out.println("More list: "+list);
       list.click();
        try {
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File("./image.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    @Test(priority = 15)
    @Then("User can see Customer Care page")
    public void User_can_see_Customer_Care_page() {
       WebElement helpCenter = new WebDriverWait(driver, Duration.ofSeconds(30))
               .until(ExpectedConditions.visibilityOfElementLocated(By
                       .xpath("//a[@href='/helpcentre?view=ORDERS']")));
       assertEquals(helpCenter.getText(),"Help Centre");
    }
    @Test(priority = 16)
    @When("User clicks cart icon")
    public void User_clicks_cart_icon(){
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(
        mainPage.mainPageCart)).click();
    }
}
