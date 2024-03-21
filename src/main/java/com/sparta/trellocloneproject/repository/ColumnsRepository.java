package com.sparta.trellocloneproject.repository;

import com.sparta.trellocloneproject.entity.Columns;
import com.sparta.trellocloneproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ColumnsRepository extends JpaRepository<Columns, Long> {

}