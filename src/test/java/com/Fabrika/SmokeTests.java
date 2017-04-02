package com.Fabrika;



import com.Fabrika.utilites.BaseTest;
import com.Fabrika.utilites.Listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;
import static org.hamcrest.MatcherAssert.assertThat;


@Title("Smoke tests")
@Description("Tests of main website functionality")
@Listeners(TestListener.class)
public class SmokeTests extends BaseTest {


    @Title("Positive registration")
    @Description("Positive scenario of registration")
    @Test
    public void positiveRegistration() throws Exception {
        regPage.openPage();
        regPage.register(regPage.USER_FIRST_NAME, regPage.USER_LAST_NAME, regPage.USR_EMAIL, regPage.USER_PASSWORD, regPage.USER_PASSWORD, regPage.USER_NICKNAME);
        verifications.verifyRegistration();
    }
















    @Title("Positive login")
    @Description("positive login test")
    @Test
    public void positiveLogin()throws Exception{
        loginPage.openPage();
        loginPage.login("savva.genchevskiy@gmail.com", "19021992qa");
        website.waitForElement(homePage.flashMessageForm);
        homePage.viewMessage("Hello!");
        Thread.sleep(3000);

    }


    @Test
    public void test() throws Exception{
        homePage.openPage();
        homePage.pressHome();
        Thread.sleep(2000);
    }

    @Title("positive registration")
    @Description("registration test")
    @Test
    public void positiversdasRegistration(){
        regPage.openPage();
        regPage.register(regPage.USER_FIRST_NAME, regPage.USER_LAST_NAME, regPage.USR_EMAIL, regPage.USER_PASSWORD, regPage.USER_PASSWORD, regPage.USER_NICKNAME);
    }


    @Test
    public void test21() throws Exception{
        loginPage.openPage();
        loginPage.login("savva.genchevskiy+1@gmail.com", "19021992qa");
        website.waitForElement(homePage.flashMessageForm);
        profilePage.openPage();
        profilePage.deleteProfile();
    }









}
