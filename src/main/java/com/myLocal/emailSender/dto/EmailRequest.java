package com.myLocal.emailSender.dto;

import java.util.Map;

public class EmailRequest {
    private String to;
    private String subject;
    private Map<String, String> placeholders;

    // Getters and setters

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Map<String, String> getPlaceholders() {
        return placeholders;
    }

    public void setPlaceholders(Map<String, String> placeholders) {
        this.placeholders = placeholders;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
