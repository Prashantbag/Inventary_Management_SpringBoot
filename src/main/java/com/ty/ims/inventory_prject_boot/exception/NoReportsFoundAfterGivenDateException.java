package com.ty.ims.inventory_prject_boot.exception;

public class NoReportsFoundAfterGivenDateException extends RuntimeException {

	String message = "No Transactions found afte the date";

	public NoReportsFoundAfterGivenDateException(String message) {
		super();
		this.message = message;
	}

	public NoReportsFoundAfterGivenDateException() {

	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}

}
