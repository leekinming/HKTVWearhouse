package com.pixeltrice.springbootimportcsvfileapp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "record")
public class Record {

    @Id
    @Column(name = "recordid")
    private long recordid;

    @Column(name = "locationid")
    private long locationid;

    @Column(name = "number")
    private long number;

    @Column(name = "productid")
    private long productid;

    public Record() {

    }

    public Record(long recordid, long locationid, long  number, long productid) {
        this.recordid = recordid;
        this.locationid = locationid;
        this.number = number;
        this.productid = productid;
    }

    public long getRecordid() {
        return recordid;
    }

    public void setRecordid(long recordid) {
        this.recordid = recordid;
    }

    public long getLocationid() {
        return locationid;
    }

    public void setLocationid(long locationid) {
        this.locationid = locationid;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public long getProductid() {
        return productid;
    }

    public void setProductid(long productid) {
        this.productid = productid;
    }

    @Override
    public String toString() {
        return "Record [Recordid=" + recordid + ", Locationid=" + locationid + ", number=" + number + ", Productid=" + productid + "]";
    }
}