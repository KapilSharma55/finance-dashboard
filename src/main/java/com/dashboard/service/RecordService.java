package com.dashboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dashboard.model.FinanceRecord;
import com.dashboard.repository.RecordRepository;

@Service
public class RecordService {
	
	@Autowired
	private RecordRepository recordRepository;
	
	
	// create record
	public FinanceRecord save(FinanceRecord record) {
		return recordRepository.save(record);
	}
	
	// Get all
	public List<FinanceRecord> getAll(){
		return recordRepository.findAll();
	}
	
	// Delete record by id
	public void delete(Long id) {
		 recordRepository.deleteById(id);
	}
	
	
}
