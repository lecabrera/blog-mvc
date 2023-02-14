package com.bandesal.blog.dao.repository;

import com.bandesal.blog.dao.dbo.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    @Query(value = "select * from blogs  where title = :title", nativeQuery = true)
    public Blog findBlogByTitle(@Param("title") String title);

}
