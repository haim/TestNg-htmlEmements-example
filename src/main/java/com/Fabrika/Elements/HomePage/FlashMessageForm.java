package com.Fabrika.Elements.HomePage;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import static org.testng.Assert.*;

@Block(@FindBy(className = "flash"))
public class FlashMessageForm extends HtmlElement{

    @FindBy(id = "closeflash") public static Button closeButton;


    public void closeFlash(){
        closeButton.click();
    }

}
