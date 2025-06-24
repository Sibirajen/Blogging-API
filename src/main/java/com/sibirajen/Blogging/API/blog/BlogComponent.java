package com.sibirajen.Blogging.API.blog;

import com.sibirajen.Blogging.API.dto.BlogRequest;
import com.sibirajen.Blogging.API.dto.BlogResponse;
import com.sibirajen.Blogging.API.model.Blog;
import com.sibirajen.Blogging.API.model.Tag;
import com.sibirajen.Blogging.API.tag.TagRepository;
import com.sibirajen.Blogging.API.tag.TagResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1")
public class BlogComponent {
    private final BlogRepository blogRepo;
    private final TagRepository tagRepo;

    @Autowired
    public BlogComponent(BlogRepository blogRepo, TagRepository tagRepo) {
        this.blogRepo = blogRepo;
        this.tagRepo = tagRepo;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.setDisallowedFields("id","createdAt","updatedAt");
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<BlogResponse> getBlogById(@PathVariable Long id){
        return blogRepo.findById(id)
                .map(BlogMapper::toBlogResponse)
                .map(ResponseEntity::ok)
                .orElseGet( () -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/posts")
    public ResponseEntity<List<BlogResponse>> getBlogs(@RequestParam(required = false) String term){
        List<Blog> blogList;

        if (term == null || term.equals("*")){
            blogList = blogRepo.findAll();
        }
        else {
            blogList = blogRepo.findByTitleContainingIgnoreCaseOrContentContainingIgnoreCaseOrCategoryContainingIgnoreCase(term, term, term);
        }

        List<BlogResponse> responseList = blogList.stream()
                .map(BlogMapper::toBlogResponse)
                .toList();

        return ResponseEntity.ok(responseList);
    }

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<Void> deleteBlogById(@PathVariable Long id){
        if(!blogRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        blogRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/posts")
    public ResponseEntity<BlogResponse> postBlog(@Validated @RequestBody BlogRequest blogRequest){
        Blog savedBlog = blogRepo.save(BlogMapper.toBlog(blogRequest, tagRepo));
        URI uri = URI.create("/posts/" + savedBlog.getId());
        return ResponseEntity.created(uri).body(BlogMapper.toBlogResponse(savedBlog));
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<BlogResponse> putBlog(@PathVariable Long id, @Validated @RequestBody BlogRequest blogRequest){
        Optional<Blog> savedBlogOpt = blogRepo.findById(id);
        if(savedBlogOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        Blog savedBlog = savedBlogOpt.get();

        List<Tag> tagList = TagResolver.toTagList(blogRequest.getTags(), tagRepo);

        savedBlog.setTitle(blogRequest.getTitle());
        savedBlog.setContent(blogRequest.getContent());
        savedBlog.setCategory(blogRequest.getCategory());
        savedBlog.setTags(tagList);

        BlogResponse blogResponse = BlogMapper.toBlogResponse(blogRepo.save(savedBlog));
        return ResponseEntity.ok(blogResponse);
    }
}
