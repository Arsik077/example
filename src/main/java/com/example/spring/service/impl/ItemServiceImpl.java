package com.example.spring.service.impl;

import com.example.spring.model.Item;
import com.example.spring.repositories.ItemRepository;
import com.example.spring.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;


    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAllByAmountBetweenAndBrandIsStartingWith(10,20,"qwe");
    }

    @Override
    public Item getItemById(Long id) {
        Optional<Item> itemOptional = itemRepository.findById(id);
        if(itemOptional.isPresent()){
            return itemOptional.get();
        }
        return null;
    }
}
