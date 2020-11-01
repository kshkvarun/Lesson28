package Citrus.Pages;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GeneralWaiterPage {
    GeneralWaiterPage waitForCompletePage() {

        new WebDriverWait(WebDriverRunner.getWebDriver(), 20).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        return this;
    }
}
