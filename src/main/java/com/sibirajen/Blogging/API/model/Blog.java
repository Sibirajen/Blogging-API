package com.sibirajen.Blogging.API.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "BLOGS")
public class Blog extends DateEntity{
    @Column(name = "TITLE", length = 255)
    private String title;

    @Column(name = "CONTENT", columnDefinition = "TEXT")
    private String content;

    @Column(name = "CATEGORY", length = 100)
    private String category;

    @ManyToMany
    @JoinTable(
            name = "BLOG_TAG_MAPPING",
            joinColumns = @JoinColumn(name = "BLOG_ID"),
            inverseJoinColumns = @JoinColumn(name = "TAG_ID")
    )
    private List<Tag> tags = new ArrayList<>();

    @Builder
    public Blog(String title, String content, String category, List<Tag> tags) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.tags = (tags == null)? new ArrayList<>(): tags;
    }
}