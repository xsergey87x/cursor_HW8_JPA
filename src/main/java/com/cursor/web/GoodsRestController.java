package com.cursor.web;


import com.cursor.entity.Goods;
import com.cursor.service.GoodsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/")
public class GoodsRestController {

    private final GoodsService goodsService;

    public GoodsRestController(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @PostMapping(value = "/addGoods")
    @ResponseStatus(HttpStatus.CREATED)
    public Goods createGoods(@RequestBody Goods goods) {
        return goodsService.create(goods);
    }

    @GetMapping(value = "/addTestGoods")
    @ResponseStatus(HttpStatus.CREATED)
    public Goods createTestGoods() {
        return goodsService.create(new Goods("SecondThing", 20, "doSomeImportant", "Canada", 2010, 2015));
    }

    @GetMapping(value = "/allGoods")
    public List<Goods> getAllGoods() { // users/user/42
        return goodsService.findAllGoods();
    }

    @GetMapping("/findGoodsById/{goodsId}")
    public ResponseEntity getGoodsById(@PathVariable Long goodsId) {
        Optional<Goods> goods = goodsService.findGoodsById(goodsId);
        if (goods == null) {
            return ResponseEntity.status(HttpStatus.valueOf(404)).body("Goods with this Id doesn't exist");
        }
        return new ResponseEntity<>(goods, HttpStatus.OK);
    }

    @GetMapping("/deleteGoodsById/{goodsId}")
    public void deleteGoodsById(@PathVariable Long goodsId) {
        goodsService.delete(goodsId);
    }

    @GetMapping("/findGoodsByName/{goodsName}")
    public ResponseEntity getGoodsByName(@PathVariable String goodsName) {
        List<Goods> goods = goodsService.findGoodsByName(goodsName);
        if (goods == null) {
            return ResponseEntity.status(HttpStatus.valueOf(404)).body("Goods with this Name doesn't exist");
        }
        return new ResponseEntity<>(goods, HttpStatus.OK);
    }

    @PostMapping(value = "/modifyGoodsById/{goodsId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void modifyGoodsById(@PathVariable Long goodsId, @RequestBody Goods goods) {
        goodsService.modifyGoodsById(goods, goodsId);
    }

    @GetMapping("/findExpiredGoods")
    public List<Goods> findExpiredGoods() {
        return goodsService.findAllExpiredGoods();
    }

    @GetMapping("/findCheepGoods")
    public List<Goods> findCheepGoods() {
        return goodsService.findCheepGoods();
    }

    @GetMapping("/findGoodsByProductionAndExpireYear/{goodsProductYear}/{goodsExpireYear}")
    public List<Goods> findGoodsByProductionAndExpireYear(@PathVariable int goodsProductYear, @PathVariable int goodsExpireYear) {
        return goodsService.findGoodsByProductionAndExpireYear(goodsProductYear, goodsExpireYear);
    }

}
