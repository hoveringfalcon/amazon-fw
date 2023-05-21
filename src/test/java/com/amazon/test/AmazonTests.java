package com.amazon.test;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.amazon.base.BaseTest;
import com.amazon.pageEvents.CartEvents;
import com.amazon.pageEvents.HomePageEvents;
import com.amazon.pageEvents.ProductPageEvents;
import com.aventstack.extentreports.Status;

public class AmazonTests extends BaseTest {

    @Test
    public void cartTest() {

        actions = new Actions(driver);
        HomePageEvents.searchitems("dove soap");
        driver.findElement(By.xpath("//*[contains(text(),'Dove Go Fresh Moisture')]")).click();
        Set<String> ids = driver.getWindowHandles();
        Iterator<String> it = ids.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);

        ProductPageEvents.addtocart();

        test = extent.createTest("Amazon Cart Test");

        if (driver.findElement(By.xpath("//*[contains(text(),'Dove Go Fresh Moisture')]")).isDisplayed())
            test.log(Status.PASS, "Amazon Cart test successful");
        else
            test.log(Status.FAIL, "Amazon Cart test failed");


    }

    @Test
    public void testProductSearchAndDetails() {

        HomePageEvents.searchitems("iPhone 14 128 GB midnight");
        driver.findElement(By.xpath("//*[contains(text(),'Midnight')]")).click();

        Set<String> ids = driver.getWindowHandles();
        Iterator<String> it = ids.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);

        test = extent.createTest("Amazon Search & Details Test");

        if (driver.findElement(By.xpath("//*[contains(text(),'6.1-inch')]")).isDisplayed()) {

            if(driver.findElement(By.xpath("//*[contains(text(),'A15 Bionic chip')]")).isDisplayed())
                test.log(Status.PASS, "Amazon Search & Details test successful");

        }
        else
            test.log(Status.FAIL, "Amazon Search & Details test failed");

    }
    
}
