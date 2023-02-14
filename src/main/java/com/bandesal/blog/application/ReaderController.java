package com.bandesal.blog.application;

import com.bandesal.blog.application.repository.IReaderService;
import com.bandesal.blog.dao.dbo.Reader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bandesal")
public class ReaderController {

    Logger logger;
    @Autowired
    IReaderService iReaderService;

    public ReaderController(){
        this.logger = LoggerFactory.getLogger(getClass());
    }

    @GetMapping("/getReader/{id}")
    public ResponseEntity<Reader> getReaderById(@PathVariable("id") int id){
        try{
            logger.info("Response from service: " + id);
            return new ResponseEntity<Reader>(iReaderService.getReaderById(id), HttpStatus.OK);
        }catch (Exception e){
           logger.error(e.getMessage());
            return  new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/saveReader")
    public ResponseEntity<Reader> saveReader(@RequestBody Reader reader){
        return new ResponseEntity<Reader>(iReaderService.saveReader(reader), HttpStatus.CREATED);
    }
}
