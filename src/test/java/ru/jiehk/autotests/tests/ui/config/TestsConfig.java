package ru.jiehk.autotests.tests.ui.config;

import org.aeonbits.owner.Config;

@TestsConfig.Sources({
        "classpath:config/${env}.properties"
})
public interface TestsConfig extends Config {

    @Key("browser")
    @DefaultValue("chrome")
    String getBrowser();

    @Key("baseUrl")
    @DefaultValue("https://hh.ru")
    String getBaseUrl();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String getBrowserSize();

    @Key("browserVersion")
    @DefaultValue("114.0")
    String getBrowserVersion();

    @Key("remoteDriverUrl")
    String getRemoteDriverUrl();

}
