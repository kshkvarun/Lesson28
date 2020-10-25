package Lesson28;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class RyanAir {

    SelenideElement departure = $(By.id("input-button__departure"));
    SelenideElement destination = $(By.id("input-button__destination"));
    ElementsCollection airports = $$("span[data-ref='airport-item__name']");
    SelenideElement searchButton = $("button[aria-label='Пошук']");
    SelenideElement departureDateButton = $("fsw-input-button[uniqueid='dates-from']");
    SelenideElement returnDateButton = $("fsw-input-button[uniqueid='dates-to']");
    SelenideElement dateForm = $("div[data-id='2020-11-19']");
    SelenideElement dateTo = $("div[data-id='2020-11-28']");
    SelenideElement passengers = $("div.input-button__input.input-button__display-value--truncate-text");
    ElementsCollection addAdult = $$("div[class='counter__button-wrapper--enabled']");
    ElementsCollection toThereAndBack = $$("journey-container > journey");
    SelenideElement ticketsDates = $x("//div[@class='details__bottom-bar b2 ng-tns-c24-2 ng-trigger ng-trigger-fadeInOut ng-star-inserted']");


    @Test
    public void ryanAir (){
        Configuration.startMaximized=true;

        open("https://www.ryanair.com/");

        departure.waitUntil(visible, 10000);
        departure.clear();
        departure.setValue("Vienna");
        destination.click();
        destination.setValue("Kyiv");
        airports.findBy(text(" Київ-Бориспіль ")).click();
        searchButton.click();
        departureDateButton.click();
        dateForm.click();
        dateTo.click();
        passengers.click();
        addAdult.get(0).click();
        searchButton.click();
        toThereAndBack.shouldHaveSize(2);
        assertTrue(ticketsDates.getText().contains("19 лист."));
        assertTrue(ticketsDates.getText().contains("28 лист."));
    }

}
