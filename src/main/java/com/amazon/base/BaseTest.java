package com.amazon.base;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
    
    public static WebDriver driver;
    public ExtentTest test;
    public ExtentReports extent;
    public ExtentSparkReporter spark;
    public Actions actions;

    @BeforeTest
    public void beforeTestMethod() {

        extent = new ExtentReports();
        spark = new ExtentSparkReporter("C:\\Users\\vyom\\selenium_tests\\amazonframework\\frameworkdemo\\reports\\extentreport.html");
        extent.attachReporter(spark);
        
    }

    @BeforeMethod
    public void beforeMethodMethod() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));

    }

    @AfterMethod
    public void afterMethod() {

        driver.quit();

    }

    @AfterTest
    public void afterTest() {

        extent.flush();

    }

}
