package test1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ProductPage {

    private WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {

    }

    public void addProductToCartByName(String productName) {
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

}
