package config;
import org.openqa.selenium.chrome.ChromeDriver;
import startEngine.ExcelEngine;
import utility.Contants;
import org.openqa.selenium.WebDriver;

//“登陆”相关的关键字操作实现
public class LoginKeyWords {
    public static WebDriver driver=null;
    public static void OpenBrowser(){
        try {
            System.setProperty("webdriver.chrome.driver", Contants.driverUrl);
            driver= new ChromeDriver();
            driver.manage().window().maximize();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            ExcelEngine.bResult=false;
        }
    }
}
