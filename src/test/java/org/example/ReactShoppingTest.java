package org.example;

import org.example.pages.CartPage;
import org.example.pages.HomePage;
import org.example.utils.ScreenShotUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class ReactShoppingTest extends BaseTest {



    @Test
    public void addOneItem() {
        HomePage homepage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);
        homepage.openURL();
        homepage.addFirstItemToCart();
   //     ScreenShotUtils.takeScreenshot(driver);
        assertEquals(cartPage.getText(), "Cropped Stay Groovy off white");
    }

    @Test
    public void findAllItems() {
        HomePage homepage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);
        homepage.openURL();
        List<String> namesListInHomepage = homepage.createNamesList();
        homepage.addAllItemsToCart();
        List<String> namesListInCart = cartPage.createNamesInCartList();
        Assert.assertEquals(namesListInHomepage, namesListInCart);
    }

    @Test
    public synchronized void filterItems() throws InterruptedException {
        HomePage homepage = new HomePage(driver);
        homepage.openURL();
        int sizeAllItems = homepage.namesAllItemsSize();
        homepage.clickXsButton();
        //   Thread.sleep(5000);
        wait(3000);
        int sizeXsItems = homepage.xsItemsSize();
        Assert.assertTrue(sizeAllItems > sizeXsItems);
    }

    @Test
    public synchronized void parsingItems() throws InterruptedException {
        HomePage homepage = new HomePage(driver);
        homepage.openURL();
        wait(3000);
        int countAll = homepage.countAllItems();
        homepage.clickSButton();
        wait(3000);
        int countS = homepage.countSItems();
        Assert.assertTrue(countAll > countS);
    }
}
