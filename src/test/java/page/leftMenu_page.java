package page;

import org.openqa.selenium.By;

public class leftMenu_page {    public static By btnLogin = By.xpath("//button[contains(text(),'Log in')]");
        public static By NavCustomers = By.xpath("//body/div[3]/aside[1]/div[1]/div[4]/div[1]/div[1]/nav[1]/ul[1]/li[4]/a[1]");
        public static By btnCustomers = By.xpath("//body[1]/div[3]/aside[1]/div[1]/div[4]/div[1]/div[1]/nav[1]/ul[1]/li[4]/ul[1]/li[1]/a[1]/p[1]");
        public static By btnCustomerRoles = By.xpath("//p[contains(text(),'Customer roles')]");
        public static By btnVendors = By.xpath("//p[contains(text(),'Vendors')]");
        public static By btnActivityLog = By.xpath("//p[contains(text(),'Activity log')]");
        public static By btnActivityTypes = By.xpath("//p[contains(text(),'Activity Types')]");
}
