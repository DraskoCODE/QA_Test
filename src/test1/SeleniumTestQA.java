package test1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumTestQA {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\Driver\\chromedriver.exe");

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        //WebElement inputUserName = driver.findElement(By.id("user-name"));
        //WebElement inputUserName = driver.findElement(By.name("user-name"));
        WebElement inputUserName = driver.findElement(By.xpath("//input[@id='user-name']"));
        inputUserName.clear();
        //inputUserName.sendKeys("");
        inputUserName.sendKeys("standard_user");

        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.clear();
        inputPassword.sendKeys("secret_sauce");

        WebElement buttonLogin = driver.findElement(By.id("login-button"));
        buttonLogin.click();

        //String currentUrl = driver.getCurrentUrl();

        //if(currentUrl.equals("https://www.saucedemo.com/inventory.html")) {
            //System.out.println("Test passed");
        //}
        //else {
            //System.out.println("Test failed");
        //}

        //List<WebElement> cartList = driver.findElements(By.id("shopping_cart_container"));

        //List<WebElement> inventoryContainer = driver.findElements(By.id("inventory_container"));
        //if(inventoryContainer.size() > 1) {
            //System.out.println("Test passed");
        //}
        //else {
            //System.out.println("Test failed");
        //}

        //driver.findElement(By.xpath("//"))

        //Thread.sleep(5000);
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

        //Eksplicitni wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(60000));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.id("shopping_cart_container"), 3));

        WebElement h3 = driver.findElement(By.xpath("//h3[@data-test='error']"));
        //System.out.println(h3.getText());

        //if(h3.getText().equals("Epic sadface: Sorry, this user has been locked out.")) {
            //System.out.println("Test passed");
        //}
        //else {
            //System.out.println("Test failed");
        //}

        List<WebElement> shopingCart = driver.findElements(By.id("shopping_cart_container"));

        if(shopingCart.size() == 0 && h3.getText().equals("Epic sadface: Sorry, this user has been locked out.")) {
            System.out.println("Test passed");
        }
        else if (shopingCart.size() > 0) {
            System.out.println("Test failed");
        }
        else if(!h3.getText().equals("Epic sadface: Sorry, this user has been locked out.")) {
            System.out.println("Test failed, message is not as expected");
        }



        driver.quit();

    }

}
