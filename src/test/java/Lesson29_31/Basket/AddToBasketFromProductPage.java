package Lesson29_31.Basket;

import static com.codeborne.selenide.Selenide.*;

import Citrus.Steps.CartPageStep;
import Citrus.Steps.MainPageStep;
import Citrus.Steps.ProductListPageStep;
import Citrus.Steps.ProductPageStep;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddToBasketFromProductPage {

//    MainPage mainpage;
//    ProductListPage productListPage;
//    ProductPage productPage;
//    CartPage basketPage;

    MainPageStep mainPageStep;
    ProductListPageStep productListPageStep;
    ProductPageStep productPageStep;
    CartPageStep cartPageStep;


    @BeforeClass
    public void openSite() {
        Configuration.baseUrl = "https://www.citrus.ua/";
        Configuration.startMaximized = true;
        open("");
        mainPageStep = new MainPageStep();
        productListPageStep = new ProductListPageStep();
        cartPageStep = new CartPageStep();
        productPageStep = new ProductPageStep();
    }

    @Test
    public void addProductToBasketFromMenu() {
        mainPageStep.clickPnMenuItem("Apple");
        productListPageStep.clickOnProductByName("Apple iPhone 11 128Gb Black");
        String productPrice = productPageStep.getProductPrice();
        String productName = productPageStep.getProductName();
        productPageStep.clickBuyButton();
        cartPageStep.verifyItemsInCart(productPrice, productName);
    }
}
