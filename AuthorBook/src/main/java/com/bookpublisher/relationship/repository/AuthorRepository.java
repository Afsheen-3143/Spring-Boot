package com.bookpublisher.relationship.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookpublisher.relationship.model.Author;

public interface AuthorRepository extends JpaRepository<Author,Integer>{
	
}
