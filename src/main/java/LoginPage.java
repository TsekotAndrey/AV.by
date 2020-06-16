import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {
    private WebDriver chromeDriver;

    public LoginPage(WebDriver chromeDriver) {
                this.chromeDriver = chromeDriver;
    }
    private By loginField = By.xpath("//input[@id='login']");
    private By passwordField = By.xpath("//input[@id='password']");
    private By signInButton = By.xpath("//button[@class='button button--action']");
    private By error = By.xpath("//div[@class='error-message']");

    public LoginPage typeUsername(String username){
        chromeDriver.findElement(loginField).sendKeys(username);
        return this;
    }
    public LoginPage typePassword(String password){
        chromeDriver.findElement(passwordField).sendKeys(password);
        return this;
    }
    public LoginPage LoginWithInvalidCreds(String username, String password){
        this.typeUsername(username);
        this.typePassword(password);
        chromeDriver.findElement(signInButton).click();
        return  new LoginPage(chromeDriver);
    }
    public String getErrorTest(){
        return chromeDriver.findElement(error).getText();
    }
}
