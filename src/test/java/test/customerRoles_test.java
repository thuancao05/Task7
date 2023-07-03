package test;

import core.TestListener;
import core.baseTest;
import function.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class customerRoles_test extends baseTest  {
    public common_function commonFunction;
    public login_function loginFunction;
    public dashboard_function dashboardFunction;
    public  leftMenu_function leftMenuFunction;
    public customerRoles_function customersRolesFunction;
    public addNewCustomerRole_function addNewCustomerRoleFunction;

    //Them customer role
    @Test
    public void TC_015() {
        loginFunction = new login_function();
        commonFunction = new common_function();
        loginFunction.Login();
        commonFunction.sleep(1000);
        dashboardFunction = new dashboard_function();
        leftMenuFunction = dashboardFunction.verifyDasboardPage();
        leftMenuFunction.clickNavCustomers();
        commonFunction.sleep(1000);
        leftMenuFunction.clickBtnCustomerRoles();
        commonFunction.sleep(1000);
        customersRolesFunction =  new customerRoles_function();
        customersRolesFunction.clickBtnAddNew();
        addNewCustomerRoleFunction = new addNewCustomerRole_function();
        addNewCustomerRoleFunction.inputNameRole("New Role 1");
        addNewCustomerRoleFunction.checkFreeShipping();
        addNewCustomerRoleFunction.checkTaxExempt();
        addNewCustomerRoleFunction.clickBtnSave();
        customersRolesFunction =  new customerRoles_function();
        customersRolesFunction.checkNotification("The new customer role has been added successfully.");
    }

    //kiem tra tinh nang show
    @Test
    public void TC_016() {
        loginFunction = new login_function();
        commonFunction = new common_function();
        loginFunction.Login();
        commonFunction.sleep(1000);
        dashboardFunction = new dashboard_function();
        leftMenuFunction = dashboardFunction.verifyDasboardPage();
        leftMenuFunction.clickNavCustomers();
        commonFunction.sleep(1000);
        leftMenuFunction.clickBtnCustomerRoles();
        commonFunction.sleep(1000);
        customersRolesFunction =  new customerRoles_function();
        customersRolesFunction.selectShow("7");
        customersRolesFunction.checkTotalInTable(7);
    }

    //Kiểm tra chức năng edit role
    @Test
    public void TC_017() {
        loginFunction = new login_function();
        commonFunction = new common_function();
        loginFunction.Login();
        commonFunction.sleep(1000);
        dashboardFunction = new dashboard_function();
        leftMenuFunction = dashboardFunction.verifyDasboardPage();
        leftMenuFunction.clickNavCustomers();
        commonFunction.sleep(1000);
        leftMenuFunction.clickBtnCustomerRoles();
        commonFunction.sleep(1000);
        customersRolesFunction =  new customerRoles_function();
        customersRolesFunction.clickBtnEditByNameOfRole("Guests");
        addNewCustomerRoleFunction = new addNewCustomerRole_function();
        addNewCustomerRoleFunction.checkFreeShipping();
        addNewCustomerRoleFunction.clickBtnSave();
        customersRolesFunction =  new customerRoles_function();
        customersRolesFunction.checkNotification("The customer role has been updated successfully.");
    }
    //Kiểm tra chức năng reload danh sách
    @Test
    public void TC_018() {
        loginFunction = new login_function();
        commonFunction = new common_function();
        loginFunction.Login();
        commonFunction.sleep(1000);
        dashboardFunction = new dashboard_function();
        leftMenuFunction = dashboardFunction.verifyDasboardPage();
        leftMenuFunction.clickNavCustomers();
        commonFunction.sleep(1000);
        leftMenuFunction.clickBtnCustomerRoles();
        commonFunction.sleep(1000);
        customersRolesFunction =  new customerRoles_function();
        customersRolesFunction.clickBtnReload();
    }


}
