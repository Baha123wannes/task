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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="metering_task")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	@Column(name="task_id")
	private int taskId;
	@Column(name="name")
	private String name;
	@Column(name="version")
	private String version;
	@Column(name="execpriority")
	private String execPriority;
	private String source;
	@Column(name="created_by")
	private String createdBy;
	@Column(name="creation_date")
	private LocalDate creationDate;
	@Column(name="modification_date")
	private LocalDate modificationDate;
	@Column(name="isactivation")
	private boolean isActivation;
	@Column(name="status")
	private TaskStatut status;
	@Column(name="dlms_params_mode")
	private DlmsParams dlms_params_mode;
	@Column(name="dlms_params_unicast_timeout")
	private Long dlms_params_unicast_timeout;
	@Column(name="dlms_params_unicast_max_try")
	private int dlms_params_unicast_max_try;
	@Column(name="dlms_params_multicast_wait")
	private Long dlms_params_multicast_wait;
	@Column(name="dlms_params_cplpriority")
	private CPLProirity dlms_params_cplpriority;
	@Column(name="dlms_params_dynamicperiodadaptation")
	private boolean dlms_params_dynamicperiodadaptation;
	@Column(name="dlms_params_recovery_active")
	private RecoveryActive dlms_params_recovery_active;
	@Column(name="dlms_params_recovery_execpriority")
	private int dlms_params_recovery_execpriority;
	@Column(name="dlms_params_recovery_maxdepth")
	private String dlms_params_recovery_maxdepth;
	@Column(name="dlms_params_standard_recovery_mode")
	private String dlms_params_standard_recovery_mode;
	@Column(name="dlms_params_recovery_min_wait_time")
	private String dlms_params_recovery_min_wait_time;
	@Column(name="dlms_params_recovery_cache_mode")
	private String dlms_params_recovery_cache_mode;
	@Column(name="result_params_priority")
	private String result_params_priority;
	@Column(name="result_params_mode")
	private String result_params_mode;
	@Column(name="result_params_cache_use")
	private String result_params_cache_use;
	@ManyToOne(cascade = CascadeType.ALL)
	private TaskTargetType type;
	@ManyToOne(cascade = CascadeType.ALL)
	private TaskScheduling schudelerId ;
	@OneToOne
	private TaskHistory History;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="replaced_task_id_id")
	private Task replacedTaskId;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="category_id")
	private Category category;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="profile_id")
	private Profil profils;
	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Task(int id, int taskId, String name, String version, String execPriority, String source, String createdBy,
			LocalDate creationDate, LocalDate modificationDate, boolean isActivation, TaskStatut status,
			DlmsParams dlms_params_mode, Long dlms_params_unicast_timeout, int dlms_params_unicast_max_try,
			Long dlms_params_multicast_wait, CPLProirity dlms_params_cplpriority,
			boolean dlms_params_dynamicperiodadaptation, RecoveryActive dlms_params_recovery_active,
			int dlms_params_recovery_execpriority, String dlms_params_recovery_maxdepth,
			String dlms_params_standard_recovery_mode, String dlms_params_recovery_min_wait_time,
			String dlms_params_recovery_cache_mode, String result_params_priority, String result_params_mode,
			String result_params_cache_use, TaskTargetType type, TaskScheduling schudelerId, TaskHistory history,
			Task replacedTaskId, Category category, Profil profils) {
		super();
		this.id = id;
		this.taskId = taskId;
		this.name = name;
		this.version = version;
		this.execPriority = execPriority;
		this.source = source;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
		this.isActivation = isActivation;
		this.status = status;
		this.dlms_params_mode = dlms_params_mode;
		this.dlms_params_unicast_timeout = dlms_params_unicast_timeout;
		this.dlms_params_unicast_max_try = dlms_params_unicast_max_try;
		this.dlms_params_multicast_wait = dlms_params_multicast_wait;
		this.dlms_params_cplpriority = dlms_params_cplpriority;
		this.dlms_params_dynamicperiodadaptation = dlms_params_dynamicperiodadaptation;
		this.dlms_params_recovery_active = dlms_params_recovery_active;
		this.dlms_params_recovery_execpriority = dlms_params_recovery_execpriority;
		this.dlms_params_recovery_maxdepth = dlms_params_recovery_maxdepth;
		this.dlms_params_standard_recovery_mode = dlms_params_standard_recovery_mode;
		this.dlms_params_recovery_min_wait_time = dlms_params_recovery_min_wait_time;
		this.dlms_params_recovery_cache_mode = dlms_params_recovery_cache_mode;
		this.result_params_priority = result_params_priority;
		this.result_params_mode = result_params_mode;
		this.result_params_cache_use = result_params_cache_use;
		this.type = type;
		this.schudelerId = schudelerId;
		History = history;
		this.replacedTaskId = replacedTaskId;
		this.category = category;
		this.profils = profils;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getExecPriority() {
		return execPriority;
	}
	public void setExecPriority(String execPriority) {
		this.execPriority = execPriority;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public LocalDate getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
	public LocalDate getModificationDate() {
		return modificationDate;
	}
	public void setModificationDate(LocalDate modificationDate) {
		this.modificationDate = modificationDate;
	}
	public boolean isActivation() {
		return isActivation;
	}
	public void setActivation(boolean isActivation) {
		this.isActivation = isActivation;
	}
	public TaskStatut getStatus() {
		return status;
	}
	public void setStatus(TaskStatut status) {
		this.status = status;
	}
	
	public DlmsParams getDlms_params_mode() {
		return dlms_params_mode;
	}

	public void setDlms_params_mode(DlmsParams dlms_params_mode) {
		this.dlms_params_mode = dlms_params_mode;
	}

	public Long getDlms_params_unicast_timeout() {
		return dlms_params_unicast_timeout;
	}

	public void setDlms_params_unicast_timeout(Long dlms_params_unicast_timeout) {
		this.dlms_params_unicast_timeout = dlms_params_unicast_timeout;
	}

	public int getDlms_params_unicast_max_try() {
		return dlms_params_unicast_max_try;
	}

	public void setDlms_params_unicast_max_try(int dlms_params_unicast_max_try) {
		this.dlms_params_unicast_max_try = dlms_params_unicast_max_try;
	}

	public Long getDlms_params_multicast_wait() {
		return dlms_params_multicast_wait;
	}

	public void setDlms_params_multicast_wait(Long dlms_params_multicast_wait) {
		this.dlms_params_multicast_wait = dlms_params_multicast_wait;
	}

	public CPLProirity getDlms_params_cplpriority() {
		return dlms_params_cplpriority;
	}

	public void setDlms_params_cplpriority(CPLProirity dlms_params_cplpriority) {
		this.dlms_params_cplpriority = dlms_params_cplpriority;
	}

	public boolean isDlms_params_dynamicperiodadaptation() {
		return dlms_params_dynamicperiodadaptation;
	}

	public void setDlms_params_dynamicperiodadaptation(boolean dlms_params_dynamicperiodadaptation) {
		this.dlms_params_dynamicperiodadaptation = dlms_params_dynamicperiodadaptation;
	}

	public RecoveryActive getDlms_params_recovery_active() {
		return dlms_params_recovery_active;
	}

	public void setDlms_params_recovery_active(RecoveryActive dlms_params_recovery_active) {
		this.dlms_params_recovery_active = dlms_params_recovery_active;
	}

	public int getDlms_params_recovery_execpriority() {
		return dlms_params_recovery_execpriority;
	}

	public void setDlms_params_recovery_execpriority(int dlms_params_recovery_execpriority) {
		this.dlms_params_recovery_execpriority = dlms_params_recovery_execpriority;
	}

	public String getDlms_params_recovery_maxdepth() {
		return dlms_params_recovery_maxdepth;
	}

	public void setDlms_params_recovery_maxdepth(String dlms_params_recovery_maxdepth) {
		this.dlms_params_recovery_maxdepth = dlms_params_recovery_maxdepth;
	}

	public String getDlms_params_standard_recovery_mode() {
		return dlms_params_standard_recovery_mode;
	}

	public void setDlms_params_standard_recovery_mode(String dlms_params_standard_recovery_mode) {
		this.dlms_params_standard_recovery_mode = dlms_params_standard_recovery_mode;
	}

	public String getDlms_params_recovery_min_wait_time() {
		return dlms_params_recovery_min_wait_time;
	}

	public void setDlms_params_recovery_min_wait_time(String dlms_params_recovery_min_wait_time) {
		this.dlms_params_recovery_min_wait_time = dlms_params_recovery_min_wait_time;
	}

	public String getDlms_params_recovery_cache_mode() {
		return dlms_params_recovery_cache_mode;
	}

	public void setDlms_params_recovery_cache_mode(String dlms_params_recovery_cache_mode) {
		this.dlms_params_recovery_cache_mode = dlms_params_recovery_cache_mode;
	}

	public String getResult_params_priority() {
		return result_params_priority;
	}

	public void setResult_params_priority(String result_params_priority) {
		this.result_params_priority = result_params_priority;
	}

	public String getResult_params_mode() {
		return result_params_mode;
	}

	public void setResult_params_mode(String result_params_mode) {
		this.result_params_mode = result_params_mode;
	}

	public String getResult_params_cache_use() {
		return result_params_cache_use;
	}

	public void setResult_params_cache_use(String result_params_cache_use) {
		this.result_params_cache_use = result_params_cache_use;
	}

	public TaskTargetType getType() {
		return type;
	}
	public void setType(TaskTargetType type) {
		this.type = type;
	}
	public TaskScheduling getSchudelerId() {
		return schudelerId;
	}
	public void setSchudelerId(TaskScheduling schudelerId) {
		this.schudelerId = schudelerId;
	}
	public TaskHistory getHistory() {
		return History;
	}
	public void setHistory(TaskHistory history) {
		History = history;
	}
	public Task getReplacedTaskId() {
		return replacedTaskId;
	}
	public void setReplacedTaskId(Task replacedTaskId) {
		this.replacedTaskId = replacedTaskId;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Profil getProfils() {
		return profils;
	}
	public void setProfils(Profil profils) {
		this.profils = profils;
	}

}
