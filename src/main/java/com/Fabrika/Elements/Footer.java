package com.Fabrika.Elements;

import com.Fabrika.utilites.TypifiedElements.Menu;
import com.Fabrika.Objects.Website;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@Block(@FindBy(tagName = "footer"))
public class Footer extends HtmlElement {

    public static Website website;

    @FindBy(xpath = "//*/footer[@class='container']") Menu footerMenu;

    public void pressAbout(){
        footerMenu.selectByValue("About");
    }

    public void pressterms(){
        footerMenu.selectByValue("Terms");
    }

    public void pressContact(){
        footerMenu.selectByValue("Contact");
    }


    //BAD WAY HOW TO MADE PAGE OBJECTS
   /* @FindBy(linkText = "About")public static Link aboutLink;
    @FindBy(linkText = "Terms")public static Link termsLink;
    @FindBy(linkText = "Contact")public static Link contactLink;


    public void pressAboutLink(){
        aboutLink.click();
    }

    public void presstermsLink(){
        termsLink.click();
    }

    public void pressContactLink(){
        contactLink.click();
    }*/


}
