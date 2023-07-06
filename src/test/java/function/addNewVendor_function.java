package function;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import page.addNewVendor_page;

import javax.swing.*;

import static driver.DriverManager.getDriver;

public class addNewVendor_function {
    common_function commonFunction = new common_function();
    addNewVendor_page addNewVendorPage =  new addNewVendor_page();

    //nhap name vendor
    public void inputNameVendor(String str){
        commonFunction.sendKeys(addNewVendorPage.txtNameVendor, str);
    }

    //nhap email vendor
    public void inputEmailVendor(String str){
        commonFunction.sendKeys(addNewVendorPage.txtEmailVendor, str);
    }

    // nhap description vendor
    public void inputDescriptionVendor(String str){
        DriverManager.getDriver().switchTo().frame("Description_ifr");              //chuyen sang frame con
        WebElement element = DriverManager.getDriver().findElement(addNewVendorPage.descripttionInOtherFrame);
        element.clear();
        element.sendKeys(str);

        DriverManager.getDriver().switchTo().parentFrame();     // tro ve frame cha
    }

    //nhan nut save
    public void clickBtnSave(){
        commonFunction.clicks(addNewVendorPage.btnSave);
    }
}
