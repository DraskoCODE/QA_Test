package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ManCornerPage {

    private WebDriver driver;

    public ManCornerPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void openObuca() {
        WebElement linkObuca = driver.findElements(By.xpath("//a[@href='https://www.buzzsneakers.rs/obuca/za-muskarce']")).get(2);
        linkObuca.click();
    }

    public void openOdeca() {

    }

    public void openOprema() {

    }

}
