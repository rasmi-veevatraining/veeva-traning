package Veeva3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Question4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver wb=new ChromeDriver();
		wb.get("https://www.google.com");
		String s=wb.getTitle();
		if(s.equals("Google"))
		{
			System.out.println("passed");
		}
		else
			System.out.println("Failed");
		String s1=wb.getCurrentUrl();
		if(s1.contains("google.co.in"))
			System.out.println("passed it is redirecting");
		else 
			System.out.println("Failed it is not redirecting");


	}

}
