import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {

    private WebDriver driver;

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    private By emailField = By.cssSelector("input.ng-touched");
    private By passField = By.cssSelector("div.form-group:nth-child(2) > input:nth-child(1)");
    private By buttonLogin = By.cssSelector(".button--success");
    private By heading = By.cssSelector(".auth-widget__head");
    private By createAccount = By.cssSelector(".auth-widget__sign-in > a:nth-child(1)");
    private By checkboxNotRobot = By.cssSelector(".recaptcha-checkbox-checkmark");

    public Login typeEmail(String email){
        driver.findElement(emailField).sendKeys(email);
        return this; //вернем текущую страницу
    }

    public Login typePass(String pass){
        driver.findElement(passField).sendKeys(pass);
        return this; //вернем текущую страницу
    }

    public Login loginEmailPass (String email, String pass){
        this.typeEmail(email);
        this.typePass(pass);
        driver.findElement(buttonLogin).click();
        return new Login(driver);
    }

    public String getHeadingText(){
        return driver.findElement(heading).getText();
    }

    public SignUp createAccount() {
        driver.findElement(createAccount).click();
        return new SignUp(driver);
    }

}
