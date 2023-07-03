package test;

import core.TestListener;
import core.baseTest;
import function.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.text.ParseException;

@Listeners(TestListener.class)
public class activityLog_test extends baseTest {
    public common_function commonFunction;
    public login_function loginFunction;
    public dashboard_function dashboardFunction;
    public leftMenu_function leftMenuFunction;
    public activityLog_function activityLogFunction;

    //Kiểm tra chức năng tìm kiếm bằng created from
    @Test
    public void TC_023() throws ParseException {
        loginFunction = new login_function();
        commonFunction = new common_function();
        loginFunction.Login();
        commonFunction.sleep(1000);
        dashboardFunction = new dashboard_function();
        leftMenuFunction = dashboardFunction.verifyDasboardPage();
        leftMenuFunction.clickNavCustomers();
        commonFunction.sleep(1000);
        leftMenuFunction.clickBtnActivityLog();
        commonFunction.sleep(1000);
        activityLogFunction = new activityLog_function();
        activityLogFunction.inputCreatedOnFrom("7/1/2023");
        activityLogFunction.clickBtnSearch();
        commonFunction.sleep(1500);
        activityLogFunction.checkDateInTable("Created On", "07/01/2023", "from");

    }
    //Kiểm tra chức năng tìm kiếm bằng created to
    @Test
    public void TC_024() throws ParseException {
        loginFunction = new login_function();
        commonFunction = new common_function();
        loginFunction.Login();
        commonFunction.sleep(1000);
        dashboardFunction = new dashboard_function();
        leftMenuFunction = dashboardFunction.verifyDasboardPage();
        leftMenuFunction.clickNavCustomers();
        commonFunction.sleep(1000);
        leftMenuFunction.clickBtnActivityLog();
        commonFunction.sleep(1000);
        activityLogFunction = new activityLog_function();
        activityLogFunction.inputCreatedOnTo("1/1/2022");
        activityLogFunction.clickBtnSearch();
        commonFunction.sleep(1500);
        activityLogFunction.checkDateInTable("Created On", "01/01/2022", "to");
    }

    //Kiểm tra chức năng tìm kiếm activity log type
    @Test
    public void TC_025() {
        loginFunction = new login_function();
        commonFunction = new common_function();
        loginFunction.Login();
        commonFunction.sleep(1000);
        dashboardFunction = new dashboard_function();
        leftMenuFunction = dashboardFunction.verifyDasboardPage();
        leftMenuFunction.clickNavCustomers();
        commonFunction.sleep(1000);
        leftMenuFunction.clickBtnActivityLog();
        commonFunction.sleep(1000);
        activityLogFunction = new activityLog_function();
        activityLogFunction.selectActivityLogType("Install a new plugin");
        activityLogFunction.clickBtnSearch();
        commonFunction.sleep(2000);
        activityLogFunction.checkDataInTable("Activity log type", "Install a new plugin");
    }
    //Tìm kiếm khách hàng theo IP address
    @Test
    public void TC_026() {
        loginFunction = new login_function();
        commonFunction = new common_function();
        loginFunction.Login();
        commonFunction.sleep(1000);
        dashboardFunction = new dashboard_function();
        leftMenuFunction = dashboardFunction.verifyDasboardPage();
        leftMenuFunction.clickNavCustomers();
        commonFunction.sleep(1000);
        leftMenuFunction.clickBtnActivityLog();
        commonFunction.sleep(1000);
        activityLogFunction = new activityLog_function();
        activityLogFunction.inputIPAddress("127.0.0.1");
        activityLogFunction.clickBtnSearch();
        commonFunction.sleep(2000);
        activityLogFunction.checkDataInTable("IP address", "127.0.0.1");

    }

    //Kiểm tra chức năng xóa 1 activity log
    @Test
    public void TC_027() {
        loginFunction = new login_function();
        commonFunction = new common_function();
        loginFunction.Login();
        commonFunction.sleep(1000);
        dashboardFunction = new dashboard_function();
        leftMenuFunction = dashboardFunction.verifyDasboardPage();
        leftMenuFunction.clickNavCustomers();
        commonFunction.sleep(1000);
        leftMenuFunction.clickBtnActivityLog();
        commonFunction.sleep(1000);
        activityLogFunction = new activityLog_function();
        activityLogFunction.deleteActivity();
        activityLogFunction.checkDataFirstRowInTable("Activity log type", "Delete activity log");
    }

    //Tìm kiếm khách hàng theo IP address và Activity log type
    @Test
    public void TC_028() {
        loginFunction = new login_function();
        commonFunction = new common_function();
        loginFunction.Login();
        commonFunction.sleep(1000);
        dashboardFunction = new dashboard_function();
        leftMenuFunction = dashboardFunction.verifyDasboardPage();
        leftMenuFunction.clickNavCustomers();
        commonFunction.sleep(1000);
        leftMenuFunction.clickBtnActivityLog();
        commonFunction.sleep(1000);
        activityLogFunction = new activityLog_function();
        activityLogFunction.inputIPAddress("127.0.0.1");
        activityLogFunction.selectActivityLogType("Delete a gift card");
        activityLogFunction.clickBtnSearch();
        commonFunction.sleep(2000);
        activityLogFunction.checkDataInTable("IP address", "127.0.0.1");
        activityLogFunction.checkDataInTable("Activity log type", "Delete a gift card");
    }


}
