import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUp {
    WebDriver driver;

    public SignUp(WebDriver driver) {
        this.driver = driver;
    }

    private By nameField = By.cssSelector("div.form-group:nth-child(1) > input:nth-child(1)");
    private By emailField = By.cssSelector("div.form-group:nth-child(2) > input:nth-child(1)");
    private By passField = By.cssSelector("div.form-group:nth-child(3) > input:nth-child(1)");
    private By buttonSignUp = By.cssSelector(".button--success");
    private By heading = By.cssSelector(".auth-widget__head");
    private By haveAccountLogin = By.cssSelector("a.link:nth-child(1)");
    private By incorrectEmail = By.cssSelector("div.hint-text:nth-child(2)");
    private By checkboxNotRobot = By.cssSelector(".recaptcha-checkbox-checkmark");

    public SignUp typeName(String name) {
        driver.findElement(nameField).sendKeys(name);
        return this;
    }

    public SignUp typeEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this; //вернем текущую страницу
    }

    public SignUp typePass(String pass) {
        driver.findElement(passField).sendKeys(pass);
        return this; //вернем текущую страницу
    }

    public SignUp signNameEmailPass(String name, String email, String pass) {
        this.typeName(name);
        this.typeEmail(email);
        this.typePass(pass);

        driver.findElement(buttonSignUp).click();
        return new SignUp(driver);
    }

    public String getHeadingText() {
        return driver.findElement(heading).getText();
    }

    public String getIncorrectEmailText() {
        return driver.findElement(incorrectEmail).getText();
    }

    public Login haveAccountlogin() {
        driver.findElement(haveAccountLogin).click();
        return new Login(driver);
    }

    public SignUp clickNotRobot() {
        driver.findElement(checkboxNotRobot).click();
        return this;
    }
}
