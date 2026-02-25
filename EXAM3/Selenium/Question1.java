package Veeva3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Question1 {
	public static void main(String args[]) throws InterruptedException
	{
		WebDriver wb=new ChromeDriver();
		wb.get("https://sves.org.in/ecap/Default.aspx?ReturnUrl=%2fecap");
		wb.findElement(By.xpath("//input[@id='txtId2']")).sendKeys("22A81A05H4");
		wb.findElement(By.xpath("//input[@id='txtPwd2']")).sendKeys("Srivasavi");
		wb.findElement(By.xpath("//input[@id='imgBtn2']")).click();
		Thread.sleep(5000);
		wb.quit();
		
	}
}
