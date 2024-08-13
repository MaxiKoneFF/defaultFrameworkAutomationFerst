package test.exitFromAccount;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.authorization.AuthorizationPage;
import pages.account.AccountPage;
import services.AuthorizationService;

public class ExitFromAccount {
    private final AuthorizationService authorizationService = new AuthorizationService();
    private final AuthorizationPage authorizationPage = new AuthorizationPage();
    private final AccountPage exitFromAccountPage = new AccountPage();

    @BeforeTest
    public void authorization() {
        String email = "konev.tonystark@gmail.com";
        String password = "94949697";

        authorizationService.openAuthorizationPage();
        authorizationPage.enterEmail(email);
        authorizationPage.enterPassword(password);
        authorizationPage.clickEnterButton();
    }

    @Test
    public void exitFromAccount(){
        exitFromAccountPage.comeToPersonalAccount();
        exitFromAccountPage.pressExitButton();
    }
}