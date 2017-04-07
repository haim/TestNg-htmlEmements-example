package com.Fabrika.Objects.Pages;


import com.Fabrika.Elements.Footer.Footer;
import com.Fabrika.Elements.Header.Header1;
import com.Fabrika.Elements.Header.Header2;
import com.Fabrika.Elements.HomePage.FlashMessageForm;
import com.Fabrika.Elements.HomePage.MessageForm;
import com.Fabrika.Elements.HomePage.PostForm;
import com.Fabrika.Objects.Website;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;
import sun.security.krb5.internal.crypto.Des;

public class HomePage {

    public static Website website;
    public static RegistrationPage registrationPage;

    public static final String HOME_PAGE_URL  = website.BASE_URL + "default/index";
    public static final String HOME_PAGE_TITLE = "Selenium Testing";
    public static final String FLASH_MESSAGE_NOT_LOGIN = "Welcome to Selenium course!" + "\n" + "×";
    public static final String FLASH_MESSAGE_LOGGED_IN = "Welcome to Selenium course, " + registrationPage.USER_FIRST_NAME + "!" + "\n" + "×";


    public static Header1 header1;
    public static Header2 header2;
    public static Footer footer;
    public static MessageForm messageForm;
    public static FlashMessageForm flashMessageForm;
    public static PostForm postForm;
    public static TermsPage termsPage;
    public static DescriptionPage descriptionPage;
    public static ContactsPage contactsPage;
    public static AboutPage aboutPage;

    public HomePage(EventFiringWebDriver driver){
        HtmlElementLoader.populatePageObject(this, driver);
        website = new Website(driver);
    }

    @Step
    public void openPage(){
        website.loadPage(HOME_PAGE_URL, HOME_PAGE_TITLE);
        website.waitForElement(flashMessageForm);
    }

    @Step
    public void pressHome(){
        header1.pressHome();
        website.waitForTitle(HOME_PAGE_TITLE);
    }
    @Step
    public void viewMessage(String messageText){
        website.waitForElement(flashMessageForm);
        messageForm.viewMessage(messageText);
        website.waitForHtmlElement(postForm.backButton);
        website.makeScreenshot();
    }
    @Step
    public void deleteMessage(String messageText){
        messageForm.deleteMessage(messageText);
        website.confirmAlert();
        website.waitForHtmlElement(flashMessageForm.closeButton);
        website.makeScreenshot();
    }
    @Step
    public void pressTerms(){
        footer.pressterms();
        website.waitForTitle(termsPage.TERMS_PAGE_TITLE);
        website.makeScreenshot();
    }
    @Step
    public void pressAbout(){
        footer.pressAbout();
        website.waitForTitle(aboutPage.ABOUT_PAGE_TITLE);
        website.makeScreenshot();
    }
    @Step
    public void pressDescription(){
        header1.pressDescription();
        website.waitForTitle(descriptionPage.DESCRIPTION_PAGE_TITLE);
        website.makeScreenshot();
    }
    @Step
    public void presContacts(){
        footer.pressContact();
        website.waitForTitle(contactsPage.CONTACTS_PAGE_TITLE);
        website.makeScreenshot();
    }





}
