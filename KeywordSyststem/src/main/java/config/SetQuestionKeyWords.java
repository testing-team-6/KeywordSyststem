package config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utility.Constants;

//"出题"相关的关键字实现
public class SetQuestionKeyWords {
    public static WebDriver driver=null;

    public static void Set_AuthorStartDate() {
        driver.findElement(By.id("authorStartDate")).sendKeys(Constants.authorStartDate);
    }

    public static void Set_AuthorFinishDate() {
        driver.findElement(By.id("authorFinishDate")).sendKeys(Constants.authorFinishDate);
    }

    public static void Set_ReviewStartDate() {
        driver.findElement(By.id("reviewStartDate")).sendKeys(Constants.reviewStartDate);
    }

    public static void Set_ReviewFinishDate() {
        driver.findElement(By.id("reviewFinishDate")).sendKeys(Constants.reviewFinishDate);
    }


}
