import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class createAccount extends setUp {


    @Test
    public void singUp() throws InterruptedException {
        driver.get("http://qa.taltektc.com/home/login");
        wait = new WebDriverWait(driver, 10);

        //goto the link and find create account page
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Create new account')]"))).sendKeys(Keys.ENTER);
        Boolean singUpPage = driver.findElement(By.tagName("legend")).isDisplayed();
        Assert.assertEquals(singUpPage, true);

        //give input first and last name into the create account page
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text'][@name='firstName']"))).sendKeys("Fardin");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text'][@name='lastName']"))).sendKeys("Arpon");

        // input an email address into the create account page
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text'][@name='email']"))).sendKeys("fardin121@gmail.com");

        //give a password and confirm the create account page
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password'][@name='password']"))).sendKeys("Fardin123");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password'][@name='confirmPassword']"))).sendKeys("Fardin123");

        //select month day and year
        //wait.until(ExpectedConditions.elementToBeClickable(By.name("month"))).click();
        Select month = new Select(driver.findElement(By.name("month")));
        month.selectByValue("11");

        Select day = new Select(driver.findElement(By.name("day")));
        day.selectByValue("15");

        Select year = new Select(driver.findElement(By.name("year")));
        year.selectByValue("2002");

        //select gender
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='radio'][@name='gender'][@id='male'][@value='male']"))).click();

        // click terms and conditions give checkmark
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#defaultCheck1"))).click();

        //click create my account button
        driver.findElement(By.xpath(("//button[contains(text(),'Create my account')]"))).click();

        //show status successful
        Boolean status = driver.findElement(By.id(("success_message"))).isDisplayed();
        Assert.assertEquals(true, status);
    }

}