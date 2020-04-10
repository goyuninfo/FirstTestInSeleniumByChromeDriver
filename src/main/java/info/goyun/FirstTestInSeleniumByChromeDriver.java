package info.goyun;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTestInSeleniumByChromeDriver {

    public static void main(String[] args) {
//Windows users with Chocolatey installed: choco install chromedriver
//setting the driver executable
        System.setProperty("webdriver.chrome.driver", "C:\\ProgramData\\chocolatey\\lib\\chromedriver\\tools\\chromedriver.exe");
//Initiating your chromedriver
        WebDriver driver = new ChromeDriver();

//Applied wait time
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//maximize window
        driver.manage().window().maximize();
        final String baseURL = "https://www.goyun.info";
        final String expectedTitle = "www.goyun.info";
        String actualTitle;
//open browser with desried URL
        driver.get(baseURL);
// get the actual value of the title
        actualTitle = driver.getTitle();

        /*
         * compare the actual title of the page with the expected one and print
         * the result as "Passed" or "Failed"
         */
        if (actualTitle.contentEquals(expectedTitle)) {
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }
//closing the browser
        driver.close();

    }

}
