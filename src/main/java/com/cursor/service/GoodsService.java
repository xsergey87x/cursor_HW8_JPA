package com.cursor.service;


import com.cursor.entity.Goods;


import java.util.List;
import java.util.Optional;


public interface GoodsService {

    Goods create(Goods goods);

    void modifyGoodsById(Goods goods, Long id);

    List<Goods> findAllExpiredGoods();

    List<Goods> findCheepGoods();

    List<Goods> findAllGoods();

    List<Goods> findGoodsByProductionAndExpireYear(int goodsProductYear, int goodsExpireYear);

    void delete(Long id);

    Optional<Goods> findGoodsById(Long id);

    List<Goods> findGoodsByName(String name);


}
