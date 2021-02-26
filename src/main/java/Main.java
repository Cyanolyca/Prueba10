import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\lucas\\Downloads\\chromedriver.exe");

        //Creamos una nueva instancia de ChromeDriver
        WebDriver driver = new ChromeDriver();

        //Hacemos una llamada a esta página
        driver.get("https://formy-project.herokuapp.com/form");

        submitForm(driver);
        waitforAlertBanner(driver);

        assertEquals("The form was successfully submitted!", getAlertBannerTest(driver));

    }

    public static void submitForm(WebDriver driver){
        (driver.findElement(By.id("first-name"))).sendKeys("Pedro");
        (driver.findElement(By.id("last-name"))).sendKeys("Zaragoza");
        (driver.findElement(By.id("first-name"))).sendKeys("Estudiante");
        (driver.findElement(By.id("radio-button-3"))).click();
        driver.findElement(By.id("checkbox-1")).click();
        driver.findElement(By.cssSelector("option[value='4']")).click();
        driver.findElement(By.id("datepicker")).sendKeys("08/23/2000");
        driver.findElement(By.id("datepicker")).sendKeys(Keys.RETURN);
        driver.findElement(By.cssSelector(".btn.btn-lg.btn-primary")).click();
    }

    public static void waitforAlertBanner(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement alert = wait.until((ExpectedConditions.visibilityOfElementLocated(By.className("alert"))));
    }

    public static String getAlertBannerTest(WebDriver driver){
        return driver.findElement(By.className("alert")).getText();
    }
}
