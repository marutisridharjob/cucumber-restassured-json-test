package configs;

public class BaseConfig {

    String env = System.getProperty("env");

    public String baseUrl() {
        env = (env != null) ? env : "local";
        String url = null;
        switch (env) {
            case "local" -> url = "http://localhost:7000";
            case "test" -> url = "";
        }
        return url;
    }
}
