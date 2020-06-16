import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainClass {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\IdeaProjects\\untitled\\src\\main\\resources\\drivers\\chromedriver_win32\\chromedriver.exe");
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.get("https://av.by/");
       // chromeDriver.findElement(By.xpath("//a[@class='button-n button--primary button--small button--block']")).click();
       // MainPage qqq = new MainPage(chromeDriver);

    }
}
