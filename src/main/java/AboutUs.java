import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AboutUs {

    WebDriver driver;

    public  AboutUs (WebDriver driver) {
        this.driver = driver;

    }

    private By rewiews = By.cssSelector("li.user-panel__slot:nth-child(1) > a:nth-child(1)");
    private By cs50 = By.cssSelector("li.user-panel__slot:nth-child(3) > a:nth-child(1)");
    private By beginEducation = By.cssSelector("#button_menu_start_learning_unauthorized_user");

    public Rewiews clickRewiews (){
        driver.findElement(rewiews).click();
        return new Rewiews(driver);
    }

    public CS50 clickCS50 (){
        driver.findElement(cs50).click();
        return new CS50(driver);
    }

    public SignUp clickBeginEducation (){
        driver.findElement(beginEducation).click();
        return new SignUp(driver);
    }
}
