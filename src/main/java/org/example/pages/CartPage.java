package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@class = 'sc-1h98xa9-0 gFkyvN']")
    private WebElement closeIcon;

    @FindBy(xpath = "//p[@class = 'sc-11uohgb-2 elbkhN']")
    private WebElement firstItemInCart;

    @FindBy(xpath = "//p[@class ='sc-11uohgb-2 elbkhN']")
    List<WebElement> namesAllItemsInCard;


    public String getText() {
        return firstItemInCart.getText();
    }

    public List<String> createNamesInCartList() {
        List<String> namesAllItemsInCardStr = namesAllItemsInCard.stream().map(x -> x.getText()).toList();
        return namesAllItemsInCardStr;
    }

}
