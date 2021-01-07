package com.pixeltrice.springbootimportcsvfileapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecordController {
    @Autowired
    RecordRepository recordRepository;

    @GetMapping("/managestore")
    public List<Object[]> managestore(){
        List<Object[]> record = recordRepository.storeresult();
        return record;
    }
}
