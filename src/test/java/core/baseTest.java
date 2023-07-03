package core;

import driver.DriverFactory;
import driver.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import keywords.WebUI;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ThreadGuard;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class baseTest {

    public WebDriver driver;
    @BeforeMethod
    public void setUp() {
        ThreadGuard.protect(new DriverFactory().createDriver());
        WebUI.openURL("https://admin-demo.nopcommerce.com/login");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        DriverManager.quit();
    }
    @AfterMethod
    public void takeScreenshot(ITestResult result) {
        //take screen shot when testcase fail
        if(ITestResult.FAILURE == result.getStatus()){
            try {
                String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
                //Tao tham chieu cua TakeScreenShot voi driver hien tai
                TakesScreenshot ts = (TakesScreenshot) driver;
                // Goi ham capture screenshoot - getScreenshotAs
                File source = ts.getScreenshotAs(OutputType.FILE);
                //Kiem tra folder ton tai khong. Neu chua co thi tao moi
                File theDir = new File("./ScreenShot/");
                if (!theDir.exists())
                    theDir.mkdirs();
                // gan ten cua testcase cho ten hinh
                FileHandler.copy(source, new File("./ScreenShot/" + result.getName()+ "-" + date + ".png"));
                System.out.println("Screenshot taken: " + result.getName());
            }catch (Exception e){
                System.out.println("Exception while taking screenshot " + e.getMessage());
            }
        }
    }
//    @AfterMethod
//    public void checkAfterMethod(ITestResult result) {
//        //Bắt trạng thái hoặc tên Test case sau khi chạy xong để xử lý gì đó
//        if (ITestResult.FAILURE == result.getStatus()) {
//            System.out.println(result.getName() + " failed");
//        }
//        else if(ITestResult.SUCCESS == result.getStatus()){
//            System.out.println(result.getName() + " passed");
//        }
//        else{
//            System.out.println(result.getName() + " skipped");
//        }
//    }
}
