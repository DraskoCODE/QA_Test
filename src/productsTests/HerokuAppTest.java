package productsTests;

import models.Row;
import models.Table;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.CheckBoxesPage;
import pages.TablePage;

import java.util.ArrayList;
import java.util.List;

public class HerokuAppTest {

    public List<List<String>> returnTableDataList() {
        return null;
    }

    public Table returnTableData() {
        return null;
    }

    @Test
    public void readTable() {
        System.setProperty("webdriver.chrome.driver","D:\\Driver\\chromedriver.exe");

        ChromeDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/");
        WebElement sortDataTables = driver.findElement(By.xpath("//a[@href='/tables']"));
        sortDataTables.click();

        TablePage tablePage = new TablePage(driver);
        Table table1 = tablePage.readTable("table1");
        Table table2 = tablePage.readTable("table2");
        System.out.println("");

    }

    @Test
    public void readRowAtPosition() {
        System.setProperty("webdriver.chrome.driver","D:\\Driver\\chromedriver.exe");

        ChromeDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/");

        WebElement sortDataTables = driver.findElement(By.xpath("//a[@href='/tables']"));
        sortDataTables.click();
        List<Row> listRows = new ArrayList<>();
        List<List<String>> tableData = new ArrayList<>();
        WebElement table = driver.findElement(By.id("table1"));

        WebElement tBody = table.findElement(By.xpath("//tbody"));
        List<WebElement> tRows = tBody.findElements(By.xpath(".//tr"));

        List<WebElement> tData = tRows.get(0).findElements(By.xpath(".//td"));
            //System.out.println(tData);
        List<String> tableRowData = new ArrayList<>();

        for(int j = 0; j < tData.size(); j++) {
            System.out.println(tData.get(j).getText());
            tableRowData.add(tData.get(j).getText());
        }
        System.out.println("");
    }

    @Test
    public void verifyAddTableItem() {
        System.setProperty("webdriver.chrome.driver","D:\\Driver\\chromedriver.exe");

        ChromeDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/");
        WebElement sortDataTables = driver.findElement(By.xpath("//a[@href='/tables']"));
        sortDataTables.click();

        TablePage tablePage = new TablePage(driver);
        Table table1 = tablePage.readTable("table1");
        List<String> lastRow = table1.returnRowAtPosition(table1.getRows().size() - 1);

        SoftAssert softAssert = new SoftAssert();
        for(int i = 0; i < lastRow.size(); i++) {
            softAssert.assertEquals(lastRow.get(0), "Conway");
            softAssert.assertEquals(lastRow.get(1), "Tim");
        }
        softAssert.assertAll();

        driver.quit();
    }

    @Test
    public void verifyCheckBoxSecondStatus() {
        System.setProperty("webdriver.chrome.driver","D:\\Driver\\chromedriver.exe");

        ChromeDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/");
        WebElement checkBoxesItem = driver.findElement(By.xpath("//a[@href='/checkboxes']"));
        checkBoxesItem.click();

        CheckBoxesPage checkBoxesPage = new CheckBoxesPage(driver);
        //checkBoxesPage.checkCheckBox("checkbox 1");
        Assert.assertEquals(checkBoxesPage.isCheckBoxChecked("checkbox 2"), true, "CheckBox2 is not checked");

        driver.quit();
    }

    @Test
    public void verifyCheckBoxFirstStatus() {
        System.setProperty("webdriver.chrome.driver","D:\\Driver\\chromedriver.exe");

        ChromeDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/");
        WebElement checkBoxesItem = driver.findElement(By.xpath("//a[@href='/checkboxes']"));
        checkBoxesItem.click();

        CheckBoxesPage checkBoxesPage = new CheckBoxesPage(driver);
        //checkBoxesPage.checkCheckBox("checkbox 1");
        Assert.assertEquals(checkBoxesPage.isCheckBoxChecked("checkbox 1"), false, "CheckBox1 is checked");

        driver.quit();
    }

    @Test
    public void verifyFirstCheckBoxChecked() {
        System.setProperty("webdriver.chrome.driver","D:\\Driver\\chromedriver.exe");

        ChromeDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/");
        WebElement checkBoxesItem = driver.findElement(By.xpath("//a[@href='/checkboxes']"));
        checkBoxesItem.click();

        CheckBoxesPage checkBoxesPage = new CheckBoxesPage(driver);
        checkBoxesPage.checkCheckBox("checkbox 1");
        Assert.assertEquals(checkBoxesPage.isCheckBoxChecked("checkbox 1"), true, "CheckBox1 is not checked");

        driver.quit();
    }

   

}
