package Citrus.Steps;

import Citrus.Pages.CartPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;


public class CartPageStep {

    CartPage cartPage = new CartPage();

    @Step("Verify items in Cart")
    public void verifyItemsInCart(String productPrice, String productName) {
        cartPage.getProductNamesFromBasket().shouldHaveSize(1);
        cartPage.getProductNamesFromBasket().get(0).shouldHave(text(productName));
        cartPage.getBasketProductPrice().get(0).shouldHave(text(productPrice));
        cartPage.getBasketTotal().shouldHave(text(productPrice));
    }
}

