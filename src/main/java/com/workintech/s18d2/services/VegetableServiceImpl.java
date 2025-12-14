package com.workintech.s18d2.services;

import com.workintech.s18d2.dao.VegetableRepository;
import com.workintech.s18d2.entity.Vegetable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VegetableServiceImpl implements VegetableService{

    private VegetableRepository vegetableRepository;

    public VegetableServiceImpl(VegetableRepository vegetableRepository){
        this.vegetableRepository=vegetableRepository;
    }

    @Override
    public List<Vegetable> allVegetables() {
        return vegetableRepository.findAll();
    }

    @Override
    public Vegetable getById(long id) {
        return vegetableRepository.getById(id);
    }

    @Override
    public Vegetable getByPrice(double price) {
        return vegetableRepository.getByPrice(price);
    }

    @Override
    public Vegetable save(Vegetable vegetable) {
        Vegetable newVegetable=vegetableRepository.save(vegetable);
        return newVegetable;
    }

    @Override
    public List<Vegetable> findByName(String name) {
        return vegetableRepository.findByName(name);
    }

    @Override
    public Vegetable remove(long id) {
        Vegetable deletedVegetable=vegetableRepository.getById(id);
        vegetableRepository.delete(deletedVegetable);
        return deletedVegetable;
    }

    @Override
    public List<Vegetable> allVegetablesSortedByPriceDesc() {
        return vegetableRepository.allVegetablesSortedByPriceDesc();
    }

    @Override
    public List<Vegetable> allVegetablesSortedByPriceAsc() {
        return vegetableRepository.allVegetablesSortedByPriceAsc();
    }
}
