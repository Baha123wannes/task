package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Option;
import com.example.demo.model.Task;
import com.example.demo.repository.TaskOptionRepository;

@Service
public class OptionService {
	@Autowired
	private TaskOptionRepository OptionRepo;

	public OptionService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OptionService(TaskOptionRepository optionRepo) {
		super();
		OptionRepo = optionRepo;
	}
	//CRUD task 
	public Option saveTask(Option options)
	{
		return OptionRepo.save(options);
	}
	public Optional<Option> findTaskById(int id)
	{
		return OptionRepo.findById(id);
	}
	public boolean deleteTask(Option options)
	{	OptionRepo.delete(options);
		return true;
	}
	
}
