package com.bandesal.blog.application.repository;

import com.bandesal.blog.dao.dbo.Reader;

public interface IReaderService {
    public Reader getReaderById(int idReader);
    public Reader saveReader(Reader reader);
    public Boolean deleteReader (int idReader);

}
