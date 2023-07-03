package page;

import org.openqa.selenium.By;

public class customers_page {
    public static By btnSearch = By.id("search-customers");
    public static By txtSearchEmail = By.id("SearchEmail");
    public static By txtSearchFirstName = By.id("SearchFirstName");
    public static By txtSearchLastName = By.id("SearchLastName");
    public static By cbxSearchMonth = By.id("SearchMonthOfBirth");
    public static By cbxSearchDay = By.id("SearchDayOfBirth");
    public static By txtSearchRegistrationDateTo = By.id("SearchRegistrationDateTo");
    public static By txtSearchLastActivityFrom = By.id("SearchLastActivityFrom");
    public static By txtSearchRegistrationDateFrom = By.id("SearchRegistrationDateFrom");
    public static By txtSearchLastActivityTo = By.id("SearchLastActivityTo");
    public static By txtSearchCompany = By.id("SearchCompany");
    public static By txtSearchIpAddress = By.id("SearchIpAddress");

    public static By cbxSearchCustomerRoles = By.xpath("//body/div[3]/div[1]/form[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[5]/div[2]/div[1]/div[1]/input[1]");
    public static By btnVendorsRole = By.xpath("//li[contains(text(),'Vendors')]");
    public static By btnForumModeratorsRole = By.xpath("//li[contains(text(),'Forum Moderators')]");
    public static By rowInTable = By.xpath("//tbody/tr");
    public static By columnInTable = By.xpath("//table[1]/thead[1]/tr[1]/th");
    public static By btnCloseRegistered = By.xpath("//body/div[3]/div[1]/form[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[5]/div[2]/div[1]/div[1]/ul[1]/li[1]/span[2]");
}
