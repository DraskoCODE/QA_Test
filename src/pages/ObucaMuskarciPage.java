package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ObucaMuskarciPage {

    private WebDriver driver;

    public ObucaMuskarciPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void sortBy(String sortValue) {
        WebElement selectSorting = driver.findElement(By.id("sort"));
        List<WebElement> listOptions = selectSorting.findElements(By.xpath(".//option"));

        for(int i = 0; i < listOptions.size(); i++) {
            if(listOptions.get(i).getText().equals(sortValue)) {
                listOptions.get(i).click();
                break;
            }
        }
    }

    public List<String> returnAllItems() {
        List<String> listOfProducts = new ArrayList<>();

        WebElement productsListing = driver.findElement(By.className("products-listing"));

        List<WebElement> products = productsListing.findElements(By.xpath(".//[@class='item']"));
        for(int i = 0; i < products.size(); i++) {
            listOfProducts.add(products.get(i).getAttribute("data-productname="));
        }
        return listOfProducts;
    }

    public List<String> returnAllPrices() {
        List<String> listOfPrices = new ArrayList<>();

        WebElement productsListing = driver.findElement(By.className("product-listing-items"));

        List<WebElement> products = productsListing.findElements(By.xpath(".//div[@class='item']"));
        for(int i = 0; i < products.size(); i++) {
            WebElement currentPrice = products.get(i).findElement(By.xpath(".//div[@class='current-price']"));
            System.out.println(currentPrice.findElement(By.xpath(".//span")).getText());
            listOfPrices.add(currentPrice.findElement(By.xpath(".//span")).getText());
        }
        return listOfPrices;
    }


}
