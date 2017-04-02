package com.Fabrika;



import com.Fabrika.DataProviders.RegistrationData;
import com.Fabrika.utilites.BaseTest;
import com.Fabrika.utilites.Listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.htmlelements.matchers.DoesElementExistMatcher;
import static org.testng.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;


@Title("Smoke tests")
@Description("Tests of main website functionality")
@Listeners(TestListener.class)
public class SmokeTests extends BaseTest {


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


    @Title("Post message creation")
    @Description("Post creation test")
    @Test(priority = 5)
    public void createPost(){
        website.loginUser(loginPage.USR_EMAIL, loginPage.USER_PASSWORD);
        postPage.openPage();
        postPage.createMessage(postPage.NEW_MESSAGE);
        verifications.verifyPostExist(postPage.NEW_MESSAGE);
    }

    @Title("View message")
    @Description("message opening")
    @Test(priority = 6)
    public void viewPost(){
        website.loginUser(loginPage.USR_EMAIL, loginPage.USER_PASSWORD);
        homePage.viewMessage(postPage.NEW_MESSAGE);
        assertThat(homePage.postForm, DoesElementExistMatcher.exists());
        assertEquals(homePage.postForm.messageField.getText(), postPage.NEW_MESSAGE);

    }

    @Title("Delete message")
    @Description("message opening")
    @Test(priority = 7)
    public void deletePost(){
        website.loginUser(loginPage.USR_EMAIL, loginPage.USER_PASSWORD);
        homePage.deleteMessage(postPage.NEW_MESSAGE);
    }





}
