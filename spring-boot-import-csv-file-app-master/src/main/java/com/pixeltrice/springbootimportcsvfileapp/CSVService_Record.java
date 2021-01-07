package com.pixeltrice.springbootimportcsvfileapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@Service
public class CSVService_Record {
  @Autowired
  RecordRepository repository;

  public void save(MultipartFile file) {
    try {
      List<Record> tutorials = CSVHelper_Record.csvToTutorials(file.getInputStream());
      repository.saveAll(tutorials);
    } catch (IOException e) {
      throw new RuntimeException("fail to store csv data: " + e.getMessage());
    }
  }

  public ByteArrayInputStream load() {
    List<Record > tutorials = repository.findAll();

    ByteArrayInputStream in = CSVHelper_Record.tutorialsToCSV(tutorials);
    return in;
  }

  public List<Record > getAllTutorials() {
    return repository.findAll();
  }
}

