package com.example.journal;

import java.io.Serializable;

public class JournalEntry implements Serializable {
    private Long id;
    private String title;
    private String content;
    private String mood;
    private String timestamp;

    // Create contructor
    public JournalEntry(Long id, String title, String content, String mood, String timestamp) {
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

    public String getContent() { return content; }

    public String getMood() {
        return mood;
    }

    public String getTimestamp() {
        return timestamp;
    }
}