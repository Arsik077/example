package com.example.spring.repositories;

import com.example.spring.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findAllByAmountBetweenAndBrandIsStartingWith(int from, int to,String brand);
}
