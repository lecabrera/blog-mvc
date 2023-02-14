package com.bandesal.blog.application;

import com.bandesal.blog.application.repository.IBlogService;
import com.bandesal.blog.dao.dbo.Blog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BlogController {
    Logger logger;
    @Autowired
    IBlogService iBlogService;
    public BlogController(){
        this.logger = LoggerFactory.getLogger(getClass());
    }

    //Solicito todos los estudiantes.
    @GetMapping("/blogs")
    public String getAllBlogs(Model model){
        model.addAttribute("blogs", iBlogService.getAllBlogs());
        return "blogs";
    }
    @GetMapping("/blogs/update/{id}")
    public String updateBlog(@PathVariable("id") String id, Model model){
        Blog currentBlog = iBlogService.getBlogById(Integer.valueOf(id));
        model.addAttribute("blogs", currentBlog);
        model.addAttribute("$title_blog", currentBlog.getTitle());
        return "blogs_edit";
    }

    @PostMapping("/blogs/{id}")
    public String submitUpdate(@PathVariable("id") Integer id, @ModelAttribute("blog") Blog blog, Model model){
        Blog currentBlog = blog;
        currentBlog.setIdBlog(id);
        logger.info(currentBlog.getTitle());
        logger.info("" + currentBlog.getIdBlog());
        Blog changeBlog = iBlogService.createNewBlog(blog);
        logger.info("" + changeBlog.getIdBlog());
        return "redirect:/blogs";
    }

    @GetMapping("/blogs/delete/{id}")
    public String deleteBlog(@PathVariable("id") String id, Model model){
        iBlogService.deleteBlog(Integer.valueOf(id));
        return "redirect:/blogs";
    }

    @PostMapping("blogs/create")
    public String createNewBlog( @ModelAttribute("blog") Blog blog, Model model){
        iBlogService.createNewBlog(blog);
        logger.info("Se creo el nuevo Blog");
        return "redirect:/blogs";
    }

    @GetMapping("blogs/new")
    public String createBlogForm(Model model){
        Blog blog = new Blog();
        model.addAttribute(blog);
        return "blogs_create";
    }
}
