package org.example.testing1;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import java.util.List;

import static org.testng.Assert.assertEquals;


public class ReactShoppingTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Alexandra\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void addOneItem() {
        driver.get("https://react-shopping-cart-67954.firebaseapp.com/");
        driver.findElement(By.xpath("//div [@class='sc-124al1g-2 dwOYCh']"));
        driver.findElement(By.xpath(" //div[@class='sc-124al1g-2 dwOYCh']/button")).click();
        WebElement oneItem = driver.findElement(By.xpath("//p[@class = 'sc-11uohgb-2 elbkhN']"));
        assertEquals(oneItem.getText(), "Cropped Stay Groovy off white");
    }

    @FindBy(xpath = "//button[@class = 'sc-1h98xa9-0 gFkyvN']")
    WebElement closeIcon;
    @Test
    public void findAllItems() {
        driver.get("https://react-shopping-cart-67954.firebaseapp.com/");
        PageFactory.initElements(driver, this);
        List<WebElement> namesAllItems = driver.findElements(By.xpath("//p[@class ='sc-124al1g-4 eeXMBo']"));
        List<String> namesAllItemsStr = namesAllItems.stream().map(x -> x.getText()).toList();
        List<WebElement> webElementList = driver.findElements(By.xpath("//*[text() = 'Add to cart']"));
        for (WebElement element : webElementList) {
            wait.until(ExpectedConditions.elementToBeClickable(closeIcon)).click();
            element.click();
        }
        List<WebElement> namesAllItemsInCard = driver.findElements(By.xpath("//p[@class ='sc-11uohgb-2 elbkhN']"));
        List<String> namesAllItemsInCardStr = namesAllItemsInCard.stream().map(x -> x.getText()).toList();
        Assert.assertEquals(namesAllItemsStr, namesAllItemsInCardStr);

    }

    @Test
    public synchronized void filterItems() throws InterruptedException {
        driver.get("https://react-shopping-cart-67954.firebaseapp.com/");
        List<WebElement> namesAllItems = driver.findElements(By.xpath("//p[@class ='sc-124al1g-4 eeXMBo']"));
        int sizeAllItems = namesAllItems.size();
        driver.findElement(By.xpath("//span[@class = \"checkmark\"][text() = 'XS']")).click();
        wait(5000);
        //  waitForLoadPage();
        List<WebElement> xsItems = driver.findElements(By.xpath("//p[@class ='sc-124al1g-4 eeXMBo']"));
        int sizeXSItems = xsItems.size();
        Assert.assertTrue(sizeAllItems > sizeXSItems);
    }

    @Test
    public synchronized void parsingItems() throws InterruptedException {
        driver.get("https://react-shopping-cart-67954.firebaseapp.com/");
        wait(3000);

        WebElement countAllItems = driver.findElement(By.xpath("//main[@class = 'sc-ebmerl-4 iliWeY']//p"));
        String[] mas = countAllItems.getText().split("[,\\s]+");
        int countAll = Integer.parseInt(mas[0]);
        WebElement sizeS = driver.findElement(By.xpath("//span[@class = \"checkmark\"][text() = 'S']"));
        sizeS.click();
        wait(3000);
        WebElement countSItems = driver.findElement(By.xpath("//main[@class = 'sc-ebmerl-4 iliWeY']//p"));
        String[] mas2 = countSItems.getText().split("[,\\s]+");
        int countS = Integer.parseInt(mas2[0]);
        Assert.assertTrue(countAll > countS);
    }

    @AfterTest
    public void closeSession() {
        driver.quit();
    }

}
