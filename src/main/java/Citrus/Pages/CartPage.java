package Citrus.Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class CartPage extends GeneralWaiterPage {

    SelenideElement basketPopUp = $x("//div[@class='el-dialog el-dialog--medium']");
    ElementsCollection basketProductNames = $$x("//div[@class='ctrs-basket-item__products']");
    ElementsCollection productPrices = $$x("//span[@class='ctrs-main-price']");
    SelenideElement basketTotal = $x("//span[@class='ctrs-main-price ctrs-basket-footer__new-price']");
    SelenideElement basketFirstStringPrice = $x("//div[@class='ctrs-basket-item ctrs-basket-product-list__item'][1]//span[@class='ctrs-main-price']");
    SelenideElement basketSecondStringPrice = $x("//div[@class='ctrs-basket-item ctrs-basket-product-list__item'][2]//span[@class='ctrs-main-price']");

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
    int basketFirstPrice;
    int basketSecondPrice;
    public int getBasketFirstPrice() {
        return basketFirstPrice = Integer.parseInt(basketFirstStringPrice.getText().replaceAll("\\s+","").substring(0,5));

    }

    public int getBasketSecondPrice() {
        return basketSecondPrice = Integer.parseInt(basketSecondStringPrice.getText().replaceAll("\\s+","").substring(0,5));
    }

    public int getBasketTotal2() {
        return basketFirstPrice + basketSecondPrice;
    }
}
