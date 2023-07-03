package page;

import org.openqa.selenium.By;

public class vendors_page {
    public static By txtSearchName = By.id("SearchName");
    public static By txtSearchEmail = By.id("SearchEmail");
    public static By btnSearch = By.id("search-vendors");
    public static By btnAddNewVendor = By.xpath("//body/div[3]/div[1]/div[1]/div[1]/a[1]");
    public static By rowInTable = By.xpath("//tbody/tr");
    public static By columnInTable = By.xpath("//table[1]/thead[1]/tr[1]/th");
    public static By lblMessage =By.xpath("//body/div[3]/div[1]/div[1]");
}
