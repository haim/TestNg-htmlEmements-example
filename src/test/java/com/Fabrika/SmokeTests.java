package com.Fabrika;



import com.Fabrika.utilites.BaseTest;
import com.Fabrika.utilites.Listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;


@Title("Smoke tests")
@Description("Tests of main website functionality")
@Listeners(TestListener.class)
public class SmokeTests extends BaseTest {


    @Title("Positive login")
    @Description("positive login test")
    @Test
    public void test()throws Exception{
        loginPage.openPage();
        loginPage.login("savva.genchevskiy@gmail.com", "19021992qa");

    }







}
