package productsTests;

import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.ProductsPage;

import java.util.List;

public class VerifySortProductByPrice {

    public static void main(String[] args) {
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

        System.out.println(productPage.priceSortingFromLowToHigh(productsPrice));


    }
}
