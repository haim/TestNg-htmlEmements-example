package com.Fabrika.Elements.LoginPage;


import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.element.*;

@Block(@FindBy(id = "web2py_user_form"))
public class LoginForm extends HtmlElement {

    @FindBy(id = "auth_user_email") public static TextInput emailField;
    @FindBy(id = "auth_user_password") public static TextInput passwordField;
    @FindBy(id = "auth_user_remember") public static CheckBox remeberMeCheckBox;
    @FindBy(xpath = "//input[@value='Login']") public static Button loginButton;
    @FindBy(linkText = "Register']")public static Button registerButton;
    @FindBy(linkText = "Lost Password")public static Button lostPasswordButton;

    public void login(String email, String password){
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public void pressRegister(){
        registerButton.click();
    }

    public void pressforgotPassword(){
        lostPasswordButton.click();
    }




}
