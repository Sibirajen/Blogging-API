package com.sibirajen.Blogging.API.blog;

import com.sibirajen.Blogging.API.model.Blog;
import com.sibirajen.Blogging.API.model.Tag;

public class BlogResponseMapper {
    public static BlogResponse toDTO(Blog blog){
            return BlogResponse.builder()
                    .id(blog.getId())
                    .title(blog.getTitle())
                    .content(blog.getContent())
                    .category(blog.getCategory())
                    .tags(blog.getTags().stream().map(Tag::getTag).toList())
                    .createdAt(blog.getCreatedAt())
                    .updatedAt(blog.getCreatedAt())
                    .build();
    }
}
