package com.Fabrika.Objects.Pages;


import com.Fabrika.Objects.Website;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class HomePage {

    public static Website website;

    public static final String HOME_PAGE_URL = website.BASE_URL + "default/index";
    public static final String HOME_PAGE_TITLE  = "Selenium Testing";


    public HomePage(EventFiringWebDriver driver){
        HtmlElementLoader.populatePageObject(this, driver);
        website = new Website(driver);
    }





}
