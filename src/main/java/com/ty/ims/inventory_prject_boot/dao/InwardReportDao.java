package com.ty.ims.inventory_prject_boot.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.ims.inventory_prject_boot.dto.InwardReport;
import com.ty.ims.inventory_prject_boot.repository.InwardReportRepository;

@Repository
public class InwardReportDao {

	@Autowired
	InwardReportRepository inwardReportRepository;

	public InwardReport saveInwardReport(InwardReport inwardReport) {

		return inwardReportRepository.save(inwardReport);
	}
}
