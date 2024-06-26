package org.example.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public synchronized static WebDriver createDriver(String browser) {
        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\chess\\drivers\\chromedriver.exe");
            return new ChromeDriver();
        } else if(browser.equals("firefox")) {
            System.setProperty("webdriver.firefox.driver", "C:\\Users\\chess\\drivers\\geckodriver.exe");
            return new FirefoxDriver();
        }
        return null;

    }
}
