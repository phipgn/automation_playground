package com.saucedemo.pojos;

public class Config {
    private String baseUrl;
    private int implicitTimeout;
    private String username;
    private String password;
    private boolean headless;

    public String getBaseUrl() {
        return baseUrl;
    }
    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
    public int getImplicitTimeout() {
        return implicitTimeout;
    }
    public void setImplicitTimeout(int implicitTimeout) {
        this.implicitTimeout = implicitTimeout;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public boolean getHeadless() {
        return headless;
    }
    public void setHeadless(boolean headless) {
        this.headless = headless;
    }
}
