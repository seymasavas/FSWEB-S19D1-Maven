package com.workintech.s18d2.controller;


import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.services.VegetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/vegetable")
public class VegetableController {
    private VegetableService vegetableService;

    @Autowired
    public VegetableController(VegetableService vegetableService){
        this.vegetableService=vegetableService;
    }
    //url olarak asc yazmak gerekebilir?
    @GetMapping
    public List<Vegetable> allVegetablesSortedByPriceAsc(){
        return vegetableService.allVegetablesSortedByPriceAsc();
    }
    @GetMapping("/{id}")
    public Vegetable getById(@PathVariable long id){
        return vegetableService.getById(id);
    }
    @GetMapping("/desc")
    public List<Vegetable> allVegetablesSortedByPriceDesc(){
        return vegetableService.allVegetablesSortedByPriceDesc();
    }

    // exception
    @PostMapping
    public Vegetable savedVegetable(@RequestBody Vegetable vegetable){
        return vegetableService.save(vegetable);
    }
    @PostMapping("/{name}")
    public List<Vegetable> findByName(String name){
        return vegetableService.findByName(name);
    }
    @DeleteMapping("/{id}")
    public Vegetable remove(@PathVariable long id){
        Vegetable deletedvegetable=vegetableService.remove(id);
        return deletedvegetable;
    }

}
