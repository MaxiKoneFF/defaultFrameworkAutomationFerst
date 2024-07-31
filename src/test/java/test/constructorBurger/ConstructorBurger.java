package test.constructorBurger;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.authorization.AuthorizationPage;
import pages.constructor.ConstructorPage;
import services.AuthorizationService;

public class ConstructorBurger {

    private final ConstructorPage constructorPage = new ConstructorPage();
    private final AuthorizationPage authorizationPage = new AuthorizationPage();
    private final AuthorizationService authorizationService = new AuthorizationService();
    @BeforeTest
    public void authorization(){
        String email = "konev.tonystark@gmail.com";
        String password = "94949697";

        authorizationService.openAuthorizationPage();
        authorizationPage.enterEmail(email);
        authorizationPage.enterPassword(password);
        authorizationPage.clickEnterButton();
    }
    @Test
    public void chooseToppingAndMakeOrder() {
        constructorPage.dragAndDropBun();
        constructorPage.makeOrder();
        constructorPage.closeOrderNumber();
        constructorPage.clickOrderFeed();
    }
}