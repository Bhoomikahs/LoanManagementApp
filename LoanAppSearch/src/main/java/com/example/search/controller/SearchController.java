package com.example.search.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.search.dto.SearchRequest;
import com.example.search.entity.Borrower;
import com.example.search.entity.Loan;
import com.example.search.repo.BorrowerRepository;
import com.example.search.repo.LoanRepository;
import com.sipios.springsearch.anotation.SearchSpec;

@RestController
public class SearchController {
	
	@Autowired
	private BorrowerRepository borrowerRepository;
	
	@Autowired
	private LoanRepository loanRepository;
	
	public SearchController(BorrowerRepository borrowerRepository,LoanRepository loanRepository) {
		this.borrowerRepository=borrowerRepository;
		this.loanRepository=loanRepository;
		
	}
	
	@PostMapping("/create")
	public Borrower createSearch(@RequestBody SearchRequest request) {
		return borrowerRepository.save(request.getBorrower());
	}
	
	@GetMapping("/findAll")
	public List<Borrower> getAllSearch(){
		return borrowerRepository.findAll();
	}
	
	@GetMapping("/find")
    public ResponseEntity<List<Borrower>> searchForCars(@SearchSpec Specification<Borrower> specs) {
        return new ResponseEntity<>(borrowerRepository.findAll(Specification.where(specs)), HttpStatus.OK);
    }
	
	@GetMapping("/find1")
    public ResponseEntity<List<Loan>> searchForCars1(@SearchSpec Specification<Loan> specs) {
        return new ResponseEntity<>(loanRepository.findAll(Specification.where(specs)), HttpStatus.OK);
    }
	
	
}
