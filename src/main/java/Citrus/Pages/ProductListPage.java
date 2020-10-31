package Citrus.Pages;

import static com.codeborne.selenide.Selenide.$x;

public class ProductListPage {
    public ProductListPage clickProductByName(String productName) {
        $x("//span[contains(text(), '" + productName +"')]").click();
        return this;
    }
}
