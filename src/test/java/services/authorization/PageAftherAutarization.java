package services.authorization;

import base.BaseService;

import static com.codeborne.selenide.Selenide.open;

public class PageAftherAutarization extends BaseService {
    public void openPageAftherAutarization() {
        open(baseUrl);
    }
}