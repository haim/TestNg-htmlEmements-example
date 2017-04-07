package com.Fabrika;



import com.Fabrika.DataProviders.RegistrationData;
import com.Fabrika.utilites.BaseTest;
import com.Fabrika.utilites.Listeners.TestListener;
import org.testng.Assert;
import org.testng.ITestResult;
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
public class PostMessageTests extends BaseTest {

    @BeforeMethod
    public void startTest(){
        website.loginUser(loginPage.USR_EMAIL, loginPage.USER_PASSWORD);
    }

    @AfterMethod
    public void stopTest(){
        website.logOut();
    }


    @Title("Post message creation")
    @Description("Post creation test")
    @Test(priority = 1)
    public void createPost(){
        postPage.openPage();
        postPage.createMessage(postPage.NEW_MESSAGE);
        verifications.verifyPostExist(postPage.NEW_MESSAGE);
    }

    @Title("View message")
    @Description("message opening")
    @Test(priority = 2)
    public void viewPost() throws Exception{
        homePage.viewMessage(postPage.NEW_MESSAGE);
        assertThat(homePage.postForm, DoesElementExistMatcher.exists());
        assertEquals(homePage.postForm.messageField.getText(), postPage.NEW_MESSAGE);
    }

    @Title("Delete message")
    @Description("message opening")
    @Test(priority = 3)
    public void deletePost(){
        homePage.deleteMessage(postPage.NEW_MESSAGE);
        verifications.verifyPostDeleted(postPage.NEW_MESSAGE);
    }





}
