package test;



import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.openqa.selenium.winium.WiniumDriverService;


public class CalculatorApp {

		WiniumDriver driver;
		 String calcPath = "C:\\Windows\\System32\\calc.exe";
		 String winiumDriverPath = "F:\\Winium\\Winium.Desktop.Driver.exe";
		 
		public WiniumDriver setupEnvironment() throws IOException {			    
		    DesktopOptions options = new DesktopOptions(); //Initiate Winium Desktop Options
		    options.setApplicationPath(calcPath); //Set outlook application path		 
		    File drivePath = new File(winiumDriverPath); //Set winium driver path	 
		    WiniumDriverService service = new WiniumDriverService.Builder().usingDriverExecutable(drivePath).usingPort(9999).buildDesktopService();
		    service.start(); //Build and Start a Winium Driver service
		    driver = new WiniumDriver(service, options); //Start a winium driver 
		    return driver;
		}
		
		public void addNumberTest() throws InterruptedException, IOException {
			setupEnvironment();
		    Thread.sleep(5000);
		    WebElement calcFrame = driver.findElement(By.className("CalcFrame"));
		    WebElement menu = driver.findElement(By.id("MenuBar"));
		    WebElement viewMenu = menu.findElement(By.name("View"));
		    viewMenu.click();
		    viewMenu.findElement(By.name("Scientific")).click();
		    Thread.sleep(2000);
		    calcFrame.findElement(By.id("132")).click();
		    Thread.sleep(2000);
		    calcFrame.findElement(By.id("93")).click();
		    Thread.sleep(2000);
		    calcFrame.findElement(By.id("134")).click();
		    Thread.sleep(2000);
		    calcFrame.findElement(By.id("121")).click();
		    Thread.sleep(2000);
		}
		
		public static void main(String args[]) throws InterruptedException, IOException {
			CalculatorApp c = new CalculatorApp();
			c.addNumberTest();
		}
		
}
