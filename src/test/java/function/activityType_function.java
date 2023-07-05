package function;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import page.activityType_page;

import java.util.List;

public class activityType_function {
    common_function commonFunction =  new common_function();
    activityType_page activityTypePage = new activityType_page();

    // nhan nut save
    public void clickBtnSave(){
        commonFunction.clicks(activityTypePage.btnSave);
    }

    //kiem tra thong bao sao khi thuc hien thao tac
    public void checkNotification(String expected){
        WebElement element = DriverManager.getDriver().findElement(activityTypePage.lblMessage);
        String actual =  commonFunction.getText(element);
        expected = "×\n"+expected;
        System.out.println(actual);
        System.out.println(expected);
        Assert.assertEquals(actual, expected);
    }

    //lay tong so cot trong bang
    public int getTotalRowInTable(By by){
        commonFunction.scrollToElement(by);
        List<WebElement> elementList = DriverManager.getDriver().findElements(by);
        int rowTotal = elementList.size();
        System.out.println("Total Row : " + rowTotal);
        return rowTotal;
    }
    //lay so dong trung voi ten role
    public int getRowByName(String str) {
        int column = 1;                                                 // Name la cot 1 trong bang
        int rowTotal = getTotalRowInTable(activityTypePage.rowInTable);    //Tong so cot trong bang
        for (int i = 1; i <= rowTotal; i++) {
            WebElement element = DriverManager.getDriver().findElement(By.xpath("//table/tbody/tr[" + i + "]/td[" + column + "]"));
            commonFunction.scrollToElement(element);
            System.out.println(element.getText());
            if(str.equals(element.getText()))
                return i;
        }
        return -1;
    }

    //dung check theo then type
    public void clickCheckEnableByNameOfType(String name){
        int row = getRowByName(name);
        if(commonFunction.isChecked(By.xpath("//table/tbody/tr["+row+"]/td[2]/input[1]")))
            return;
        WebElement element = DriverManager.getDriver().findElement(By.xpath("//table/tbody/tr["+row+"]/td[2]/input[1]"));
        element.click();
    }

    //dung bo check theo then type
    public void clickUnCheckEnableByNameOfType(String name){
        int row = getRowByName(name);
        if(!commonFunction.isChecked(By.xpath("//table/tbody/tr["+row+"]/td[2]/input[1]")))
            return;
        WebElement element = DriverManager.getDriver().findElement(By.xpath("//table/tbody/tr["+row+"]/td[2]/input[1]"));
        element.click();
    }
}
