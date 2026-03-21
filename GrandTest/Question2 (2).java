package GrandExam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ques2 {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://ui.vision/demo/webtest/frames/");
        driver.manage().window().maximize();

        Thread.sleep(2000);

        //using index
        driver.switchTo().frame(0);
        System.out.println("switched using index");

        driver.findElement(By.name("mytext1")).sendKeys("Welcome");

        Thread.sleep(2000);
        driver.switchTo().defaultContent();

        //using name
        WebElement frame2 = driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
        driver.switchTo().frame(frame2);
        System.out.println("switched using name - frame 2");

        driver.findElement(By.name("mytext2")).sendKeys("Frame 2");

        Thread.sleep(2000);
        driver.switchTo().defaultContent();

        //using webelement
        WebElement frame3 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
        driver.switchTo().frame(frame3);
        System.out.println("switched using webelement - frame 3");

        driver.findElement(By.name("mytext3")).sendKeys("Frame 3");

        Thread.sleep(2000);
        driver.switchTo().defaultContent();

        driver.quit();
    }
}
