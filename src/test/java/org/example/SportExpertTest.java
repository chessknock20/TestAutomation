package org.example;

import org.example.listeners.ElementActionListener;
import org.example.utils.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class SportExpertTest extends BaseTest{

    @DataProvider(name = "data")
    public Object[][] getData(){
        return new Object[][]{
                {"Victoria", "123"},
                {"", "123"},
                {"Victoria", ""},
                {"", ""}
        };
    }

    @Test(dataProvider = "data")
    public void LoginIn(String name, String password){
        driver.get("https://expert-sport.by");
        driver.findElement(By.id("gs-login")).click();
        driver.findElement(By.id("input-email")).sendKeys(name);
        driver.findElement(By.id("input-password")).sendKeys(password);
        driver.findElement(By.xpath("//* [@class = \"btn btn-primary\"]")).click();

        boolean result = driver.findElement(By.xpath("//* [@class = \"fa fa-exclamation-circle\"]")).isDisplayed();
        Assert.assertTrue(result);

    }
}
