package com.dashboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dashboard.model.FinanceRecord;
import com.dashboard.service.RecordService;

@RestController
@RequestMapping("/records")
public class RecordController {

	@Autowired
	private RecordService recordService;
	
	// create record
	@PreAuthorize("hasAnyRole('ADMIN','ANALYST')")
	@PostMapping
	public FinanceRecord create(@RequestBody FinanceRecord record) {
		return recordService.save(record);
	}
	
	// get all records
	@GetMapping
	public List<FinanceRecord> getAll(){
		return recordService.getAll();
	}
	
	// delete records by id
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		recordService.delete(id);
	}
	
}
