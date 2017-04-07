package com.Fabrika.Objects.Pages;


import com.Fabrika.Objects.Website;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class TermsPage {

    public static Website website;

    public static final String TERMS_PAGE_URL = website.BASE_URL + "default/terms";
    public static final String TERMS_PAGE_TITLE = "Terms";

    public TermsPage(EventFiringWebDriver driver){
        HtmlElementLoader.populatePageObject(this, driver);
        website = new Website(driver);
    }

}
