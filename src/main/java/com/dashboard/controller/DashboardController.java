package com.dashboard.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dashboard.model.FinanceRecord;
import com.dashboard.model.Type;
import com.dashboard.repository.RecordRepository;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

	@Autowired
	private RecordRepository recordRepository;
	
	@PreAuthorize("hasAnyRole('ADMIN','ANALYST','VIEWER')")
	@GetMapping("/summary")
	public Map<String, Double> getSummary(){
		
		// fetch records from repository
		List<FinanceRecord> records = recordRepository.findAll();
	     
		double income = 0;
		double expense = 0;
		
		for(FinanceRecord r: records) {
			if(r.getType() == Type.INCOME) {
				income += r.getAmount();
			} else {
				expense += r.getAmount();
			}
		}
		Map<String, Double> result = new HashMap<>();
		result.put("totalIncome", income);
		result.put("totalExpense", expense);
		result.put("netBalance", income - expense);
		
		return result;
	}
}
