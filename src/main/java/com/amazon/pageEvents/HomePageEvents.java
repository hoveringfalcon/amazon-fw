package com.amazon.pageEvents;

import org.openqa.selenium.By;

import com.amazon.base.BaseTest;
import com.amazon.pageObjects.HomePageElements;
import org.openqa.selenium.Keys;

public class HomePageEvents extends BaseTest {

    public static void searchitems(String item) {

        driver.findElement(By.cssSelector(HomePageElements.searchbox)).sendKeys(item);
        driver.findElement(By.cssSelector(HomePageElements.searchbox)).sendKeys(Keys.ENTER);

    }

    
    
}
