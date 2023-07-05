package function;

import page.dashboard_page;

import javax.swing.*;

public class dashboard_function {
    private dashboard_page dashboardPage = new dashboard_page();
    common_function commonFunction = new common_function();

    //verify trang dashboard sau khi login
    public leftMenu_function verifyDasboardPage(){
        commonFunction.isDisplayed(dashboardPage.logo);
        System.out.println("Verified Dashboard Page");
        return  new leftMenu_function();
    }
}
