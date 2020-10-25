package Lesson28;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class WizzAir {
    SelenideElement searchButton = $("button[data-test='flight-search-submit']");
    SelenideElement fromField = $("input[data-test='search-departure-station']");
    SelenideElement toField = $("input[data-test='search-arrival-station']");
    ElementsCollection chooseFromList = $$("label[data-test='flight-search-panel-location-label']");
    SelenideElement departure = $("span[id='search-departure-date']");
    SelenideElement fromDate = $("button[data-pika-year='2020'][data-pika-month='10'][data-pika-day='19']");
    SelenideElement toDate = $("button[data-pika-year='2020'][data-pika-month='10'][data-pika-day='22']");
    SelenideElement passengers = $("div[data-test='flight-search-search-passenger']");
    SelenideElement addAdult = $("button[data-test='services-flight-search-increment']");
    SelenideElement confirmNumberOfPassengers = $("button[data-test='flight-search-hide-panel']");
    SelenideElement searchFlight = $("button[data-test='flight-search-submit']");
    SelenideElement showPrices = $x("//div[contains(text(), ' show prices from ')]");
    ElementsCollection searchResult = $$("div[data-test='flight-select-selected-flight-title']");
    ElementsCollection flightTime = $$("time[data-test='flight-select-flight-info-details-time']");
    SelenideElement okButton = $("button[data-test='calendar-shrinkable-ok-button']");


    // Почти каждое действие с переходами занимает секунд 30. Поэтому такой вейтер
    @Test
    public void wizzAir() throws InterruptedException {
        open("https://wizzair.com/");
        searchButton.waitUntil(visible, 50000);
        fromField.clear();
        fromField.val("Vienna");
        chooseFromList.findBy(text("Vienna")).click();
        toField.val("Kyiv");
        chooseFromList.findBy(text("Kyiv - Zhulyany")).click();
        departure.click();
//        okButton.waitUntil(visible, 20000);
//        Ничего кроме слипов не работает
        sleep(10000);
        fromDate.waitUntil(visible, 50000).waitUntil(enabled, 50000).click();
        sleep(10000);
//        okButton.waitUntil(visible, 20000);
        toDate.click();
        passengers.click();
        addAdult.shouldBe(visible);
        addAdult.click();
        confirmNumberOfPassengers.click();
        searchFlight.click();
        switchTo().window(1);
        sleep(40000);
        showPrices.waitUntil(visible, 20000);
        searchResult.shouldHaveSize(2);
        flightTime.get(0).shouldHave(text(" Thu, 19 Nov 2020 "));
        flightTime.get(0).shouldHave(text(" Sun, 22 Nov 2020 "));
    }
}

