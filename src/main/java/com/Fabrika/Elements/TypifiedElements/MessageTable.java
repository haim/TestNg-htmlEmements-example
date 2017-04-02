package com.Fabrika.Elements.TypifiedElements;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

import java.util.List;
import java.util.NoSuchElementException;

public class MessageTable extends TypifiedElement {

    public MessageTable(WebElement wrappedElement) {
        super(wrappedElement);
    }

    private List<WebElement> getItems(){
        return getWrappedElement().findElements(By.xpath("//*/tr"));
    }

    public void viewByMessage(String itemValue){
        for (WebElement item: getItems()){
            if (itemValue.contains(item.findElement(By.xpath("//td")).getText())){
                WebElement button = item.findElement(By.xpath("//*/a/span[@title='View']"));
                button.click();
                return;
            }
            /*if (itemValue.equals(item.getText())){
                item.click();
                return;
            }*/
        }
        throw new NoSuchElementException();
    }

    public void deleteByMessage(String itemValue){
        for (WebElement item: getItems()){
            if (itemValue.contains(item.findElement(By.xpath("//td")).getText())){
                WebElement button = item.findElement(By.xpath("//*/a/span[@title='Delete']"));
                button.click();
                return;
            }
        }
        throw new NoSuchElementException();
    }

    public void viewByUserId(String userNameWithId){
        for (WebElement item: getItems()){
            if (userNameWithId.contains(item.findElement(By.xpath("//td[2]")).getText())){
                WebElement button = item.findElement(By.xpath("//*/a/span[@title='View']"));
                button.click();
                return;
            }
            /*if (itemValue.equals(item.getText())){
                item.click();
                return;
            }*/
        }
        throw new NoSuchElementException();
    }

    public void deleteByUserId(String userNameWithId){
        for (WebElement item: getItems()){
            if (userNameWithId.contains(item.findElement(By.xpath("//td[2]")).getText())){
                WebElement button = item.findElement(By.xpath("//*/a/span[@title='Delete']"));
                button.click();
                return;
            }
        }
        throw new NoSuchElementException();
    }






}
