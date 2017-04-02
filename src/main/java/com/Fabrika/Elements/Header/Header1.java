package com.Fabrika.Elements.Header;


import com.Fabrika.Elements.TypifiedElements.Menu;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@Block(@FindBy(tagName = "header"))
public class Header1 extends HtmlElement {

    @FindBy(tagName = "h1") public static HtmlElement title;
    @FindBy(className = "sf-menu") public static Menu headerMenu;
    @FindBy(linkText = "Login") public static Button loginButton;
    @FindBy(xpath = "//*/a[href='/test_1/default/help']") public static Button helpButton;
    @FindBy(xpath = "//*/a[href='/test_1/default/privacy']") public static Button descriptionButton;


    public void pressHome(){
        headerMenu.selectByValue("Home");
    }

    public void pressHelp(){
        headerMenu.selectByValue("Help");
    }

    public void pressLogin(){
        headerMenu.selectByValue("Login");
    }

    public void pressDescription(){
        headerMenu.selectByValue("Description");
    }

    public void pressLoginButton(){
        loginButton.click();
    }

    public void pressDescriptionButton(){
        descriptionButton.click();
    }
    public void pressHelpButton(){
        helpButton.click();
    }





}
