package com.example.spring.Controller;

import com.example.spring.Database.Database;
import com.example.spring.Database.TestBean;
import com.example.spring.model.Item;
import com.example.spring.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    // IOC / DI
    // IoC - Inversion of control
    // DI - Dependency Injection

    //changes from user 1

    @Autowired
    private TestBean testBean;

    @Qualifier(value = "testBean2")
    @Autowired TestBean testBean2;

    @Autowired
    private ItemService itemService;

    @GetMapping
    public String index(Model model) {
        List<Item> items = itemService.getAllItems();
        model.addAttribute("items", items);
//        model.addAttribute("testBean", testBean.getBeanData());
        return "index";
    }

    @GetMapping("/item/{id}")
    public String details(@PathVariable("id") Long id, Model model) {
        Item item = itemService.getItemById(id);
        List<String> countries = Arrays.asList("Kazakhstan","Russia","China", "USA");
        model.addAttribute("item", item);
        model.addAttribute("countries", countries);
        return "details";
    }

    @PostMapping("/addItem")
    public String addedItem(@RequestParam(value = "name") String name,
                            @RequestParam(value = "description") String description,
                            @RequestParam(value = "price") int price) {
        Item item = Item.builder()
                .name(name)
                .price(price)
                .description(description)
                .build();
        Database.addItem(item);

        return "redirect:/api";
    }

    @PostMapping("/delete/{id}")
    public String deleteItemById(@PathVariable("id") Long id) {
        Database.removeItemById(id);
        return "redirect:/";
    }

    @PostMapping("/update/{id}")
    public String updateItemById(Model model,
                                 @PathVariable("id") Long id,
                                 @RequestParam(value = "name") String name,
                                 @RequestParam(value = "description") String description,
                                 @RequestParam(value = "price") int price) {
        Item item = Item.builder()
                .id(id)
                .description(description)
                .name(name)
                .price(price)
                .build();
        Database.updateItem(item);
        return "redirect:/item/" + id;
    }


}