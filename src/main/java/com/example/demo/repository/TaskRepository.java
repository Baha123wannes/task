package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Profil;
import com.example.demo.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task,Integer> {



	Task findByProfils(Profil profil);


	Task findByStatus(String status);


	Task findByName(String task);

}
