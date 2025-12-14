package com.workintech.s18d2.services;

import com.workintech.s18d2.dao.FruitRepository;
import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.exception.PlantException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FruitServiceImpl implements  FruitService {
    private FruitRepository fruitRepository;

    @Autowired
    public FruitServiceImpl(FruitRepository fruitRepository){
        this.fruitRepository=fruitRepository;
    }

    @Override
    public List<Fruit> allFruit() {
        return fruitRepository.findAll();
    }

    @Override
    public Fruit getById(long id) {
        return fruitRepository.findById(id)
                .orElseThrow(() -> new PlantException(
                        "Fruit with id " + id + " not found",
                        HttpStatus.NOT_FOUND
                ));

    }
    @Override
    public Fruit getByPrice(double price) {
        return fruitRepository.getByPrice(price);
    }

    @Override
    public Fruit save(Fruit fruit) {
        Fruit newfruit=fruitRepository.save(fruit);
        return newfruit;
    }

    @Override
    public List<Fruit> searchByName(String name) {
        return fruitRepository.searchByName(name);
    }

    @Override
    public Fruit delete(long id) {
        Fruit deletedFruit = fruitRepository.findById(id)
                .orElseThrow(() -> new PlantException(
                        "Fruit with id " + id + " not found",
                        HttpStatus.NOT_FOUND
                ));
        fruitRepository.delete(deletedFruit);
        return deletedFruit;
    }
    @Override
    public List<Fruit> getByPriceDesc(){
        return fruitRepository.getByPriceDesc();

    }

    @Override
    public List<Fruit> getByPriceAsc(){
        return fruitRepository.getByPriceAsc();

    }
}
