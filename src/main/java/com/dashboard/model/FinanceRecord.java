package com.dashboard.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class FinanceRecord {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Double amount;
	
	@Enumerated(EnumType.STRING)
	private Type type; // income // Expense
	
	 private String category;

	 private LocalDate date;

	 private String notes;
	 
	 @ManyToOne
	 private User user;

	 public Long getId() {
		 return id;
	 }

	 public void setId(Long id) {
		 this.id = id;
	 }

	 public Double getAmount() {
		 return amount;
	 }

	 public void setAmount(Double amount) {
		 this.amount = amount;
	 }

	 public Type getType() {
		 return type;
	 }

	 public void setType(Type type) {
		 this.type = type;
	 }

	 public String getCategory() {
		 return category;
	 }

	 public void setCategory(String category) {
		 this.category = category;
	 }

	 public LocalDate getDate() {
		 return date;
	 }

	 public void setDate(LocalDate date) {
		 this.date = date;
	 }

	 public String getNotes() {
		 return notes;
	 }

	 public void setNotes(String notes) {
		 this.notes = notes;
	 }

	 public User getUser() {
		 return user;
	 }

	 public void setUser(User user) {
		 this.user = user;
	 }
	 
	 
	 
}
