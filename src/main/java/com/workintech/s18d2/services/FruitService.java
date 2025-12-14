package com.workintech.s18d2.services;
import com.workintech.s18d2.entity.Fruit;
import java.util.List;

public interface FruitService {
    List<Fruit> allFruit();
    Fruit getById(long id);
    Fruit getByPrice(double price);
    Fruit save(Fruit fruit);
    List<Fruit> searchByName(String name);
    Fruit delete(long id);
    List<Fruit> getByPriceAsc();
    List<Fruit> getByPriceDesc();

}
