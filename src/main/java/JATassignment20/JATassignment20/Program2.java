package JATassignment20.JATassignment20;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Program2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
	       
	       // Initialize ChromeDriver
	       WebDriver driver = new ChromeDriver();
	       
        driver.get("https://www.guvi.in");
        
        // Maximize the window
        driver.manage().window().maximize();
        
        waitForElement(4000);
        
       
        // Verify the page title for registration
        String registrationTitle = driver.getTitle();

        if (registrationTitle.equals("GUVI | Sign Up")) {
            System.out.println("Page title is as expected: " + registrationTitle);
        } else {
            System.out.println("Unexpected page title!");
        }
        
        
        //Sign Up button at the top right corner
        WebElement signUp = driver.findElement(By.xpath("//a[normalize-space()='Sign up']"));
        signUp.click(); 
        
        //Fullname
        
        WebElement nameID = driver.findElement(By.id("name"));
        nameID.sendKeys("ftestname");     
			 
                 
        //email
        WebElement emailID = driver.findElement(By.id("email"));
        emailID.sendKeys("testpk073@gmail.com");
        
                   
        //password
        WebElement passwordID = driver.findElement(By.id("password"));
        passwordID.sendKeys("Test@12345");
        
		                    
        //mobile number
        WebElement mobileID = driver.findElement(By.id("mobileNumber"));
        mobileID.sendKeys("9999999999");       
			
			             
        //Sign Up button
        WebElement signUpID = driver.findElement(By.id("signup-btn"));
        signUpID.click();
        
        
     // Check registration is success
        if(driver.findElements(By.xpath("//h1[contains(text(),'Almost Done! Check Your Inbox!')]")).size()>0)
        {
         System.out.println("User successfully registered");
        } 
        else {
            System.out.println("User registration failed");
        }
        
        driver.navigate().back();
        waitForElement(4000);
        //Login        
       try
       {
        WebElement Login = driver.findElement(By.xpath("//a[@id='login-btn']"));
        Login.click(); 
        
     // Verify the page title for login
        String loginTitle = driver.getTitle();

        if (loginTitle.equals("GUVI | Login")) {
            System.out.println("Page title is as expected: " + loginTitle);
        } else {
            System.out.println("Unexpected page title!");
        }
         
        WebElement loginEmail = driver.findElement(By.xpath("//input[@id='email']"));
        loginEmail.sendKeys("testpk073@gmail.com");    
        
        WebElement loginPwd = driver.findElement(By.xpath("//input[@id='password']"));
        loginPwd.sendKeys("Test@12345");
        
        WebElement loginBtn = driver.findElement(By.xpath("//a[@id='login-btn']"));
        loginBtn.click();
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement profileElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='gravatar-wrap']")));

        // Check if the profile element is displayed
        if (profileElement.isDisplayed()) {
            System.out.println("Login successful! Profile is displayed.");
        } else {
            System.out.println("Login failed! Profile is not displayed.");
        }
       }
       
       catch (Exception e) {
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
