package loginTests;

import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import java.util.ArrayList;
import java.util.List;

public class VerifyLoginWithStandardUser {

    public static void main(String[] args) {
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



        //provera jel test prosao
    }

}
