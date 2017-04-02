package com.Fabrika.Elements.Header;


import com.Fabrika.Elements.TypifiedElements.Menu;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@Block(@FindBy(tagName = "header"))
public class Header2 extends HtmlElement{


    @FindBy(tagName = "h1") public static HtmlElement title;
    @FindBy(className = "sf-menu") public static Menu headerMenu;
    @FindBy(linkText = "Post Message") public static Button postMessagebutton;
    @FindBy(linkText = "Logout") public static Button logoutButton;
    @FindBy(xpath = "//*/a[href='/test_1/default/help']") public static Button helpButton;
    @FindBy(xpath = "//*/a[href='/test_1/default/privacy']") public static Button descriptionButton;

    public void pressHome(){
        headerMenu.selectByValue("Home");
    }

    public void pressHelp(){
        headerMenu.selectByValue("Help");
    }

    public void pressLogout(){
        headerMenu.selectByValue("Logout");
    }

    public void pressPostMessage(){
        headerMenu.selectByValue("Post Message");
    }

    public void pressDescription(){
        headerMenu.selectByValue("Description");
    }

    public void pressLogoutButton(){
        logoutButton.click();
    }

    public void pressPostMessageButton(){
        postMessagebutton.click();
    }

    public void pressDescriptionButton(){
        descriptionButton.click();
    }

    public void pressHelpButton(){
        helpButton.click();
    }


}
