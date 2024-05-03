package org.example.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;

public class HomePage extends BasePage {


    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div [@class='sc-124al1g-2 dwOYCh']")
    private WebElement firstItem;

    @FindBy(xpath = " //div[@class='sc-124al1g-2 dwOYCh']/button")
    private WebElement addToCartFirstItem;

    @FindBy(xpath = "//p[@class ='sc-124al1g-4 eeXMBo']")
    List<WebElement> namesAllItems;

    @FindBy(xpath = "//*[text() = 'Add to cart']")
    List<WebElement> allAddToCartIcons;

    @FindBy(xpath = "//span[@class = \"checkmark\"][text() = 'XS']")
    WebElement xsButton;

    @FindBy(xpath = "//p[@class ='sc-124al1g-4 eeXMBo']")
    List<WebElement> xsItems;

    @FindBy(xpath = "//span[@class = \"checkmark\"][text() = 'S']")
    WebElement sButton;

    @FindBy(xpath = "//main[@class = 'sc-ebmerl-4 iliWeY']//p")
    WebElement countAllItemsIcon;

    @FindBy(xpath = "//main[@class = 'sc-ebmerl-4 iliWeY']//p")
    WebElement countSItemsIcon;

    public void openURL() {
        driver.get("https://react-shopping-cart-67954.firebaseapp.com/");
    }

    public void addFirstItemToCart() {
        addToCartFirstItem.click();
    }

    public void addAllItemsToCart() {
        for (WebElement element : allAddToCartIcons) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    public List<String> createNamesList() {
        List<String> namesAllItemsStr = namesAllItems.stream().map(x -> x.getText()).toList();
        return namesAllItemsStr;
    }

    public List<WebElement> listAllItems() {
        return namesAllItems;
    }

    public int namesAllItemsSize() {
        int sizeAllItems = namesAllItems.size();
        return sizeAllItems;
    }

    public void clickXsButton() {
        xsButton.click();
    }

    public void clickSButton() {
        sButton.click();
    }

    public int xsItemsSize() {
        int sizeXsItems = xsItems.size();
        return sizeXsItems;
    }

    public int countAllItems() {
        String[] mas = countAllItemsIcon.getText().split("[,\\s]+");
        int countAll = Integer.parseInt(mas[0]);
        return countAll;
    }

    public int countSItems() {
        String[] mas2 = countSItemsIcon.getText().split("[,\\s]+");
        int countS = Integer.parseInt(mas2[0]);
        return countS;
    }
}
