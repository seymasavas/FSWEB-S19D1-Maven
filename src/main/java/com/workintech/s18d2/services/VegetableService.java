package com.workintech.s18d2.services;
import com.workintech.s18d2.entity.Vegetable;
import java.util.List;

public interface VegetableService {
    List<Vegetable> allVegetables();
    Vegetable getById(long id);
    Vegetable getByPrice(double price);
    Vegetable save(Vegetable vegetable);
    List<Vegetable> findByName(String name);
    Vegetable remove(long id);
    List<Vegetable> allVegetablesSortedByPriceDesc();
    List<Vegetable> allVegetablesSortedByPriceAsc();

}
