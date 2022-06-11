package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="metering_task_option")
public class Option {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="name")
	private String name ; 
	@Column(name="value")
	private String value;
	@ManyToOne(cascade =CascadeType.ALL)
	@JoinColumn(name="task_id")
	private Task taskId;
	public Option() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Option(int id, String name, String value, Task taskId) {
		super();
		this.id = id;
		this.name = name;
		this.value = value;
		this.taskId = taskId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Task getTaskId() {
		return taskId;
	}
	public void setTaskId(Task taskId) {
		this.taskId = taskId;
	}
	
}
