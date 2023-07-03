package function;

import driver.DriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import page.activityLog_page;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class activityLog_function {
    common_function commonFunction = new common_function();
    activityLog_page activityLogPage = new activityLog_page();


    public void inputCreatedOnFrom(String str){
        commonFunction.sendKeys(activityLogPage.txtCreatedOnFrom, str);
    }
    public void inputCreatedOnTo(String str){
        commonFunction.sendKeys(activityLogPage.txtCreatedOnTo, str);
    }
    public void inputIPAddress(String str){
        commonFunction.sendKeys(activityLogPage.txtIPAddress, str);
    }
    public void clickBtnSearch(){
        commonFunction.clicks(activityLogPage.btnSearch);
    }
    public void selectActivityLogType(String str){
        WebElement cbxElement = DriverManager.getDriver().findElement(activityLogPage.cbxActivityLogType);
        Select selectElement = new Select(cbxElement);
        selectElement.selectByVisibleText(str);

    }

    public void deleteActivity(){
        commonFunction.clicks(activityLogPage.btnDeleteFirstRow);
        DriverManager.getDriver().switchTo().alert().accept();
        commonFunction.press(Keys.ENTER);
        commonFunction.sleep(1000);
    }


    public void checkDataInTable(String titleName, String data){
        commonFunction.checkDataInTable(titleName,data,activityLogPage.columnInTable, activityLogPage.rowInTable);
    }
    public boolean checkDataFirstRowInTable(String titleColumn, String data) {
        int column = commonFunction.getColumnByTitle(titleColumn,activityLogPage.columnInTable);
        int rowTotal = commonFunction.getTotalRowInTable(activityLogPage.rowInTable);    //Tong so cot trong bang

        WebElement element = DriverManager.getDriver().findElement(By.xpath("//table/tbody/tr[1]/td[" + column + "]"));
        commonFunction.scrollToElement(element);
        System.out.println(element.getText());
        if(!data.equals(element.getText())) {
            Assert.assertTrue(false);
            return false;
        }

        Assert.assertTrue(true);
        return true;
    }


    public boolean checkDateInTable(String titleColumn, String data, String key)  throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy"); //Để khai báo những giá trị mới trong đối tượng date mới, hãy sử dụng cùng định dạng khi tạo ngày.
            Date date1 = sdf.parse(data); //date1 ngay can search
            System.out.println(date1);

        int column = commonFunction.getColumnByTitle(titleColumn, activityLogPage.columnInTable);
        int rowTotal = commonFunction.getTotalRowInTable(activityLogPage.rowInTable);    //Tong so cot trong bang
        for (int i = 1; i <= rowTotal; i++) {
            WebElement element = DriverManager.getDriver().findElement(By.xpath("//table/tbody/tr[" + i + "]/td[" + column + "]"));
            commonFunction.scrollToElement(element);
            System.out.println(element.getText());

            Date date2 = sdf.parse(commonFunction.cutStringDate(element.getText()));
            System.out.println(date2);

            if(key.equals("from"))
                if(date1.after(date2)) {
                    Assert.assertTrue(false);
                    return false;
                }
            if(key.equals("to"))
                if(date2.after(date1)) {
                    Assert.assertTrue(false);
                    return false;
                }
        }
        Assert.assertTrue(true);
        return true;
    }

}
