package Citrus.Pages;

import static com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.experimental.theories.suppliers.TestedOn;

import java.lang.annotation.Target;

import static com.codeborne.selenide.Selenide.$x;

public class ProductPage extends GeneralWaiterPage {

    SelenideElement productPrice = $x("//div[@class='normal__prices']/div/span/span");

    SelenideElement productName = $x("//h1[@class='product__title']");

    SelenideElement buyButton = $x("//div[@id='buy-block']//button[@class='btn orange full']");

    @Step("Get product price")
    public String getProductPrice() {
        return productPrice.getText();
    }

    @Step("Get product name")
    public String getProductName() {
        return  productName.getText();
    }

    @Step("clickBuyButton")
    public void clickBuyButton() {
        buyButton.waitUntil(visible, 10000).waitUntil(enabled, 10000).click();
    }
}
