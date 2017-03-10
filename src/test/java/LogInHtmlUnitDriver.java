import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import static java.util.concurrent.TimeUnit.SECONDS;



public class LogInHtmlUnitDriver {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new HtmlUnitDriver();
        //driver.setJavascriptEnabled(true);
    }

    @Test
    public void login() throws Exception{

        driver.get("https://192.168.100.26/");

        WebElement username = driver.findElement(By.xpath(".//*[@id='Username']"));
        WebElement password = driver.findElement(By.xpath(".//*[@id='Password']"));
        WebElement button = driver.findElement(By.xpath(".//*[@id='SubmitButton']"));

        username.sendKeys("EugenBorisik");
        password.sendKeys("qwerty12345");
        button.submit();

        driver.manage().timeouts().implicitlyWait(10, SECONDS);
        WebElement linkText = driver.findElement(By.xpath("//ins[text()='Sign Out']"));

        Assert.assertEquals("Sign Out",linkText.getText());
    }
}