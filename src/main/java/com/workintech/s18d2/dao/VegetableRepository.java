package com.workintech.s18d2.dao;
import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.entity.Vegetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VegetableRepository extends JpaRepository<Vegetable,Long> {

    Vegetable getByPrice(double price);
    @Query("select v from Vegetable v where v.name like CONCAT('%',:name,'%')")
    List<Vegetable> findByName(String name);
    @Query("select v from Vegetable v order by v.price DESC")
    List<Vegetable> allVegetablesSortedByPriceDesc();
    @Query("select v from Vegetable v order by v.price ASC")
    List<Vegetable> allVegetablesSortedByPriceAsc();



}
