package com.capg.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.springboot.entity.Wikimedia;

public interface WikimediaDataRepository extends JpaRepository<Wikimedia, Long> {

}
