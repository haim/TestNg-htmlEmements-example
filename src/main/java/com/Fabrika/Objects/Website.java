package com.Fabrika.Objects;


import com.Fabrika.Elements.Header.Header1;
import com.Fabrika.Elements.Header.Header2;
import com.Fabrika.Objects.Pages.*;
import com.jayway.restassured.response.Response;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;
import static ru.yandex.qatools.htmlelements.matchers.DoesElementExistMatcher.*;

import java.util.List;
import java.util.Map;

import static com.Fabrika.utilites.Waits.visibilityOfElement;
import static com.Fabrika.utilites.Waits.visibilityOfHtmlElement;
import static com.jayway.restassured.RestAssured.given;
import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotSame;
import static org.testng.Assert.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;

public class Website {

    public static EventFiringWebDriver webDriver;
    public static WebDriverWait wait;
    public static final Logger log = Logger.getLogger(Website.class);

    public static Header2 header2;
    public static Header1 header1;
    public static HomePage homePage;

    public Website(EventFiringWebDriver driver){
        this.webDriver = driver;
        wait = new WebDriverWait(driver, 10);
        //PageFactory.initElements(webDriver, this);
        HtmlElementLoader.populatePageObject(this, driver);
    }

    public static final String DOMAIN_NAME = "http://vlay.pythonanywhere.com";
    public static final String WEBSITE_URI = "/test_1/";
    public static final String BASE_URL = DOMAIN_NAME + WEBSITE_URI;


    public LoginPage loginPage(){return new LoginPage(webDriver);}
    public HomePage homePage() { return new HomePage(webDriver);}
    public RegistrationPage registrationPage(){ return new RegistrationPage(webDriver);}
    public PostPage postPage(){ return new PostPage(webDriver);}
    public ProfilePage profilePage(){ return new ProfilePage(webDriver);}
    public AboutPage aboutPage(){ return new AboutPage(webDriver);}
    public ContactsPage contactsPage(){ return new ContactsPage(webDriver);}
    public DescriptionPage descriptionPage(){ return new DescriptionPage(webDriver);}
    public TermsPage termsPage(){ return new TermsPage(webDriver);}


    @Attachment
    public byte[] makeScreenshot() {
        return ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
    }


    @Step("Load page - \"{0}\"")
    public void loadPage(String url, String title){
        try {
            webDriver.get(url);
            wait.until(titleIs(title));
            assertEquals(webDriver.getTitle(), title);
            assertEquals(webDriver.getCurrentUrl(), url);
            makeScreenshot();
        }catch (Exception|AssertionError e){
            e.printStackTrace();
            makeScreenshot();
        }
    }

    @Step("Typing text \"{1}\" to element - \"{0}\"")
    public void setElementText(WebElement element, String text){
        try {
            element.clear();
            element.sendKeys(text);
            assertEquals(element.getAttribute("value"), text);
        } catch (Exception e){
            e.printStackTrace();
            log.error("Cannot find input field: " + element + " " + element.getText() + "\n" + e.getMessage());
        }
    }

    @Step("Waiting for title \"{0}\"")
    public void waitForTitle(String title){
        try {
            wait = new WebDriverWait(webDriver, 10);
            wait.until(titleIs(title));
            assertEquals(webDriver.getTitle(), title);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Step("Waiting for element \"{0}\"")
    public void waitForElement(WebElement element){
        try {
            wait = new WebDriverWait(webDriver, 10);
            wait.until(visibilityOfElement(element));
            assertTrue(element.isDisplayed());
        } catch (Exception e){
            e.printStackTrace();
            log.error("Cannot find element: " + element + " " + element.getText());
        }
    }

    public void waitForHtmlElement(TypifiedElement element){
        try {
            wait = new WebDriverWait(webDriver, 10);
            wait.until(visibilityOfHtmlElement(element));
            assertTrue(element.isDisplayed());
        } catch (Exception e){
            e.printStackTrace();
            log.error("Cannot find element: " + element + " " + element.toString());
        }

    }

    @Step("Waiting for clickable element - \"{0}\"")
    public void waitElementToBeClickable(WebElement element){
        try {
            wait = new WebDriverWait(webDriver, 10);
            wait.until(elementToBeClickable(element));
            assertTrue(element.isEnabled());
        } catch (Exception e){
            e.printStackTrace();
            log.error("Element is not clickable : " + element + " " + element.getText());
        }
    }

    public static boolean assertVisibility(WebElement element) {
        try {
            assertTrue(element.isDisplayed());
            return true;
        } catch (AssertionError e){
            e.printStackTrace();
            return false;
        }
    }

    public static boolean assertHtmlElementVisibility(TypifiedElement element){
        try {
            assertTrue(element.isDisplayed());
            return true;
        } catch (AssertionError e){
            e.printStackTrace();
            return false;
        }
    }

    public static boolean verify(String expected, String actual){
        try {
            assertEquals(expected, actual);
            return true;
        } catch (AssertionError e){
            e.printStackTrace();
            return false;
        }
    }


    @Step("Click element -  \"{0}\"")
    public void clickElement(WebElement element){
        wait.until(visibilityOfElement(element));
        element.click();
    }


    @Step("Scroll to element -  \"{0}\"")
    public void scrollToElement(WebElement element){
        try {
            wait.until(visibilityOfElement(element));
            JavascriptExecutor js = ((JavascriptExecutor) webDriver);
            //js.executeScript("scroll(0,400)");
            js.executeScript("arguments[0].scrollIntoView(true);",element);
            makeScreenshot();
        } catch (Exception e){
            e.printStackTrace();
            log.error("Cannot find element : " + element + " " + element.getText());
        }
    }

    @Step("Page error validation -  \"{2}\"")
    public void validatePageError(String pageTitle, WebElement errorElement, String errorMessage) throws Exception, AssertionError{
        try {
            wait.until(visibilityOfElement(errorElement));
            makeScreenshot();
            assertVisibility(errorElement);
            scrollToElement(errorElement);
            assertEquals(webDriver.getTitle(), pageTitle);
            assertEquals(errorMessage, errorElement.getText());
        } catch (Exception e){
            e.printStackTrace();
            log.error("Exception while error message verification: " + e.getMessage());
        }
    }

    public void selectValieInDropdown(WebElement dropdown, String value){
        Select select = new Select(dropdown);
        select.selectByValue(value);
    }

    public void switchToWindow(){
        for (String handle : webDriver.getWindowHandles()) {
            webDriver.switchTo().window(handle);
        }
    }

  /*  @Step("Logout")
    public void logOut(){
        try {
            if (logOutButton.isDisplayed()) {
                makeScreenshot();
                clickElement(logOutButton);
                waitForTitle(homePage.HOME_PAGE_TITLE);
                waitForElement(logInButton);
                assertTrue(logInButton.isDisplayed());
                log.info("User was logged out!");
                makeScreenshot();
            }
        } catch (Exception e){
            e.printStackTrace();
            log.error("Error occured in logout function!");
        }

    }*/
    @Step("Logout")
    public void logOut(){
        try {
            if (header2.logoutButton.isDisplayed()){
                makeScreenshot();
                header2.pressLogout();
                //waitForTitle(homePage.HOME_PAGE_TITLE);
                waitForHtmlElement(header1.loginButton);
                assertHtmlElementVisibility(header1.loginButton);
                log.info("User was logged out!");
                makeScreenshot();
            }
        } catch (Exception e){
            e.printStackTrace();
            log.error("Error occured in logout function!");
        }
    }

    public void confirmAlertWithMessage(String alertMessage){
        wait.until(alertIsPresent());
        String allertText =  webDriver.switchTo().alert().getText();
        assertEquals(allertText, alertMessage);
        webDriver.switchTo().alert().accept();
    }

    @Step("Assert number of required fields is - \"{0}\"")
    public void searchErrorsCountByClass(int requiredFieldsNumber ,String errorsLocatorClass, WebElement errorMessageField){
        try {
            waitForElement(errorMessageField);
            List<WebElement> requiredFields = webDriver.findElements(By.className(errorsLocatorClass));
            int errorNumber = requiredFields.size();
            assertEquals(requiredFieldsNumber, errorNumber);
            makeScreenshot();
        } catch (Exception | AssertionError e){
            e.printStackTrace();
            log.error("Error : " + e.getMessage());
        }

    }

    @Step("Assert number of required fields is - \"{0}\"")
    public void searchErrorsCountById(int requiredFieldsNumber ,String errorsLocatorClass, WebElement errorMessageField){
        try {
            waitForElement(errorMessageField);
            List<WebElement> requiredFields = webDriver.findElements(By.id(errorsLocatorClass));
            int errorNumber = requiredFields.size();
            assertEquals(requiredFieldsNumber, errorNumber);
        } catch (Exception | AssertionError e){
            e.printStackTrace();
            log.error("Error : " + e.getMessage());
        }

    }

    @Step("Conform alert")
    public void confirmAlert(){
        try{
            wait.until(alertIsPresent());
            makeScreenshot();
            Alert alert  = webDriver.switchTo().alert();
            String alertMessage = alert.getText();
            log.info("Confirming alert: \"" + alertMessage + "\"");
            alert.accept();
            makeScreenshot();
        } catch (Exception e){
            e.printStackTrace();
            log.error("Error occured in alert confirming" + e.getMessage());
        }

    }

    @Step("Get page cookie")
    public static Map<String, String> getCookie(String url){
        Map<String, String> cookie = null;
        try {
            Response response = given().authentication().basic("", "").when().get(url);
            cookie = response.getCookies();
            if (cookie.size() != 0) {
                System.out.println("Cookies was accepted!!!");
                System.out.println(cookie);
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            return cookie;
        }
    }



    public void loginUser(String email, String pass){
        loginPage().openPage();
        loginPage().login(email, pass);
    }




}