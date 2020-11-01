package Citrus.Pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class MainPage extends GeneralWaiterPage {

    SelenideElement popUpCloseButton = $("el-icon-close");
    SelenideElement searchField = $x("//input[@class='global-search__field']");

    public MainPage hoverMenuItem(String menuItem) {
        $x("//div[@class='menu--desktop__drop-list show']//a[@href='/smartfony/']/span[contains(text(),'" + menuItem + "')]").hover();
        return this;
    }

    public MainPage clickOnMenuItem(String text) {
        $x("//div[@class='menu-aim__item-submenu']//a[@href='/smartfony/brand-xiaomi/']//span[contains(text(), '" + text + "')]").click();
        return this;
    }
    public MainPage clickOnMenuItem1(String text) {
        $x("//div[@class='menu-aim__item-submenu']//a[@href='/smartfony/brand-samsung/']//span[contains(text(), '" + text + "')]").click();
        return this;
    }
    public MainPage clickOnMenuItem2(String text) {
        $x("//div[@class='menu-aim__item-submenu']//a[@href='/smartfony/brand-huawei/']//span[contains(text(), '" + text + "')]").click();
        return this;
    }

    public MainPage waitForCompletePage() {
        super.waitForCompletePage();
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

    public MainPage searchProduct(String productName) {
        searchField.val(productName).pressEnter();
        return this;
    }
}
