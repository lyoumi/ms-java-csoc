package com.so.csoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.so.csoc.data.entity.Phone;

public interface PhoneRepository extends JpaRepository<Phone, String> {

}
