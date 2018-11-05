package hybridtest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Hybridclass {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver=new org.openqa.selenium.chrome.ChromeDriver();
		driver.get("https://accounts.google.com/signin/v2/identifier?passive=1209600&continue=https%3A%2F%2Faccounts.google.com%2FManageAccount&followup=https%3A%2F%2Faccounts.google.com%2FManageAccount&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
        File xlsfile= new File("c:\\testdata\\testdata.xls");
		
		FileInputStream infile= new FileInputStream(xlsfile);
		
	    HSSFWorkbook file2=new HSSFWorkbook(infile);	
	
		HSSFSheet sheet1=file2.getSheetAt(0);
		
		String uname=sheet1.getRow(0).getCell(0).getStringCellValue();
		
		System.out.println("username"+uname);
		
		
		String pname=sheet1.getRow(0).getCell(1).getStringCellValue();
		System.out.println("password"+pname);
		
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(uname);
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/content/span")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pname);
		driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/content/span")).click();
		
		
		
		
	}

}
