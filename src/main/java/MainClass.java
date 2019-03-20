import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.util.concurrent.TimeUnit;
import java.io.File;
import java.lang.String;
public class MainClass {

    static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\8\\IdeaProjects\\TestJR\\drivers\\geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary(new FirefoxBinary(new File("C:\\Program Files\\Firefox Developer Edition\\firefox.exe")));
        driver = new FirefoxDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://javarush.ru/");

        MainPage mainPage = new MainPage(driver);
        SignUp signUp = new SignUp(driver);
        mainPage.clickBeginEducation();
        signUp.signNameEmailPass("diana", "diana63b@yandex.ru", "PassPass");

        System.out.println(signUp.getHeadingText());

    }
}
