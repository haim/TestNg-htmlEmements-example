package com.Fabrika.Elements.HomePage;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@Block(@FindBy(id = "button"))
public class HomePageButtons extends HtmlElement{

    @FindBy(xpath = "//*/a[@href='/test_1/default/user/profile']") public static Button profileButton;
    @FindBy(xpath = "//*/a[@href='/test_1/default/user/register']") public static Button registerButton;

    public void pressRegister(){
        registerButton.click();
    }

    public void pressProfile(){
        profileButton.click();
    }
}
