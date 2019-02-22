package com.epam.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epam.course.model.MyProduct;

@Repository
public interface MyProductRepository extends JpaRepository<MyProduct,Long> {

}
