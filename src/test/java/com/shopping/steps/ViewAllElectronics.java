package com.shopping.steps;

import com.shopping.runners.FlipCartDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

@Test(priority = 5)
public class ViewAllElectronics extends FlipCartDriver {

    @Test(priority = 1)
    @When("User clicks view all tab")
    public void user_clicks_view_all_tab() throws InterruptedException {
        signUpPage.Xclose.click();
        belowMovingImageLinks.viewAll.click();
        Thread.sleep(3000);
    }
    @Test(priority = 2)
    @Then("User landed in the electronic page")
    public void user_landed_in_the_electronic_page(){
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.presenceOfElementLocated(By
                .xpath("//div[@class = '_1Yt2GF']")));
        assertEquals(element.getText(), "Best of Electronics");
    }
    @Test(priority = 3)
    @When("User clicks laptop link")
    public void user_clicks_laptop_link() throws InterruptedException {
        driver.get("https://www.flipkart.com");
        Thread.sleep(3000);
        belowMovingImageLinks.laptop.click();

    }
    @Test(priority = 4)
    @Then("User landed in the intel 12th Gen Page")
    public void user_landed_in_the_intel_12th_Gen_page(){
        WebElement intel = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//h1[@class = '_10Ermr']")));
        assertEquals(intel.getText(), "Intel 12th Gen");
    }
    @Test(priority = 5)
    @When("User clicks mirror less camera")
    public void user_clicks_mirrorless_camera() throws InterruptedException {
        driver.get("https://www.flipkart.com");
        Thread.sleep(3000);
        List<WebElement> links = driver.findElements(By.tagName("a"));
        for(WebElement element : links)
            System.out.println(element.getText());
        System.out.println("No of links: "+links.size());
        belowMovingImageLinks.camera.click();

    }
    @Test(priority = 6)
    @Then("User landed in mirrorless camera page")
    public void user_landed_in_mirrorless_page(){
        WebElement dslr = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.presenceOfElementLocated(By
                .xpath("//h1[@class = '_10Ermr']")));
        assertEquals(dslr.getText(), "DSLR & Mirrorless");
    }
}
