package org.example;

import org.example.listeners.ElementActionListener;
import org.example.listeners.TestListener;
import org.example.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

@Listeners(TestListener.class)
public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.createDriver("chrome");
        EventFiringDecorator<WebDriver> decorator = new EventFiringDecorator(new ElementActionListener());
        driver = decorator.decorate(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        //    wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @AfterMethod
    public void closeSession() {
        driver.quit();
    }

}
