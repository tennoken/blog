package io.blog.service;

import io.blog.Repository.BlogRepository;
import io.blog.model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService {


    private final  BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }


    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    public Optional<Blog> findById(Integer id) {return blogRepository.findById(id);}

    public String saveBlog(Blog blog) {
        blogRepository.save(blog);
        return "save";
    }

    public void deleteBlog(Integer id) {
        blogRepository.deleteById(id);
    }


}
