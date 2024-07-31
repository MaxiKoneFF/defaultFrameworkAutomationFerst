package pages.constructor;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ConstructorPage {

    private final By TOPPING_BUN = By.xpath("//p[contains(text(), 'Краторная булка N-200i')]");
    private final By SOURCE_ELEMENT = By.xpath("//*[@id=\"root\"]/div/main/div/section[2]/div[1]");
    private final By ORDER = By.xpath("//button[contains(text(), 'Оформить заказ')]");
    private final By ORDER_NUMBER = By.xpath("//*[contains(@class, 'modal-overlay_overlay__AKixE')]");
    private final By ORDER_FEED = By.xpath("//button[contains(text(), 'Лента заказов')]");

    public SelenideElement toppingBun() {
        return element(TOPPING_BUN).shouldBe(visible);
    }

    public SelenideElement sourceElement() {
        return element(SOURCE_ELEMENT).shouldBe(visible);
    }

    public void dragAndDropBun() {
        SelenideElement toppingBun = toppingBun();
        SelenideElement sourceElement = sourceElement();

        Actions actions = actions();
        actions.dragAndDrop(toppingBun, sourceElement).perform();
    }

    public SelenideElement order() {
        return element(ORDER);
    }

    public void makeOrder() {
        order().click();
        try {
            sleep(25000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
public SelenideElement orderNumber() {
        return element(ORDER_NUMBER);
    }
    public void closeOrderNumber(){
        orderNumber().click();
    }
    public SelenideElement orderFeed() {
        return element(ORDER_FEED);
    }
    public void clickOrderFeed() {
        orderFeed().click();
    }
}