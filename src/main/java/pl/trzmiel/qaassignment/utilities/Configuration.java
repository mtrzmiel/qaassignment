package pl.trzmiel.qaassignment.utilities;

import pl.trzmiel.qaassignment.entities.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

public class Configuration {

    private static Properties properties;

    private Configuration() {
        // only static methods
    }

    private static Properties getProperties() {
        return Objects.requireNonNullElseGet(properties, () -> properties = loadProperties());
    }

    private static Properties loadProperties() {
        Properties properties = new Properties();
        InputStream inputStream = Configuration.class.getClassLoader().getResourceAsStream("config.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Cannot load configuration file");
        }
        return properties;
    }

    static String getWidth() {
        return getProperties().getProperty("width");
    }

    static String getHeight() {
        return getProperties().getProperty("height");
    }

    public static String getMainUrl() {
        return getProperties().getProperty("mainUrl");
    }

    public static User getUser() {
        var name = getProperties().getProperty("username");
        var mail = getProperties().getProperty("mail");
        var password = getProperties().getProperty("password");
        return new User(name, mail, password);
    }

    private static String getPlatformUserName() {
        return getProperties().getProperty("platformUser");
    }
    private static String getPlatformPassword() {
        return getProperties().getProperty("platformPassword");
    }

    public static String getUrlWithAuthentication(){
        var url = getMainUrl();
        var user = getPlatformUserName();
        var password = getPlatformPassword();
        String[] urlSplit = url.split("//");
        if (urlSplit.length != 2) {
            throw new RuntimeException("Incorrect url format");
        }
        var protocol = urlSplit[0];
        var urlWithoutProtocol = urlSplit[1];
        return protocol + "//" + user + ":" + password + "@" + urlWithoutProtocol;
    }


    public static int getExplicitWait() {
        return Integer.parseInt(getProperties().getProperty("explicitWait"));
    }

    public static int getImplicitWait() {
        return Integer.parseInt(getProperties().getProperty("implicitWait"));
    }
}
