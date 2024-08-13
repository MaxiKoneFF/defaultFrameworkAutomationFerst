package test.constructorBurger;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.authorization.AuthorizationPage;
import pages.constructor.ConstructorPage;
import pages.exitFromAccount.ExitFromAccount;
import services.AuthorizationService;

public class ConstructorBurger {

    private final ConstructorPage constructorPage = new ConstructorPage();
    private final AuthorizationPage authorizationPage = new AuthorizationPage();
    private final AuthorizationService authorizationService = new AuthorizationService();
    private final ExitFromAccount exitFromAccountPage = new ExitFromAccount();
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
        constructorPage.clickOrderFeed();
        constructorPage.findOrder();
    }
    @AfterTest
    public void exitFromAccount(){
        exitFromAccountPage.comeToPersonalAccount();
        exitFromAccountPage.pressExitButton();
    }
}