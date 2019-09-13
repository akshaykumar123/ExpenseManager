package com.techsophy.expense.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techsophy.expense.entity.ExpenseEntity;
import com.techsophy.expense.repository.ExpenseRepository;

@Service
public class ExpenseServiceImpl implements ExpenseService {
	
	private final Logger logger = LoggerFactory.getLogger(ExpenseServiceImpl.class);
	private ExpenseRepository expenseRepository;
	
	@Autowired
	public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
		super();
		this.expenseRepository = expenseRepository;
	}

	@Override
	public ExpenseEntity addExpense(ExpenseEntity expense) {
		expenseRepository.save(expense);
		logger.info("Added person id :  [{}]", expense.getId());
		
		return expense;
	}

	@Override
	public List<ExpenseEntity> getAllExpenses() {
        logger.info("getAll Called");
		
		return expenseRepository.findAll();
		
	}

	@Override
	public ExpenseEntity updateExpense(ExpenseEntity expense) {
        expenseRepository.save(expense);
		
		logger.info("Updated id : [{}]", expense.getId());

		return expense;
	}

	@Override
	public void deleteExpense(Integer id) {
        
		
		expenseRepository.deleteById(id);
		
	}

	@Override
	public List<ExpenseEntity> searchExpenseByDate(String date) {
		return expenseRepository.getExpenseByDate(date.toLowerCase());		
	}

}
