package page;

import org.openqa.selenium.By;

public class addNewVendor_page {
    public static By txtNameVendor = By.id("Name");
    public static By txtEmailVendor = By.id("Email");
    public static By btnSave = By.xpath("//body/div[3]/div[1]/form[1]/div[1]/div[1]/button[1]");
    public static By descripttionInOtherFrame = By.xpath("//body//p");
}
