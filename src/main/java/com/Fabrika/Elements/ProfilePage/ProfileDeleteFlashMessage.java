package com.Fabrika.Elements.ProfilePage;


import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

@Block(@FindBy(className = "flash"))
public class ProfileDeleteFlashMessage extends HtmlElement {

    @FindBy(id = "closeflash") public static Button closeButton;

    public void closeFlash(){
        closeButton.click();
    }
}
