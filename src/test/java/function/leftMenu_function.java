package function;

import page.leftMenu_page;

public class leftMenu_function {
    public leftMenu_page leftMenuPage = new leftMenu_page();
    public common_function commonFunction = new common_function();

    public void clickNavCustomers(){
        commonFunction.clicks(leftMenuPage.NavCustomers);
    }
    public void clickBtnCustomers(){
        commonFunction.clicks(leftMenuPage.btnCustomers);
    }
    public void clickBtnVendors(){
        commonFunction.clicks(leftMenuPage.btnVendors);
    }
    public void clickBtnActivityLog(){
        commonFunction.clicks(leftMenuPage.btnActivityLog);
    }
    public void clickBtnCustomerRoles(){
        commonFunction.clicks(leftMenuPage.btnCustomerRoles);
    }
    public void clickBtnActivityTypes(){
        commonFunction.clicks(leftMenuPage.btnActivityTypes);
    }
}
