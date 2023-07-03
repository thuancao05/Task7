package function;

import driver.DriverManager;
import org.openqa.selenium.WebElement;
import page.addNewVendor_page;

public class addNewVendor_function {
    common_function commonFunction = new common_function();
    addNewVendor_page addNewVendorPage =  new addNewVendor_page();

    public void inputNameVendor(String str){
        commonFunction.sendKeys(addNewVendorPage.txtNameVendor, str);
    }
    public void inputEmailVendor(String str){
        commonFunction.sendKeys(addNewVendorPage.txtEmailVendor, str);
    }
    public void inputDescriptionVendor(String str){
//        commonFunction.sendKeys(addNewVendorPage.areaDescription, str);
        WebElement element = DriverManager.getDriver().findElement(addNewVendorPage.areaDescription);
        element.sendKeys(str);
    }
    public void clickBtnSave(){
        commonFunction.clicks(addNewVendorPage.btnSave);
    }
}
