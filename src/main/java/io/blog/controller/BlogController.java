package io.blog.controller;

import io.blog.model.Blog;
import io.blog.service.BlogService;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/blog")
@CrossOrigin(origins = "http://localhost:3000")
public class BlogController {
    @Autowired
    private BlogService blogService;


    @GetMapping("/list")
    public List<Blog> findAll() {

        System.out.println("++++++++++++" + blogService.findAll());
        return blogService.findAll();
    }



    @PostMapping("/save")
    public String saveBlog(@RequestBody Blog blog) {

        Blog saveBlog = new Blog();
        saveBlog.setTitle(blog.getTitle());
        saveBlog.setContent(blog.getContent());
        System.out.println(blog);
        return blogService.saveBlog(blog);
    }

    @PostMapping("/{blogId}")
    public String updateBlog(@RequestBody Blog blog, @PathVariable(name = "blogId") int blogId) {

        Blog item = blogService.findById(blogId).orElseThrow();

        if(item.getId() != 0) {
            System.out.println("true");
            System.out.println(item);
            item.setTitle(blog.getTitle());
            item.setContent(blog.getContent());

            blogService.saveBlog(item);

        } else {
            System.out.println("false");
        }
        return "";
    }

    @DeleteMapping("/{blogId}")
    public String deleteBlog(@PathVariable(name = "blogId") int blogId) {
        blogService.deleteBlog(blogId);
        return "deleted";
    }
    
    
}
