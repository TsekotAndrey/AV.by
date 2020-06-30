import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver chromeDriver;

    public LoginPage(WebDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
    }
    private By loginField = By.xpath("//input[@id='login']");
    private By passwordField = By.xpath("//input[@id='password']");
    private By signInButton = By.xpath("//button[@class='button button--action']");
    private By error = By.xpath("//div[@class='error-message']");
    private By headingText = By.xpath("//h1[@class='flyer__title']");
    private By headingPopularCar = By.xpath("//h4[@class='brands-title']");

    public LoginPage typeUsername(String username) {
        chromeDriver.findElement(loginField).sendKeys(username);
        return this;
    }
    public LoginPage typePassword(String password) {
        chromeDriver.findElement(passwordField).sendKeys(password);
        return this;
    }
    public LoginPage loginWithInvalidCreds(String username, String password) {
        this.typeUsername(username);
        this.typePassword(password);
        chromeDriver.findElement(signInButton).click();
        return new LoginPage(chromeDriver);
    }
    public LoginPage loginWithValidCreds(String username, String password) {
        this.typeUsername(username);
        this.typePassword(password);
        chromeDriver.findElement(signInButton).click();
        return new LoginPage(chromeDriver);
    }
    public LoginPage loginWithFiguresCredsTest(String username, String password) {
        this.typeUsername(username);
        this.typePassword(password);
        chromeDriver.findElement(signInButton).click();
        return new LoginPage(chromeDriver);
    }
    public String getErrorTest() {
        return chromeDriver.findElement(error).getText();
    }
    public String getHeadigTest() {
        return chromeDriver.findElement(headingText).getText();
    }
    public String getHeadingPopularCar() {
        return chromeDriver.findElement(headingPopularCar).getText();
    }
}
