
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



public class SignUpTest {
    private WebDriver driver;
    private SignUp signUp;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\8\\IdeaProjects\\TestJR\\drivers\\geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary(new FirefoxBinary(new File("C:\\Program Files\\Firefox Developer Edition\\firefox.exe")));
        driver = new FirefoxDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://javarush.ru/login/signup");
        signUp = new SignUp(driver);
    }

    @Test
    public void SignUpTest(){

        signUp.signNameEmailPass("name","fff@f", "hkhk");
        Assert.assertEquals("Регистрация", signUp.getHeadingText());

    }
    @Test
    public void SignUpToLoginTest(){
        signUp.haveAccountlogin();
        Assert.assertEquals(driver.getCurrentUrl(), "https://javarush.ru/login" );
    }

    @After
    public void tearDown() {
        driver.quit();

    }
}

