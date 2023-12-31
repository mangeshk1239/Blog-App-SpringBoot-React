package com.webapp.blog.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "blogs")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "preview_description")
    private String previewDescription;

    @Column(name = "blog_image_url")
    private String blogImageUrl;

    // Getters
    public long getId() {return id;}
    public long getUserId() { return userId; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getPreviewDescription() { return previewDescription; }
    public String getBlogImageUrl() { return blogImageUrl; }

    // Setters
    public void setId(long id) { this.id = id; }
    public void setUserId(long userId) { this.userId = userId; }
    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setPreviewDescription(String previewDescription) { this.previewDescription = previewDescription; }
    public void setBlogImageUrl(String blogImageUrl) { this.blogImageUrl = blogImageUrl; }
}
