package info.goyun;


import java.io.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.remote.*;

public class GettingStartedWithService {

    private static ChromeDriverService service;
    private WebDriver driver;

    @BeforeClass
    public static void createAndStartService() throws IOException {
        service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("C:\\work\\testing\\chromedriver_win32\\chromedriver.exe"))
                .usingAnyFreePort()
                .build();
        service.start();
    }

    @AfterClass
    public static void stopService() {
        service.stop();
    }

    @Before
    public void createDriver() {
        driver = new RemoteWebDriver(service.getUrl(), new ChromeOptions());
    }

    @After
    public void quitDriver() {
        driver.quit();
    }

    @Test
    public void testGoogleSearch() throws InterruptedException {

        driver.get("https://www.google.com/");
        Thread.sleep(3000);  // Let the user actually see something!
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("GoYUN.INFO");
        searchBox.submit();
        Thread.sleep(8000);  // Let the user actually see something!
    }
}
