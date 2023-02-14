package com.bandesal.blog.dao.dbo;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
@Embeddable
public class BlogsReaderPK implements Serializable {
    @Column(name = "id_r")
    private Integer idReader;
    @Column(name = "id_b")
    private Integer idBlog;

    public Integer getIdReader() {
        return idReader;
    }

    public void setIdReader(Integer idReader) {
        this.idReader = idReader;
    }

    public Integer getIdBlog() {
        return idBlog;
    }

    public void setIdBlog(Integer idBlog) {
        this.idBlog = idBlog;
    }
}
