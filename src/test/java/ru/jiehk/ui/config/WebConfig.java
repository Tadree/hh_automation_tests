package ru.jiehk.ui.config;

import org.aeonbits.owner.Config;

@WebConfig.Sources({
        "classpath:config/${env}.properties"
})
public interface WebConfig extends Config {

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

    @Key("isRemote")
    Boolean getIsRemote();
}
