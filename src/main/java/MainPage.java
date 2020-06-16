import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver chromeDriver;

    public MainPage(WebDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
    }

    private By login = By.xpath("//a[@class='nav__link js-open-auth-drawer']//span[@class='nav__link-text']");
    private By addCar = By.xpath("//a[@class='button-n button--primary button--small button--block']");

    public LoginPage login(){
        chromeDriver.findElement(login).click();
        return new LoginPage(chromeDriver);
    }
    public AddNewCar addCar(){
        chromeDriver.findElement(addCar).click();
        return new AddNewCar(chromeDriver);
    }
}