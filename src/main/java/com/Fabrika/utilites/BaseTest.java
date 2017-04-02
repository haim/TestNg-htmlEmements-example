package com.Fabrika.utilites;


import com.Fabrika.Objects.Pages.*;
import com.Fabrika.Objects.Verifications;
import com.Fabrika.Objects.Website;
import com.Fabrika.utilites.Listeners.EventListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import static com.Fabrika.utilites.Browser.getBrowser;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;
    public com.Fabrika.utilites.Listeners.EventListener eventListener;
    public static EventFiringWebDriver webDriver;
    public static Website website;
    public static LoginPage loginPage;
    public static HomePage homePage;
    public static RegistrationPage regPage;
    public static PostPage postPage;
    public static ProfilePage profilePage;
    public static Verifications verifications;


    public static com.Fabrika.Objects.Pages.LoginPage loginPage2;


    @BeforeClass(alwaysRun = true)
    @Parameters({"browserType"})
    public void setUpClass(@Optional String browserType) throws Exception {
        //this.driver = getDriver(getBrowserTypeByProperty());
        this.driver = getBrowser("firefox", false);
        webDriver = new EventFiringWebDriver(driver);
        eventListener = new EventListener();
        webDriver.register(eventListener);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        website = new Website(webDriver);
        loginPage = new LoginPage(webDriver);
        homePage = new HomePage(webDriver);
        regPage = new RegistrationPage(webDriver);
        postPage = new PostPage(webDriver);
        profilePage = new ProfilePage(webDriver);
        verifications = new Verifications(webDriver);
    }


    @AfterClass(alwaysRun = true)
    public void tearDown(){
        if (webDriver != null){
            webDriver.quit();
        }
    }


}
