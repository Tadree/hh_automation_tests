package ru.jiehk.mobile.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:config/browserstack.properties",
        "classpath:config/android.properties"
})
public interface MobileConfig extends Config {

    @Key("user")
    @DefaultValue("bsuser_JSwAUo")
    String getUser();

    @Key("key")
    @DefaultValue("PgfYVaTjLqqsfixeYaFJ")
    String getKey();

    @Key("baseUrl")
    @DefaultValue("https://hub.browserstack.com/wd/hub")
    String getBaseUrl();

    @Key("app")
    @DefaultValue("bs://36729c2e803d2c77f2569ea4bd5259dddd49e24e")
    String getApp();

    @Key("device")
    @DefaultValue("Google Pixel 3")
    String getDevice();

    @Key("osVersion")
    @DefaultValue("9.0")
    String getOsVersion();

    @Key("project")
    @DefaultValue("First Java Project")
    String getProject();

    @Key("build")
    @DefaultValue("browserstack-build-1")
    String getBuild();

    @Key("name")
    @DefaultValue("first_test")
    String getName();
}
