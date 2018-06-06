package main.java.model;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Message {
    private String username;
    private Long millis;
    private String balbal;

    public Message(String username, Long millis, String balbal) {
        this.username = username;
        this.millis = millis;
        this.balbal = balbal;
    }

    public String getUsername() {
        return username;
    }

    public Long getMillis() {
        return millis;
    }

    public String getBalbal() {
        return balbal;
    }

    public LocalDateTime getLocalDateTime() {
        return Instant.ofEpochMilli(millis)
                .atZone(ZoneId.of("Asia/Taipei"))
                .toLocalDateTime();
    }
}
