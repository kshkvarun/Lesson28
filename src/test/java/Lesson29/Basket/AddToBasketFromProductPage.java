package Lesson29.Basket;

import Citrus.Pages.CartPage;
import Citrus.Pages.MainPage;
import Citrus.Pages.ProductListPage;
import Citrus.Pages.ProductPage;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddToBasketFromProductPage {

    MainPage mainpage;
    ProductListPage productListPage;
    ProductPage productPage;
    CartPage basketPage;

    @BeforeClass
    public void openSite(){
        Configuration.baseUrl = "https://www.citrus.ua/";
        Configuration.startMaximized = true;
        open("");
        mainpage = new MainPage();
        productListPage = new ProductListPage();
        basketPage = new CartPage();
        productPage = new ProductPage();
    }

    @Test
    public void addProductToBasketFromMenu(){
        mainpage.waitForPopUp()
                .closePopUp()
                .hoverMenuItem("Смартфоны")
                .clickOnMenuItem("Apple");
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
