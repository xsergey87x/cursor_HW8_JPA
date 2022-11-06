package com.cursor.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Goods {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int price;
    private String description;
    private String countryProducer;
    private int yearProduction;
    private int yearExpireDate;

    public Goods() {
    }

    public Goods(String name, int price, String description, String countryProducer, int yearProduction, int yearExpireDate) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.countryProducer = countryProducer;
        this.yearProduction = yearProduction;
        this.yearExpireDate = yearExpireDate;
    }

    public Goods(Long id, String name, int price, String description, String countryProducer, int yearProduction, int yearExpireDate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.countryProducer = countryProducer;
        this.yearProduction = yearProduction;
        this.yearExpireDate = yearExpireDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountryProducer() {
        return countryProducer;
    }

    public void setCountryProducer(String countryProducer) {
        this.countryProducer = countryProducer;
    }

    public int getYearProduction() {
        return yearProduction;
    }

    public void setYearProduction(int yearProduction) {
        this.yearProduction = yearProduction;
    }

    public int getYearExpireDate() {
        return yearExpireDate;
    }

    public void setYearExpireDate(int yearExpireDate) {
        this.yearExpireDate = yearExpireDate;
    }
}
