package com.example.demo.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="metering_task_history")
public class TaskHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="modification_date")
	private Date modificationDate;
	@Column(name="status")
	private String status;	
	@OneToOne(cascade =CascadeType.ALL)
	private Task relatedTaskId;
	public TaskHistory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TaskHistory(int id, Date modificationDate, String status, Task relatedTaskId) {
		super();
		this.id = id;
		this.modificationDate = modificationDate;
		this.status = status;
		this.relatedTaskId = relatedTaskId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getModificationDate() {
		return modificationDate;
	}
	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Task getRelatedTaskId() {
		return relatedTaskId;
	}
	public void setRelatedTaskId(Task relatedTaskId) {
		this.relatedTaskId = relatedTaskId;
	}
	
}
