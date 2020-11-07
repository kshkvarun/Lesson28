package Citrus.Steps;

import Citrus.Pages.MainPage;
import io.qameta.allure.Step;

public class MainPageStep {

    MainPage mainPage = new MainPage();

    @Step("Click on Link in Menu")
    public void clickPnMenuItem(String apple) {
        mainPage.waitForCompletePage()
                .waitForPopUp()
                .closePopUp()
                .hoverMenuItem("Смартфоны")
                .clickOnMenuItemApple(apple);
    }
}
