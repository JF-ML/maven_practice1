package StepDefinitions;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
public class LoginFeatures {
	private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
//	@Given("browser is open")
//	public void browser_is_open() {
//		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jorge Marquez\\Desktop\\Escuela\\chromedriver.exe");
//		    driver = new ChromeDriver();
//		    baseUrl = "https://www.google.com/";
//		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//	}
//
//	@Given("user is in google")
//	public void user_is_in_google() {
//		driver.get("https://www.google.com/");
//	}
//	
//	@When("^user enters (.*)$")
//	public void user_enters_word(String word) {
//		driver.get("https://www.google.com/");
//	    driver.findElement(By.name("q")).clear();
//	    driver.findElement(By.name("q")).sendKeys(word);
//	    driver.findElement(By.id("tsf")).submit();
//	}
//
//	@When("user press enter")
//	public void user_press_enter() {
//		driver.findElement(By.id("tsf")).submit();
//	}
//
//	@Then("browser shows page")
//	public void browser_shows_page() {
//	  	
//		driver.findElement(By.id("result-stats")).isDisplayed();
//		driver.close();
//		driver.quit();
//	}
}
