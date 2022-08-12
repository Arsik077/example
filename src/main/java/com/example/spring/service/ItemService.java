package com.example.spring.service;

import com.example.spring.model.Item;

import java.util.List;

public interface ItemService {
    List<Item> getAllItems();
    Item getItemById(Long id);
}
