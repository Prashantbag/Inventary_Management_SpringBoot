package com.ty.ims.inventory_prject_boot.exception;

public class ItemQuantityExceededException extends RuntimeException {

	String message = "Item Quantity Exceeded Per Customer";

	public ItemQuantityExceededException(String message) {
		super();
		this.message = message;
	}

	public ItemQuantityExceededException() {

	}

	@Override
	public String getMessage() {
		return message;
	}

}
