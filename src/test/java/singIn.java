import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class singIn extends setUp{

    @Test
    public void singIn() throws InterruptedException {
        driver.get("http://qa.taltektc.com/home/login");
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.name("email"))).sendKeys("fardinhasan121@gmail.com");
        wait.until(ExpectedConditions.elementToBeClickable(By.name("password"))).sendKeys("Fardin243@");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='submit']"))).click();

        //show status successful
        Boolean status = driver.findElement(By.id(("profile_form"))).isDisplayed();
        Assert.assertEquals(true, status);
    }
}
