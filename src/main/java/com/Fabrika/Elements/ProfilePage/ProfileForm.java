package com.Fabrika.Elements.ProfilePage;


import com.Fabrika.Objects.Website;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.CheckBox;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@Block(@FindBy(id = "main"))
public class ProfileForm extends HtmlElement{

    public static Website website;
    public static WebDriverWait wait;

    @FindBy(id = "delete_record") public static CheckBox deleteCheckBox;
    @FindBy(xpath = "//*/input[@value='Submit']") Button submitButton;

    public void selectDeleteCheckBox() {
        deleteCheckBox.select();
    }

    public void pressSubmit(){
        submitButton.click();
    }

}
