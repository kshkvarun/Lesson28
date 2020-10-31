package Citrus.Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class CartPage {

    SelenideElement basketPopUp = $x("//div[@class='el-dialog el-dialog--medium']");
    ElementsCollection basketProductNames = $$x("//a[@class='ex-active active ctrs-basket-product__name']");
    ElementsCollection productPrices = $$x("//span[@class='ctrs-main-price']");
    SelenideElement basketTotal = $x("//span[@class='ctrs-main-price ctrs-basket-footer__new-price']");

    public SelenideElement getBusket() {
        return basketPopUp;
    }

    public ElementsCollection getProductNamesFromBasket() {
        return basketProductNames;
    }

    public ElementsCollection getBasketProductPrice() {
        return productPrices;
    }

    public SelenideElement getBasketTotal() {
        return basketTotal;
    }
}
