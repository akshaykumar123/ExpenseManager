package com.techsophy.expense.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.techsophy.expense.entity.ExpenseEntity;

public interface ExpenseRepository extends JpaRepository<ExpenseEntity, Integer> {

	List<ExpenseEntity> findByDate(String date);

	@Query("SELECT date FROM expenses date WHERE date.date like %:monthAndYear%")
	List<ExpenseEntity> findAllByMonthAndYear(String monthAndYear);

	@Query("SELECT date FROM expenses date WHERE date.date LIKE %:year%")
	List<ExpenseEntity> findAllByYear(String year);
}
