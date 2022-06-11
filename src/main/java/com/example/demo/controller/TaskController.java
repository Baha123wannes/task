package com.example.demo.controller;

import java.time.LocalDate;
import java.util.Date;

import org.joda.time.Instant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.TargetType;
import com.example.demo.model.Task;
import com.example.demo.model.TaskTargetType;
import com.example.demo.service.TaskService;

@RestController
public class TaskController {
	@Autowired 
	private TaskService taskService;
	
	@GetMapping("/findTask/{name}")
	public Task searchTask(@PathVariable int name)
	{
		return taskService.findTaskById(name).get();
	}
	@GetMapping("/test/{nametask}/{category}/{source}/{typeTarget}/{version}/{idType}/{start}/{end}/{startLimit}/{profilName}")
	public Task test(@PathVariable String nametask,@PathVariable String category,@PathVariable String source,@PathVariable TargetType typeTarget,@PathVariable String version,@PathVariable int idType,@PathVariable("start") @DateTimeFormat(pattern = "yyyy-MM-dd") Date start,@PathVariable("end") @DateTimeFormat(pattern = "yyyy-MM-dd") Date end,@PathVariable("startLimit") @DateTimeFormat(pattern = "yyyy-MM-dd")  Date startLimit,@PathVariable String profilName)
	{
		return taskService.taskDescription(nametask,category,source, typeTarget,version,idType, start, end, startLimit,profilName);
	}
	@GetMapping("/date")
	public LocalDate date()
	{	
		 LocalDate localDate = LocalDate.now();
		 return localDate;
	}
}
