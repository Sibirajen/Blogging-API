package com.sibirajen.Blogging.API.blog;

import com.sibirajen.Blogging.API.model.Blog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends CrudRepository<Blog, Long> {

}
