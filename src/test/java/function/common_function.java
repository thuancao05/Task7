package function;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static driver.DriverManager.getDriver;

public class common_function {
    private WebDriverWait wait;
    public WebDriverWait getWait() {
        return wait;
    }
    Actions actions = new Actions(getDriver());

    public static WebElement getWebElement(By by) {
        return DriverManager.getDriver().findElement(by);
    }

    public static List<WebElement> getWebElements(By by) {
        return DriverManager.getDriver().findElements(by);
    }

    public void clicks(By by) {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", getDriver().findElement(by));
    }

    public void sendKeys(By by, String text) {
        WebElement element = getWebElement(by);
        element.clear();
        element.sendKeys(text);

    }

    public void press(Keys key) {
        actions.sendKeys(key).perform();
    }

    public boolean isDisplayed(By by) {
        WebElement element = getWebElement(by);
        return element.isDisplayed();
    }

    public void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean isChecked(By by){
        try {
            WebElement element = getWebElement(by);
            if (getAttribute("checked", element).equals("checked"))
                return true;
            else
                return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;

        }
    }

    public String getTitlePage() {
        return getDriver().getTitle();
    }
    public String getAttribute(String attr, WebElement element){
        return element.getAttribute(attr);
    }

    public String getText(WebElement element){
        return element.getText();
    }
    public boolean verifyTitlePage(String titlePage) {
        return getTitlePage().contains(titlePage);
    }

    public void selectValue(String value, By element) {
        WebElement select = getWait().until(ExpectedConditions.visibilityOfElementLocated(element));
        Select selectOption = new Select(select);
        selectOption.selectByValue(value);
    }

    //xoa attribute trong phan tu
    public void removeAttribute(By by, String attr){
        WebElement element = DriverManager.getDriver().findElement(by);
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].removeAttribute('" + attr + "')", element);
    }

    //cai dat attribute cho phan tu
    public void setAttribute(By by, String attr, String value){
        WebElement element = DriverManager.getDriver().findElement(by);
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].setAttribute('" + attr + "' , '" + value + "')", element);
    }

    // scroll to find element with By
    public void scrollToElement(By by){
        WebElement element = DriverManager.getDriver().findElement(by);
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].scrollIntoView(true)", element);
    }
    // scroll to find element with web element
    public void scrollToElement(WebElement element){
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].scrollIntoView(true)", element);
    }
    // scroll to find element with web element
    public void jsClick(By by){
        WebElement element = DriverManager.getDriver().findElement(by);
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    // scroll to find element with web element
    public void jsSendKey(By by, String str){
        WebElement element = DriverManager.getDriver().findElement(by);
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].setAttribute('value','khongduoc');", element);
    }

    //Ham kiem tra xep theo thu tu lon -> be
    public void checkDESC(By by){
        ArrayList<String> obtainedList = new ArrayList<>();
        List<WebElement> elementList = getDriver().findElements(by);
        for (WebElement we :elementList){
            obtainedList.add(we.getText());
            System.out.println(we);
        }
        ArrayList<String> sortedList = new ArrayList<>();
        for (String s : obtainedList){
            sortedList.add(s);
            System.out.println(s);
        }
        Collections.sort(sortedList);
        sortedList.sort(Collections.reverseOrder());
        Assert.assertEquals(obtainedList,sortedList);
    }

    //cat chuoi date
    public String cutStringDate(String str){
        return str.substring(0,10);
    }

    public int getTotalRowInTable(By by){
        scrollToElement(by);
        List<WebElement> elementList = DriverManager.getDriver().findElements(by);
        int rowTotal = elementList.size();
        System.out.println("Total Row : " + rowTotal);
        return rowTotal;
    }
    public int getTotalColumnInTable(By by){
        scrollToElement(by);
        List<WebElement> elementList = DriverManager.getDriver().findElements(by);
        int columnTotal = elementList.size()/2;
        System.out.println("Total Column : " + columnTotal);
        return columnTotal;
    }

    //lay so dong trung voi ten vendor
    public int getColumnByTitle(String str, By columnInTable) {

        int columnTotal = getTotalColumnInTable(columnInTable);    //Tong so cot trong bang
        for (int i = 1; i <= columnTotal; i++) {
            WebElement element = DriverManager.getDriver().findElement(By.xpath("//table[1]/thead[1]/tr[1]/th["+i+"]"));
            scrollToElement(element);
            if(str.equals(element.getText()))
                return i;
        }
        return -1;
    }
    public boolean checkDataInTable(String titleColumn, String data, By columnInTable, By rowInTable) {
        int column = getColumnByTitle(titleColumn, columnInTable);
        int rowTotal = getTotalRowInTable(rowInTable);    //Tong so cot trong bang
        for (int i = 1; i <= rowTotal; i++) {
            WebElement element = DriverManager.getDriver().findElement(By.xpath("//table/tbody/tr[" + i + "]/td[" + column + "]"));
            scrollToElement(element);
            System.out.println(element.getText());

            if(!data.equals(element.getText())) {
                Assert.assertTrue(false);
                return false;
            }
        }
        Assert.assertTrue(true);
        return true;
    }


}
