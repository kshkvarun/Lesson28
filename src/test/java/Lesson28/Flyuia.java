package Lesson28;

import static com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.commands.PressEnter;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class Flyuia {


    @Test
    public void searchTicketsFlyuiaCom() {
        Configuration.timeout = 10000;
        Configuration.startMaximized = true;
        open("https://www.flyuia.com/");



        $("#SEARCH_WIDGET_FORM_INPUTS_DEPARTURE .ng-untouched").setValue("VIENNA");
        sleep(10000);
        $("#SEARCH_WIDGET_FORM_INPUTS_DEPARTURE .ng-untouched").pressEnter();
        $("#SEARCH_WIDGET_FORM_INPUTS_ARRIVAL .ng-untouched").setValue("Kyiv").pressEnter();
        $("span[class='obe-sw-icon-calendar-departure']").click();
        $("i[class='obe-sw-icon-navigate_next']").click();
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
