package Veeva3;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Question2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		WebDriver wb = null;
		String s=sc.next();
		switch(s.toLowerCase())
		{
		case "chrome":
			wb=new ChromeDriver();
			break;
		case "browser":
			wb=new EdgeDriver();
			break;
		case "firefox":
			wb=new FirefoxDriver();
			break;
		}
		wb.manage().window().maximize();
		Thread.sleep(5000);
		wb.quit();
		

	}

}
