package function;

import page.addNewCustomerRole_page;

public class addNewCustomerRole_function {
    common_function commonFunction = new common_function();
    addNewCustomerRole_page addNewCustomerRolePage = new addNewCustomerRole_page();

    //nhan nut save
    public void clickBtnSave(){
        commonFunction.clicks(addNewCustomerRolePage.btnSave);
    }

    //nhap role name
    public void inputNameRole(String str){
        commonFunction.sendKeys(addNewCustomerRolePage.txtName, str);
    }

    //check vao free shipping
    public void checkFreeShipping(){
        commonFunction.clicks(addNewCustomerRolePage.checkFreeShipping);
    }

    // check vao tax exempt
    public void checkTaxExempt(){
        commonFunction.clicks(addNewCustomerRolePage.checkTaxExempt);
    }
}
