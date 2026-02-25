package Veeva3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Question3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver wb=new ChromeDriver();
		wb.get("https://testautomationpractice.blogspot.com/");
		wb.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']")).sendKeys("Selenium");
		wb.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(5000);
		List<WebElement> l=wb.findElements(By.xpath("//div[@id='wikipedia-search-result-link']//a"));
		for(int i=0;i<l.size();i++)
		{
			System.out.println(l.get(i).getText());
		}

	}

}
