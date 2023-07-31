package productsTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;

import java.util.ArrayList;
import java.util.List;

public class ProductsTests extends BaseTest {

    @BeforeClass
    public void driverSetup() {
        System.setProperty("webdriver.chrome.driver","D:\\Driver\\chromedriver.exe");
        super.driver = new ChromeDriver();
    }

    @AfterClass
    public void driverClose() {
       super.driver.quit();
    }

    @BeforeTest
    public void driverInit() {
        //super.driver = new ChromeDriver();
    }

    @Test
    public void verifyAddProductToCart() {

        //ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        ProductsPage productPage = new ProductsPage(driver);
        Integer beforeAdd = productPage.returnItemNumber(driver);
        productPage.addProductToCartByName("Sauce Labs Bike Light");

        Integer afterAdd = productPage.returnItemNumber(driver);

        Assert.assertEquals(afterAdd, beforeAdd + 1, "Product number is not equals");

        //driver.quit();
    }

    @Test
    public void verifySortProductByPriceFromLowToHigh() {

        //ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        ProductsPage productPage = new ProductsPage(driver);

        productPage.sortProductByPrice("Price (low to high)");
        System.out.println("test");

        List<Double> productsPrice = productPage.returnProductsPrice();
        System.out.println("test");

        Assert.assertEquals(productPage.priceSortingFromLowToHigh(productsPrice), "Redosled OK", "Redosled nije dobar");
        //System.out.println(productPage.priceSortingFromLowToHigh(productsPrice));

        //driver.quit();
    }


    public void verifySortProductByPriceFromHighToLow() {
        System.setProperty("webdriver.chrome.driver","D:\\Driver\\chromedriver.exe");

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        ProductsPage productPage = new ProductsPage(driver);

        productPage.sortProductByPrice("Price (high to low)");
        System.out.println("test");

        List<Double> productsPrice = productPage.returnProductsPrice();
        System.out.println("test");
    }

    @Test
    public void verifyProductsInCart() {
        driver.get("https://www.saucedemo.com/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        List<String> itemsToBeAdded = new ArrayList<>();
        itemsToBeAdded.add("Sauce Labs Backpack");
        itemsToBeAdded.add("Sauce Labs Bike Light");

        ProductsPage productPage = new ProductsPage(driver);
        for(int i = 0; i < itemsToBeAdded.size(); i++) {
            productPage.addProductToCartByName(itemsToBeAdded.get(i));
        }

        productPage.returnProducts();

        productPage.openCart();

        CartPage cartPage = new CartPage(driver);
        //List<String> cartItems = new ArrayList<>();
        List<String> cartItems = cartPage.itemsInCart();
        //cartItems.add("Sauce Labs Backpack");
        //cartItems.add("Sauce Labs Backpack");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(cartItems.size(), itemsToBeAdded.size(), "Some items is not added od add more than one");
        //SoftAssert softAssert = new SoftAssert();
        for(int i = 0; i < itemsToBeAdded.size(); i++) {
            softAssert.assertEquals(cartItems.contains(itemsToBeAdded.get(i)), true,
                    "Item " + itemsToBeAdded.get(i) + " id not added to cart");
        }
        softAssert.assertAll();



    }

}
