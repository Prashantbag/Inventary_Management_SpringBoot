package com.ty.ims.inventory_prject_boot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.ims.inventory_prject_boot.dao.AdminDao;
import com.ty.ims.inventory_prject_boot.dto.Admin;
import com.ty.ims.inventory_prject_boot.exception.AdminRegisterNotAllowedException;
import com.ty.ims.inventory_prject_boot.exception.NoSuchIdFoundException;
import com.ty.ims.inventory_prject_boot.exception.WrongEmailIDPasswordException;
import com.ty.ims.inventory_prject_boot.util.CryptographicalSecurity;
import com.ty.ims.inventory_prject_boot.util.ResponseStructure;

@Service
public class AdminService {

	@Autowired
	private AdminDao adminDao;

	@Autowired
	private CryptographicalSecurity cryptographicalSecurity;

	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(Admin admin) {
		ResponseStructure<Admin> responseStructure = new ResponseStructure<Admin>();
		if (adminDao.getAllAdmin().size() < 3) {
			admin.setAdminPassword(cryptographicalSecurity.encrypt(admin.getAdminPassword()));
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setMessage("Admin created");
			responseStructure.setData(adminDao.saveAdmin(admin));
		} else {
			throw new AdminRegisterNotAllowedException();
		}
		ResponseEntity<ResponseStructure<Admin>> responseEntity = new ResponseEntity<ResponseStructure<Admin>>(
				responseStructure, HttpStatus.CREATED);

		return responseEntity;

	}

	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(Admin admin, String id) {
		ResponseStructure<Admin> responseStructure = new ResponseStructure<Admin>();

		Optional<Admin> admin2 = adminDao.getAdminById(id);

		if (admin2.isPresent()) {
			admin.setId(id);
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setMessage("Admin Found & Updated");
			responseStructure.setData(adminDao.saveAdmin(admin));
		} else {
			throw new NoSuchIdFoundException();
		}
		ResponseEntity<ResponseStructure<Admin>> responseEntity = new ResponseEntity<ResponseStructure<Admin>>(
				responseStructure, HttpStatus.CREATED);

		return responseEntity;
	}

	public ResponseEntity<ResponseStructure<Admin>> getAdminById(String id) {

		ResponseStructure<Admin> responseStructure = new ResponseStructure<Admin>();

		Optional<Admin> optional = adminDao.getAdminById(id);

		if (optional.isPresent()) {
			Admin admin = optional.get();
			admin.setAdminPassword(cryptographicalSecurity.decrypt(admin.getAdminPassword()));
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Admin Found");
			responseStructure.setData(admin);

		} else {
			throw new NoSuchIdFoundException();
		}
		ResponseEntity<ResponseStructure<Admin>> responseEntity = new ResponseEntity<ResponseStructure<Admin>>(
				responseStructure, HttpStatus.FOUND);

		return responseEntity;
	}

	public ResponseEntity<ResponseStructure<Admin>> deleteAdmin(String id) {
		ResponseStructure<Admin> responseStructure = new ResponseStructure<Admin>();
		Optional<Admin> optional = adminDao.getAdminById(id);

		if (optional.isPresent()) {
			adminDao.deleteAdmin(optional.get());
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Admin Found and Deleted");
			responseStructure.setData(optional.get());
		} else {
			throw new NoSuchIdFoundException();
		}
		ResponseEntity<ResponseStructure<Admin>> responseEntity = new ResponseEntity<ResponseStructure<Admin>>(
				responseStructure, HttpStatus.FOUND);

		return responseEntity;

	}

	public ResponseEntity<ResponseStructure<Admin>> loginAdmin(Admin admin) {
		ResponseStructure<Admin> responseStructure = new ResponseStructure<Admin>();

		String password = admin.getAdminPassword();
		List<Admin> alladmin = adminDao.getAllAdmin();

		for (Admin admin2 : alladmin) {
			if (cryptographicalSecurity.decrypt(admin2.getAdminPassword()).equals(password)) {
				responseStructure.setStatus(HttpStatus.FOUND.value());
				responseStructure.setMessage("Admin Found & Granted Access");
				responseStructure.setData(admin);
				break;
			} else {
				throw new WrongEmailIDPasswordException();
			}
		}

		return new ResponseEntity<ResponseStructure<Admin>>(responseStructure, HttpStatus.FOUND);
	}

}
