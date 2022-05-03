package utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ConfReader implements ConfigProvider{

    public static String getUrl() {
        return config.getString("url");
    }

    public static String getPropertyByPath(String path) {
        return config.getString(path);
    }
}
