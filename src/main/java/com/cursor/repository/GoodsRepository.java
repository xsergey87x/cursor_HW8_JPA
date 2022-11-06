package com.cursor.repository;


import com.cursor.entity.Goods;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface GoodsRepository extends CrudRepository<Goods, Long> {

    List<Goods> findGoodsByName(String name);

    @Transactional
    @Modifying
    @Query("UPDATE Goods g SET g.name =:name, g.price =:price, g.description =:description, g.countryProducer =:countryProducer, g.yearProduction =:yearProduction, g.yearExpireDate =:yearExpireDate WHERE id =:id")
        //@Query("UPDATE Goods g SET g.name = ?2, g.price = ?3, g.description = ?4, g.countryProducer = ?5, g.yearProduction = ?6, g.yearExpireDate = ?7 WHERE id = ?1")
    void modifyGoodsById(Long id, String name, int price, String description, String countryProducer, int yearProduction, int yearExpireDate);

    @Query("SELECT g FROM Goods g WHERE g.yearExpireDate < 2022")
    List<Goods> findAllExpiredGoods();

    @Query("SELECT g FROM Goods g WHERE g.price < 50")
    List<Goods> findCheepGoods();


    @Query("SELECT g FROM Goods g WHERE g.yearProduction =:yearProduction AND g.yearExpireDate =:yearExpireDate")
    List<Goods> findGoodsByProductionAndExpireYear(int yearProduction, int yearExpireDate);

}

