package com.project.NHSBSA.stepdefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import envReader.EnvReader;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.File;
import java.io.IOException;


public class Hooks
{
    public static WebDriver driver;
    public static String OS;
    public static String browser;
    
    Scenario scenario;


    @Before
    public void beforeStartUp(Scenario scenario) throws IOException
    {
    	OS = System.getProperty("os_name");
    	browser = System.getProperty("browser_name");
    	
    	System.out.println(" OS "+System.getProperty("os_name"));
    	System.out.println(" browser "+System.getProperty("browser_name"));
    	
    	if (OS.equalsIgnoreCase("MAC"))
    	{
    		if (browser.equalsIgnoreCase("chrome"))
            {
    			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//" + EnvReader.getProperty("mac_chrome"));
    	        driver = new ChromeDriver();
    	        driver.manage().window().maximize();
            }
    		
    		else if (browser.equalsIgnoreCase("firefox"))
    		{
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
    		}
    	}
    	
    	else if (OS.equalsIgnoreCase("Windows"))
    	{
    		if (browser.equalsIgnoreCase("chrome"))
            {
    			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//" + EnvReader.getProperty("windows_chrome"));
    	        driver = new ChromeDriver();
    	        driver.manage().window().maximize();
            }
    		
    		else if (browser.equalsIgnoreCase("firefox"))
    		{
                driver = new FirefoxDriver();
                driver.manage().window().fullscreen();
    		}
    	}
  }


    @After
    public void after (Scenario scenario) throws IOException
    {
        // ---------- Takes screenshot if Scenario Fails  -------------------- //
        if (scenario.isFailed() )
        {
            File scrFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try {
                   FileUtils.copyFile(scrFile, new File("target/site/screenshots/"+scenario.getName()+".png"));
                }
                catch (IOException e)
                {
                  e.printStackTrace();
                }

            // Embend the screenshot if test failes
            try {
                  scenario.write("Current Page URL is " + driver.getCurrentUrl());
                  // byte[] screenshot = getScreenshotAs(OutputType.BYTES);
                  byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
                  scenario.embed(screenshot, "image/png");
                }
             catch (WebDriverException somePlatformsDontSupportScreenshots)
             {
                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
             }
        }
        
       driver.quit();
     }

}
