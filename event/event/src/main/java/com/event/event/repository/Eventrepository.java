package com.event.event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.event.event.Model.Evententity;

@Repository
public interface Eventrepository extends JpaRepository<Evententity,Integer>{
	

}
