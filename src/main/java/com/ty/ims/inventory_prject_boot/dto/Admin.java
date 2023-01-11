package com.ty.ims.inventory_prject_boot.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
public class Admin {

	@Id
	@GenericGenerator(name = "admin_Id", strategy = "com.ty.ims.inventory_prject_boot.util.AdminCustomIdGenerator")
	@GeneratedValue(generator = "admin_Id")
	@Column(name = "admin_Id")
	private String id;
	@NotNull
	@Email(message = "Enter Proper Email ID")
	private String adminEmail;

	@NotNull
	private String adminPassword;

	@NotNull
	@Pattern(regexp = "^[A-Za-z]*$", message = "Use only Alphabets, Invalid Input")
	private String adminName;

	@Column(unique = true)
	private String adminRole;

	@NotNull
	private long adminPhone;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminRole() {
		return adminRole;
	}

	public void setAdminRole(String adminRole) {
		this.adminRole = adminRole;
	}

	public long getAdminPhone() {
		return adminPhone;
	}

	public void setAdminPhone(long adminPhone) {
		this.adminPhone = adminPhone;
	}

}
