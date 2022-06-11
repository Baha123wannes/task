package com.example.demo.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Task;
import com.example.demo.model.TaskScheduling;
import com.example.demo.model.TaskStatut;
import com.example.demo.repository.TaskSchedulingRepository;

@Service
public class TaskSchedulingService {
	@Autowired
	private TaskSchedulingRepository SchedulerRepo;
	
	public TaskSchedulingService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TaskSchedulingService(TaskSchedulingRepository schedulerRepo) {
		super();
		SchedulerRepo = schedulerRepo;
	}
	
	//CRUD //Manque udpate
	public TaskScheduling saveTask(TaskScheduling taskScheduling)
	{
		return SchedulerRepo.save(taskScheduling);
	}
	public Optional<TaskScheduling> findTaskById(int id)
	{
		return SchedulerRepo.findById(id);
	}
	public boolean deleteTask(TaskScheduling taskScheduling)
	{	SchedulerRepo.delete(taskScheduling);
		return true;
	}
	
	//Creation Task Scheduling
	
	public TaskScheduling taskSchduler(LocalDate start,LocalDate end,LocalDate startLimit)
	{
		TaskScheduling scheduler =new TaskScheduling();
		if((start.isBefore(startLimit))&&(startLimit.isBefore(end)))
		{
			scheduler.setStart(start);
			scheduler.setStop(end);
			scheduler.setStart_limit(startLimit);
			
			return scheduler;
		}
		else
			return scheduler;
		
	}
}
