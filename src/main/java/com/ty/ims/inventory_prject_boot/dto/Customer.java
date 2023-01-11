package com.ty.ims.inventory_prject_boot.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Customer {
	@Id
	@GenericGenerator(name = "customer_Id", strategy = "com.ty.ims.inventory_prject_boot.util.Customer_customIdGenerator")
	@GeneratedValue(generator = "customer_Id")
	@Column(name = "customer_Id")
	private String customerId;
	@NotNull
	@Pattern(regexp = "^[A-Za-z]*$", message = "Use only Alphabets, Invalid Input")
	private String customerName;

	@Column(unique = true)
	@Email(message = "Enter Proper Email ID")
	private String customerEmailId;

	@NotNull
	private long customerPhoneNo;

	private Date outwardDate;

	private int outwardQuantity;

	@JsonIgnoreProperties(value = { "quantity" }, allowSetters = true)
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(joinColumns = @JoinColumn, inverseJoinColumns = @JoinColumn)
	private List<Item> item;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmailId() {
		return customerEmailId;
	}

	public void setCustomerEmailId(String customerEmailId) {
		this.customerEmailId = customerEmailId;
	}

	public long getCustomerPhoneNo() {
		return customerPhoneNo;
	}

	public void setCustomerPhoneNo(long customerPhoneNo) {
		this.customerPhoneNo = customerPhoneNo;
	}

	public Date getOutwardDate() {
		return outwardDate;
	}

	public void setOutwardDate(Date outwardDate) {
		this.outwardDate = outwardDate;
	}

	public int getOutwardQuantity() {
		return outwardQuantity;
	}

	public void setOutwardQuantity(int outwardQuantity) {
		this.outwardQuantity = outwardQuantity;
	}

	public List<Item> getItem() {
		return item;
	}

	public void setItem(List<Item> item) {
		this.item = item;
	}

}
