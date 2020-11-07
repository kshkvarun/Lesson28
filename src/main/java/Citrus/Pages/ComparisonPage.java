package Citrus.Pages;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class ComparisonPage extends GeneralWaiterPage {
    CartPage cartPage = new CartPage();

    ElementsCollection addToCartFirstProduct = $$x("//div[@class='base-column']//i[@class='icon-new-citrus-cart el-tooltip item']");
    ElementsCollection addToCartSecondProduct = $$x("//div[@class='swiper-item swiper-slide swiper-slide-active']//i[@class='icon-new-citrus-cart el-tooltip item']");

    @Step("Add first product to compare")
    public ComparisonPage addFirstProductToCart() {
        addToCartFirstProduct.get(0).click();
        $x("//div[2]/div/div[1]/button[2]").click();
        return this;
    }

    @Step("Add second product to compare")
    public ComparisonPage addSecondProductToCart() {
        addToCartSecondProduct.get(0).click();
        $x("//div[2]/div/div[1]/button[2]").click();
        return this;
    }
}
