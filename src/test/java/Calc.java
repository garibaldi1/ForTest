import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Calc {
    @Test
    public void Check() {
        System.setProperty("webdriver.firefox.bin",
                "c:\\Mozilla\\firefox.exe");
        System.setProperty("webdriver.gecko.driver", "c:\\Mozilla\\geckodriver.exe");
        String url = "https://mail.yandex.ru/";
        String name = ""; //Enter login
        String password = ""; //Enter password
        String sender = ".//*[@id='nb-1']/body/div[2]/div[3]/div/div[2]/div[3]/div[2]/div[5]/div[1]/div/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/span[2]/span[1]";
        String senderTrue = ""; //Enter senderMail

        String value;
        WebDriver driver = new FirefoxDriver();
        driver.get(url);
        WebElement element = driver.findElement(By.name("login"));
        WebElement element1 = driver.findElement(By.name("passwd"));
        WebElement element2 = driver.findElement(By.xpath(".//*[@id='js']/body/div[1]/div[1]/div[1]/form/div[4]/span/button"));
        element.sendKeys(name);
        element1.sendKeys(password);
        element2.submit();

        WebElement element3 = (new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='nb-1']/body/div[2]/div[3]/div/div[2]/div[3]/div[2]/div[5]/div[1]/div/div/div[2]/div/div[1]/div/div/div/a/div/span[1]/span[2]")));
        element3.click();
        WebElement element4 = (new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(sender)));
        value = element4.getText();
        System.out.println(value);
        System.out.println(senderTrue);
        if (value == senderTrue){
            System.out.println("Неизвестный отправитель");
            driver.close();
            driver.quit();
        }else {
            System.out.println("Отправитель корректный");
        }
        WebElement element5 = driver.findElement(By.xpath(".//*[@id='nb-1']/body/div[2]/div[3]/div/div[1]/div[4]/div[5]/div[1]"));
        element5.click();
        WebElement element6 = (new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='nb-7']/div/div/div[8]/a")));
        element6.click();
    }
}


