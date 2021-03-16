package utils;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

public class Browser {

    public static WebDriver driver;
    public static WebDriverWait wait;

    public static WebDriver getCurrentDriver(){
        if(driver == null){
                ChromeOptions capability;
                capability = new ChromeOptions();
                System.setProperty("webdriver.chrome.driver", "chromedriver.exe");//busca o chromedriver na pasta raiz do projeto
                driver = new ChromeDriver(capability);
                wait = new WebDriverWait(driver, 30);
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//espera rendenizar a página para depois concluir o teste
                driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        }
        return driver;
    }

    public static void close(){
        getCurrentDriver().quit();
        driver = null;
    }

    public static void loadPage(String url) {
        getCurrentDriver().get(url);
    }

    public static void print(){
        //Vai tirar o print
        byte[] screenshootBytes = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        InputStream screenshootStream = new ByteArrayInputStream(screenshootBytes);

        //Vai adicionar o print ao relatório
        Allure.addAttachment("Screenshoot Test: ",screenshootStream);
    }
}