package com.bandesal.blog.application.repository;

import com.bandesal.blog.dao.dbo.Blog;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface IBlogService
{
    public Blog getBlogByTitle(String title);
    public Blog getBlogById(Integer id);
    public Blog createNewBlog(Blog blog);
    public List<Blog> getAllBlogs();
    public void  deleteBlog(Integer id);
}
