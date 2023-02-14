package com.bandesal.blog.application.service;

import com.bandesal.blog.application.repository.IReaderService;
import com.bandesal.blog.dao.dbo.Reader;
import com.bandesal.blog.dao.repository.IReaderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ReaderService implements IReaderService {
    private Logger logger;

    private IReaderRepository iReaderRepository;

    public ReaderService(IReaderRepository iReaderRepository){
      //  this.iReaderRepository = iReaderRepository;
        this.iReaderRepository = iReaderRepository;
        this.logger = LoggerFactory.getLogger(getClass());
    }
    @Override
    public Reader getReaderById(int idReader) {
        Reader reader;
        try{
            reader = iReaderRepository.finfByIdReader(idReader);
            return reader;
        }catch (Exception e) {
            logger.error("Error: ", e);
            return null;

        }
    }

    @Override
    public Reader saveReader(Reader reader){
        return  iReaderRepository.save(reader);
    }

    @Override
    public Boolean deleteReader(int idReader) {
        return null;
    }
}
