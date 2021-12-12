import org.junit.Assert;
import org.junit.Test;

public class getTitle extends setUp {

    @Test
    public void getTitle() {
        driver.get("http://qa.taltektc.com/");
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertTrue(title.contains("Sign In"));
    }

}
