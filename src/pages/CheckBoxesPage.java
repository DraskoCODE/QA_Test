package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBoxesPage {

    private WebDriver driver;

    public CheckBoxesPage(WebDriver driver) {
        this.driver = driver;
    }


    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void checkCheckBox(String value) {
        WebElement form = driver.findElement(By.id("checkboxes"));
        if(value.equals("checkbox 1")) {
            form.findElements(By.xpath(".//input")).get(0).click();
        }
        else if(value.equals("checkbox 2")) {
            form.findElements(By.xpath(".//input")).get(1).click();
        }
        //driver.findElement(By.id("checkboxes")).findElement(By.xpath(".//input[te]"))
    }

    public boolean isCheckBoxChecked(String value) {
        boolean toReturn = false;
        WebElement form = driver.findElement(By.id("checkboxes"));
        if(value.equals("checkbox 1")) {
            if(form.findElements(By.xpath(".//input")).get(0).getAttribute("checked") != null) {
                toReturn = true;
            }
            else {
                toReturn = false;
            }
        }
        else if(value.equals("checkbox 2")) {
            if(form.findElements(By.xpath(".//input")).get(1).getAttribute("checked") != null) {
                //toReturn = Boolean.parseBoolean(form.findElements(By.xpath(".//input")).get(1).getAttribute("checked"));
                toReturn = true;
            }
            else {
                toReturn = false;
            }
        }
        return toReturn;
    }
}
