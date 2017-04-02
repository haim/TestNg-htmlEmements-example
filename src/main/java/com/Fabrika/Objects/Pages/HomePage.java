package com.Fabrika.Objects.Pages;


import com.Fabrika.Elements.Header.Header1;
import com.Fabrika.Elements.Header.Header2;
import com.Fabrika.Elements.HomePage.FlashMessageForm;
import com.Fabrika.Elements.HomePage.MessageForm;
import com.Fabrika.Elements.HomePage.PostForm;
import com.Fabrika.Objects.Website;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class HomePage {

    public static Website website;
    public static RegistrationPage registrationPage;

    public static final String HOME_PAGE_URL  = website.BASE_URL + "default/index";
    public static final String HOME_PAGE_TITLE = "Selenium Testing";
    public static final String FLASH_MESSAGE_NOT_LOGIN = "Welcome to Selenium course!" + "\n" + "×";
    public static final String FLASH_MESSAGE_LOGGED_IN = "Welcome to Selenium course, " + registrationPage.USER_FIRST_NAME + "!" + "\n" + "×";


    public static Header1 header1;
    public static Header2 header2;
    public static MessageForm messageForm;
    public static FlashMessageForm flashMessageForm;
    public static PostForm postForm;

    public HomePage(EventFiringWebDriver driver){
        HtmlElementLoader.populatePageObject(this, driver);
        website = new Website(driver);
    }

    @Step
    public void openPage(){
        website.loadPage(HOME_PAGE_URL, HOME_PAGE_TITLE);
        website.waitForElement(flashMessageForm);
    }

    public void pressHome(){
        header1.pressHome();
        website.waitForTitle(HOME_PAGE_TITLE);
    }

    public void viewMessage(String messageText){
        website.waitForElement(flashMessageForm);
        messageForm.viewMessage(messageText);
        website.waitForHtmlElement(postForm.backButton);
    }

    public void deleteMessage(String messageText){
        messageForm.deleteMessage(messageText);
        website.confirmAlert();
        website.waitForElement(flashMessageForm);
    }





}
