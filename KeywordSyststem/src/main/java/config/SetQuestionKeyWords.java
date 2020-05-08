package config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import startEngine.ExcelEngine;
import utility.Constants;

import java.util.List;

import utility.Constants;

//"出题"相关的关键字实现
public class SetQuestionKeyWords {
    public static WebDriver driver=null;

    //页面
    public static void PageForward(){
        try {
            System.setProperty("webdriver.chrome.driver", Constants.driverUrl);
            driver= new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(Constants.url1);



            driver.findElement(By.id("username")).sendKeys(Constants.userName);
            driver.findElement(By.id("password")).sendKeys(Constants.userPassword);
            driver.findElement(By.id("auth-button")).click();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Select projectList = new Select(driver.findElement(By.id("project-list")));
            projectList.selectByVisibleText(Constants.projectName);
            driver.findElement(By.id("login-button")).click();



        } catch (Exception e) {
            e.printStackTrace();
            ExcelEngine.bResult=false;
        }
    }
    //题目管理、新增题目
    public static void ManageQuestion_Click(){
        driver.findElement(By.linkText("题目管理")).click();
    }

    public static void AddQuestion_Click(){
        driver.findElement(By.linkText("新增题目")).click();
    }

    //章节、知识点、作者、评审、质管、题目类型、题目语言
    public static void SetChapter(){
        Select chapterList = new Select(driver.findElement(By.id("chapter-select")));
        chapterList.selectByIndex(0);
    }

    public static void SetKnowledgePoint() {
        Select knowledgeList = new Select(driver.findElement(By.id("knowledge-point-select")));
        knowledgeList.selectByIndex(0);
    }

    public static void SetAuthor(){
        Select authorList = new Select(driver.findElement(By.id("author-list")));
        authorList.selectByIndex(1);
    }

    public static void SetReviewer(){
        Select reviewerList = new Select(driver.findElement(By.id("reviewer-list")));
        reviewerList.selectByIndex(2);
    }

    public static void SetQuality(){
        Select qualityList = new Select(driver.findElement(By.id("question-qa-list")));
        qualityList.selectByIndex(3);
    }

    public static void SetType(){
        Select typeList = new Select(driver.findElement(By.id("question-type-list")));
        typeList.selectByIndex(0);
    }

    public static void SetLanguage(){
        Select languageList = new Select(driver.findElement(By.id("question-language-list")));
        languageList.selectByIndex(0);
    }

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
    public static void SubmitQuestion1_Button(){
        driver.findElement(By.id("save-question-btn")).click();
    }
    public static void Choose_Question(){
        WebElement table = driver.findElement(By.id("question-mgmt-table"));
        List<WebElement> table_rows = table.findElements(By.tagName("tr"));
        WebElement question = table_rows.get(table_rows.size()-1);
        question.findElement(By.className("edit-item")).click();
    }

    public static void wait1() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
