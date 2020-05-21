package com.test.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class gameAutoLogin {
    @Test
    @Parameters({"driverPath", "url"})
    public void autoLogin(String driverPath, String url) {
    System.setProperty("webdriver.chrome.driver", driverPath);
        WebDriver webdriver = new ChromeDriver();
        webdriver.get(url);
    }
}
