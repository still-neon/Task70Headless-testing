import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import pageobjects.MailRuLoginPage;
import pageobjects.MailRuMailPage;
import static java.util.concurrent.TimeUnit.SECONDS;
import static openqa.selenium.OutputType.*;

public class LogIn {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();
    }

    @Test
    public void login() {

        MailRuLoginPage mailRuLoginPage = new MailRuLoginPage(driver);

        mailRuLoginPage.load();

        //screen232223

        MailRuMailPage mailRuMailPage = mailRuLoginPage.login();

        driver.manage().timeouts().implicitlyWait(10, SECONDS);

        mailRuMailPage.checkExit();

        mailRuMailPage.close();
    }
}