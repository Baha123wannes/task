package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.DeviceTypes;
import com.example.demo.model.NetworkType;
import com.example.demo.model.TargetType;
import com.example.demo.model.Task;
import com.example.demo.model.TaskTargetType;
import com.example.demo.repository.TaskTargetRepository;

@Service
public class TaskTargetTypeService {
	@Autowired
	private TaskTargetRepository targetRepo;

	public TaskTargetTypeService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TaskTargetTypeService(TaskTargetRepository targetRepo) {
		super();
		this.targetRepo = targetRepo;
	}
	//CRUD task 
		public TaskTargetType saveTargetType(TaskTargetType TargetType)
		{
			return targetRepo.save(TargetType);
		}
		public Optional<TaskTargetType> findTargetTypeById(int id)
		{
			return targetRepo.findById(id);
		}
		public boolean deleteTargetType(TaskTargetType TargetType)
		{	targetRepo.delete(TargetType);
			return true;
		}
		
}
