package com.pixeltrice.springbootimportcsvfileapp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "productid")
    private long productid;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "weight")
    private long weight;

    public Product() {

    }

    public Product(long productid, String code, String name, long weight) {
        this.productid = productid;
        this.code = code;
        this.name = name;
        this.weight = weight;
    }

    public long getProductid() {
        return productid;
    }

    public void setProductid(int productidid) {
        this.productid = productidid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Product [ProductID=" + productid + ", Code=" + code + ", Name=" + name + ", Weight=" + weight + "]";
    }
}

