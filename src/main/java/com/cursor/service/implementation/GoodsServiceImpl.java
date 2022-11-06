package com.cursor.service.implementation;


import com.cursor.entity.Goods;
import com.cursor.repository.GoodsRepository;
import com.cursor.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private final GoodsRepository goodsRepository;

    public GoodsServiceImpl(GoodsRepository goodsRepository) {
        this.goodsRepository = goodsRepository;
    }

    @Override
    public Goods create(Goods goods) {
        return goodsRepository.save(goods);
    }

    @Override
    public void modifyGoodsById(Goods goods, Long id) {
        goodsRepository.modifyGoodsById(id, goods.getName(), goods.getPrice(), goods.getDescription(), goods.getCountryProducer(),
                goods.getYearProduction(), goods.getYearExpireDate());
    }

    @Override
    public List<Goods> findAllExpiredGoods() {
        return goodsRepository.findAllExpiredGoods();
    }

    @Override
    public List<Goods> findCheepGoods() {
        return goodsRepository.findCheepGoods();
    }


    @Override
    public List<Goods> findAllGoods() {
        return (List<Goods>) goodsRepository.findAll();
    }

    @Override
    public List<Goods> findGoodsByProductionAndExpireYear(int goodsProductYear, int goodsExpireYear) {
        return goodsRepository.findGoodsByProductionAndExpireYear(goodsProductYear, goodsExpireYear);
    }

    @Override
    public void delete(Long id) {
        goodsRepository.deleteById(id);
    }

    @Override
    public Optional<Goods> findGoodsById(Long id) {
        return goodsRepository.findById(id);
    }

    @Override
    public List<Goods> findGoodsByName(String name) {
        return goodsRepository.findGoodsByName(name);
    }

}
