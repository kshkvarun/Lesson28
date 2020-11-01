package Lesson29.Filter;

import Citrus.Pages.*;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class PriceFilter {

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
    public void UsePriceFilter() throws Exception {
        mainpage.waitForCompletePage()
                .closePopUp()
                .hoverMenuItem("Смартфоны")
                .clickOnMenuItem1("Samsung");
        productListPage.waitForCompletePage();
        productListPage.addMinPrice();
        productListPage.waitForCompletePage();
        productListPage.addMaxPrice();
        productListPage.clickSomeWhere();
        productListPage.waitForCompletePage();
        productListPage.ifAllAreInPriceRange();
        productListPage.ifAllNamesContainsSameWord("Samsung");

    }


}