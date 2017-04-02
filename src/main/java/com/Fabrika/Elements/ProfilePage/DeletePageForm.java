package com.Fabrika.Elements.ProfilePage;


import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@Block(@FindBy(id = "main"))
public class DeletePageForm extends HtmlElement{

    @FindBy(linkText = "Home") public static Button homeButton;

    public void pressHome(){
        homeButton.click();
    }

}
