package Citrus.Steps;

import Citrus.Pages.CartPage;
import Citrus.Pages.ProductPage;
import io.qameta.allure.Step;

import java.lang.annotation.Target;

import static com.codeborne.selenide.Condition.visible;

public class ProductPageStep {

    ProductPage productPage = new ProductPage();
    CartPage cartPage = new CartPage();

    @Step("Get product price")
    public String getProductPrice() {
        return productPage.getProductPrice();
    }

    @Step("Get product name")
    public String getProductName() {
        return productPage.getProductName();
    }

    @Step("Click on buy button and go to CArt Page")
    public void clickBuyButton() {
        productPage.clickBuyButton();
        cartPage.getBusket().shouldBe(visible);
    }
}
