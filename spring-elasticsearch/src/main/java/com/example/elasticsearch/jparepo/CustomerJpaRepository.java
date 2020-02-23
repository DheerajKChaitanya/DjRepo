package com.example.elasticsearch.jparepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.elasticsearch.model.Customer;

@Repository
public interface CustomerJpaRepository extends JpaRepository<Customer,String> {

}
