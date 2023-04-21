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
    @When("User clicks fashion photo link")
    public void user_clicks_fashion_photo_link() throws InterruptedException {

        driver.get("https://www.flipkart.com");
//        mainPage.fashion.click();
        Actions action = new Actions(driver);
        action.moveToElement(mainPage.fashion).build().perform();
        Thread.sleep(3000);
        WebElement footwear = driver.findElement(By.linkText("Men Footwear"));
        action.moveToElement(footwear).build().perform();
        Thread.sleep(5000);
        WebElement active = driver.findElement(By.linkText("Men's Casual Shoes"));
        action.moveToElement(active).click().build().perform();

    }
    @Test(priority = 6)
    @Then("User landed in the whole fashion link page")
    public void User_landed_in_the_whole_fashion_link_page() throws InterruptedException {
        WebElement shoes = new WebDriverWait(driver,
                Duration.ofSeconds(30))
                .until(ExpectedConditions
                .presenceOfElementLocated(By
                .xpath("//h1[contains(text(), 'Casual Shoes')]")));
        assertEquals(shoes.getText(), "Casual Shoes");
    }

    @Test(priority = 7)
    @When("User clicks electronics photo link")
    public void user_clicks_electronics_photo_link() throws InterruptedException {
        driver.get("https://www.flipkart.com");
//        mainPage.electronics.click();
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
    @Then("User landed in the whole electronics page")
    public void user_landed_in_the_whole_electronics_page(){
        WebElement games = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions
                .presenceOfElementLocated(By
                .xpath("//h1[contains(text(), 'Games')]")));
        assertEquals(games.getText(), "Games");
    }

    @Test(priority = 9)
    @When("User clicks home and furniture link")
    public void user_clicks_home_and_furniture_link() throws InterruptedException {
        driver.get("https://www.flipkart.com");
//        mainPage.home.click();
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
    @Then(" User can see whole home and furniture appliances page")
    public void User_can_see_whole_home_and_furniture_appliances_page(){
        WebElement cookwares = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//h1[contains(text(),'Cookware')]")));
        assertEquals(cookwares.getText(), "Cookware");
    }

    @Test(priority = 11)
    @When("User clicks applaince link")
    public void user_clicks_applaince_link(){
        driver.get("https://www.flipkart.com");
        mainPage.applaince.click();
    }
    @Test(priority = 12)
    @Then("User can land in the applaince page")
    public void User_can_land_in_the_applaince_page(){
        WebElement applaince = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                        "//h1[contains(text(), 'TVs and Appliances')]"
                )));
        assertEquals(applaince.getText(), "TVs and Appliances");
    }

    @Test(priority = 13)
    @When("User clicks travel link")
    public void User_clicks_travel_link(){
        driver.get("https://www.flipkart.com");
        mainPage.travel.click();
    }
    @Test(priority = 14)
    @Then("User land in travel page")
    public void user_land_in_travel_page(){
        WebElement applaince = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                        "//div[@class = 'lAXZRO']"
                )));
        assertEquals(applaince.getText(), "Travel");
    }
    @Test(priority = 15)
    @When("User clicks top offers link")
    public void user_clicks_top_offers_link(){
        driver.get("https://www.flipkart.com");
        mainPage.topOffers.click();
    }
    @Test(priority = 16)
    @Then("User land in deals of the day page")
    public void user_land_in_deals_of_the_day_page(){
        WebElement offers = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[@class = '_1Yt2GF']")));
        assertEquals(offers.getText(), "Deals of the Day");
    }

    @Test(priority = 17)
    @When("User hower over beauty, toys and more and hover over baby care and clicks baby wipes")
    public void user_hover_over_beauty_and_baby_care_and_clicks_baby_wipes() throws InterruptedException {
        driver.get("https://www.flipkart.com");
        Actions action = new Actions(driver);
        action.moveToElement(mainPage.beauty).build().perform();
        Thread.sleep(3000);
        WebElement babyCare = driver.findElement(By.linkText("Baby Care"));
        action.moveToElement(babyCare).build().perform();
        Thread.sleep(3000);
        WebElement wipes = driver.findElement(By.linkText("Baby Wipes"));
        action.moveToElement(wipes).click().build().perform();
        Thread.sleep(3000);
    }
    @Test(priority = 18)
    @Then("User lands in baby wipes page")
    public void user_lands_in_baby_wipes_page(){
        WebElement babyWipes = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//h1[@class='_10Ermr']")));
        assertEquals(babyWipes.getText(), "Baby Wipes");
    }
    @Test(priority = 19)
    @When("User hover over two wheelers link and clicks electric vehicles")
    public void user_hover_over_two_wheelers_link_and_clicks_electric_vehicles() throws InterruptedException {
        driver.get("https://www.flipkart.com");
        Actions actions = new Actions(driver);
        actions.moveToElement(mainPage.twoWheelers).build().perform();
        Thread.sleep(3000);
        WebElement vehicles = driver.findElement(By.linkText("Electric Vehicles"));
        actions.moveToElement(vehicles).click().build().perform();
        Thread.sleep(3000);
    }
    @Test(priority = 20)
    @Then("User lands electric vehicles store page")
    public void user_lands_electric_vehicles_store_page(){
        WebElement electricVehicles = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//h1[@class='_3vKRL2']")));
        assertEquals(electricVehicles.getText(), "Electric Vehicles Store");
    }

}
