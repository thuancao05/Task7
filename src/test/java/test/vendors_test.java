package test;

import core.TestListener;
import core.baseTest;
import function.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class vendors_test extends baseTest {
    public common_function commonFunction;
    public login_function loginFunction;
    public dashboard_function dashboardFunction;
    public leftMenu_function leftMenuFunction;
    public vendors_function vendorsFunction;
    public addNewVendor_function addNewVendorFunction;

    //Kiểm tra tìm kiếm theo vendor name
    @Test
    public void TC_019() {
        loginFunction = new login_function();
        commonFunction = new common_function();
        loginFunction.Login();
        commonFunction.sleep(1000);
        dashboardFunction = new dashboard_function();
        leftMenuFunction = dashboardFunction.verifyDasboardPage();
        leftMenuFunction.clickNavCustomers();
        commonFunction.sleep(1000);
        leftMenuFunction.clickBtnVendors();
        commonFunction.sleep(1000);
        vendorsFunction = new vendors_function();
        vendorsFunction.inputSearchName("Vendor 1");
        vendorsFunction.clickBtnSearch();
        commonFunction.sleep(1500);
        vendorsFunction.checkDataInTable("Name","Vendor 1");
        vendorsFunction.checkDataInTable("Email","vendor1email@gmail.com");
    }
    //Kiểm tra tìm kiếm theo vendor email
    @Test
    public void TC_020() {
        loginFunction = new login_function();
        commonFunction = new common_function();
        loginFunction.Login();
        commonFunction.sleep(1000);
        dashboardFunction = new dashboard_function();
        leftMenuFunction = dashboardFunction.verifyDasboardPage();
        leftMenuFunction.clickNavCustomers();
        commonFunction.sleep(1000);
        leftMenuFunction.clickBtnVendors();
        commonFunction.sleep(1000);
        vendorsFunction = new vendors_function();
        vendorsFunction.inputSearchEmail("vendor1email@gmail.com");
        vendorsFunction.clickBtnSearch();
        commonFunction.sleep(1500);
        vendorsFunction.checkDataInTable("Name","Vendor 1");
        vendorsFunction.checkDataInTable("Email","vendor1email@gmail.com");

    }
    //Kiểm tra chức năng add new vendor
    @Test
    public void TC_021() {
        loginFunction = new login_function();
        commonFunction = new common_function();
        loginFunction.Login();
        commonFunction.sleep(1000);
        dashboardFunction = new dashboard_function();
        leftMenuFunction = dashboardFunction.verifyDasboardPage();
        leftMenuFunction.clickNavCustomers();
        commonFunction.sleep(1000);
        leftMenuFunction.clickBtnVendors();
        commonFunction.sleep(1000);
        vendorsFunction = new vendors_function();
        vendorsFunction.clickBtnAddNewVendor();
        addNewVendorFunction =  new addNewVendor_function();
        addNewVendorFunction.inputNameVendor("New Vendor 1");
        addNewVendorFunction.inputEmailVendor("newvendor1@gmail.com");
        addNewVendorFunction.clickBtnSave();
        vendorsFunction.checkNotification("For security purposes, the feature you have requested is not available on the demo site.");
    }
    //Kiểm tra chức năng add new vendor
    @Test
    public void TC_022() {
        loginFunction = new login_function();
        commonFunction = new common_function();
        loginFunction.Login();
        commonFunction.sleep(1000);
        dashboardFunction = new dashboard_function();
        leftMenuFunction = dashboardFunction.verifyDasboardPage();
        leftMenuFunction.clickNavCustomers();
        commonFunction.sleep(1000);
        leftMenuFunction.clickBtnVendors();
        commonFunction.sleep(1000);
        vendorsFunction = new vendors_function();
        vendorsFunction.clickBtnEditByNameOfVendor("Vendor 1");
        addNewVendorFunction =  new addNewVendor_function();
        commonFunction.sleep(10000);
        addNewVendorFunction.inputNameVendor("New Vendor 1");
        addNewVendorFunction.inputDescriptionVendor("Best Vendor");
        addNewVendorFunction.clickBtnSave();
        vendorsFunction.checkNotification("The vendor has been updated successfully.");
    }
}