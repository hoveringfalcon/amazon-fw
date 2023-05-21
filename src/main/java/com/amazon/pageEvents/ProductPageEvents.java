package com.amazon.pageEvents;

import org.openqa.selenium.By;

import com.amazon.base.BaseTest;
import com.amazon.pageObjects.ProductPageElements;

public class ProductPageEvents extends BaseTest {

    public static void addtocart() {

        driver.findElement(By.cssSelector(ProductPageElements.addtocart)).click();
        driver.findElement(By.linkText(ProductPageElements.gotocart)).click();
        
    }
    
}
