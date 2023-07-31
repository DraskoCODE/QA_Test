package pages;

import models.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage {

    private WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }


    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void addProductToCartByName(String product) {
        WebElement inventoryList = driver.findElement(By.className("inventory_list"));

        List<WebElement> inventoryItems = inventoryList.findElements(By.className("inventory_item"));

        for(int i = 0; i < inventoryItems.size(); i++) {
            WebElement inventoryItemName = inventoryItems.get(i).findElement(By.className("inventory_item_name"));

            if(inventoryItemName.getText().equals(product)) {
                WebElement addToCartButton = inventoryItems.get(i).findElement(By.xpath(".//button"));
                addToCartButton.click();
                break;
            }
        }
    }

    public void addProductsToCard(List<String> products) {
        for(int i = 0; i < products.size(); i++) {
            WebElement inventoryList = driver.findElement(By.className("inventory_list"));
            List<WebElement> inventoryItems = inventoryList.findElements(By.className("inventory_item"));
            for(int j = 0; j < inventoryItems.size(); j++) {
                WebElement inventoryItemName = inventoryItems.get(j).findElement(By.className("inventory_item_name"));
                String inventoryName = inventoryItemName.getText();

                if(inventoryName.equals(products.get(i))) {
                    //dodajemo element
                    inventoryItems.get(j).findElement(By.xpath(".//button")).click();
                    break;
                }

            }
        }
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

    public void removeProductFromCart(String product) {

    }

    public void removeProductsFromCart(List<String> product) {

    }

    public void sortProductByName(String sorting) {
        WebElement productSortContainer = driver.findElement(By.className("product_sort_container"));
        productSortContainer.click();

        if(sorting.equals("Name (A to Z)")) {
            productSortContainer.findElements(By.xpath(".//option")).get(0).click();
        }
        else if (sorting.equals("Name (Z to A)")){
            productSortContainer.findElements(By.xpath(".//option")).get(1).click();
        }
    }

    public void sortProductByPrice(String sorting) {
        WebElement productSortContainer = driver.findElement(By.className("product_sort_container"));
        productSortContainer.click();

        if(sorting.equals("Price (low to high)")) {
            productSortContainer.findElements(By.xpath(".//option")).get(2).click();
        }
        else if (sorting.equals("Price (high to low)")){
            productSortContainer.findElements(By.xpath(".//option")).get(3).click();
        }
    }

    public WebElement returnItemList() {
        return driver.findElement(By.className("inventory_list"));
    }

    public List<WebElement> returnInventoryItems() {
        WebElement inventoryList = returnItemList();
        return inventoryList.findElements(By.className("inventory_item"));
    }

    //metoda koje vrace imena producta sa stranice
    public List<String> returnProductsName() {
        List <String> lista = new ArrayList<>();

        WebElement inventoryList = returnItemList();

        List<WebElement> inventoryItems = inventoryList.findElements(By.className("inventory_item"));



        for (int i = 0; i < inventoryItems.size(); i++) {

            lista.add(inventoryItems.get(i).findElement(By.className("inventory_item_name")).getText());

        }

        return lista;
    }

    //metoda koje vrace cene producta sa stranice
    public List<Double> returnProductsPrice() {
        List<Double> list = new ArrayList<>();

        //WebElement inventoryList = returnItemList();

        //List<WebElement> inventoryItems = inventoryList.findElements(By.className("inventory_item"));

        List<WebElement> inventoryItems = returnInventoryItems();

        for(int i = 0; i < inventoryItems.size(); i++) {
            WebElement itemPrice = inventoryItems.get(i).findElement(By.className("inventory_item_price"));
            String price = itemPrice.getText();
            list.add(Double.parseDouble(price.substring(1)));
        }
        return list;
    }

    public List<Product> returnProducts() {
        List<Product> lista = new ArrayList<>();

        WebElement inventoryList = returnItemList();

        List<WebElement> inventoryItems = inventoryList.findElements(By.className("inventory_item"));

        for (int i = 0; i < inventoryItems.size(); i++) {

            WebElement itemName = inventoryItems.get(i).findElement(By.className("inventory_item_name"));
            String name = itemName.getText();

            WebElement itemPrice = inventoryItems.get(i).findElement(By.className("inventory_item_price"));
            double price = Double.parseDouble(itemPrice.getText().substring(1));

            Product product = new Product(name, price);
            lista.add(product);
        }

        return lista;
    }

    public String priceSortingFromLowToHigh(List<Double> prices) {
        String message = null;

        for(int i = 0; i < prices.size() - 1; i++) {
            int j = i + 1;
            if(prices.get(i) <= prices.get(j)) {
                message = "Redosled OK";
            }
            else {
               message = "Redosled nije dobar";
               break;
            }
        }

        return message;
    }

    public String  priceSortingFromHighToLow(List<Double> prices) {
        return null;
    }

    public void openCart() {
        //driver.findElement(By.className("shopping_cart_link")).click();
        WebElement cart = driver.findElement(By.className("shopping_cart_link"));
        cart.click();
    }


}
