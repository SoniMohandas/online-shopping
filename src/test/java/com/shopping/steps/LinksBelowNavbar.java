package com.shopping.steps;

import com.shopping.runners.FlipCartDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


import static org.testng.AssertJUnit.assertEquals;

@Test
public class LinksBelowNavbar extends FlipCartDriver {

    // Grocery photo links
    @Test(priority = 1)
    @When("User clicks grocery photo link")
    public void user_clicks_grocery_photo_link() throws InterruptedException {
        signUpPage.Xclose.click();
        mainPage.groceryImg.click();
        Thread.sleep(5000);
    }
    @Test(priority = 2)
    @Then("User can landed in the grocery page")
    public void user_can_landed_in_the_grocery_page() throws InterruptedException {

        try {
            File sourceFile = groceryPage.groceryTitle.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File("./grocery.png"));
            File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenShot, new File("./img1.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
        Thread.sleep(5000);
    }
    // Mobile Photo Links
    @Test(priority = 3)
    @When("User clicks mobile photo link")
    public void user_clicks_mobile_photo_link() throws InterruptedException {
        driver.get("https://www.flipkart.com");
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions
                .elementToBeClickable(mainPage.mobileImg))
                .click();
        Thread.sleep(5000);
    }

    @Test(priority = 4)
    @Then("User can landed in the mobile electronic page")
    public void user_can_landed_in_the_mobile_electronic_page() {
        System.out.println(mobileElectronicPage.electronicPage.getText());
        assertEquals(mobileElectronicPage.electronicPage
                .getText(),"Mobile Phones");
    }
    //Fashion Photo links
    @Test(priority = 5)
    @When("User hover over fashion photo link then Men Footwear then Men's Casual Shoes")
    public void user_hover_over_fashion_photo_link() throws InterruptedException {
        driver.get("https://www.flipkart.com");
        Actions action = new Actions(driver);
        action.moveToElement(mainPage.fashion).build().perform();
        Thread.sleep(3000);
        WebElement footwear = driver.findElement(By.linkText("Men Footwear"));
        action.moveToElement(footwear).build().perform();
        Thread.sleep(3000);
        WebElement active = driver.findElement(By.linkText("Men's Casual Shoes"));
        action.moveToElement(active).click().build().perform();

    }
    @Test(priority = 6)
    @Then("New Casual shoes page opened")
    public void new_pane_of_links_appears() throws InterruptedException {
        WebElement shoes = new WebDriverWait(driver,
                Duration.ofSeconds(30))
                .until(ExpectedConditions
                .presenceOfElementLocated(By
                .xpath("//h1[contains(text(),'Casual Shoes')]")));
        assertEquals(shoes.getText(), "Casual Shoes");
    }

    @Test(priority = 7)
    @When("User hover over electronics photo link then gaming link then clicks games link")
    public void user_hover_electronics_gaming_and_clicks_games_link() throws InterruptedException {
        driver.get("https://www.flipkart.com");
        Actions action = new Actions(driver);
        action.moveToElement(mainPage.electronics).build().perform();
        Thread.sleep(3000);
        WebElement gaming = driver.findElement(By.linkText("Gaming"));
        action.moveToElement(gaming).build().perform();
        Thread.sleep(3000);
        WebElement games = driver.findElement(By.linkText("Games"));
        action.moveToElement(games).click().build().perform();
        Thread.sleep(3000);
    }
    @Test(priority = 8)
    @Then("User can see Games video games and game devices")
    public void user_can_see_games_video_games(){
        WebElement games = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions
                .presenceOfElementLocated(By
                .xpath("//h1[contains(text(), 'Games')]")));
        assertEquals(games.getText(), "Games");
    }

    @Test(priority = 9)
    @When("User hover over home link then kitchen & dining link then cookware link and clicks")
    public void user_hover_over_home_kitchen_dining_then_cookwares() throws InterruptedException {
        driver.get("https://www.flipkart.com");
        Actions action = new Actions(driver);
        action.moveToElement(mainPage.home).build().perform();
        Thread.sleep(3000);
        WebElement dining = driver.findElement(By.linkText("Kitchen & Dining"));
        action.moveToElement(dining).build().perform();
        Thread.sleep(3000);
        WebElement cookware = driver.findElement(By.linkText("Cookware"));
        action.moveToElement(cookware).click().build().perform();
        Thread.sleep(3000);
    }
    @Test(priority = 10)
    @Then("User can see kitchen cookwares")
    public void user_can_see_kitchen_cookwares(){
        WebElement cookwares = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//h1[contains(text(),'Cookware')]")));
        assertEquals(cookwares.getText(), "Cookware");
    }
}
