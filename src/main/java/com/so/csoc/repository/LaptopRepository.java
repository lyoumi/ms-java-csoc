package com.so.csoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.so.csoc.data.entity.Laptop;

public interface LaptopRepository extends JpaRepository<Laptop, String> {

}
