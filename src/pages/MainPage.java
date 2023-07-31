package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void openPage() {
        driver.get("https://www.buzzsneakers.rs/");
        driver.manage().window().maximize();
    }

    private WebElement returnBrands(){
        return driver.findElement(By.xpath("//a[@title='Brendovi']"));
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void openMens() {
        WebElement linkBrendovi = driver.findElement(By.xpath("//a[@title='Muškarci']"));
        linkBrendovi.click();
    }

    public void openWomens() {

    }

    public void openChild() {

    }

    public void openBrands() {
        WebElement linkBrendovi = driver.findElement(By.xpath("//a[@title='Brendovi']"));
        linkBrendovi.click();
        //returnBrands().click();
    }


}
