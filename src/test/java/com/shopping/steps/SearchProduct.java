package com.shopping.steps;

import com.shopping.runners.FlipCartDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import static org.testng.AssertJUnit.*;

@Test(priority = 2)
public class SearchProduct extends FlipCartDriver {
    static String parent;
    @Test(priority = 1)
    @Given("User is in the flipcart website opening page")
    public void user_is_in_the_flipcart_website() {
        System.out.println(driver.getTitle());
        signUpPage.Xclose.click();
    }

    @Test(dataProvider = "productData", priority = 2)
    @When("User search for the product name with memory size")
    public void user_search_for_the_product_name(String product) throws InterruptedException {
        mainPage.productSearch.sendKeys(Keys.CONTROL, "a");
        mainPage.productSearch.sendKeys(Keys.DELETE);
        mainPage.productSearch.sendKeys(product);
        mainPage.productSearch.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
    }
    @DataProvider(name = "productData")
    public Object[][] excelData(){
        return getExcelData("src/test/java/com/shopping/exceldata/productData.xlsx", "Sheet1");
    }
   public String[][] getExcelData(String filename, String sheetname){
       String[][] data = null;
        try {
            FileInputStream file = new FileInputStream(filename);
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheet(sheetname);
            XSSFRow row = sheet.getRow(1);
            Cell cell;
            int noOfRows = sheet.getPhysicalNumberOfRows();
            int noOfCols = row.getLastCellNum();
            data = new String[noOfRows-1][noOfCols];
            for(int i =1; i<noOfRows; i++)
                for(int j = 0; j<noOfCols; j++){
                    row = sheet.getRow(i);
                    cell = row.getCell(j);
                    data[i-1][j] = cell.getStringCellValue();
                }
        }catch(IOException e){
            e.printStackTrace();
        }
        return data;
   }

//    @DataProvider(name = "productData")
//    public Object[][] products(){
//        Object[][] data = new Object[3][1];
//        data[0][0] = "Rice";
//        data[1][0] = "Shirt";
//        data[2][0] = "iPhone13";
//        return data;
//    }

    @Test(priority = 3)
    @When("User select the product")
    public void user_select_the_product() throws InterruptedException {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions
                        .visibilityOfAllElements(mainPage.listProducts));
        System.out.println(mainPage.listProducts.size());

        parent = driver.getWindowHandle();
        System.out.println("Current URL: "+driver.getCurrentUrl());
        List<WebElement> list = mainPage.listProducts;
        for(int i =0; i<list.size(); i++){
            if(list.get(i).getText().equals("APPLE iPhone 13 (Pink, 128 GB)")) {
                list.get(i).click();
                break;
            }
        }
//        list.get(0).click();

        // It will return the parent window name as a String
        Set<String> windows = driver.getWindowHandles();

        // Now iterate through the set
        for(String child : windows){
            if(!parent.contentEquals(child)) {
                driver.switchTo().window(child);
                break;
            }
        }
        Thread.sleep(8000);
    }
    @Test(priority = 4)
    @When("User add product to the cart")
    public void user_add_product_to_the_cart() throws InterruptedException {
        String url = driver.getCurrentUrl();
        System.out.println("New URL: " + url);
        System.out.println(selectProductPage.addCart.isEnabled());
        selectProductPage.addCart.click();
       // Screanshot of element
        try {
            File scrFile = selectProductPage.addCart.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("./image.png"));
        }catch (IOException e){e.printStackTrace();}
        new WebDriverWait(driver, Duration.ofSeconds(50))
                .until(ExpectedConditions.visibilityOf(selectProductPage
                        .cartIcon)).sendKeys(Keys.ENTER);
    }
    @Test(priority = 5)
    @When("User select place the order")
    public void user_select_place_the_order() throws InterruptedException {
        if(conditionCheck(driver)!=null){
        driver.findElement(By.xpath("//div[@class='Vy94J0']/button")).click();
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(selectProductPage.cartIcon)).click();
        }
        Thread.sleep(4000);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(placeOrderPage
                        .placeOrder)).click();
    }
   public static WebElement conditionCheck(WebDriver driver){
        try{
            WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(By
                            .xpath("//div[@class='Vy94J0']/button")));
            return element;
        }catch (Exception e){
            return null;
        }
   }
    @Test(priority = 6)
    @Then("User should be in the Sign up or Sign in page")
    public void User_should_be_in_the_Sign_up_or_Sign_in_page() throws InterruptedException {
        assertEquals(signUpPage.loginPageHeader.getText(),"LOGIN OR SIGNUP");
    }
}
