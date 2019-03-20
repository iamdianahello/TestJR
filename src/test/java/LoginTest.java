import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.util.concurrent.TimeUnit;


public class LoginTest {
    private WebDriver driver;
    private Login login;


    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\8\\IdeaProjects\\TestJR\\drivers\\geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary(new FirefoxBinary(new File("C:\\Program Files\\Firefox Developer Edition\\firefox.exe")));
        driver = new FirefoxDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://javarush.ru/login");
        login = new Login(driver);
    }

    @Test
    public void loginTest(){

        login.loginEmailPass("fff@f", "hkhk");
        Assert.assertEquals("Вход", login.getHeadingText());

    }

    @Test
    public void loginGoToSignUpTest(){
        login.createAccount();
        Assert.assertEquals(driver.getCurrentUrl(), "https://javarush.ru/login/signup" );
    }

    @After
    public void tearDown() {
        driver.quit();

    }
}
