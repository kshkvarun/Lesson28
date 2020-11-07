package Lesson29_31.Basket;

import Citrus.Pages.*;
import com.codeborne.selenide.Configuration;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

public class AddTwoProductsToBasketFromComparison {
    MainPage mainpage;
    ProductListPage productListPage;
    ProductPage productPage;
    CartPage basketPage;
    ComparisonPage comparisonPage;

    @BeforeClass
    public void openSite(){
        Configuration.baseUrl = "https://www.citrus.ua/";
        open("");
        mainpage = new MainPage();
        productListPage = new ProductListPage();
        basketPage = new CartPage();
        productPage = new ProductPage();
        comparisonPage = new ComparisonPage();
    }


    @Test
    public void addProductToBasketFromComparison(){
        mainpage.waitForCompletePage()
                .waitForPopUp()
                .closePopUp()
                .searchProduct("Apple iPhone 11");
        int productPrice1 = productListPage.getProductPrice1();
        int productPrice2 = productListPage.getProductPrice2();
        int totalPrice = productPrice1 + productPrice2;
        String productName1 = productListPage.getProductName1();
        String productName2 = productListPage.getProductName2();
        System.out.println(productName1);
        System.out.println(productName2);
        productListPage.addTocompareFirst();
        productListPage.addToCompareSecond();
        productListPage.clickCompare();
        comparisonPage.addFirstProductToCart();
        comparisonPage.addSecondProductToCart();
        productListPage.clickCartButton();

        basketPage.getProductNamesFromBasket().shouldHaveSize(2);
        basketPage.getProductNamesFromBasket().get(0).shouldHave(text(productName2));
        basketPage.getProductNamesFromBasket().get(1).shouldHave(text(productName1));

        Assert.assertEquals(productPrice1, basketPage.getBasketFirstPrice());
        Assert.assertEquals(productPrice2, basketPage.getBasketSecondPrice());
        Assert.assertEquals(totalPrice, basketPage.getBasketTotal2());

    }
}
