package com.ppdai.demo.数据迁移性能优化.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by huanglijun on 2017/7/31.
 */
@Configuration
@ConfigurationProperties(prefix = "swagger.api")
public class SwaggerPropperties {
    private String name;
    private String title;
    private String description;
    private String verison;
    private String contactUser;
    private String contactUrl;
    private String contactEmail;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVerison() {
        return verison;
    }

    public void setVerison(String verison) {
        this.verison = verison;
    }

    public String getContactUser() {
        return contactUser;
    }

    public void setContactUser(String contactUser) {
        this.contactUser = contactUser;
    }

    public String getContactUrl() {
        return contactUrl;
    }

    public void setContactUrl(String contactUrl) {
        this.contactUrl = contactUrl;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }
}
