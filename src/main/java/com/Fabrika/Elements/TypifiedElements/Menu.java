package com.Fabrika.Elements.TypifiedElements;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

import java.util.List;
import java.util.NoSuchElementException;

public class Menu extends TypifiedElement{

    public Menu(WebElement wrappedElement){
        super(wrappedElement);
    }

    private List<WebElement> getItems(){
        return getWrappedElement().findElements(By.xpath("//*/a"));
    }

    public void selectByIndex(int itemIndex){
        getItems().get(itemIndex).click();
    }

    public void selectByValue(String itemValue){
        for (WebElement item: getItems()){
            if (itemValue.equals(item.getText())){
                item.click();
                return;
            }
        }
        throw new NoSuchElementException();
    }

}
