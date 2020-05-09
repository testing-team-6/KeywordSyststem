package config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import startEngine.ExcelEngine;
import utility.Constants;

//“登陆”相关的关键字操作实现
public class LoginKeyWords {
    public static WebDriver driver=null;
    public static void OpenBrowser(){
        try {
            System.setProperty("webdriver.chrome.driver", Constants.driverUrl);
            driver= new ChromeDriver();
            driver.manage().window().maximize();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            ExcelEngine.bResult=false;
        }
    }

    public static void Navigate() {
        try{
            driver.get(Constants.url);
        }catch (Exception e){
            e.printStackTrace();
            ExcelEngine.bResult=false;
        }
    }

    public static void Input_Name() {
        try{
            driver.findElement(By.id("username")).sendKeys(Constants.userName);
        }catch (Exception e){
            e.printStackTrace();
            ExcelEngine.bResult=false;
        }
    }

    public static void Input_Password() {
        try {
            driver.findElement(By.id("password")).sendKeys(Constants.userPassword);
        }catch (Exception e){
            e.printStackTrace();
            ExcelEngine.bResult=false;
        }

    }

    public static void Auth_Button() {
        try{
            driver.findElement(By.id("auth-button")).click();
        }catch (Exception e){
            e.printStackTrace();
            ExcelEngine.bResult=false;
        }

    }

    public static void Wait() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void Choose_Project() {
        try {
            Select projectList = new Select(driver.findElement(By.id("project-list")));
            projectList.selectByVisibleText(Constants.projectName);
        }catch (Exception e){
            e.printStackTrace();
            ExcelEngine.bResult=false;
        }
    }

    public static void Login_Button() {
        try {
            driver.findElement(By.id("login-button")).click();
        }catch (Exception e){
            e.printStackTrace();
            ExcelEngine.bResult=false;
        }
    }
}
