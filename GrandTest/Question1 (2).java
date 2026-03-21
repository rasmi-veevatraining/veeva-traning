package GrandExam;

import java.io.FileInputStream;
import java.time.Duration;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ques1 {
    public static void main(String[] args) {

        WebDriver driver = null;

        try {
            FileInputStream fis = new FileInputStream("D:/selenium/Book1.xlsx");
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {

                Row row = sheet.getRow(i);

                
                String username = row.getCell(0).toString();
                String password = row.getCell(1).toString();

                driver.get("https://the-internet.herokuapp.com/login");

                driver.findElement(By.id("username")).clear();
                driver.findElement(By.id("username")).sendKeys(username);

                driver.findElement(By.id("password")).clear();
                driver.findElement(By.id("password")).sendKeys(password);

                
                driver.findElement(By.cssSelector("button.radius")).click();

                String message = driver.findElement(By.id("flash")).getText();

                if (message.contains("You logged into a secure area")) {
                    System.out.println("Login SUCCESS for: " + username);
                } else {
                    System.out.println("Login FAILED for: " + username);
                }

                Thread.sleep(2000);
                //driver.findElement(By.cssSelector(".button.secondary.radius")).click();
            }

            workbook.close();

        } catch (Exception e) {
            e.printStackTrace(); 
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}