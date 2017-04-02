package com.Fabrika.Objects.Pages;


import com.Fabrika.Elements.Header.Header2;
import com.Fabrika.Elements.PostPage.PostMesageForm;
import com.Fabrika.Objects.Website;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

import static org.testng.Assert.*;
import static com.Fabrika.Objects.Website.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class PostPage {

    public static Website website;
    public static WebDriverWait wait;
    public static PostMesageForm postMesageForm;
    public static HomePage homePage;

    public static final String POST_PAGE_URL = website.BASE_URL + "default/entry_post";
    public static final String POST_PAGE_TITLE = "Selenium Testing";
    public static final String NEW_MESSAGE = "Hello!";

    public PostPage(EventFiringWebDriver driver){
        HtmlElementLoader.populatePageObject(this, driver);
        website = new Website(driver);
    }

    public void openPage(){
        website.loadPage(POST_PAGE_URL, POST_PAGE_TITLE);
    }

    public void createMessage(String text){
        postMesageForm.createMessage(text);
        website.waitForTitle(homePage.HOME_PAGE_TITLE);

    }



}
