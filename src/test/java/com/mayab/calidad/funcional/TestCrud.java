package com.mayab.calidad.funcional;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.regex.Pattern;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.Select;

public class TestCrud {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private String mail;
  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");  
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    Date date = new Date();
    DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    mail=df.format(date);
    
  }
	  
	  @Test
	  public void TestaddSucess() throws Exception {
	    driver.get("https://mern-crud.herokuapp.com/");
	    driver.findElement(By.xpath("//div[@id='root']/div/div[2]/button")).click();
	    driver.findElement(By.name("name")).click();
	    driver.findElement(By.name("name")).clear();
	    driver.findElement(By.name("name")).sendKeys("Jorge Marquez");
	    driver.findElement(By.name("email")).click();
	    driver.findElement(By.name("email")).clear();
	    driver.findElement(By.name("email")).sendKeys("jf"+mail+"@gmail.com");
	    driver.findElement(By.name("age")).click();
	    driver.findElement(By.name("age")).clear();
	    driver.findElement(By.name("age")).sendKeys("22");
	    driver.findElement(By.xpath("//div[3]/div[2]/div")).click();
	    driver.findElement(By.xpath("//div[2]/div/div[2]/div")).click();
	    driver.findElement(By.xpath("//form/button")).click();
	    pause(4000);
	    assertEquals("Successfully added!", driver.findElement(By.xpath("//div[4]/div/p")).getText());
	  }
  /*
  @Test
  public void TestaddFail() throws Exception {
	  	
	    driver.get("https://mern-crud.herokuapp.com/");
	    driver.findElement(By.xpath("//div[@id='root']/div/div[2]/button")).click();
	    driver.findElement(By.name("name")).click();
	    driver.findElement(By.name("name")).clear();
	    driver.findElement(By.name("name")).sendKeys("JM");
	    driver.findElement(By.name("email")).click();
	    driver.findElement(By.name("email")).clear();
	    driver.findElement(By.name("email")).sendKeys("jf@gmail.com");
	    driver.findElement(By.name("age")).click();
	    driver.findElement(By.name("age")).clear();
	    driver.findElement(By.name("age")).sendKeys("22");
	    driver.findElement(By.xpath("//div[3]/div[2]/div")).click();
	    driver.findElement(By.xpath("//div[2]/div/div[2]/div")).click();
	    driver.findElement(By.xpath("//form/button")).click();
	    pause(2000);
	    driver.findElement(By.name("name")).click();
	    driver.findElement(By.name("name")).clear();
	    driver.findElement(By.name("name")).sendKeys("Jose Matinez");
	    driver.findElement(By.name("email")).click();
	    driver.findElement(By.name("email")).clear();
	    driver.findElement(By.name("email")).sendKeys("jf@gmail.com");
	    driver.findElement(By.name("age")).click();
	    driver.findElement(By.name("age")).clear();
	    driver.findElement(By.name("age")).sendKeys("18");
	    driver.findElement(By.xpath("//div[3]/div[2]/div")).click();
	    driver.findElement(By.xpath("//div[2]/div/div[2]/div")).click();
	    driver.findElement(By.xpath("//form/button")).click();
	    
	    pause(5000);
	    assertEquals("That email is already taken.", driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[5]/div/p")).getText());
	  }*/
  	
	  @Test
	  public void testDelete() throws Exception {
	    driver.get("https://mern-crud.herokuapp.com/");
	    driver.findElement(By.xpath("//div[@id='root']/div/div[2]/button")).click();
	    driver.findElement(By.name("name")).click();
	    driver.findElement(By.name("name")).clear();
	    driver.findElement(By.name("name")).sendKeys("Jorge");
	    driver.findElement(By.name("email")).click();
	    driver.findElement(By.name("email")).clear();
	    driver.findElement(By.name("email")).sendKeys("jf"+mail+"@gmail.com");
	    driver.findElement(By.name("age")).click();
	    driver.findElement(By.name("age")).clear();
	    driver.findElement(By.name("age")).sendKeys("22");
	    driver.findElement(By.xpath("//div[3]/div[2]/div")).click();
	    driver.findElement(By.xpath("//div[2]/div/div[2]/div")).click();
	    driver.findElement(By.xpath("//form/button")).click();
	    driver.findElement(By.xpath("//i")).click();
	    driver.findElement(By.xpath("//div[@id='root']/div/div[2]/button")).click();
	    driver.findElement(By.name("name")).click();
	    driver.findElement(By.name("name")).clear();
	    driver.findElement(By.name("name")).sendKeys("Fernando");
	    driver.findElement(By.xpath("//form")).click();
	    driver.findElement(By.name("email")).click();
	    driver.findElement(By.name("email")).clear();
	    driver.findElement(By.name("email")).sendKeys("lopez"+mail+"@gmail.com");
	    driver.findElement(By.name("age")).click();
	    driver.findElement(By.name("age")).clear();
	    driver.findElement(By.name("age")).sendKeys("20");
	    driver.findElement(By.xpath("//div[3]/div[2]/div")).click();
	    driver.findElement(By.xpath("//div[2]/div/div[2]/div")).click();
	    driver.findElement(By.xpath("//form/button")).click();
	    driver.findElement(By.xpath("//i")).click();
	    pause(3000);
	    driver.findElement(By.xpath("//div[@id='root']/div/div[2]/table/tbody/tr/td[5]/button[2]")).click();
	    driver.findElement(By.xpath("//div[3]/button")).click();
	    pause(3000);
	    assertEquals("Jorge",driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/table/tbody/tr[1]/td[1]")).getText());

	   
	  }
	  @Test
	  public void testUpdate() throws Exception {
	    driver.get("https://mern-crud.herokuapp.com/");
	    driver.findElement(By.xpath("//div[@id='root']/div/div[2]/button")).click();
	    driver.findElement(By.name("name")).click();
	    driver.findElement(By.name("name")).clear();
	    driver.findElement(By.name("name")).sendKeys("Jorge");
	    driver.findElement(By.xpath("//form")).click();
	    driver.findElement(By.name("email")).click();
	    driver.findElement(By.name("email")).clear();
	    driver.findElement(By.name("email")).sendKeys("marquez"+mail+"@gmail.com");
	    driver.findElement(By.name("age")).click();
	    driver.findElement(By.name("age")).clear();
	    driver.findElement(By.name("age")).sendKeys("20");
	    driver.findElement(By.xpath("//div[3]/div[2]/div")).click();
	    driver.findElement(By.xpath("//div[2]/div/div[2]/div")).click();
	    driver.findElement(By.xpath("//form/button")).click();
	    driver.findElement(By.xpath("//i")).click();
	    pause(1000);
	    driver.findElement(By.xpath("//div[@id='root']/div/div[2]/table/tbody/tr/td[5]/button")).click();
	    driver.findElement(By.name("email")).click();
	    driver.findElement(By.name("email")).clear();
	    driver.findElement(By.name("email")).sendKeys("correo"+mail+"@mail.com");
	    driver.findElement(By.xpath("//form/button")).click();
	    pause(4000);
	    assertEquals("Successfully updated!",driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[4]/div/p")).getText());
	    
	  }
  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private void pause(long mils) {
	  try {
		  Thread.sleep(mils);
	  }catch(Exception e){
		  e.printStackTrace();
	  }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
