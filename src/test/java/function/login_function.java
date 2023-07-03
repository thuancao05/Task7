package function;

import org.testng.Assert;
import page.dashboard_page;
import page.login_page;

import static keywords.WebUI.openURL;

public class login_function  {
    public login_page loginPage = new login_page();
    public common_function commonFunction = new common_function();

    // Ham verify login page
//    public void verifyLoginPage() {
//        Assert.assertTrue(commonFunction.isDisplayed(loginPage.txtUserName));
//        Assert.assertTrue(commonFunction.isDisplayed(loginPage.lblRemember));
//        Assert.assertTrue(commonFunction.isDisplayed(loginPage.txtPassWord));
//        Assert.assertTrue(commonFunction.isDisplayed(loginPage.btnLogin));
//        System.out.println("Verify Login Page");
//    }


    //ham nhap username
//    public void inputUsername(String username) {
//        commonFunction.sendKeys(loginPage.txtUserName, username);
//    }
    //hàm này dùng để nhập password
//    public void inputPassword(String pass) {
////        WebUI.setText(loginPage.txtPassWord, pass);
//
//        commonFunction.sendKeys(loginPage.txtPassWord, pass);
//    }
    //hàm này dùng để click vào nút Login
    public dashboard_function clickLoginButton() {
 //       WebUI.clickElement(loginPage.btnLogin);

        commonFunction.clicks(loginPage.btnLogin);
        return new dashboard_function();
    }

    public dashboard_page Login() {
//        verifyLoginPage();
//        inputUsername(username);
//        inputPassword(password);
        clickLoginButton();
        return new dashboard_page();
    }

}
