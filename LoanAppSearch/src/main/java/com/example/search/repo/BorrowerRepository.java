package com.example.search.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.search.entity.Borrower;

@RepositoryRestResource
public interface BorrowerRepository extends JpaRepository<Borrower, Integer>,JpaSpecificationExecutor<Borrower>{

}
