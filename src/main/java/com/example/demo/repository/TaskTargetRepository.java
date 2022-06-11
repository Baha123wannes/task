package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.TaskTargetType;
@Repository
public interface TaskTargetRepository extends JpaRepository<TaskTargetType,Integer> {

}
