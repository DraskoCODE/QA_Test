package pages;

import models.Brand;
import models.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BrandsPage {
    private WebDriver driver;

    public BrandsPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void selectBrand(String brand) {

    }

    public List<String> returnAllBrands() {
        List<String> brends = new ArrayList<>();

        List<WebElement> container = driver.findElements(By.className("container"));
        List<WebElement> linkBrands = container.get(8).findElements(By.xpath(".//a"));

        for(int i = 0; i < linkBrands.size(); i++) {
            System.out.println(linkBrands.get(i).getAttribute("title"));
            brends.add(linkBrands.get(i).getAttribute("title"));
        }
        return brends;
    }

    public List<Brand> returnBrands() {
        List<Brand> brends = new ArrayList<>();

        List<WebElement> container = driver.findElements(By.className("container"));
        List<WebElement> linkBrands = container.get(8).findElements(By.xpath(".//a"));

        for(int i = 0; i < linkBrands.size(); i++) {
            System.out.println(linkBrands.get(i).getAttribute("title"));
            Brand brand = new Brand(linkBrands.get(i).getAttribute("title"));
            brends.add(brand);
        }
        return brends;
    }

    public Product returnProduct() {
        return null;
    }

    public void calculatePrice() {

    }

    public void selectBrand() {

    }

    public static void printBrand() {
        System.out.println("Nike");
    }

}
