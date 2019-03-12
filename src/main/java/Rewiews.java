import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Rewiews {
    WebDriver driver;

    public Rewiews(WebDriver driver) {
        this.driver = driver;
    }

    private By authorization = By.cssSelector(".link");

    public Login clickAuthorization(){
        driver.findElement(authorization).click();
        return new Login(driver);
    }
}
