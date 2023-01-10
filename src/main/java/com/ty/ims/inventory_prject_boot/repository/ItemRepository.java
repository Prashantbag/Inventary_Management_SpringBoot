package com.ty.ims.inventory_prject_boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.ims.inventory_prject_boot.dto.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

	public List<Item> findByPrice(double price);
	public List<Item> findByquantity (int qty);
	public List<Item> findByquantityGreaterThanEqual(int qty);
	public List<Item> findByquantityLessThanEqual(int qty);
}
