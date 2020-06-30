import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private WebDriver chromeDriver;

    public RegistrationPage(WebDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
    }

    private By fieldName = By.xpath("//input[@id='name']");
    private By errorFieldName = By.xpath("//div[text()='Напишите имя кириллицей']");
    private By fieldEmail = By.xpath("//input[@id='email']");
    private By errorFieldEmail = By.xpath("//div[contains(text(),', info@av.by')]");
    private By fieldPassword = By.xpath("//input[@id='password']");
    private By errorFieldPassword = By.xpath("//div[@class='toggle-password']//div[@class='error-message']");
    private By signUpButton = By.xpath("//button[@class='button button--primary']");
    private By headingRegistrationPage = By.xpath("//h1[@class='flyer__title']");

    public RegistrationPage typeName(String username) {
        chromeDriver.findElement(fieldName).sendKeys(username);
        return this;
    }
    public RegistrationPage typeEmail(String Email) {
        chromeDriver.findElement(fieldEmail).sendKeys(Email);
        return this;
    }
    public RegistrationPage typePassword(String password) {
        chromeDriver.findElement(fieldPassword).sendKeys(password);
        return this;
    }
    public RegistrationPage registrationWithInvalidCreds(String username, String Email, String password) {
        this.typeName(username);
        this.typeEmail(Email);
        this.typePassword(password);
        chromeDriver.findElement(signUpButton).click();
        return new RegistrationPage(chromeDriver);
    }
    public RegistrationPage registrationWithFiguresCreds(String username, String Email, String password) {
        this.typeName(username);
        this.typeEmail(Email);
        this.typePassword(password);
        chromeDriver.findElement(signUpButton).click();
        return new RegistrationPage(chromeDriver);
    }
    public String getErrorFieldName() {
        return chromeDriver.findElement(errorFieldName).getText();
    }
    public String getErrorFieldEmail() {
        return chromeDriver.findElement(errorFieldEmail).getText();
    }
    public String getErrorFieldPassword() {
        return chromeDriver.findElement(errorFieldPassword).getText();
    }
    public String getHeadingRegistration() {
        return chromeDriver.findElement(headingRegistrationPage).getText();
    }
}