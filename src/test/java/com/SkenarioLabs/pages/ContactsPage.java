package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactsPage extends BasePage {

    @FindBy(css=".input-widget")
    public WebElement pageNumber;


    public WebElement getContactEmail(String email){
        String xpath = "//*[contains(text(), '"+email+"') and @data-column-label='Email']";
        return Driver.get().findElement(By.xpath(xpath));

    }
    public String getNameAndSurname(String email){
        //*[contains(text(), 'mbrackstone9@example.com') and @data-column-label='Email']//..//td[2]

        WebElement names = Driver.get().findElement(By.xpath("//*[contains(text(), '" + email + "') and @data-column-label='Email']//..//td[2]"));
        String actualName= names.getText();
        WebElement surnames= Driver.get().findElement(By.xpath("//*[contains(text(), '"+email+"') and @data-column-label='Email']//..//td[3]"));
        String actualSurname= surnames.getText();


        return actualName+" "+actualSurname;


    }


}
