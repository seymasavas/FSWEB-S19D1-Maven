package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.services.FruitService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@NoArgsConstructor
@RestController
@RequestMapping("/fruit")
public class FruitController {
    private FruitService fruitService;

    @Autowired
    public FruitController(FruitService fruitService){
        this.fruitService=fruitService;
    }
//url olarak asc yazmak gerekebilir?
    @GetMapping
    public List<Fruit> getByPriceAsc(){
        return fruitService.getByPriceAsc();
    }
    @GetMapping("/{id}")
    public Fruit getById(@PathVariable long id){
        return fruitService.getById(id);
    }
    @GetMapping("/desc")
    public List<Fruit> getByPriceDesc(){
        return fruitService.getByPriceDesc();
    }

    // exception
    @PostMapping
    public Fruit savedFruit(@RequestBody Fruit fruit){
        return fruitService.save(fruit);
    }
    @GetMapping ("/name/{name}")
    public List<Fruit> searchByName(@PathVariable String name){
        return fruitService.searchByName(name);
    }
    @DeleteMapping("/{id}")
    public Fruit delete(@PathVariable long id){
        Fruit deletedFruit=fruitService.delete(id);
        return deletedFruit;
    }

}
