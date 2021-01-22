package org.progmatic.messenger.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class Message {

    @NotNull
    @NotBlank
    @Size(min = 3, max = 250)
    private String message;

    @NotNull
    @NotBlank
    private String from;

    @NotNull
    @NotBlank
    private String to;

    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm")
    private LocalDateTime date;
    private int id;

    public Message(String message, String from, String to) {
        this.message = message;
        this.from = from;
        this.to = to;
        this.date = LocalDateTime.now();
    }

    public String getMessage() {
        return message;
    }

    public String getFrom() {
        return from;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
