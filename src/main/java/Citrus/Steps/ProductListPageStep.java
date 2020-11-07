package Citrus.Steps;

import Citrus.Pages.ProductListPage;
import com.codeborne.selenide.commands.Click;
import io.qameta.allure.Step;

public class ProductListPageStep {

    ProductListPage productListPage = new ProductListPage();

    @Step("Click on product by name")
    public void clickOnProductByName(String s) {
        productListPage.clickProductByName(s);
    }
}
