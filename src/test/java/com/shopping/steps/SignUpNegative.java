package com.shopping.steps;

import com.shopping.runners.FlipCartDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

@Test(priority = 1)
public class SignUpNegative extends FlipCartDriver {

    @Test(priority = 1)
    @Then("A new login page opens")
    public void a_new_login_page_opens() {
        System.out.println(signUpPage.newUser.getText());
        assertEquals(signUpPage.newUser.getText(),"New to Flipkart? Create an account");
    }
    @Test(priority = 2)
    @When("User clicks create an account button")
    public void user_clicks_create_an_account_button(){
        signUpPage.newUser.click();
    }
    @Test(priority = 3)
    @Then("Looks like you are new here page opens")
    public void looks_like_you_are_new_here_page_opens(){
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOf(signUpPage.newHere));
        assertEquals(signUpPage.newHere.getText(), "Looks like you're new here!");
    }
    @Test(priority = 4)
    @When("User entered his phone number")
    public void user_entered_his_phone_number() {
        signUpPage.phoneNumber.sendKeys("1122233344");
    }
    @Test(priority = 5)
    @When("User clicks continue button")
    public void user_clicks_continue_button(){
        signUpPage.signUpContinue.click();
    }
    @Test(priority = 6)
    @Then("Invalid mobile number message appears")
    public void Invalid_mobile_no_message_appears(){
        assertEquals(signUpPage.invalidNo.getText(),"Please enter a valid Mobile number");
    }
}
