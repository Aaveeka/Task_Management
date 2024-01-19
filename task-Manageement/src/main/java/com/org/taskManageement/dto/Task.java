package com.org.taskManageement.dto;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Nonnull
	private String tname;

	@Nonnull
	@DateTimeFormat(pattern ="yyyy-mm-dd")
	private Date duedate;

	@Nonnull
	private String status;

	@Nonnull
	private String priority;

	public int getId() { 
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public Date getDuedate() {
		return duedate;
	}

	public void setDuedate(Date duedate) {
		this.duedate = duedate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}
	
	
	public Task() {
		// TODO Auto-generated constructor stub
	}

	public Task(int id, String tname, Date duedate, String status, String priority) {
		super();
		this.id = id;
		this.tname = tname;
		this.duedate = duedate;
		this.status = status;
		this.priority = priority;
	}

	public static Task TaskElements(Task task) {
		return new Task(task.getId(), task.getTname(), task.getDuedate(), task.getPriority(), task.getStatus());

	}

}
