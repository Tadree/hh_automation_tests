package ru.jiehk.autotests.tests.ui.config;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class TestsConfigure {

    public static void configure() {
        TestsConfig config = ConfigFactory.create(TestsConfig.class, System.getProperties());
        Configuration.browser = config.getBrowser();
        Configuration.baseUrl = config.getBaseUrl();
        Configuration.browserSize = config.getBrowserSize();
        Configuration.browserVersion = config.getBrowserVersion();
        Configuration.remote = config.getRemoteDriverUrl();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        Configuration.browserCapabilities = capabilities;
//        Configuration.pageLoadStrategy = "eager";

        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("--dns-prefetch-disable");
        chromeOptions.addArguments("disable-browser-side-navigation");
        chromeOptions.addArguments("disable-dev-shm-usage");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--single-process");
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("enable-automation");
        chromeOptions.addArguments("--disable-browser-side-navigation");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--lang=en-en");
        chromeOptions.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");
        chromeOptions.addArguments("enable-features=NetworkServiceInProcess");
    }
}
