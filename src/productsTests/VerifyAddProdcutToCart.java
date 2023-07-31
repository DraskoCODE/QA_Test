package productsTests;

import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.ProductsPage;
import test1.ProductPage;

import java.util.List;

public class VerifyAddProdcutToCart {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","D:\\Driver\\chromedriver.exe");

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        ProductsPage productPage = new ProductsPage(driver);
        //Integer beforeAdd = productPage.returnItemNumber(driver);
        //productPage.addProductToCartByName("Test");

        //Integer afterAdd = productPage.returnItemNumber(driver);

        //if(afterAdd == beforeAdd+1) {
            //System.out.println("PASSED");
        //}
       // else {
            //System.out.println("FAILED");
        //}
        productPage.sortProductByName("Name (Z to A)");
        System.out.println("test");

        List<Double> prodcutsPrice = productPage.returnProductsPrice();
        System.out.println("test");
    }

}
