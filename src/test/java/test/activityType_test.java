package test;

import core.baseTest;
import function.*;
import org.testng.annotations.Test;

public class activityType_test extends baseTest {
    public common_function commonFunction;
    public login_function loginFunction;
    public dashboard_function dashboardFunction;
    public leftMenu_function leftMenuFunction;

    public activityType_function activityTypeFunction;
    //Kiểm tra chức năng Enabled
    @Test
    public void TC_029() {
        loginFunction = new login_function();
        commonFunction = new common_function();
        loginFunction.Login();
        commonFunction.sleep(1000);
        dashboardFunction = new dashboard_function();
        leftMenuFunction = dashboardFunction.verifyDasboardPage();
        leftMenuFunction.clickNavCustomers();
        commonFunction.sleep(1000);
        leftMenuFunction.clickBtnActivityTypes();
        commonFunction.sleep(1000);
        activityTypeFunction = new activityType_function();
        activityTypeFunction.clickCheckEnableByNameOfType("Public store. Add blog comment");
        activityTypeFunction.clickBtnSave();
        activityTypeFunction.checkNotification("The types have been updated successfully.");
    }

    //Kiểm tra chức năng Enabled
    @Test
    public void TC_030() {
        loginFunction = new login_function();
        commonFunction = new common_function();
        loginFunction.Login();
        commonFunction.sleep(1000);
        dashboardFunction = new dashboard_function();
        leftMenuFunction = dashboardFunction.verifyDasboardPage();
        leftMenuFunction.clickNavCustomers();
        commonFunction.sleep(1000);
        leftMenuFunction.clickBtnActivityTypes();
        commonFunction.sleep(1000);
        activityTypeFunction = new activityType_function();
        activityTypeFunction.clickCheckEnableByNameOfType("Public store. Add blog comment");
        activityTypeFunction.clickBtnSave();
        activityTypeFunction.checkNotification("The types have been updated successfully.");
    }
}
