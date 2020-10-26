package Lesson28;

import static com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class Flyuia {


    @Test
    public void searchTicketsFlyuiaCom() {

        open("https://www.flyuia.com/");
        Configuration.timeout = 10000;


        $$("input[class='ng-untouched ng-pristine ng-valid']").get(0).setValue("VIENNA").pressEnter();
        $$("input[class='ng-untouched ng-pristine ng-valid']").get(1).setValue("Kyiv").pressEnter();
        $("span[class='obe-sw-icon-calendar-departure']").click();
        $x("//button[@class='calendar-day calendar-day-btn fx-flex-fill fx-row__center__center'][contains(text(), '19')]").click();
        $("span[class='obe-sw-icon-calendar-arrivals']").click();
        $x("//button[@class='calendar-day calendar-day-btn fx-flex-fill fx-row__center__center'][contains(text(), '22')]").click();
        $("span[class='obe-sw-icon-passenger']").click();
        $$("button[class='set-val-btn fx-row__center__center fx-flex-15']").get(1).click();
        switchTo().window(1);
        if($("button[class='pw-subscribe-popup-button']").isDisplayed()){
            $("button[class='pw-subscribe-popup-button']").click();
        }

        if ($("i[class='icon-close']").isDisplayed()){
            $("i[class='icon-close']").click();
        }

        $$("div[class='product__title']").shouldHaveSize(2);
        $$("div[class='search-details__item--text']").get(1).shouldHave(text("Thu, 19 Nov - Thu, 19 Nov"));


    }
}
