package capstone.insurancetesting;

import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class App 
{
    public static void main( String[] args ) throws InterruptedException, IOException
    {
    System.out.println("Script Started");	
       //initializing the web driver
    System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
    //setting properties
    ChromeOptions chromeOptions = new ChromeOptions();
	chromeOptions.addArguments("--headless");
	chromeOptions.addArguments("--disable-gpu");
	chromeOptions.addArguments("--no-sandbox");
    // open url
    System.out.println("Driver opening up the url in browser");	
    WebDriver driver = new ChromeDriver(chromeOptions);
    driver.get("http://13.233.114.71:8080/contact.html");	
    //invole implicit waits to load the page
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    System.out.println("Enter details in the form");
    //enter details
    driver.findElement(By.id("inputName")).sendKeys("Rohith");
    Thread.sleep(1000);
    driver.findElement(By.id("inputNumber")).sendKeys("1234567890");
    Thread.sleep(1000);
    driver.findElement(By.id("inputMail")).sendKeys("ro@roro.com");
    Thread.sleep(1000);
    driver.findElement(By.id("inputMessage")).sendKeys("Hi friends");
    Thread.sleep(1000);
    driver.findElement(By.id("my-button")).click();
    Thread.sleep(1000);
    String response = driver.findElement(By.id("response")).getText();
    System.out.println(response);
    Thread.sleep(1000);
    System.out.println("test scrpits are executed");
    TakesScreenshot scrShot = ((TakesScreenshot)driver);
    File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
    File destFile = new File("/home/ubuntu/sel-test.jpg");
    FileUtils.copyFile(srcFile, destFile);
    Thread.sleep(1000);
    driver.quit();
    }
}
