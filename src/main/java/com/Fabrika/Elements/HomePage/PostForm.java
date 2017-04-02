package com.Fabrika.Elements.HomePage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

@Block(@FindBy(xpath = "//*/div[@class='web2py_grid']"))
public class PostForm extends HtmlElement {

    @FindBy(linkText = "Back") public static Button backButton;
    @FindBy(xpath = "//*/tr[@id='post_new_post__row']/td[2]") public static WebElement messageField;

}
