package com.example.Expense_Tracker_Application.Repository;

import com.example.Expense_Tracker_Application.Model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long>{

    List<Expense> findByExpenseDate(LocalDate expenseDate);

    @Query("""
            SELECT SUM(e.amount)
            FROM Expense e
            WHERE MONTH(e.expenseDate)= :month            
            """)
    Double getMonthlyTotal(@Param("month") int month);

    @Query("""
       SELECT e.category, SUM(e.amount)
       FROM Expense e
       WHERE MONTH(e.expenseDate) = :month
       GROUP BY e.category
       """)
    List<Object[]> getCategoryWiseMonthlySpend(@Param("month") int month);

    @Query("""
       SELECT e.paymentMode, SUM(e.amount)
       FROM Expense e
       WHERE MONTH(e.expenseDate) = :month
       GROUP BY e.paymentMode
       """)
    List<Object[]> getPaymentModeWiseMonthlySpend(@Param("month") int month);

    





}
