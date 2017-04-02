package com.Fabrika.Elements.HomePage;


import com.Fabrika.Elements.TypifiedElements.MessageTable;
import freemarker.core.TextBlock;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import static org.testng.Assert.*;

@Block(@FindBy(className = "web2py_table"))
public class MessageForm extends HtmlElement {

    @FindBy(className = "web2py_counter") public static TextBlock messageCounter;
    @FindBy(tagName = "tbody") public static MessageTable messagesTable;

    public void viewMessage(String messageText){
        messagesTable.viewByMessage(messageText);
    }

    public void deleteMessage(String messageText){
        messagesTable.deleteByMessage(messageText);
    }

    public void verifyMessage(String message){
        messagesTable.findMessageText(message);
    }


}
