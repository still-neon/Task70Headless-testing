import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.phantomjs.*;

import java.io.File;

import static java.util.concurrent.TimeUnit.SECONDS;


public class LogInPhantomJS {
    private WebDriver driver;
    private DesiredCapabilities dCaps;

    @BeforeMethod
    public void setUp() {

        dCaps = new DesiredCapabilities();
        dCaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "C:\\phantomjs\\bin\\phantomjs.exe");
        dCaps.setJavascriptEnabled(true);
        dCaps.setCapability("takesScreenshot", true);
        driver=new PhantomJSDriver(dCaps);
    }

    @Test
    public void login() throws Exception{

        driver.get("http://google.com");

        driver.manage().timeouts().implicitlyWait(10, SECONDS);

        driver = (PhantomJSDriver) new Augmenter().augment(driver);
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("D:\\screenshot_1.png"));

        //driver.manage().timeouts().implicitlyWait(10, SECONDS);
        /*
        WebElement username = driver.findElement(By.cssSelector("#Username"));
        WebElement password = driver.findElement(By.cssSelector("#Password"));
        WebElement button = driver.findElement(By.cssSelector("#SubmitButton"));

        username.sendKeys("EugenBorisik");
        password.sendKeys("qwerty12345");
        button.submit();

        driver.manage().timeouts().implicitlyWait(10, SECONDS);
        //WebElement linkText = driver.findElement(By.xpath("//ins[text()='Sign Out']"));

        //Assert.assertEquals("Sign Out",linkText.getText());*/
    }
}