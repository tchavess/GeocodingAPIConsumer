package config;

public class GeolocationConfig {
    private String key_code;

    public GeolocationConfig() {
        this.key_code = "AIzaSyADxZ2DfcGkasFIjsXIL6RgT5kJIYzqokw";
    }

    public String getKey_code() {
        return key_code;
    }

    public void setKey_code(String key_code) {
        this.key_code = key_code;
    }

    @Override
    public String toString() {
        return "GeolocationConfig{" +
                "key_code='" + key_code + '\'' +
                '}';
    }
}
