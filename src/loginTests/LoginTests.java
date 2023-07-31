package loginTests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.util.ArrayList;
import java.util.List;

public class LoginTests {

    @Test
    public void verifyLoginWithStandardUser() {
        System.setProperty("webdriver.chrome.driver","D:\\Driver\\chromedriver.exe");

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        List<String> standardUser = new ArrayList<>();
        standardUser.add("standard_user");
        standardUser.add("standard_userr");
        standardUser.add("standard_user");
        standardUser.add("standard_user");

        LoginPage loginPage = new LoginPage(driver);
        for(int i = 0; i < standardUser.size(); i++) {
            loginPage.login(standardUser.get(i), "secret_sauce");

            if(driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html")) {
                //System.out.println("PASSED for user " + standardUser.get(i));
            }
            else {
                System.out.println("FAILED for user " + standardUser.get(i));
            }
        }

    }

    @Test
    public void verifyLoginWithLockOutUser() {
        System.setProperty("webdriver.chrome.driver","D:\\Driver\\chromedriver.exe");

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("locked_out_user", "secret_sauce");
    }

}
