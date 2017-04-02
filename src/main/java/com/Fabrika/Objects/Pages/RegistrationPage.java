package com.Fabrika.Objects.Pages;


import com.Fabrika.Elements.Header.Header1;
import com.Fabrika.Elements.Header.Header2;
import com.Fabrika.Elements.RegistrationPage.RegistrationForm;
import com.Fabrika.Objects.Website;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class RegistrationPage {

    public static Website website;
    public static WebDriverWait wait;
    public static Header2 header2;
    public static Header1 header1;
    public static HomePage homePage;
    public static RegistrationForm registrationForm;

    public static final String REGISTRATION_PAGE_URL = website.BASE_URL + "default/user/register";
    public static final String REGISTRATION_PAGE_TITLE  = "Registration";
    public static final String USER_FIRST_NAME = "Savva";
    public static final String USER_LAST_NAME = "Genchevskiy";
    public static final String USR_EMAIL = "savva.genchevskiy+1@gmail.com";
    public static final String USER_PASSWORD = "19021992qa";
    public static final String USER_NICKNAME = "savva_genchevskiy";

    public RegistrationPage(EventFiringWebDriver driver){
        HtmlElementLoader.populatePageObject(this, driver);
        website = new Website(driver);
    }

    public void openPage(){
        website.loadPage(REGISTRATION_PAGE_URL, REGISTRATION_PAGE_TITLE);
        website.waitForHtmlElement(registrationForm.emailField);
    }

    public void register(String firstName, String lastName, String email, String password, String rePassword, String nickname){
        registrationForm.register(firstName, lastName, email, password, rePassword, nickname);
        website.waitForElement(homePage.flashMessageForm);
    }



}
