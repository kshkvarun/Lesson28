package Citrus.Pages;

import static com.codeborne.selenide.Condition.*;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class ProductListPage extends GeneralWaiterPage {

    SelenideElement productPrice1 = $x("//div[@class='product-card product-card--mini'][1]//span[@class='price-number']");
    SelenideElement productPrice2 = $x("//div[@class='product-card product-card--mini'][2]//span[@class='price-number']");

    SelenideElement productName1 = $x("//div[@class='product-card product-card--mini'][1]//h5");
    SelenideElement productName2 = $x("//div[@class='product-card product-card--mini'][2]//h5");

    SelenideElement firstBuyButton = $x("//div[@class='product-card product-card--mini'][1]//i[@class='icon-new-citrus-cart el-tooltip item']");
    SelenideElement secondBuyButton = $x("//div[@class='product-card product-card--mini'][2]//i[@class='icon-new-citrus-cart el-tooltip item']");

    SelenideElement addToCompareFirst = $x("//div[@class='product-card product-card--mini'][1]//i[@class='icon-comparison2 el-tooltip item']");
    SelenideElement addToCompareSecond = $x("//div[@class='product-card product-card--mini'][2]//i[@class='icon-comparison2 el-tooltip item']");

    SelenideElement comparisonCounter = $x("//i[@class='icon-comparison2']//span[@class='counter']");
    SelenideElement compareButton = $x("//i[@class='icon-comparison2']");

    SelenideElement cartButton = $x("//i[@class='icon-new-citrus-cart']");

    ElementsCollection productsNames = $$x("//div[@class='product-card__name']");
    ElementsCollection productsPrices = $$x("//div[@class='prices__price']/span[@class='price']");
    ElementsCollection products = $$x("//div[@class='properties__body']/ul/li/span[@class='item__value']");


    @Step("Wait for full page download")
    public ProductListPage waitForCompletePage() {
        super.waitForCompletePage();
        return this;
    }

    @Step("Click on {productName}")
    public ProductListPage clickProductByName(String productName) {
        $x("//span[contains(text(), '" + productName + "')]").click();
        return this;
    }

    @Step("Find product by {productName}")
    public ProductListPage findProductByFoundName(String productName) {
        $x("//span[contains(text(), '" + productName + "')]").click();
        return this;
    }

    @Step("Buy first item")
    public ProductListPage buyFirstItem() {
        firstBuyButton.click();
        return this;
    }

    @Step("Buy second item")
    public ProductListPage buySecondItem() {
        secondBuyButton.click();
        return this;
    }


    @Step("Get first product price")
    public int getProductPrice1() {
        return Integer.parseInt(productPrice1.getText().replaceAll("\\s+", ""));
    }

    @Step("Get second product price")
    public int getProductPrice2() {
        return Integer.parseInt(productPrice2.getText().replaceAll("\\s+", ""));
    }

    @Step("Get first product name")
    public String getProductName1() {
        return productName1.getText();
    }

    @Step("Get second product name")
    public String getProductName2() {
        return productName2.getText();
    }

    @Step("Add to compare first product")
    public ProductListPage addTocompareFirst() {
        addToCompareFirst.click();
        assertEquals(comparisonCounter.getText(), "1");
        return this;
    }
    @Step("Add to compare second product")
    public ProductListPage addToCompareSecond() {
        addToCompareSecond.click();
        comparisonCounter.waitUntil(text("2"), 3000);
        assertEquals(comparisonCounter.getText(), "2");
        return this;
    }

    @Step("Click on compare")

    public ProductListPage clickCompare() {
        compareButton.click();
        return this;
    }

    @Step("Click on cart button")
    public ProductListPage clickCartButton() {
        cartButton.click();
        return this;
    }

    @Step("Add min price")
    public ProductListPage addMinPrice() {
        $$x("//input[@class='el-input__inner']").get(0).val("1000");
        return this;
    }

    @Step("Add max price")
    public ProductListPage addMaxPrice() {
        $$x("//input[@class='el-input__inner']").get(1).val("20000");
        return this;
    }

    @Step("Check if all prices in price range")
    public ProductListPage ifAllAreInPriceRange() throws Exception {
        int price;
        String priceWithoutSpaces;
        for (SelenideElement prices : productsPrices) {
            priceWithoutSpaces = prices.getText().replaceAll("\\s+", "");
            price = Integer.parseInt(priceWithoutSpaces);
            if (price <= 1000 || price >= 20000) {
                throw new Exception("Price out of range 1000-20000");
            }
        }
        return this;
    }

    @Step("Check if all prices in memory range")
    public ProductListPage ifAllAreInMemoryRange(String minGb, String maxGb) throws Exception {
        for (SelenideElement names : productsNames) {
            if (!names.getText().contains(minGb) || !names.getText().contains(maxGb)) {
                throw new Exception("Some or All products out of memory range");
            }
        }
        return this;
    }

    @Step("change focus to somewhere")
    public ProductListPage clickSomeWhere() {
        $x("//div[@class='filter-itm__title'][contains(text(), 'Бренд')]").click();
        return this;
    }

    @Step("If all product's names contain same word")
    public ProductListPage ifAllNamesContainsSameWord(String productName) throws Exception {
        for (SelenideElement names : productsNames) {
//            Подстава,  в выборку попал другой телефон. БЫть может один и тот же производитель
            if (!names.getText().contains(productName) || !names.getText().contains("Poco")) {
                throw new Exception("Not all items are '" + productName + "'");
            }
        }
        return this;
    }
    @Step("If all product's contain same word")
    public ProductListPage ifAllProductsContainsSameWord(String productName) throws Exception {
        for (SelenideElement product : products) {
            System.out.println(product.getText());
//            Подстава,  в выборку попал другой телефон. БЫть может один и тот же производитель
            if (!product.getText().contains(productName)) {
                throw new Exception("Not all items are made of '" + productName + "'");
            }
        }
        return this;
    }

    @Step("Add min RAM Gb")
    public ProductListPage addMinRamGb() {
        $x("//a[@href='https://www.citrus.ua/smartfony/brand-xiaomi/hdd_32-gb/']").click();
        return this;
    }

    @Step("Add max RAM Gb")
    public ProductListPage addMaxRamGb() {
        $x("//a[@href='https://www.citrus.ua/smartfony/brand-xiaomi/hdd_64-gb/']").click();
        return this;
    }

    @Step("Choose material")
    public ProductListPage chooseMaterial() {
        $x("//a[@href='https://www.citrus.ua/smartfony/brand-huawei/materialy-korpusa_metall/']").click();
        return this;
    }
}
