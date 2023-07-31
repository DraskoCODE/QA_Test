package test1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ProductsPage {

    //dodavanje liste proizvoda u korpu
    public void addProductsToCard(ChromeDriver driver, List<String> products) {
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

}
