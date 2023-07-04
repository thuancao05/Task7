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

        //chuyen huong den trang dashboard
        dashboardFunction = new dashboard_function();
        leftMenuFunction = dashboardFunction.verifyDasboardPage();
        leftMenuFunction.clickNavCustomers();
        commonFunction.sleep(1000);
        leftMenuFunction.clickBtnActivityLog();
        commonFunction.sleep(1000);

        //chuyen huong den trang activity log
        activityLogFunction = new activityLog_function();
        activityLogFunction.inputCreatedOnFrom("7/1/2023");     // nhan created on from
        activityLogFunction.clickBtnSearch();                       //click save
        commonFunction.sleep(1500);
        // kiem tra ket qua sau khi tim kiem
        activityLogFunction.checkDateInTable("Created On", "07/01/2023", "from");

    }
    //Kiểm tra chức năng tìm kiếm bằng created to
    @Test
    public void TC_024() throws ParseException {
        loginFunction = new login_function();
        commonFunction = new common_function();
        loginFunction.Login();
        commonFunction.sleep(1000);

        //chuyen huong den trang dashboard
        dashboardFunction = new dashboard_function();
        leftMenuFunction = dashboardFunction.verifyDasboardPage();
        leftMenuFunction.clickNavCustomers();
        commonFunction.sleep(1000);
        leftMenuFunction.clickBtnActivityLog();
        commonFunction.sleep(1000);

        //chuyen huong den trang activity log
        activityLogFunction = new activityLog_function();
        activityLogFunction.inputCreatedOnTo("1/1/2022");       // nhap created on to
        activityLogFunction.clickBtnSearch();                       // nhan nut search
        commonFunction.sleep(1500);
        // kiem tra ket qua sau khi search
        activityLogFunction.checkDateInTable("Created On", "01/01/2022", "to");
    }

    //Kiểm tra chức năng tìm kiếm activity log type
    @Test
    public void TC_025() {
        loginFunction = new login_function();
        commonFunction = new common_function();
        loginFunction.Login();
        commonFunction.sleep(1000);

        //chuyen huong den trang dashboard
        dashboardFunction = new dashboard_function();
        leftMenuFunction = dashboardFunction.verifyDasboardPage();
        leftMenuFunction.clickNavCustomers();
        commonFunction.sleep(1000);
        leftMenuFunction.clickBtnActivityLog();
        commonFunction.sleep(1000);

        //chuyen huong den trang activity log
        activityLogFunction = new activityLog_function();
        activityLogFunction.selectActivityLogType("Install a new plugin");  // chon activity type
        activityLogFunction.clickBtnSearch();                                   // nhan nut search
        commonFunction.sleep(2000);
        // kiem tra ket qua sau khi search
        activityLogFunction.checkDataInTable("Activity log type", "Install a new plugin");
    }
    //Tìm kiếm khách hàng theo IP address
    @Test
    public void TC_026() {
        loginFunction = new login_function();
        commonFunction = new common_function();
        loginFunction.Login();
        commonFunction.sleep(1000);

        //chuyen huong den trang dashboard
        dashboardFunction = new dashboard_function();
        leftMenuFunction = dashboardFunction.verifyDasboardPage();
        leftMenuFunction.clickNavCustomers();
        commonFunction.sleep(1000);
        leftMenuFunction.clickBtnActivityLog();
        commonFunction.sleep(1000);

        //chuyen huong den trang activity log
        activityLogFunction = new activityLog_function();
        activityLogFunction.inputIPAddress("127.0.0.1");        // nhap ip
        activityLogFunction.clickBtnSearch();                       // nhan nut search
        commonFunction.sleep(2000);

        // kiem tra ket qua sau khi search
        activityLogFunction.checkDataInTable("IP address", "127.0.0.1");

    }

    //Kiểm tra chức năng xóa 1 activity log
    @Test
    public void TC_027() {
        loginFunction = new login_function();
        commonFunction = new common_function();
        loginFunction.Login();
        commonFunction.sleep(1000);

        //chuyen huong den trang dashboard
        dashboardFunction = new dashboard_function();
        leftMenuFunction = dashboardFunction.verifyDasboardPage();
        leftMenuFunction.clickNavCustomers();
        commonFunction.sleep(1000);
        leftMenuFunction.clickBtnActivityLog();
        commonFunction.sleep(1000);

        //chuyen huong den trang activity log
        activityLogFunction = new activityLog_function();
        activityLogFunction.deleteActivity();               // xoa 1 activity dau tien
        // kiem tra ket qua sau khi xóa
        activityLogFunction.checkDataFirstRowInTable("Activity log type", "Delete activity log");
    }

    //Tìm kiếm khách hàng theo IP address và Activity log type
    @Test
    public void TC_028() {
        loginFunction = new login_function();
        commonFunction = new common_function();
        loginFunction.Login();
        commonFunction.sleep(1000);

        //chuyen huong den trang dashboard
        dashboardFunction = new dashboard_function();
        leftMenuFunction = dashboardFunction.verifyDasboardPage();
        leftMenuFunction.clickNavCustomers();
        commonFunction.sleep(1000);
        leftMenuFunction.clickBtnActivityLog();
        commonFunction.sleep(1000);

        //chuyen huong den trang activity log
        activityLogFunction = new activityLog_function();
        activityLogFunction.inputIPAddress("127.0.0.1");                    //nhap ip
        activityLogFunction.selectActivityLogType("Delete a gift card");    //chon activity log type
        activityLogFunction.clickBtnSearch();                                   // nhan nut search
        commonFunction.sleep(2000);

        // kiem tra ket qua sau khi search
        activityLogFunction.checkDataInTable("IP address", "127.0.0.1");
        activityLogFunction.checkDataInTable("Activity log type", "Delete a gift card");
    }


}
