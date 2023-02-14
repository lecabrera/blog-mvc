package com.bandesal.blog.application.service;

import com.bandesal.blog.application.repository.IBlogService;
import com.bandesal.blog.dao.dbo.Blog;
import com.bandesal.blog.dao.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;
    @Override
    public Blog getBlogByTitle(String title) {
        return iBlogRepository.findBlogByTitle(title);
    }

    @Override
    public Blog getBlogById(Integer id) {
        return iBlogRepository.findById(id).orElse(new Blog());
    }

    @Override
    public Blog createNewBlog(Blog blog) {
        return iBlogRepository.save(blog);
    }

    @Override
    public List<Blog> getAllBlogs() {
        return iBlogRepository.findAll();
    }

    @Override
    public void deleteBlog(Integer id) {
        iBlogRepository.deleteById(id);
    }
}
