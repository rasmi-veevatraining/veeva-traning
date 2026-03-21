package GrandExam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Ques3 {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.out.println("Opening Browser...");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        
        driver.get("https://opensource-demo.orangehrmlive.com/");
        System.out.println("Website opened!");
    }

    @Test
    public void loginTest() throws InterruptedException {
        System.out.println("Running Login Test...");

       
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");

  
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");

     
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Thread.sleep(3000); 

       
        boolean dashboardVisible = driver.findElement(By.xpath("//h6[text()='Dashboard']")).isDisplayed();

        System.out.println("Dashboard Visible: " + dashboardVisible);
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Closing Browser...");
        driver.quit();
        System.out.println("Browser Closed!");
    }
}
