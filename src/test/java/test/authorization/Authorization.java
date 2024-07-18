package test.authorization;

import org.testng.annotations.Test;
import pages.authorization.AuthorizationPage;
import services.authorizationService.AuthorizationService;
import services.constructorPage.ConstructorServise;

public class Authorization {

    private final AuthorizationService authorizationService = new AuthorizationService();
    private final AuthorizationPage authorizationPage = new AuthorizationPage();
    private final ConstructorServise mainPageService = new ConstructorServise();

    @Test
    public void checkAuthorization() {
        String email = "konev.tonystark@gmail.com";
        String password = "94949697";

        authorizationService.openAutorizationPage();
        authorizationPage.setEmail(email);
        authorizationPage.setPassword(password);
        authorizationPage.getEnterButton().click();
        mainPageService.openBaseUrl();
    }
}