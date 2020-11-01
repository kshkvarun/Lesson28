package Lesson29.Filter;

import Citrus.Pages.*;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class MemoryFilter {

    MainPage mainpage;
    ProductListPage productListPage;
    ProductPage productPage;
    CartPage basketPage;
    ComparisonPage comparisonPage;

    @BeforeClass
    public void openSite() {
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
                .clickOnMenuItem("Xiaomi");
        productListPage.waitForCompletePage();
        productListPage.addMinRamGb();
        productListPage.waitForCompletePage();
        productListPage.addMaxRamGb();
        productListPage.waitForCompletePage();
        productListPage.ifAllNamesContainsSameWord("Xiaomi");
        productListPage.ifAllAreInMemoryRange("16", "32");

    }

}
