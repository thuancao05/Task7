package function;

import page.leftMenu_page;

public class leftMenu_function {
    public leftMenu_page leftMenuPage = new leftMenu_page();
    public common_function commonFunction = new common_function();

    //click chuyen huong den thanh dieu huong customer
    public void clickNavCustomers(){
        commonFunction.clicks(leftMenuPage.NavCustomers);
    }

    //click chuyen huong den trang customer
    public void clickBtnCustomers(){
        commonFunction.clicks(leftMenuPage.btnCustomers);
    }

    //click chuyen huong den trang vendors
    public void clickBtnVendors(){
        commonFunction.clicks(leftMenuPage.btnVendors);
    }

    //click chuyen huong den trang activity log
    public void clickBtnActivityLog(){
        commonFunction.clicks(leftMenuPage.btnActivityLog);
    }

    //click chuyen huong den trang customer roles
    public void clickBtnCustomerRoles(){
        commonFunction.clicks(leftMenuPage.btnCustomerRoles);
    }

    //click chuyen huong den trang activity type
    public void clickBtnActivityTypes(){
        commonFunction.clicks(leftMenuPage.btnActivityTypes);
    }
}
