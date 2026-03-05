package com.example.Expense_Tracker_Application.Service;
import com.example.Expense_Tracker_Application.Exception.ExpenseNotFoundException;
import com.example.Expense_Tracker_Application.Model.Expense;
import com.example.Expense_Tracker_Application.Repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import com.example.Expense_Tracker_Application.dto.ExpenseResponseDTO;
import java.time.LocalDate;
import java.util.List;

        @Service
        public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

            private ExpenseResponseDTO convertToDTO(Expense expense) {
                return new ExpenseResponseDTO(
                        expense.getId(),
                        expense.getAmount(),
                        expense.getCategory(),
                        expense.getPaymentMode(),
                        expense.getExpenseDate()
                );
            }



    @Override
    public Expense addExpense(Expense expense){
        return expenseRepository.save(expense);
    }

    @Override
    public List<ExpenseResponseDTO> getAllExpenses() {

        return expenseRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .toList();
    }
    @Override
    public List<Expense> getExpensesByDate(LocalDate date){
        return expenseRepository.findByExpenseDate(date);
    }

    @Override
    public Double getMonthlyTotal(int month){
        return expenseRepository.getMonthlyTotal(month);
    }

    @Override
    public List<Object[]> getCategoryWiseMonthlySpend(int month){
        return expenseRepository.getCategoryWiseMonthlySpend(month);
    }

    @Override
            public Expense updateExpense(Long id, Expense updatedExpense){
        Expense existingExpense = expenseRepository.findById(id).orElseThrow(() -> new ExpenseNotFoundException("Expense not found with id "+ id));

       // Expense updatedExpense;
        existingExpense.setAmount(updatedExpense.getAmount());
        existingExpense.setCategory(updatedExpense.getCategory());
        existingExpense.setPaymentMode(updatedExpense.getPaymentMode());
        existingExpense.setExpenseType(updatedExpense.getExpenseType());
        existingExpense.setExpenseDate(updatedExpense.getExpenseDate());
        existingExpense.setDescription(updatedExpense.getDescription());

        return expenseRepository.save(existingExpense);
    }

    @Override
    public void deleteExpense(Long id) {
        if (!expenseRepository.existsById(id)) {
            throw new ExpenseNotFoundException("Expense not found with id " + id);
                }
        expenseRepository.deleteById(id);
            }


            @Override
    public List<Object[]> getPaymentModeWiseMonthlySpend(int month) {
        return expenseRepository.getPaymentModeWiseMonthlySpend(month);
            }

            @Override
            public Page<Expense> getExpensesWithPagination(int page, int size) {
                return expenseRepository.findAll(PageRequest.of(page, size));
            }



        }
