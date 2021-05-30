package com.example.demo.jwt;

import com.google.common.net.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@ConfigurationProperties(prefix="application.jwt")
public class JwtConfig {
    private String secreteKey;
    private String tokenPrefix;
    private Integer tokenExpirationAfterDays;

    @Autowired
    public JwtConfig() {
    }

    public String getSecreteKey() {
        return secreteKey;
    }

    public void setSecreteKey(String secreteKey) {
        this.secreteKey = secreteKey;
    }

    public String getTokenPrefix() {
        return tokenPrefix;
    }

    public void setTokenPrefix(String tokenPrefix) {
        this.tokenPrefix = tokenPrefix;
    }

    public Integer getTokenExpirationAfterDays() {
        return tokenExpirationAfterDays;
    }

    public void setTokenExpirationAfterDays(Integer tokenExpirationAfterDays) {
        this.tokenExpirationAfterDays = tokenExpirationAfterDays;
    }

    public String getAuthorizationHeader(){

        return HttpHeaders.AUTHORIZATION;
    }
}
