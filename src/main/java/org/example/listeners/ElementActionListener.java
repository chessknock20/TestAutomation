package org.example.listeners;

import org.openqa.selenium.*;
import org.openqa.selenium.support.events.WebDriverListener;

import java.time.Duration;
import java.util.List;

public class ElementActionListener implements WebDriverListener {

    @Override
    public void afterClick(WebElement element) {
        System.out.println(element.getTagName() + " is clicked");
    }

    @Override
    public void afterGetText(WebElement element, String result) {
        System.out.println(element.getTagName() + "get text " + result);
    }

    @Override
    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        System.out.println("element found successfully");
    }

    @Override
    public void afterFindElements(WebDriver driver, By locator, List<WebElement> result) {
        System.out.println("elements found successfully");
    }
}
