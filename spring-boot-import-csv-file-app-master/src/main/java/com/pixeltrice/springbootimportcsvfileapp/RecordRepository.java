package com.pixeltrice.springbootimportcsvfileapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface RecordRepository extends JpaRepository<Record, Integer> {

    @Query(value = "select name, address, sum(number) FROM record, location, product\n" +
            "where record.ProductID = product.ProductID\n" +
            "and record.LocationID = location.locationid\n" +
            "group by name, address;", nativeQuery = true)
    List<Object[]> storeresult();
}