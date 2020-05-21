package com.test.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class gameAutoLogin {
    @Test
    public void autoLogin() {
    System.setProperty("webdriver.chrome.driver", "tools/chromedriver.exe");
        WebDriver webdriver = new ChromeDriver();
        webdriver.get("https://www.google.de");
    }
}
