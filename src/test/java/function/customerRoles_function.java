package function;

import driver.DriverManager;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import page.customerRoles_page;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class customerRoles_function {
    common_function commonFunction = new common_function();
    customerRoles_page customerRolesPage = new customerRoles_page();

    //nhan nut add new
    public void clickBtnAddNew(){
        commonFunction.clicks(customerRolesPage.btnAddNew);
    }

    //kiem tra thong bao sau khi thuc hien thao tac
    public void checkNotification(String expected){
        WebElement element = DriverManager.getDriver().findElement(customerRolesPage.lblMessage);
        String actual =  commonFunction.getText(element);
        expected = "×\n"+expected;
        System.out.println(actual);
        System.out.println(expected);
        Assert.assertEquals(actual, expected);
    }

    //chon show theo cout
    public void selectShow(String count){
        WebElement cbxElement = DriverManager.getDriver().findElement(customerRolesPage.cbxShow);
        Select selectShowAll = new Select(cbxElement);
        selectShowAll.selectByValue(count);
    }
    //lay tong so dong trong bang
    public int getTotalRowInTable(By by){
        commonFunction.scrollToElement(by);
        List<WebElement> elementList = DriverManager.getDriver().findElements(by);
        int rowTotal = elementList.size();
        System.out.println("Total Row : " + rowTotal);
        return rowTotal;
    }

    //kiem tra so dong trong bang khong duoc vuot qua show da chon
    public void checkTotalInTable(int total){
        Assert.assertTrue( !(getTotalRowInTable(customerRolesPage.rowInTable) > total));
    }

    //lay so dong trung voi ten role
    public int getRowByNameOfRole(String str) {
        int column = 1;                                                 // Name la cot 1 trong bang
        int rowTotal = getTotalRowInTable(customerRolesPage.rowInTable);    //Tong so cot trong bang
        for (int i = 1; i <= rowTotal; i++) {
            WebElement element = DriverManager.getDriver().findElement(By.xpath("//table/tbody/tr[" + i + "]/td[" + column + "]"));
            commonFunction.scrollToElement(element);
            System.out.println(element.getText());
            if(str.equals(element.getText()))
                return i;
        }
        return -1;
    }

    //nhan nut edit role bang name
    public void clickBtnEditByNameOfRole(String name){
        int row = getRowByNameOfRole(name);
        WebElement element = DriverManager.getDriver().findElement(By.xpath("//table/tbody/tr["+row+"]/td[6]"));
        element.click();
    }

    //nhan vao nut reload bang
    public void clickBtnReload(){
        commonFunction.clicks(customerRolesPage.btnReload);
        Assert.assertTrue(commonFunction.isDisplayed(customerRolesPage.lblAjaxBusy));
    }

}
