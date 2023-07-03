package function;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import page.vendors_page;

import java.util.List;

public class vendors_function {
    common_function commonFunction = new common_function();
    vendors_page vendorsPage =  new vendors_page();

    // ham nhap search name
    public void inputSearchName(String str){
        commonFunction.sendKeys(vendorsPage.txtSearchName, str);
    }
    // ham nhap search email
    public void inputSearchEmail(String str){
        commonFunction.sendKeys(vendorsPage.txtSearchEmail, str);
    }
    // ham nhan nut search
    public void clickBtnSearch( ){
        commonFunction.clicks(vendorsPage.btnSearch);
    }

    //ham nhan nut add new
    public void clickBtnAddNewVendor(){
        commonFunction.clicks(vendorsPage.btnAddNewVendor);
    }

    public void checkNotification(String expected){
        WebElement element = DriverManager.getDriver().findElement(vendorsPage.lblMessage);
        String actual =  commonFunction.getText(element);
        expected = "×\n"+expected;
        System.out.println(actual);
        System.out.println(expected);
        Assert.assertEquals(actual, expected);
    }

    //lay so dong trung voi ten vendor
    public int getRowByNameOfVendor(String str) {
        int column = 1;                                                 // Name la cot 1 trong bang
        int rowTotal = commonFunction.getTotalRowInTable(vendorsPage.rowInTable);    //Tong so cot trong bang
        for (int i = 1; i <= rowTotal; i++) {
            WebElement element = DriverManager.getDriver().findElement(By.xpath("//table/tbody/tr[" + i + "]/td[" + column + "]"));
            commonFunction.scrollToElement(element);
            System.out.println(element.getText());
            if(str.equals(element.getText()))
                return i;
        }
        return -1;
    }
    public void clickBtnEditByNameOfVendor(String name){
        int row = getRowByNameOfVendor(name);
        WebElement element = DriverManager.getDriver().findElement(By.xpath("//table/tbody/tr["+row+"]/td[4]"));
        element.click();
    }

    public void checkDataInTable(String titleName, String data){
        commonFunction.checkDataInTable(titleName,data,vendorsPage.columnInTable, vendorsPage.rowInTable);
    }

}
