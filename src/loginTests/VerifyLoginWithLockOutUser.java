package loginTests;

import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

public class VerifyLoginWithLockOutUser {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","D:\\Driver\\chromedriver.exe");

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("locked_out_user", "secret_sauce");

        //provera jel test prosao
    }

}
