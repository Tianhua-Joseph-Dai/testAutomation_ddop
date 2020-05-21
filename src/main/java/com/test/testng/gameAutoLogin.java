package com.test.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class gameAutoLogin {
    @Test(dataProvider = "dataProvider")
    public void autoLogin(String user_email, String user_pwd, String expectedResult) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "tools/geckodriver.exe");
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://naruto.oasgames.com/en/serverlist/s763");
        webDriver.findElement(By.name("user_email")).sendKeys(user_email);
        webDriver.findElement(By.name("user_password")).sendKeys(user_pwd);
        webDriver.findElement(By.xpath("//a[@onclick='ajax_login();']")).click();

        if(expectedResult != "") {
            WebDriverWait wait = new WebDriverWait(webDriver, 3);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p/span[@id='login_username_id']")));
        }
        String result = webDriver.findElement(By.xpath("//p/span[@id='login_username_id']")).getText();
//        System.out.println("Result is: " + result);
        Assert.assertEquals(result, expectedResult);
    }

    @DataProvider
    public Object[][] dataProvider() throws InterruptedException {
        return new Object[][] {
                new Object[] {"wiidai01@163.com", "wii1350", ""},
                new Object[] {"wiidai02@163.com", "wii1351", "Wrong information"},
                new Object[] {"", "wii1351", "Wrong username"},
                new Object[] {"qwerdai01@163.com", "wii1351", "User does not exist"}
        };
    }
}
