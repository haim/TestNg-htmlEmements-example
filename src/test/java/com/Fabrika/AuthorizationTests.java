package com.Fabrika;

import com.Fabrika.DataProviders.RegistrationData;
import com.Fabrika.utilites.BaseTest;
import com.Fabrika.utilites.Listeners.TestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

@Title("Authorization tests")
@Description("Tests of main website functionality")
@Listeners(TestListener.class)
public class AuthorizationTests extends BaseTest {

    @Title("Positive registration")
    @Description("Positive scenario of registration")
    @Test(priority = 1)
    public void positiveRegistration() throws Exception {
        regPage.openPage();
        regPage.register(regPage.USER_FIRST_NAME, regPage.USER_LAST_NAME, regPage.USR_EMAIL, regPage.USER_PASSWORD, regPage.USER_PASSWORD, regPage.USER_NICKNAME);
        verifications.verifyRegistration();
    }

    @Title("Negativer registration")
    @Description("Registration with invalid data")
    @Test(dataProvider = "regData" , dataProviderClass = RegistrationData.class, priority = 2)
    public void invalidRegistration(String firstName, String lastName, String email, String password, String rePassword, String nickname, String errorMessage) throws Exception {
        regPage.openPage();
        regPage.invalidRegister(firstName, lastName, email, password, rePassword, nickname);
        regPage.validateRegisterError(errorMessage);
    }


    @Title("Positive login")
    @Description("positive login test")
    @Test(priority = 3)
    public void positivelogin() throws Exception{
        loginPage.openPage();
        loginPage.login(loginPage.USR_EMAIL, loginPage.USER_PASSWORD);
        verifications.verifyLogin();
    }

    @Title("Delete profile")
    @Description("Profile deleting test")
    @Test(priority = 4)
    public void deleteProfile(){
        website.loginUser(regPage.USR_EMAIL, regPage.USER_PASSWORD);
        profilePage.openPage();
        profilePage.deleteProfile();
        verifications.verifyProfileDeleting();
    }



}
