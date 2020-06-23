import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver chromeDriver;

    public MainPage(WebDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
    }

    private By login = By.xpath("//a[@class='nav__link js-open-auth-drawer']//span[@class='nav__link-text']");
    private By registration = By.xpath("//div[@class='flyer__foot']//a[1]");
    private By headingtext = By.xpath("//h4[@class='brands-title']");

    public LoginPage login(){
        chromeDriver.findElement(login).click();
        return new LoginPage(chromeDriver);
    }
    public RegistrationPage  registration (){
        chromeDriver.findElement(login).click();
        chromeDriver.findElement(registration).click();
        return new RegistrationPage(chromeDriver);
    }
    public String getHeadig2Test() {
        return chromeDriver.findElement(headingtext).getText();
    }
}