package test;

import data.BrandsData;
import models.Brand;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BrandsPage;
import pages.MainPage;
import pages.ManCornerPage;
import pages.ObucaMuskarciPage;

import java.util.ArrayList;
import java.util.List;

public class BrandsTesting {

    //private WebDriver driver;

    @BeforeClass
    public void driverSetup() {
        //System.setProperty("webdriver.chrome.driver","D:\\Driver\\chromedriver.exe");
        //driver = new ChromeDriver();
    }

    @Test
    public void verifyReturnAllBrands() {
        //List<String> expectedBrands = new ArrayList<>();
        //expectedBrands.add("NIKE");
        //expectedBrands.add("Reebok");
        //expectedBrands.add("adibas");

        BrandsData brandsData = new BrandsData();
        List<String> expectedBrands = brandsData.returnListBrands();

        System.setProperty("webdriver.chrome.driver","D:\\Driver\\geckodriver.exe");
        //ChromeDriver driver = new ChromeDriver();
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://www.buzzsneakers.rs/");
        driver.manage().window().maximize();
        MainPage mainPage = new MainPage(driver);

        //mainPage.openPage();
        mainPage.openBrands();

        BrandsPage brandsPage = new BrandsPage(driver);
        List<String> actualBrands = brandsPage.returnAllBrands();
        List<Brand> actBrands = brandsPage.returnBrands();

        //poredimo dve liste
        Assert.assertEquals(actualBrands.size(), expectedBrands.size(), "List size is not equals");
        SoftAssert softAssert = new SoftAssert();
        for(int i = 0; i < expectedBrands.size(); i++) {
            softAssert.assertTrue(actualBrands.contains(expectedBrands.get(i)), "Brand " + expectedBrands.get(i) + " is not found on the page");
            //if(!actualBrands.contains(expectedBrands.get(i))) {
                //System.out.println("Brand " + expectedBrands.get(i) + " is not found on the page");
            //}
        }
        softAssert.assertAll();

        for(int i = 0; i < actualBrands.size(); i++) {
            softAssert.assertTrue(expectedBrands.contains(actualBrands.get(i)), "Brand " + expectedBrands.get(i) + " is not found on the page");
            //if(!actualBrands.contains(expectedBrands.get(i))) {
            //System.out.println("Brand " + expectedBrands.get(i) + " is not found on the page");
            //}
        }

    }

    @Test
    public void verifySortNajeftinijePrvo() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\Driver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.buzzsneakers.rs/");
        driver.manage().window().maximize();
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.openMens();

        ManCornerPage manCornerPage = new ManCornerPage(driver);
        manCornerPage.openObuca();

        ObucaMuskarciPage obucaMuskarciPage = new ObucaMuskarciPage(driver);
        obucaMuskarciPage.sortBy("Najjeftinije prvo");
        Thread.sleep(10000);
        obucaMuskarciPage.returnAllPrices();

        BrandsPage brandsPage = new BrandsPage(driver);
        brandsPage.returnAllBrands();

        BrandsPage.printBrand();
    }


}
