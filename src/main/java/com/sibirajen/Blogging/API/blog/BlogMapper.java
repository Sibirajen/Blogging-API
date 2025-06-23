package com.sibirajen.Blogging.API.blog;

import com.sibirajen.Blogging.API.dto.BlogRequest;
import com.sibirajen.Blogging.API.dto.BlogResponse;
import com.sibirajen.Blogging.API.model.Blog;
import com.sibirajen.Blogging.API.model.Tag;
import com.sibirajen.Blogging.API.tag.TagRepository;
import com.sibirajen.Blogging.API.tag.TagResolver;

import java.util.List;

public class BlogMapper {

    public static BlogResponse toBlogResponse(Blog blog){
            return BlogResponse.builder()
                    .id(blog.getId())
                    .title(blog.getTitle())
                    .content(blog.getContent())
                    .category(blog.getCategory())
                    .tags(TagResolver.toStrList(blog.getTags()))
                    .createdAt(blog.getCreatedAt())
                    .updatedAt(blog.getCreatedAt())
                    .build();
    }

    public static Blog toBlog(BlogRequest blogRequest, TagRepository repo){
        List<Tag> tagList = TagResolver.toTagList(blogRequest.getTags(), repo);

        return Blog.builder()
                .title(blogRequest.getTitle())
                .content(blogRequest.getContent())
                .category(blogRequest.getCategory())
                .tags(tagList)
                .build();
    }
}
