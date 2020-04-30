package config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import startEngine.ExcelEngine;
import utility.Contants;

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

    public static void Navigate() {
        driver.get(Contants.url);
    }

    public static void Input_Name() {
        driver.findElement(By.id("username")).sendKeys(Contants.userName);
    }

    public static void Input_Password() {
        driver.findElement(By.id("password")).sendKeys(Contants.userPassword);
    }

    public static void Auth_Button() {
        driver.findElement(By.id("auth-button")).click();
    }

    public static void Wait() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void Choose_Project() {
        Select projectList = new Select(driver.findElement(By.id("project-list")));
        projectList.selectByVisibleText(Contants.projectName);
    }

    public static void Login_Button() {
        driver.findElement(By.id("login-button")).click();
    }
}
