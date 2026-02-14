package com.example.Config.Client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigController {

    // Используем правильные имена свойств
    @Value("${app.name:Default App Name}")
    private String appName;

    @Value("${app.environment:default}")
    private String environment;

    @Value("${app.message:Default Message}")
    private String message;

    @Value("${app.version:1.0.0}")
    private String version;

    @GetMapping("/config")
    public String getConfig() {
        return String.format("""
            Application Configuration:
            -------------------------
            App Name: %s
            Environment: %s
            Message: %s
            Version: %s
            """, appName, environment, message, version);
    }

    @GetMapping("/app-name")
    public String getAppName() {
        return "Application name: " + appName;
    }

    @GetMapping("/message")
    public String getMessage() {
        return "Message: " + message;
    }

    @GetMapping("/test")
    public String test() {
        return "Config Client is working! Connected to Config Server.";
    }
}