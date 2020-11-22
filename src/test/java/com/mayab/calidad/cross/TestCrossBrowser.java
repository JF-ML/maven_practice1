package com.mayab.calidad.cross;

import org.openqa.selenium.By;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.regex.Pattern;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class TestCrossBrowser {
	
	public static final String URL= "https://jorgefer98:d18fc425-0c19-4e7d-bcb8-ffc47d780e60@ondemand.us-west-1.saucelabs.com:443/wd/hub";
	public static void main(String args[]) throws Exception {
		DesiredCapabilities caps = DesiredCapabilities.firefox();
	    caps.setCapability("platform", "Windows 10");
	    caps.setCapability("platform", "Linux");
	    caps.setCapability("platform", "macOS 10.13");
	    caps.setCapability("version", "latest");
	    caps.setCapability("name", "Firefox");
	    caps.setCapability("extendedDebugging", "true");
	    caps.setCapability("buildNumber", "3.0");
    
    
	    WebDriver driver = new RemoteWebDriver(new java.net.URL(URL), caps);
	
		
		
		
		driver.get("https://mern-crud.herokuapp.com/");
		driver.findElement(By.xpath("//div[@id='root']/div/div[2]/button")).click();
		driver.findElement(By.name("name")).click();
		driver.findElement(By.name("name")).clear();
		driver.findElement(By.name("name")).sendKeys("Jorge Marquez");
		driver.findElement(By.name("email")).click();
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys("jfmarquez98@gmail.com");
		driver.findElement(By.name("age")).click();
		driver.findElement(By.name("age")).clear();
		driver.findElement(By.name("age")).sendKeys("22");
		driver.findElement(By.xpath("//div[3]/div[2]/div")).click();
		driver.findElement(By.xpath("//div[2]/div/div[2]/div")).click();
		driver.findElement(By.xpath("//form/button")).click();
		
		driver.quit();
	}
		
}
