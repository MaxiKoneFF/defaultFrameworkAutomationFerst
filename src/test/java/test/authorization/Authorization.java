package test.authorization;

import org.testng.annotations.Test;
import pages.authorization.AuthorizationPage;
import services.AuthorizationService;

public class Authorization {

    private final AuthorizationService authorizationService = new AuthorizationService();
    private final AuthorizationPage authorizationPage = new AuthorizationPage();

    @Test
    public void checkAuthorization() {
        String email = "konev.tonystark@gmail.com";
        String password = "94949697";

        authorizationService.openAuthorizationPage();
        authorizationPage.enterEmail(email);
        authorizationPage.enterPassword(password);
        authorizationPage.clickEnterButton();
    }
}