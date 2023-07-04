package function;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import page.customers_page;
import page.leftMenu_page;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class customers_function {
    public customers_page customersPage = new customers_page();
    public common_function commonFunction = new common_function();


    // ham click search
    public void clickBtnSearch(){
        commonFunction.clicks(customersPage.btnSearch);
    }

    //ham nhap email search
    public void inputSearchEmail(String str){
        commonFunction.sendKeys(customersPage.txtSearchEmail, str);
    }
    //ham nhap first name search
    public void inputSearchFirstName(String str){
        commonFunction.sendKeys(customersPage.txtSearchFirstName, str);
    }
    //ham nhap last name search
    public void inputSearchLastName(String str){
        commonFunction.sendKeys(customersPage.txtSearchLastName, str);
    }
    //ham nhap month search
    public void selectSearchMonth(String month){
        WebElement cbxElement = DriverManager.getDriver().findElement(customersPage.cbxSearchMonth);
        Select selectShowAll = new Select(cbxElement);
        selectShowAll.selectByValue(month);
    }
    //ham nhap day search
    public void selectSearchDay(String day){
        WebElement cbxElement = DriverManager.getDriver().findElement(customersPage.cbxSearchDay);
        Select selectElement = new Select(cbxElement);
        selectElement.selectByValue(day);
    }

    //ham nhap Registration Date From search
    public void selectSearchRegistrationDateFrom(String str){
        commonFunction.sendKeys(customersPage.txtSearchRegistrationDateFrom, str);
    }
    //ham nhap Registration Date To search
    public void selectSearchRegistrationDateTo(String str){
        commonFunction.sendKeys(customersPage.txtSearchRegistrationDateTo, str);
    }
    //ham nhap Last activity From search
    public void selectSearchLastActivityFrom(String str){
        commonFunction.sendKeys(customersPage.txtSearchLastActivityFrom, str);
    }
    //ham nhap last activity to search
    public void selectSearchLastActivityTo(String str){
        commonFunction.sendKeys(customersPage.txtSearchLastActivityTo, str);
    }
    //ham nhap company search
    public void inputSearchCompany(String str){
        commonFunction.sendKeys(customersPage.txtSearchCompany, str);
    }
    //ham nhap ip address search
    public void inputSearchIPAddress(String str){
        commonFunction.sendKeys(customersPage.txtSearchIpAddress, str);
    }

    //ham click close registered
    public void clickCloseRegistered(){
        commonFunction.clicks(customersPage.btnCloseRegistered);
    }

    //ham chon customer role
    public void selectRoleVendors(){
        commonFunction.clicks(customersPage.cbxSearchCustomerRoles);
        commonFunction.clicks(customersPage.btnVendorsRole);
    }
    // chon role AdministratorsRole
    public void selectRoleAdministrators(){
        commonFunction.clicks(customersPage.cbxSearchCustomerRoles);
        commonFunction.clicks(customersPage.btnAdministratorsRole);
    }

    //chon role Forum Moderators
    public void selectRoleForumModerators(){
        commonFunction.clicks(customersPage.cbxSearchCustomerRoles);
        commonFunction.clicks(customersPage.btnForumModeratorsRole);

    }

    //kiem tra du lieu data theo cot
    public void checkDataInTable(String titleName, String data){
        commonFunction.checkDataInTable(titleName,data,customersPage.columnInTable, customersPage.rowInTable);
    }
    //kiem tra  tong so hang trong bang
    public void checkTotalInTable(int total){
        Assert.assertEquals(commonFunction.getTotalRowInTable(customersPage.rowInTable), total);
    }

    //Kiem tra cot active
    public void checkActive(){
        for(int i = 1; i<= commonFunction.getTotalRowInTable(customersPage.rowInTable) ; i++){
            WebElement element = DriverManager.getDriver().findElement(By.xpath("//tbody/tr["+i+"]/td[6]/i[1]"));
            String actual = commonFunction.getAttribute("nop-value", element);
            String expected = "true";
            Assert.assertEquals(actual,expected);
        }
    };
    //kiem tra role co ton tai trong table khong
    public void checkRoleInTable(String titleName, String role){
        for(int i = 1; i<= commonFunction.getTotalRowInTable(customersPage.rowInTable) ; i++){
            WebElement element = DriverManager.getDriver().findElement(By.xpath("//tbody/tr["+i+"]/td[4]"));
            String roles = element.getText();
            String[] output = roles.split(", ");
            for(int j = 0; j<= output.length; j++){
                if(role.equals(output[j]))
                    break;
            }
        }
    }

    //Kiem tra search khong tim thay
    public void checkNoDataInTable(){
        WebElement element = DriverManager.getDriver().findElement(customersPage.lblNoDataInTable);
        commonFunction.scrollToElement(element);
        Assert.assertEquals(commonFunction.getText(element), "No data available in table");
    }

}
