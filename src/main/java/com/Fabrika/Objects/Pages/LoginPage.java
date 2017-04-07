package com.Fabrika.Objects.Pages;

import com.Fabrika.Objects.Website;
import com.Fabrika.Elements.Footer.Footer;
import com.Fabrika.Elements.LoginPage.LoginForm;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoginPage {


    public static Website website;
    public static WebDriverWait wait;
    public static LoginForm loginForm;
    public static Footer footer;
    public static HomePage homePage;


    public static final String LOGIN_PAGE_URL = website.BASE_URL + "default/user/login";
    public static final String LOGIN_PAGE_TITLE  = "Selenium Testing";
    public static final String USR_EMAIL = "savva.genchevskiy@gmail.com";
    public static final String USER_PASSWORD = "19021992qa";



    public LoginPage(EventFiringWebDriver driver){
        HtmlElementLoader.populatePageObject(this, driver);
        website = new Website(driver);
    }


    @Step
    public void openPage(){
        website.loadPage(LOGIN_PAGE_URL, LOGIN_PAGE_TITLE);
    }

    @Step
    public void login(String email, String password){
        website.waitForHtmlElement(loginForm.emailField);
        loginForm.login(email,password);
        website.waitForElement(homePage.flashMessageForm);
        //assertThat(loginForm.remeberMeCheckBox, isSelected());
    }

    @Step
    public void pressAbout(){
        footer.pressAbout();
    }


}
