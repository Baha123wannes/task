package com.example.demo.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
@Table(name="metering_task_scheduler")
public class TaskScheduling {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="start")
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate start;
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name="start_limit")
	private LocalDate start_limit;
	@Column(name="stop")
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate stop;
	@Column(name="period_min_start_id")
	private int periodMinStartId;
	@Column(name="period_start_limit_id")
	private int periodStartLimitId;
	@Column(name="period_stop_id")
	private int periodStopId;
	@OneToMany(cascade=CascadeType.ALL)
	private List<Task> tasks;
	public TaskScheduling() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TaskScheduling(int id, LocalDate start, LocalDate start_limit, LocalDate stop, int periodMinStartId, int periodStartLimitId,
			int periodStopId, List<Task> tasks) {
		super();
		this.id = id;
		this.start = start;
		this.start_limit = start_limit;
		this.stop = stop;
		this.periodMinStartId = periodMinStartId;
		this.periodStartLimitId = periodStartLimitId;
		this.periodStopId = periodStopId;
		this.tasks = tasks;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getStart() {
		return start;
	}
	public void setStart(LocalDate start) {
		this.start = start;
	}
	public LocalDate getStart_limit() {
		return start_limit;
	}
	public void setStart_limit(LocalDate start_limit) {
		this.start_limit = start_limit;
	}
	public LocalDate getStop() {
		return stop;
	}
	public void setStop(LocalDate stop) {
		this.stop = stop;
	}
	public int getPeriodMinStartId() {
		return periodMinStartId;
	}
	public void setPeriodMinStartId(int periodMinStartId) {
		this.periodMinStartId = periodMinStartId;
	}
	public int getPeriodStartLimitId() {
		return periodStartLimitId;
	}
	public void setPeriodStartLimitId(int periodStartLimitId) {
		this.periodStartLimitId = periodStartLimitId;
	}
	public int getPeriodStopId() {
		return periodStopId;
	}
	public void setPeriodStopId(int periodStopId) {
		this.periodStopId = periodStopId;
	}
	public List<Task> getTasks() {
		return tasks;
	}
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
}
