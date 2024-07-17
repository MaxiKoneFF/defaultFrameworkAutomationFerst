package test.constructorBurger;

import pages.constructor.ConstructorPage;
import org.testng.annotations.Test;
import services.mainpageservice.MainPageService;

public class ConstructorBurger {
    private final MainPageService mainPageService = new MainPageService();
    private final ConstructorPage constructorPage = new ConstructorPage();

    @Test
    public void chooseToppingAndMakeOrder() {
        mainPageService.openBaseUrl();
        constructorPage.getToppingButton();
        constructorPage.getChooseBun();
        constructorPage.getMakeOrder();
        constructorPage.getOrderFeed();
    }
}