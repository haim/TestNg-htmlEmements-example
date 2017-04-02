package com.Fabrika.Objects;


import com.Fabrika.Elements.Footer.Footer;
import com.Fabrika.Elements.Header.Header1;
import com.Fabrika.Elements.Header.Header2;
import com.Fabrika.Elements.HomePage.HomePageButtons;
import com.Fabrika.Elements.HomePage.FlashMessageForm;
import com.Fabrika.Objects.Pages.HomePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

import static org.hamcrest.MatcherAssert.assertThat;
import static com.Fabrika.Objects.Website.*;

public class Verifications {

    public static Header1 header1;
    public static Header2 header2;
    public static Footer footer;
    public static HomePageButtons homePageButtons;
    public static FlashMessageForm flashMessageForm;
    Logger log = Logger.getLogger(Verifications.class);
    public static Website website;
    public static HomePage homePage;

    public Verifications(EventFiringWebDriver driver){
        HtmlElementLoader.populatePageObject(this, driver);
        website = new Website(driver);
    }

    @Step("Verify Registration")
    public void verifyRegistration() throws Exception{
        try {
            website.waitForElement(flashMessageForm);
            verify(flashMessageForm.getText(), homePage.FLASH_MESSAGE_LOGGED_IN);
            verify(webDriver.getTitle(), homePage.HOME_PAGE_TITLE);
            verify(webDriver.getCurrentUrl(), homePage.HOME_PAGE_URL);
            assertHtmlElementVisibility(homePageButtons.profileButton);
            website.makeScreenshot();
        }  finally {
            website.logOut();
            website.makeScreenshot();
        }
    }

}
