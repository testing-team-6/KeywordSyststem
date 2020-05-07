package config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import startEngine.ExcelEngine;
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

    public static void SetQuestionStart(){
        driver.findElement(By.id("submit-n-transit-btn")).click();

        WebElement ul = driver.findElement(By.id("transition-dropdown"));
        ul.findElement(By.cssSelector("li ~ li")).click();
    }

    public static void Confirm(){
        driver.findElement(By.id("f4b5cb8e-41e6-4093-ac71-dc5358cff07a")).click();
    }

    public static void SubmitQuestion_Button(){
        driver.findElement(By.id("save-question-btn")).click();
    }

}
