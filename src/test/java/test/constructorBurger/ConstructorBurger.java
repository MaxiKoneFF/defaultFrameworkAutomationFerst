package test.constructorBurger;

import org.testng.annotations.Test;
import pages.constructor.ConstructorPage;
import services.constructorPage.ConstructorServise;

public class ConstructorBurger {
    private final ConstructorServise constructorService = new ConstructorServise();
    private final ConstructorPage constructorPage = new ConstructorPage();

    @Test
    public void chooseToppingAndMakeOrder() {
        constructorService.openBaseUrl();
        constructorPage.getToppingButton();
        constructorPage.getChooseBun();
        constructorPage.getMakeOrder();
        constructorPage.getOrderFeed();
    }
}