package com.dashboard.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dashboard.model.FinanceRecord;
import com.dashboard.model.Type;

public interface RecordRepository extends JpaRepository<FinanceRecord, Long> {

	List<Record> findByType(Type type);
	
	List<Record> findByCategory(String category);
	
	List<Record> findByDateBetween(LocalDate start, LocalDate end);
}
