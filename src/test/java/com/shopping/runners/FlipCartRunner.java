package com.shopping.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"java.com.revature.steps"},
        plugin = {"pretty"},
        monochrome = true
)
public class FlipCartRunner extends AbstractTestNGCucumberTests {
}