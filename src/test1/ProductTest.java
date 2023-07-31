package test1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import java.util.ArrayList;
import java.util.List;

public class ProductTest {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","D:\\Driver\\chromedriver.exe");

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        ProductTest productTest = new ProductTest();

        //broj u korpi pre dodavanja
        Integer itemNumberBeforeAdd = productTest.returnItemNumber(driver);
        //productTest.addProductToCartByName(driver, "Sauce Labs Bike Light");
        //productTest.addProductToCartByName(driver, "Sauce Labs Bolt T-Shirt");
        //productTest.addProductToCartByName(driver, "Test.allTheThings() T-Shirt (Red)");

        List<String> productsName = new ArrayList<>();
        productsName.add("Sauce Labs Bike Light");
        productsName.add("Sauce Labs Backpack");

        ProductsPage productsPage = new ProductsPage();
        productsPage.addProductsToCard(driver, productsName);



        //broj u korpi nakon dodavanja
        Integer itemNumberAfterAdd = productTest.returnItemNumber(driver);


        if(itemNumberAfterAdd == itemNumberBeforeAdd + 2){
            System.out.println("Test passed");
        }
        else {
            System.out.println("Test failed, item number is not as expected, expected " + itemNumberBeforeAdd +
                    " but found " + itemNumberAfterAdd);
        }

        driver.quit();


    }

    public void addProductToCartByName(ChromeDriver driver, String productName) {
        WebElement inventoryList = driver.findElement(By.className("inventory_list"));

        List<WebElement> inventoryItems = inventoryList.findElements(By.className("inventory_item"));

        for(int i = 0; i < inventoryItems.size(); i++) {
            WebElement inventoryItemName = inventoryItems.get(i).findElement(By.className("inventory_item_name"));

            if(inventoryItemName.getText().equals(productName)) {
                WebElement addToCartButton = inventoryItems.get(i).findElement(By.xpath(".//button"));
                addToCartButton.click();
                break;
            }
        }
    }

    public void addProductToCartByName(ChromeDriver driver, List<String> listProductName) {
        WebElement inventoryList = driver.findElement(By.className("inventory_list"));

        List<WebElement> inventoryItems = inventoryList.findElements(By.className("inventory_item"));

        for(int i = 0; i < inventoryItems.size(); i++) {
            WebElement inventoryItemName = inventoryItems.get(i).findElement(By.className("inventory_item_name"));

            if(inventoryItemName.getText().equals(listProductName.get(0))) {
                WebElement addToCartButton = inventoryItems.get(i).findElement(By.xpath(".//button"));
                addToCartButton.click();
                break;
            }
        }
    }

    public void addFirstProductItemToCart() {

    }

    public Integer returnItemNumber(ChromeDriver driver) {
        Integer toReturn = null;
        WebElement linkShoppingCart = driver.findElement(By.className("shopping_cart_link"));

        List<WebElement> spanItemNumbers = linkShoppingCart.findElements(By.className("shopping_cart_badge"));

        if(spanItemNumbers.size() == 0) {
            toReturn = 0;
        }
        else {
            toReturn = Integer.parseInt(spanItemNumbers.get(0).getText());
        }

        //WebElement spanItemNumber = driver.findElement(By.className("shopping_cart_badge"));
        //String itotemNumber = spanItemNumber.getText();

        //return Integer.parseInt(itemNumber);
        return toReturn;
    }


}
