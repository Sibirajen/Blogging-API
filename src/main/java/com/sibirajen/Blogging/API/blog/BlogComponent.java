package com.sibirajen.Blogging.API.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class BlogComponent {
    private final BlogRepository repo;

    @Autowired
    public BlogComponent(BlogRepository repo) {
        this.repo = repo;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.setDisallowedFields("id","createdAt","updatedAt");
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<BlogResponse> getBlogById(@PathVariable Long id){
        return repo.findById(id)
                .map(BlogResponseMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElseGet( () -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/posts")
    public ResponseEntity<List<BlogResponse>> getBlogs(){
        List<BlogResponse> responseList = repo.findAll().stream()
                .map(BlogResponseMapper::toDTO)
                .toList();
        return ResponseEntity.ok(responseList);
    }

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<Void> deleteBlogById(@PathVariable Long id){
        if(!repo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
