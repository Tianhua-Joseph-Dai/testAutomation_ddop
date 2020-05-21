package com.test.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
// import org.openqa.selenium.chrome.ChromeDriver;

public class gameAutoLogin {
    @Test(dataProvider = "dataProvider")
    public void autoLogin(String user_email, String user_pwd) throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver", "tools/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "tools/geckodriver.exe");
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://naruto.oasgames.com/en/serverlist/s763");
        webDriver.findElement(By.name("user_email")).sendKeys(user_email);
        webDriver.findElement(By.name("user_password")).sendKeys(user_pwd);
        webDriver.findElement(By.xpath("//a[@onclick='ajax_login();']")).click();
    }

    @DataProvider
//    @Parameters({"driverPath", "url"})
    public Object[][] dataProvider() throws InterruptedException {
        return new Object[][] {
                new Object[] {"wiidai01@163.com", "wii1350"},
                new Object[] {"wiidai02@163.com", "wii1350"}
        };
    }
}
