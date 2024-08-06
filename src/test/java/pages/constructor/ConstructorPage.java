package pages.constructor;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ConstructorPage {

    private final By TOPPING_BUN = By.xpath("//p[contains(text(), 'Краторная булка N-200i')]");
    private final By SOURCE_ELEMENT = By.xpath("//*[@id=\"root\"]/div/main/div/section[2]/div[1]");
    private final By ORDER = By.xpath("//button[contains(text(), 'Оформить заказ')]");
    private final By ORDER_FEED = By.xpath("//*[@id=\"root\"]/div/header/nav/div[1]/a[2]/p");
    private final By FIND_ORDER = By.xpath("//*[@id=\"modals\"]/div[1]/div[2]/h2");
    private final By FIND_ORDER_ON_ORDER_FEED = By.xpath("//*[@id=\"root\"]/div/main/div/div[1]/div/a[3]/div[1]/span[1]");

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
            sleep(18000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        order().pressEscape();
    }

    public SelenideElement orderFeed() {
        return element(ORDER_FEED);
    }

    public void clickOrderFeed() {
        orderFeed().click();
        try {
            sleep(4000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public SelenideElement findOrder(){
        SelenideElement orderElement = element(FIND_ORDER);
        SelenideElement feedElement = orderElement.find(FIND_ORDER_ON_ORDER_FEED);
        return orderElement;
    }

}