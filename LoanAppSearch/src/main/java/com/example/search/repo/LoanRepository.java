package com.example.search.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.search.entity.Borrower;
import com.example.search.entity.Loan;

public interface LoanRepository extends JpaRepository<Loan, Integer>,JpaSpecificationExecutor<Loan> {

}
