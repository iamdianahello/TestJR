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

public class MainPageTest {
    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\8\\IdeaProjects\\TestJR\\drivers\\geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary(new FirefoxBinary(new File("C:\\Program Files\\Firefox Developer Edition\\firefox.exe")));
        driver = new FirefoxDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://javarush.ru/");
        mainPage = new MainPage(driver);
    }

    @Test
    public void signUpTest() {
        SignUp signUp = mainPage.clickBeginEducation();
        Assert.assertEquals("Регистрация", signUp.getHeadingText());
    }

    @Test
    public void incorrectEmailTest() {
        SignUp signUp = mainPage.clickBeginEducation();
        signUp.signNameEmailPass("diana", "wrongEmailFormat", "pass");
        Assert.assertEquals("Проверьте правильность ввода почты", signUp.getIncorrectEmailText());
    }

    @After
    public void tearDown() {
        driver.quit();

    }
}
