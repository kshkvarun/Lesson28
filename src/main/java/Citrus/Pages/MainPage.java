package Citrus.Pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class MainPage extends GeneralWaiterPage {

    SelenideElement popUpCloseButton = $("el-icon-close");
    SelenideElement searchField = $x("//input[@class='global-search__field']");

    @Step("Hover smarphones menu item")
    public MainPage hoverMenuItem(String menuItem) {
        $x("//div[@class='menu--desktop__drop-list show']//a[@href='/smartfony/']/span[contains(text(),'" + menuItem + "')]").hover();
        return this;
    }

    @Step("Click on menu item Apple")
    public MainPage clickOnMenuItemApple(String text) {
        $x("//div[@class='menu-aim__item-submenu']//a[@href='/smartfony/brand-apple/']//span[contains(text(), '" + text + "')]").click();
        return this;
    }

    @Step("Click on menu item Samsung")
    public MainPage clickOnMenuItemSamsung(String text) {
        $x("//div[@class='menu-aim__item-submenu']//a[@href='/smartfony/brand-samsung/']//span[contains(text(), '" + text + "')]").click();
        return this;
    }

    @Step("Click on menu item Huawei")
    public MainPage clickOnMenuItemHuawei(String text) {
        $x("//div[@class='menu-aim__item-submenu']//a[@href='/smartfony/brand-huawei/']//span[contains(text(), '" + text + "')]").click();
        return this;
    }

    @Step("Waiting for full page download")
    public MainPage waitForCompletePage() {
        super.waitForCompletePage();
        return this;
    }

    @Step("wait for pop-up appearing")
    public MainPage waitForPopUp() {
        return this;
    }

    @Step("Close pop-up")
    public MainPage closePopUp() {
        if (popUpCloseButton.isDisplayed()) {
            popUpCloseButton.click();
        }
        return this;
    }

    @Step("Search product {productName}")
    public MainPage searchProduct(String productName) {
        searchField.val(productName).pressEnter();
        return this;
    }
}
