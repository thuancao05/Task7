package test;

import core.TestListener;
import core.baseTest;
import function.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class customers_test extends baseTest  {
    public common_function commonFunction;
    public login_function loginFunction;
    public dashboard_function dashboardFunction;
    public  leftMenu_function leftMenuFunction;
    public customers_function customersFunction;

    //Tìm kiếm khách hàng theo email
    @Test
    public void TC_001() {
        loginFunction = new login_function();
        commonFunction = new common_function();
        loginFunction.Login();
        commonFunction.sleep(1000);

        //Chuyen huong den trang Dashboard
        dashboardFunction = new dashboard_function();
        leftMenuFunction = dashboardFunction.verifyDasboardPage();
        leftMenuFunction.clickNavCustomers();
        commonFunction.sleep(1000);
        leftMenuFunction.clickBtnCustomers();
        commonFunction.sleep(1000);

        //Chuyen huong den trang Customers
        customersFunction =  new customers_function();
        customersFunction.inputSearchEmail("admin@yourStore.com");              //Nhap email
        customersFunction.clickBtnSearch();                                         //Nhan nut Search
        commonFunction.sleep(1000);

        //Kiem tran thong tin ket qua sau khi search
        customersFunction.checkDataInTable("Name","John Smith");
        customersFunction.checkDataInTable("Email","admin@yourStore.com");
        customersFunction.checkDataInTable("Customer roles" , "Administrators, Forum Moderators, Registered");
        customersFunction.checkActive();
    }

    //Tìm kiếm khách hàng theo first name
    @Test
    public void TC_002() {
        loginFunction = new login_function();
        commonFunction = new common_function();
        loginFunction.Login();
        commonFunction.sleep(1000);

        //Chuyen huong den trang Dashboard
        dashboardFunction = new dashboard_function();
        leftMenuFunction = dashboardFunction.verifyDasboardPage();
        leftMenuFunction.clickNavCustomers();
        commonFunction.sleep(1000);
        leftMenuFunction.clickBtnCustomers();
        commonFunction.sleep(1000);

        //Chuyen huong den trang Customers
        customersFunction =  new customers_function();
        customersFunction.inputSearchFirstName("John");
        customersFunction.clickBtnSearch();
        commonFunction.sleep(1000);
        // Kiem tra ket qua sau khi search
        customersFunction.checkDataInTable("Name","John Smith");
        customersFunction.checkDataInTable("Email","admin@yourStore.com");
        customersFunction.checkDataInTable("Customer roles" , "Administrators, Forum Moderators, Registered");
        customersFunction.checkActive();
    }
    //Tìm kiếm khách hàng theo last name
    @Test
    public void TC_003() {
        loginFunction = new login_function();
        commonFunction = new common_function();
        loginFunction.Login();
        commonFunction.sleep(1000);

        //Chuyen huong den trang Dashboard
        dashboardFunction = new dashboard_function();
        leftMenuFunction = dashboardFunction.verifyDasboardPage();
        leftMenuFunction.clickNavCustomers();
        commonFunction.sleep(1000);
        leftMenuFunction.clickBtnCustomers();
        commonFunction.sleep(1000);

        //Chuyen huong den trang Customers
        customersFunction =  new customers_function();
        customersFunction.inputSearchLastName("Smith");
        customersFunction.clickBtnSearch();
        commonFunction.sleep(1000);
        // Kiem tra ket qua sau khi search
        customersFunction.checkDataInTable("Name","John Smith");
        customersFunction.checkDataInTable("Email","admin@yourStore.com");
        customersFunction.checkDataInTable("Customer roles" , "Administrators, Forum Moderators, Registered");
        customersFunction.checkActive();
    }
    //Tìm kiếm khách hàng theo date of birth
    @Test
    public void TC_004() {
        loginFunction = new login_function();
        commonFunction = new common_function();
        loginFunction.Login();
        commonFunction.sleep(1000);

        //Chuyen huong den trang Dashboard
        dashboardFunction = new dashboard_function();
        leftMenuFunction = dashboardFunction.verifyDasboardPage();
        leftMenuFunction.clickNavCustomers();
        commonFunction.sleep(1000);
        leftMenuFunction.clickBtnCustomers();
        commonFunction.sleep(1000);

        //Chuyen huong den trang Customers
        customersFunction =  new customers_function();
        customersFunction.selectSearchMonth("11");
        customersFunction.selectSearchDay("5");
        customersFunction.clickBtnSearch();
        commonFunction.sleep(1000);
        // Kiem tra ket qua sau khi search
        customersFunction.checkDataInTable("Name","Virat Kohli");
        customersFunction.checkDataInTable("Email","kiyjcycyhjc676008@gmail.com");
        customersFunction.checkDataInTable("Customer roles" , "Registered");
        customersFunction.checkDataInTable("Company name" , "Indian Cricket Team");
        customersFunction.checkActive();
    }

    //Tìm kiếm khách hàng theo date ( motnh mac dinh)
    @Test
    public void TC_005() {
        loginFunction = new login_function();
        commonFunction = new common_function();
        loginFunction.Login();
        commonFunction.sleep(1000);

        //Chuyen huong den trang Dashboard
        dashboardFunction = new dashboard_function();
        leftMenuFunction = dashboardFunction.verifyDasboardPage();
        leftMenuFunction.clickNavCustomers();
        commonFunction.sleep(1000);
        leftMenuFunction.clickBtnCustomers();
        commonFunction.sleep(1000);

        //Chuyen huong den trang Customers
        customersFunction =  new customers_function();
        customersFunction.selectSearchMonth("11");
        customersFunction.clickBtnSearch();
        commonFunction.sleep(1000);
        // Kiem tra ket qua sau khi search
        customersFunction.checkDataInTable("Name","Virat Kohli");
        customersFunction.checkDataInTable("Email","kiyjcycyhjc676008@gmail.com");
        customersFunction.checkDataInTable("Customer roles" , "Registered");
        customersFunction.checkDataInTable("Company name" , "Indian Cricket Team");
        customersFunction.checkActive();
    }
    //Tìm kiếm khách hàng theo motnh ( date mac dinh)
    @Test
    public void TC_006() {
        loginFunction = new login_function();
        commonFunction = new common_function();
        loginFunction.Login();
        commonFunction.sleep(1000);

        //Chuyen huong den trang Dashboard
        dashboardFunction = new dashboard_function();
        leftMenuFunction = dashboardFunction.verifyDasboardPage();
        leftMenuFunction.clickNavCustomers();
        commonFunction.sleep(1000);
        leftMenuFunction.clickBtnCustomers();
        commonFunction.sleep(1000);

        //Chuyen huong den trang Customers
        customersFunction =  new customers_function();
        customersFunction.selectSearchDay("5");
        customersFunction.clickBtnSearch();
        commonFunction.sleep(1000);
        // Kiem tra ket qua sau khi search
        customersFunction.checkDataInTable("Name","Virat Kohli");
        customersFunction.checkDataInTable("Email","kiyjcycyhjc676008@gmail.com");
        customersFunction.checkDataInTable("Customer roles" , "Registered");
        customersFunction.checkDataInTable("Company name" , "Indian Cricket Team");
        customersFunction.checkActive();
    }
    //Tìm kiếm khách hàng theo Registration date from
    @Test
    public void TC_007() {
        loginFunction = new login_function();
        commonFunction = new common_function();
        loginFunction.Login();
        commonFunction.sleep(1000);

        //Chuyen huong den trang Dashboard
        dashboardFunction = new dashboard_function();
        leftMenuFunction = dashboardFunction.verifyDasboardPage();
        leftMenuFunction.clickNavCustomers();
        commonFunction.sleep(1000);
        leftMenuFunction.clickBtnCustomers();
        commonFunction.sleep(1000);

        //Chuyen huong den trang Customers
        customersFunction =  new customers_function();
        customersFunction.selectSearchRegistrationDateFrom("7/1/2016");
        customersFunction.clickBtnSearch();
        commonFunction.sleep(1000);
        // Kiem tra ket qua sau khi search
        customersFunction.checkTotalInTable(7);
    }
    //Tìm kiếm khách hàng theo Registration date to
    @Test
    public void TC_008() {
        loginFunction = new login_function();
        commonFunction = new common_function();
        loginFunction.Login();
        commonFunction.sleep(1000);

        //Chuyen huong den trang Dashboard
        dashboardFunction = new dashboard_function();
        leftMenuFunction = dashboardFunction.verifyDasboardPage();
        leftMenuFunction.clickNavCustomers();
        commonFunction.sleep(1000);
        leftMenuFunction.clickBtnCustomers();
        commonFunction.sleep(1000);

        //Chuyen huong den trang Customers
        customersFunction =  new customers_function();
        customersFunction.selectSearchRegistrationDateTo("2/24/2023");
        customersFunction.clickBtnSearch();
        commonFunction.sleep(1000);
        // Kiem tra ket qua sau khi search
        customersFunction.checkTotalInTable(7);
    }

    //Tìm kiếm khách hàng theo Last activity from
    @Test
    public void TC_009() {
        loginFunction = new login_function();
        commonFunction = new common_function();
        loginFunction.Login();
        commonFunction.sleep(1000);

        //Chuyen huong den trang Dashboard
        dashboardFunction = new dashboard_function();
        leftMenuFunction = dashboardFunction.verifyDasboardPage();
        leftMenuFunction.clickNavCustomers();
        commonFunction.sleep(1000);
        leftMenuFunction.clickBtnCustomers();
        commonFunction.sleep(1000);

        //Chuyen huong den trang Customers
        customersFunction =  new customers_function();
        customersFunction.selectSearchLastActivityFrom("7/13/2019");
        customersFunction.clickBtnSearch();
        commonFunction.sleep(1000);
        // Kiem tra ket qua sau khi search
        customersFunction.checkTotalInTable(2);
    }
    //Tìm kiếm khách hàng theo Last activity to
    @Test
    public void TC_010() {
        loginFunction = new login_function();
        commonFunction = new common_function();
        loginFunction.Login();
        commonFunction.sleep(1000);

        //Chuyen huong den trang Dashboard
        dashboardFunction = new dashboard_function();
        leftMenuFunction = dashboardFunction.verifyDasboardPage();
        leftMenuFunction.clickNavCustomers();
        commonFunction.sleep(1000);
        leftMenuFunction.clickBtnCustomers();
        commonFunction.sleep(1000);

        //Chuyen huong den trang Customers
        customersFunction =  new customers_function();
        customersFunction.selectSearchLastActivityTo("3/5/2020");
        customersFunction.clickBtnSearch();
        commonFunction.sleep(1000);
        // Kiem tra ket qua sau khi search
        customersFunction.checkTotalInTable(5);
    }
    //Tìm kiếm khách hàng theo company
    @Test
    public void TC_011() {
        loginFunction = new login_function();
        commonFunction = new common_function();
        loginFunction.Login();
        commonFunction.sleep(1000);

        //Chuyen huong den trang Dashboard
        dashboardFunction = new dashboard_function();
        leftMenuFunction = dashboardFunction.verifyDasboardPage();
        leftMenuFunction.clickNavCustomers();
        commonFunction.sleep(1000);
        leftMenuFunction.clickBtnCustomers();
        commonFunction.sleep(1000);

        //Chuyen huong den trang Customers
        customersFunction =  new customers_function();
        customersFunction.inputSearchCompany("Indian Cricket Team");
        customersFunction.clickBtnSearch();
        commonFunction.sleep(1000);
        // Kiem tra ket qua sau khi search
        customersFunction.checkDataInTable("Name","Virat Kohli");
        customersFunction.checkDataInTable("Email","kiyjcycyhjc676008@gmail.com");
        customersFunction.checkDataInTable("Customer roles" , "Registered");
        customersFunction.checkDataInTable("Company name" , "Indian Cricket Team");
        customersFunction.checkActive();
    }
    //Tìm kiếm khách hàng theo ip address
    @Test
    public void TC_012() {
        loginFunction = new login_function();
        commonFunction = new common_function();
        loginFunction.Login();
        commonFunction.sleep(1000);

        //Chuyen huong den trang Dashboard
        dashboardFunction = new dashboard_function();
        leftMenuFunction = dashboardFunction.verifyDasboardPage();
        leftMenuFunction.clickNavCustomers();
        commonFunction.sleep(1000);
        leftMenuFunction.clickBtnCustomers();
        commonFunction.sleep(1000);

        //Chuyen huong den trang Customers
        customersFunction =  new customers_function();
        customersFunction.inputSearchIPAddress("172.71.210.202");       // nhap ip can tim
        customersFunction.clickBtnSearch();                                 // nhan search
        commonFunction.sleep(1000);
        //Kiem tra ket qua sau khi search
        customersFunction.checkNoDataInTable();
    }

    //Tìm kiếm khách hàng theo 1 customer role
    @Test
    public void TC_013() {
        loginFunction = new login_function();
        commonFunction = new common_function();
        loginFunction.Login();
        commonFunction.sleep(1000);

        //Chuyen huong den trang Dashboard
        dashboardFunction = new dashboard_function();
        leftMenuFunction = dashboardFunction.verifyDasboardPage();
        leftMenuFunction.clickNavCustomers();
        commonFunction.sleep(1000);
        leftMenuFunction.clickBtnCustomers();
        commonFunction.sleep(1000);

        //Chuyen huong den trang Customers
        customersFunction =  new customers_function();
        customersFunction.clickCloseRegistered();                       //tat role mac dinh
        customersFunction.selectRoleAdministrators();               // chon role admin
        customersFunction.clickBtnSearch();                             // nhan search
        commonFunction.sleep(1000);
        //Kiem tra ket qua sau khi search
        customersFunction.checkRoleInTable("Customer roles", "Administrators");
    }
    //Tìm kiếm khách hàng theo nhieu customer role
    @Test
    public void TC_014() {
        loginFunction = new login_function();
        commonFunction = new common_function();
        loginFunction.Login();
        commonFunction.sleep(1000);

        //Chuyen huong den trang Dashboard
        dashboardFunction = new dashboard_function();
        leftMenuFunction = dashboardFunction.verifyDasboardPage();
        leftMenuFunction.clickNavCustomers();
        commonFunction.sleep(1000);
        leftMenuFunction.clickBtnCustomers();
        commonFunction.sleep(1000);

        //Chuyen huong den trang Customers
        customersFunction =  new customers_function();
        customersFunction.clickCloseRegistered();               //xoa role mac dinh
        customersFunction.selectRoleVendors();                  //chon role Vendors
        customersFunction.selectRoleForumModerators();          // chon role Forum Moderators
        customersFunction.clickBtnSearch();                     //Nhan nut search
        commonFunction.sleep(1000);

        // Kiem tra ket qua sau khi search
        customersFunction.checkRoleInTable("Customer roles", "Registered");
        customersFunction.checkRoleInTable("Customer roles", "Forum Moderators");
    }

}
