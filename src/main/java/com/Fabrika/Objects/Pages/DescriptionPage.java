package com.Fabrika.Objects.Pages;


import com.Fabrika.Objects.Website;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class DescriptionPage {

    public static Website website;

    public static final String DESCRIPTION_PAGE_URL = website.BASE_URL + "default/privacy";
    public static final String DESCRIPTION_PAGE_TITLE = "Description";

    public DescriptionPage(EventFiringWebDriver driver){
        HtmlElementLoader.populatePageObject(this, driver);
        website = new Website(driver);
    }

}
