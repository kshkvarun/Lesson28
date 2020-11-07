package Lesson29_31.Basket;


import Citrus.Pages.CartPage;
import Citrus.Pages.MainPage;
import Citrus.Pages.ProductListPage;
import Citrus.Pages.ProductPage;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class AddToBasketUsingSearch {

    MainPage mainpage;
    ProductListPage productListPage;
    ProductPage productPage;
    CartPage basketPage;

    @BeforeClass
    public void openSite(){
        Configuration.baseUrl = "https://www.citrus.ua/";
        open("");
        mainpage = new MainPage();
        productListPage = new ProductListPage();
        basketPage = new CartPage();
        productPage = new ProductPage();
    }


    @Test
    public void addProductToBasketUsingSearch(){
        mainpage.waitForCompletePage()
                .waitForPopUp()
                .closePopUp()
                .searchProduct("Apple iPhone 11 128Gb");
        productListPage.clickProductByName("Apple iPhone 11 128Gb Black");
        String productPrice = productPage.getProductPrice();
        String productName = productPage.getProductName();
        productPage.clickBuyButton();
        basketPage.getBusket().shouldBe(visible);
        basketPage.getProductNamesFromBasket().shouldHaveSize(1);
        basketPage.getProductNamesFromBasket().get(0).shouldHave(text(productName));
        basketPage.getBasketProductPrice().get(0).shouldHave(text(productPrice));
        basketPage.getBasketTotal().shouldHave(text(productPrice));
    }


}
