package com.hospitalmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospitalmanagement.entity.Address;

public interface AddressRepo extends JpaRepository<Address,Integer>{

}
