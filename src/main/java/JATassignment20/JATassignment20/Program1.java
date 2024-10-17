package JATassignment20.JATassignment20;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Program1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
	       
	       // Initialize ChromeDriver
	       WebDriver driver = new ChromeDriver();
	       try
	       {
        driver.get("https://jqueryui.com/datepicker/");
        
        // Maximize the window
        driver.manage().window().maximize();
        
        waitForElement(4000);
        
        WebElement elm = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        driver.switchTo().frame(elm);
        
        WebElement datePicker = driver.findElement(By.xpath("//input[@id='datepicker']"));
        datePicker.click();
        
        WebElement nextButton = driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']"));
        nextButton.click();
        
        WebElement day22 = driver.findElement(By.xpath("//a[normalize-space()='22']"));
        day22.click();
        
        String selectedDate = datePicker.getAttribute("value"); 
        System.out.println("Selected Date: " + selectedDate);
        
        waitForElement(4000);
        driver.switchTo().defaultContent();
        
    } 
	       
	   catch(Exception e)
	       {
		// TODO Auto-generated catch block
					e.printStackTrace();
	       }   
	       
	    
		   finally {			   
        // Close the browser
	 	       driver.quit();
		   }
	       
	}

	
	   public static void waitForElement(int milliseconds)
	   {
		  try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	}


