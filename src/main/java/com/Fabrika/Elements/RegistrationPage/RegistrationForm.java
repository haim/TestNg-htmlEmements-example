package com.Fabrika.Elements.RegistrationPage;


import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

import javax.xml.soap.Text;

@Block(@FindBy(id = "web2py_user_form"))
public class RegistrationForm extends HtmlElement {

    @FindBy(id = "auth_user_first_name") public static TextInput firstNameField;
    @FindBy(id = "auth_user_last_name") public static TextInput lastNamField;
    @FindBy(id = "auth_user_email") public static TextInput emailField;
    @FindBy(id = "auth_user_password") public static TextInput passwordField;
    @FindBy(name = "password_two") public static TextInput confirmPasswordField;
    @FindBy(id = "auth_user_nickname") public static TextInput nickNameField;
    @FindBy(id = "auth_user_image") public static HtmlElement imageField;
    @FindBy(xpath = "//*/input[@value='Register']") public static Button registerButton;

    public void register(String firstName, String lastName, String email, String password, String rePassword, String nickname){
        firstNameField.sendKeys(firstName);
        lastNamField.sendKeys(lastName);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(rePassword);
        nickNameField.sendKeys(nickname);
        registerButton.click();
    }


}
