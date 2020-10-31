package Citrus.Pages;

import static com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ProductPage {

    SelenideElement productPrice = $x("//div[@class='normal__prices']/div/span/span");
    SelenideElement productName = $x("//h1[@class='product__title']");
    SelenideElement buyButton = $x("//div[@id='buy-block']//button[@class='btn orange full']");
    public String getProductPrice() {
        return productPrice.getText();
    }

    public String getProductName() {
        return  productName.getText();
    }

    public void clickBuyButton() {
        buyButton.waitUntil(visible, 10000).waitUntil(enabled, 10000).click();
    }
}
