package com.sibirajen.Blogging.API.service;

import com.sibirajen.Blogging.API.repo.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogService {
    private final BlogRepository repo;

    @Autowired
    public BlogService(BlogRepository repo) {
        this.repo = repo;
    }

}
