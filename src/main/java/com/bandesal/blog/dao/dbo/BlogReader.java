package com.bandesal.blog.dao.dbo;

import javax.persistence.*;

@Entity
@Table(name = "blogs_readers")
public class BlogReader {
    @EmbeddedId
    private BlogsReaderPK blogsReaderPK;
    @ManyToOne
    @JoinColumn(name = "id_b", insertable = false, updatable = false)
    private Blog blog;

    @ManyToOne
    @JoinColumn(name = "id_r", insertable = false, updatable = false)
    private Reader reader;


}
