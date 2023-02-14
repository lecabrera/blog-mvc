package com.bandesal.blog.dao.repository;

import com.bandesal.blog.dao.dbo.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IReaderRepository extends JpaRepository<Reader, Integer> {

    @Query(value = "select * from readers  where id = :idReader", nativeQuery = true)
    public Reader finfByIdReader(@Param("idReader") int idReader);


}
