package com.example.journal;

import java.io.Serializable;
import java.util.Date;

public class JournalEntry implements Serializable {
    private Long id;
    private String title;
    private String content;
    private String mood;
    private Date timestamp;

    // Create contructor
    public JournalEntry(Long id, String title, String content, String mood, Date timestamp) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.mood = mood;
        this.timestamp = timestamp;
    }

    // Getter and Setter for all variables
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}