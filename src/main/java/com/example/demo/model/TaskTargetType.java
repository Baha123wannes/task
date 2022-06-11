package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="metering_task_target_type")
public class TaskTargetType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="target_type")
	private TargetType targetType;
	@Column(name="device_type")
	private DeviceTypes deviceType;
	@Column(name="network_type")
	private NetworkType networkType;
	@Column(name="device_id")
	private String deviceId;
	@Column(name="groupe_ids")
	private String groupeIds;
	@OneToMany(cascade =CascadeType.ALL)
	private List<Task> tasks;
	public TaskTargetType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TaskTargetType(int id, TargetType targetType, DeviceTypes deviceType, NetworkType networkType,
			String deviceId, String groupeIds, List<Task> tasks) {
		super();
		this.id = id;
		this.targetType = targetType;
		this.deviceType = deviceType;
		this.networkType = networkType;
		this.deviceId = deviceId;
		this.groupeIds = groupeIds;
		this.tasks = tasks;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public TargetType getTargetType() {
		return targetType;
	}
	public void setTargetType(TargetType targetType) {
		this.targetType = targetType;
	}
	public DeviceTypes getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(DeviceTypes deviceType) {
		this.deviceType = deviceType;
	}
	public NetworkType getNetworkType() {
		return networkType;
	}
	public void setNetworkType(NetworkType networkType) {
		this.networkType = networkType;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getGroupeIds() {
		return groupeIds;
	}
	public void setGroupeIds(String groupeIds) {
		this.groupeIds = groupeIds;
	}
	public List<Task> getTasks() {
		return tasks;
	}
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
}
