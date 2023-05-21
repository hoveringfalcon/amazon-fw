package com.amazon.pageEvents;

import org.openqa.selenium.By;

import com.amazon.base.BaseTest;
import com.amazon.pageObjects.CartElements;

public class CartEvents extends BaseTest {

    public static void deleteitem() {

        driver.findElement(By.xpath(CartElements.deleteitem)).click();

    }
    
}
