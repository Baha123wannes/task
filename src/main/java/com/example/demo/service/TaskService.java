package com.example.demo.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.CategoryRepo;
import com.example.demo.ServiceInter.DataModelService;
import com.example.demo.model.CPLProirity;
import com.example.demo.model.DlmsParams;
import com.example.demo.model.Profil;
import com.example.demo.model.RecoveryActive;
import com.example.demo.model.TargetType;
import com.example.demo.model.Task;
import com.example.demo.model.TaskStatut;
import com.example.demo.model.TaskTargetType;
import com.example.demo.repository.TaskRepository;

@Service
public class TaskService {
	@Autowired 
	private TaskRepository taskRepo;
	@Autowired 
	private CategoryService catRepo;
	@Autowired
	private TaskTargetTypeService targetService;
	@Autowired
	private TaskSchedulingService SchedulingService;
	@Autowired 
	private ProfilService profilService;
	@Autowired 
	private DataModelService dataService;
	public TaskService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TaskService(TaskRepository taskRepo) {
		super();
		this.taskRepo = taskRepo;
	}

	
	//CRUD task 
	public Task saveTask(Task task)
	{
		return taskRepo.save(task);
	}
	
	public boolean deleteTask(Task task)
	{	taskRepo.delete(task);
		return true;
	}
	//Task description
	public Task taskDescription(String name,String category,String source,TargetType typeTarget,String version,int i,Date start,Date end,Date startLimit,String profilName)
	{
		Task task=new Task();
		task.setName(name);
		task.setCategory(catRepo.findByName(category).get());
		task.setType(type(typeTarget,i));
		task.setVersion(version);
		task.setCreationDate(java.time.LocalDate.now());
		//task.setSchudelerId(SchedulingService.taskSchduler(start,end, startLimit));
		task.setProfils(ChooseProfilByName(profilName));
		task.setSource(source);
		
		return taskRepo.save(task);
	}
	//Target Type
			public TaskTargetType type(TargetType typeTarget,int i)
			{
				TaskTargetType type = new TaskTargetType();
				if(typeTarget==TargetType.Alias)
				{
					type.setDeviceType(targetService.findTargetTypeById(i).get().getDeviceType());
					type.setNetworkType(targetService.findTargetTypeById(i).get().getNetworkType());
				}
				if(typeTarget==TargetType.DeviceList)
					
				{
					type.setDeviceId(targetService.findTargetTypeById(i).get().getDeviceId());
				}
				if(typeTarget==TargetType.Groupe)
				{
					type.setGroupeIds(targetService.findTargetTypeById(i).get().getGroupeIds());
				}
				
				return type;
			}
			//profil setting
			public Profil ChooseProfilByName(String name)
			{
				return profilService.findByName(name).get();
			}
			public Profil ChooseProfilByData(String name)
			{
				return profilService.findByDataModel(dataService.findByName(name)).get();
			}
			//Advanced Options 
			public Task AdvancedPriority(String proirity,boolean activation,String name,String category,String source,TargetType typeTarget,String version,int i,Date start,Date end,Date startLimit,String profilName)
			{
				Task task= this.taskDescription(name, category, source, typeTarget, version, i, start, end, startLimit, profilName);
				task.setActivation(activation);
				task.setExecPriority(proirity);
				return task;
			}
			
			//Result
			public Task Resultat(String priority,String mode,String cache,String proirityOption,boolean activation,String name,String category,String source,TargetType typeTarget,String version,int i,Date start,Date end,Date startLimit,String profilName)
			{
				Task task= this.AdvancedPriority(proirityOption,activation,name, category, source, typeTarget, version, i, start, end, startLimit, profilName);
				task.setResult_params_priority(priority);
				task.setResult_params_mode(mode);
				task.setResult_params_cache_use(cache);
				return task;
			}
			//DlmsParameters
			public Task DlmsParameters(DlmsParams params,CPLProirity priorityCpl,boolean dynamic_period_adaptation,RecoveryActive recovery_active,String priority,String mode,String cache,String proirityOption,boolean activation,String name,String category,String source,TargetType typeTarget,String version,int i,Date start,Date end,Date startLimit,String profilName)
			{	
				Task task = this.Resultat(priority, mode, cache, proirityOption, activation, name, category, source, typeTarget, version, i, start, end, startLimit, profilName);
				task.setDlms_params_mode(params);
				task.setDlms_params_cplpriority(priorityCpl);
				task.setDlms_params_dynamicperiodadaptation(dynamic_period_adaptation);
				task.setDlms_params_recovery_active(recovery_active);	
				return task;
			}
			//search Task 
			public Task SearchByStatut(String status)
			{
				return taskRepo.findByStatus(status);
			}
			public Optional<Task> findTaskById(int id)
			{
				return taskRepo.findById(id);
			}
			public Task findTaskByProfil(String profil)
			{
				
				return taskRepo.findByProfils(profilService.findByName(profil).get());
			}
			//Cancel Task 
			public boolean CancelTask(Task task,boolean confirm)
			{
				if((task.getStatus()==TaskStatut.Accepted)||(task.getStatus()==TaskStatut.Created)||(task.getStatus()==TaskStatut.Replaced))
				{
					LocalDate localDate = LocalDate.now();
					if(localDate.isBefore(task.getSchudelerId().getStart()))
							{
								TaskStatut LastStatus= task.getStatus();
								task.setStatus(TaskStatut.Cancel_Pending);
								if(confirm==true)
								{
									task.setStatus(TaskStatut.Canceled);
								}
								else
								{
									task.setStatus(LastStatus);
								}
							}
					return true;
				}
				else
				{
					return false;
				}
			}
			//Copy a task 
			public Task CopyTask(String task)
			{
				Task taskCopy =new Task();
				taskCopy=taskRepo.findByName(task);
				return taskCopy;
			}
			//Delete a task
			public Task DeleteTask(Task task)
			{
				if((task.getStatus()==TaskStatut.Canceled)||(task.getStatus()==TaskStatut.Rejected)||(task.getStatus()==TaskStatut.Replaced))
				{
					LocalDate localDate = LocalDate.now();
					if(localDate.isAfter(task.getSchudelerId().getStart()))
							{
								 taskRepo.delete(task);
							
							}
					 return task;
				}
				else
				{
					return null;
				}
				
				}
			
		// Replace a task 
			public Task ReplaceTask(Task task,Task taskReplaced)
			{
				Task task1 = taskRepo.findById(task.getId()).get();
				task1=taskReplaced;
				return taskRepo.save(task1);
			}

}