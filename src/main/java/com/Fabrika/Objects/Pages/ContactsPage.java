package com.Fabrika.Objects.Pages;


import com.Fabrika.Objects.Website;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class ContactsPage {

    public static Website website;

    public static final String CONTACTS_PAGE_URL = website.BASE_URL + "default/contact";
    public static final String CONTACTS_PAGE_TITLE = "Contacts";

    public ContactsPage(EventFiringWebDriver driver){
        HtmlElementLoader.populatePageObject(this, driver);
        website = new Website(driver);
    }

}
