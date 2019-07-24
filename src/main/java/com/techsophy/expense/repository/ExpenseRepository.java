package com.techsophy.expense.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techsophy.expense.entity.ExpenseEntity;


public interface ExpenseRepository extends JpaRepository<ExpenseEntity,Integer>{
	
	//@Query("SELECT p FROM Person as p LEFT OUTER JOIN p.addressList al WHERE lower(p.firstName) = ?1 and lower(p.lastName) = ?2 and lower(al.type) =?3")
	List<ExpenseEntity> getExpenseByDate(String date);

}
