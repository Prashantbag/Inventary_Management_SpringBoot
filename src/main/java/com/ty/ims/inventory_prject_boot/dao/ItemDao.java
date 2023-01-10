package com.ty.ims.inventory_prject_boot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.ims.inventory_prject_boot.dto.Item;
import com.ty.ims.inventory_prject_boot.repository.ItemRepository;

@Repository
public class ItemDao {

	@Autowired
	ItemRepository repository;

	public Item saveItem(Item item) {
		return repository.save(item);
	}

	public Item updateItem(Item item) {
		return repository.save(item);
	}

	public Optional<Item> findItembyid(int id) {
		return repository.findById(id);
	}

	public void deleteItem(Item item) {
		repository.delete(item);
	}

	public List<Item> findbyprice(double price) {
		return repository.findByPrice(price);
	}

	public List<Item> filterbyqtygreater(int qty) {
		return repository.findByquantityGreaterThanEqual(qty);
	}

	public List<Item> filterbyqtylesser(int qty) {
		return repository.findByquantityLessThanEqual(qty);
	}
}
