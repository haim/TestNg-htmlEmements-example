package com.Fabrika.Objects.Pages;


import com.Fabrika.Elements.ProfilePage.DeletePageForm;
import com.Fabrika.Elements.ProfilePage.ProfileDeleteFlashMessage;
import com.Fabrika.Elements.ProfilePage.ProfileForm;
import com.Fabrika.Objects.Website;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class ProfilePage {

    public static Website website;
    public static RegistrationPage registrationPage;
    public static ProfileForm profileForm;
    public static ProfileDeleteFlashMessage flashMessage;
    public static DeletePageForm deletePageForm;
    public static HomePage homePage;

    public static final String PROFILE_PAGE_URL = website.BASE_URL + "default/user/profile";
    public static final String PROFIEL_PAGE_TITLE  = registrationPage.USER_FIRST_NAME + "'s Profile";
    public static final String DELETE_URL = website.BASE_URL + "default/after_delete";
    public static final String DELETE_MESSAGE = "User DELETED!" + " ×";
    public static final String DELETE_PAGE_TITLE = "Selenium Testing";

    public ProfilePage(EventFiringWebDriver driver){
        HtmlElementLoader.populatePageObject(this, driver);
        website = new Website(driver);
    }

    @Step
    public void openPage(){
        website.loadPage(PROFILE_PAGE_URL, PROFIEL_PAGE_TITLE);
    }

    @Step
    public void deleteProfile(){
        profileForm.selectDeleteCheckBox();
        website.confirmAlert();
        profileForm.pressSubmit();
        website.waitForElement(flashMessage);
    }

    @Step
    public void pressHome(){
        deletePageForm.pressHome();
        website.waitForTitle(homePage.HOME_PAGE_TITLE);
    }

}
