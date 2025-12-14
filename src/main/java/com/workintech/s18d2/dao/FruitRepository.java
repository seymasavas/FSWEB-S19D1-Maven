package com.workintech.s18d2.dao;
import com.workintech.s18d2.entity.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FruitRepository extends JpaRepository <Fruit,Long> {

    Fruit getByPrice(double price);
    @Query("select f from Fruit f where f.name like CONCAT('%',:name,'%')")
    List<Fruit> searchByName(String name);
    @Query("select f from Fruit f order by f.price ASC")
    List<Fruit> getByPriceAsc();
    @Query("select f from Fruit f order by f.price DESC")
    List<Fruit> getByPriceDesc();


}
