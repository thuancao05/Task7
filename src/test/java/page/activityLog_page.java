package page;

import org.openqa.selenium.By;

public class activityLog_page {
    public static By txtCreatedOnFrom = By.id("CreatedOnFrom");
    public static By txtCreatedOnTo = By.id("CreatedOnTo");
    public static By cbxActivityLogType = By.id("ActivityLogTypeId");
    public static By txtIPAddress = By.id("IpAddress");
    public static By btnSearch = By.id("search-log");

    public static By btnDeleteFirstRow = By.xpath("//tbody/tr[1]/td[6]/a[1]");

    public static By rowInTable = By.xpath("//tbody/tr");
    public static By columnInTable = By.xpath("//table[1]/thead[1]/tr[1]/th");
    public static By lblTotalInTable = By.id("activityLog-grid_info");
}
