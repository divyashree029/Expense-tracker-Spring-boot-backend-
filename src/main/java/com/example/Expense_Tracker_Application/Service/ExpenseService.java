package com.example.Expense_Tracker_Application.Service;

import com.example.Expense_Tracker_Application.Model.Expense;
import com.example.Expense_Tracker_Application.dto.ExpenseResponseDTO;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;

public interface ExpenseService {
    Expense addExpense(Expense expense);
    List<ExpenseResponseDTO> getAllExpenses();
    List<Expense> getExpensesByDate(LocalDate date);

    Double getMonthlyTotal(int month);

    List<Object[]> getCategoryWiseMonthlySpend(int month);

    Expense updateExpense(Long id, Expense expense);

    void deleteExpense(Long id);

    List<Object[]> getPaymentModeWiseMonthlySpend(int month);

    Page<Expense> getExpensesWithPagination(int page, int size);

}
