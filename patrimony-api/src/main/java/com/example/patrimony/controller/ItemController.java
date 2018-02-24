package com.example.patrimony.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.patrimony.model.Item;
import com.example.patrimony.repository.ItemRepository;

@RestController
@RequestMapping(value="/itens")
@CrossOrigin("${origin-allowed}")
public class ItemController {
 //Inject dependcy
	@Autowired
	private ItemRepository itemRepository;

	@GetMapping 
	public List<Item> listAll(){
		return itemRepository.findAll();
	}
	
	@PostMapping
	public Item add(@RequestBody @Valid Item item) {
		return itemRepository.save(item);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
		
		itemRepository.delete(id);
		return ResponseEntity.noContent().build();
	}

}
