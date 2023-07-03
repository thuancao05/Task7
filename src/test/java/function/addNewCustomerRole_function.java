package function;

import page.addNewCustomerRole_page;

public class addNewCustomerRole_function {
    common_function commonFunction = new common_function();
    addNewCustomerRole_page addNewCustomerRolePage = new addNewCustomerRole_page();

    public void clickBtnSave(){
        commonFunction.clicks(addNewCustomerRolePage.btnSave);
    }

    public void inputNameRole(String str){
        commonFunction.sendKeys(addNewCustomerRolePage.txtName, str);
    }

    public void checkFreeShipping(){
        commonFunction.clicks(addNewCustomerRolePage.checkFreeShipping);
    }
    public void checkTaxExempt(){
        commonFunction.clicks(addNewCustomerRolePage.checkTaxExempt);
    }
}
