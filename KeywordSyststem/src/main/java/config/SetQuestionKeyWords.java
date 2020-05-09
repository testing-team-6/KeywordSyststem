package config;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
            driver.get(Constants.url);



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
        try{
            driver.findElement(By.linkText("题目管理")).click();
        }catch (Exception e) {
            e.printStackTrace();
            ExcelEngine.bResult=false;
        }
    }

    public static void AddQuestion_Click(){
        try{
            driver.findElement(By.linkText("新增题目")).click();
        }catch (Exception e) {
            e.printStackTrace();
            ExcelEngine.bResult=false;
        }
    }

    //章节、知识点、作者、评审、质管、题目类型、题目语言
    public static void SetChapter(){
        try{
            driver.findElement(By.xpath("//*[@id='select2-chapter-select-container']")).click();
            driver.findElement(By.xpath("//*[@id='select2-chapter-select-results']/li[1]")).click();
        }catch (Exception e) {
            e.printStackTrace();
            ExcelEngine.bResult=false;
        }
    }

    public static void SetKnowledgePoint() {
        try{
            driver.findElement(By.xpath("//*[@id='select2-knowledge-point-select-container']")).click();
            driver.findElement(By.xpath("//*[@id='select2-knowledge-point-select-results']/li[1]")).click();
        }catch (Exception e) {
            e.printStackTrace();
            ExcelEngine.bResult=false;
        }
    }

    public static void SetAuthor(){
        try{
            driver.findElement(By.xpath("//*[@id='select2-author-list-container']")).click();
            driver.findElement(By.xpath("//*[@id='select2-author-list-results']/li[text()='"+Constants.questionAuthor+"']")).click();
        }catch (Exception e) {
            e.printStackTrace();
            ExcelEngine.bResult=false;
        }
    }

    public static void SetReviewer(){
        try{
            driver.findElement(By.xpath("//*[@id='select2-reviewer-list-container']")).click();
            driver.findElement(By.xpath("//*[@id='select2-reviewer-list-results']/li[2]")).click();
        }catch (Exception e) {
            e.printStackTrace();
            ExcelEngine.bResult=false;
        }
    }

    public static void SetQuality(){
        try{
            driver.findElement(By.xpath("//*[@id='select2-question-qa-list-container']")).click();
            driver.findElement(By.xpath("//*[@id='select2-question-qa-list-results']/li[3]")).click();
        }catch (Exception e) {
            e.printStackTrace();
            ExcelEngine.bResult=false;
        }
    }

    public static void SetType(){
        try{
            driver.findElement(By.xpath("//*[@id='select2-question-type-list-container']")).click();
            driver.findElement(By.xpath("//*[@id='select2-question-type-list-results']/li[1]")).click();
        }catch (Exception e) {
            e.printStackTrace();
            ExcelEngine.bResult=false;
        }
    }

    public static void SetLanguage(){
        try{
            driver.findElement(By.xpath("//*[@id='select2-question-language-list-container']")).click();
            driver.findElement(By.xpath("//*[@id='select2-question-language-list-results']/li[1]")).click();
        }catch (Exception e) {
            e.printStackTrace();
            ExcelEngine.bResult=false;
        }
    }

    public static void Set_AuthorStartDate() {
        try{
            driver.findElement(By.id("authorStartDate")).sendKeys(Constants.authorStartDate);
        }catch (Exception e) {
            e.printStackTrace();
            ExcelEngine.bResult=false;
        }

    }

    public static void Set_AuthorFinishDate() {
        try{
            driver.findElement(By.id("authorFinishDate")).sendKeys(Constants.authorFinishDate);
        }catch (Exception e) {
            e.printStackTrace();
            ExcelEngine.bResult=false;
        }
    }

    public static void Set_ReviewStartDate() {
        try{
            driver.findElement(By.id("reviewStartDate")).sendKeys(Constants.reviewStartDate);
        }catch (Exception e) {
            e.printStackTrace();
            ExcelEngine.bResult=false;
        }
    }

    public static void Set_ReviewFinishDate() {
        try{
            driver.findElement(By.id("reviewFinishDate")).sendKeys(Constants.reviewFinishDate);
            driver.findElement(By.tagName("legend")).click();
        }catch (Exception e) {
            e.printStackTrace();
            ExcelEngine.bResult=false;
        }
    }

    public static void SetQuestionStart(){
        try{
            driver.findElement(By.id("submit-n-transit-btn")).click();
            driver.findElement(By.xpath("//*[@id=\"transition-dropdown\"]/li/a")).click();
        }catch (Exception e) {
            e.printStackTrace();
            ExcelEngine.bResult=false;
        }
    }

    public static void Confirm(){
        try{
            driver.findElement(By.xpath("/html/body/div[6]/div/div/div[3]/div/div/button[2]")).click();
        }catch (Exception e) {
            e.printStackTrace();
            ExcelEngine.bResult=false;
        }
    }

    public static void SubmitQuestion_Button(){
        try{
            driver.findElement(By.id("save-question-btn")).click();
        }catch (Exception e) {
            e.printStackTrace();
            ExcelEngine.bResult=false;
        }
    }

    //新建考题的提交题目
    public static void SubmitQuestion1_Button(){
        try{
            driver.findElement(By.id("save-question-btn")).click();
        }catch (Exception e) {
            e.printStackTrace();
            ExcelEngine.bResult=false;
        }
    }

    public static void Choose_Question(){
        try{
            WebElement table = driver.findElement(By.id("question-mgmt-table"));
            List<WebElement> table_rows = table.findElements(By.tagName("tr"));
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
            Thread.sleep(1000);
            table_rows.get(table_rows.size()-1).findElement(By.className("edit-item")).click();
        }catch (Exception e) {
            e.printStackTrace();
            ExcelEngine.bResult=false;
        }
    }

    public static void wait1() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
