package com.altonaut.config;

import java.time.Duration;

public class Config {
    // Define your configuration values as constants or static variables
    public static final String BROWSER = "firefox"; // Example: chrome or firefox
    public static final String BASE_URL = "https://app.altonaut.id/";
    public static final int SHORT_DELAY_MS = 1000;
    public static final int MEDIUM_DELAY_MS = 1000;
    public static final Duration LONG_WAIT_DURATION = Duration.ofSeconds(15);
}
