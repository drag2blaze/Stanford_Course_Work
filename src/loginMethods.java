package src;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public interface loginMethods extends tryingSelenium {
    WebDriver driver = new ChromeDriver();
    String loginBox = "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form[@name='home']/table/tbody/tr[4]/td/table/tbody/tr[2]/td[2]/input[@name='userName']";
    String pssWrdBox = "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form[@name='home']/table/tbody/tr[4]/td/table/tbody/tr[3]/td[2]/input[@name='password']";
    class getLoginBox implements loginMethods{
    }
}
