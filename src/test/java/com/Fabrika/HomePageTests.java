package com.Fabrika;


import com.Fabrika.utilites.BaseTest;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;
import static com.Fabrika.Objects.Website.*;
import static org.testng.Assert.*;


public class HomePageTests extends BaseTest {

    @BeforeMethod
    public void stratTest(){
        homePage.openPage();
    }


    @Title("Terms link checking")
    @Description("Description")
    @Test
    public void pressTermsLink(){
        homePage.pressTerms();
        assertEquals(webDriver.getCurrentUrl(), termsPage.TERMS_PAGE_URL);
        assertEquals(webDriver.getTitle(), termsPage.TERMS_PAGE_TITLE);
    }

    @Title("About link checking")
    @Description("Description")
    @Test
    public void pressAboutLink(){
        homePage.pressAbout();
        assertEquals(webDriver.getCurrentUrl(), aboutPage.ABOUT_PAGE_URL);
        assertEquals(webDriver.getTitle(), aboutPage.ABOUT_PAGE_TITLE);
    }

    @Title("Description Button checking")
    @Description("Description")
    @Test
    public void pressDescriptionButton(){
        homePage.pressDescription();
        assertEquals(webDriver.getCurrentUrl(), descriptionPage.DESCRIPTION_PAGE_URL);
        assertEquals(webDriver.getTitle(), descriptionPage.DESCRIPTION_PAGE_TITLE);
    }

    @Title("Contacts link checking")
    @Description("Description")
    @Test
    public void PresContactsLink(){
        homePage.presContacts();
        assertEquals(webDriver.getCurrentUrl(), contactsPage.CONTACTS_PAGE_URL);
        assertEquals(webDriver.getTitle(), contactsPage.CONTACTS_PAGE_TITLE);
    }





}
