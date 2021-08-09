package src;

import org.openqa.selenium.By;

public interface tryingSelenium {
    static void main(String[] args ) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Josh Hill\\Downloads\\chromedriver_win32\\chromedriver.exe");
        loginMethods.driver.get("http://demo.guru99.com/test/newtours/");
        loginMethods.driver.findElement(By.xpath(loginMethods.loginBox)).sendKeys("Joshua");
        loginMethods.driver.findElement(By.xpath(loginMethods.pssWrdBox)).sendKeys("password");
    }
}
