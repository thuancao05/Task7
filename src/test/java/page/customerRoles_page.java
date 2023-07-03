package page;

import org.openqa.selenium.By;

public class customerRoles_page {
    public static By btnAddNew = By.xpath("//body/div[3]/div[1]/div[1]/div[1]/a[1]");
    public static By lblMessage = By.xpath("//body/div[3]/div[1]/div[1]");
    public static By cbxShow = By.xpath("//body/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/label[1]/select[1]");
    public static By rowInTable = By.xpath("//tbody/tr");
    public static By btnReload = By.xpath("//body/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[4]/div[1]/div[1]/button[1]");
    public static By lblAjaxBusy = By.id("ajaxBusy");
}
