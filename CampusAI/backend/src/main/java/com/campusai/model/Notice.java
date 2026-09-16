package com.campusai.model;

public class Notice {
    private Long id;
    private String title;
    private String date;
    private String category;
    private String description;

    public Notice(Long id, String title, String date, String category, String description) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.category = category;
        this.description = description;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getDate() { return date; }
    public String getCategory() { return category; }
    public String getDescription() { return description; }
}
