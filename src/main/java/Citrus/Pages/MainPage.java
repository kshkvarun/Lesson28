package Citrus.Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    SelenideElement popUpCloseButton = $("el-icon-close");

    public MainPage hoverMenuItem(String menuItem) {
        $x("//div[@class='menu--desktop__drop-list show']//a[@href='/smartfony/']/span[contains(text(),'" + menuItem + "')]").hover();

        return this;
    }

    public MainPage clickOnMenuItem(String text) {
        $x("//div[@class='menu-aim__item-submenu']//a[@href='/smartfony/brand-apple/']//span[contains(text(), '" + text + "')]").click();
        return this;
    }

    public MainPage waitForPopUp() {
        return this;
    }

    public MainPage closePopUp() {
        if (popUpCloseButton.isDisplayed()) {
            popUpCloseButton.click();
        }
        return this;
    }
}
