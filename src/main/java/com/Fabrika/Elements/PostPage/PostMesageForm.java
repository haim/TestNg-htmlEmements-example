package com.Fabrika.Elements.PostPage;

import freemarker.core.TextBlock;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;


import static org.testng.Assert.*;

@Block(@FindBy(xpath = "//*/form[@class='web2py_grid']"))
public class PostMesageForm extends HtmlElement {

    @FindBy(id = "post_new_post") public static TextInput messageField;
    @FindBy(xpath = "//*/input[@type='submit']")public static Button submitButton;
    @FindBy(xpath = "//*/tr[@if='post_user_id__row']/td[@class='w2p_fw']") public static TextBlock useridField;

    public void createMessage(String message){
        messageField.sendKeys(message);
        submitButton.click();
    }

}
