package com.Fabrika.Objects.Pages;

import com.Fabrika.Objects.Website;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

/**
 * Created by savva on 07.04.2017.
 */
public class AboutPage {

    public static Website website;

    public static final String ABOUT_PAGE_URL = website.BASE_URL + "default/about";
    public static final String ABOUT_PAGE_TITLE = "About course";


    public AboutPage(EventFiringWebDriver driver){
        HtmlElementLoader.populatePageObject(this, driver);
        website = new Website(driver);
    }


}
