package com.example.search.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="borrower")
public class Borrower {
	
	@Id
    @GeneratedValue
	private int id;
	
	@Column(nullable = false,length = 50,unique = true)
	private String borrowerName;
	
	@Column(nullable = false,length = 50)
	private String gender;
	
	
	@OneToMany(targetEntity = Loan.class,cascade = CascadeType.ALL)
	@JoinColumn(name="loan_id")
	private List<Loan> loan;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getBorrowerName() {
		return borrowerName;
	}


	public void setBorrowerName(String borrowerName) {
		this.borrowerName = borrowerName;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public List<Loan> getLoan() {
		return loan;
	}


	public void setLoan(List<Loan> loan) {
		this.loan = loan;
	}
	
	
}
