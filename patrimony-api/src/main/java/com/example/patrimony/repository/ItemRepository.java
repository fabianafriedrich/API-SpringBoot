package com.example.patrimony.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.patrimony.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{

}
