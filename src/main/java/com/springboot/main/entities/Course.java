package com.springboot.main.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="courses")
public class Course {
	
	@Id
	@Column(name="id")
	private long cid;
	
	@Column(name="name")
	private String cname;
	
	@Column(name="description")
	private String description;
	
	@Column(name="mentor")
	private String mentor;
	
	@Column(name="duration")
	private double duration;

	public Course(long cid, String cname, String description, String mentor, double duration) {
		this.cid = cid;
		this.cname = cname;
		this.description = description;
		this.mentor = mentor;
		this.duration = duration;
	}

	public Course() {
		
	}

	public long getCid() {
		return cid;
	}

	public void setCid(long cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMentor() {
		return mentor;
	}

	public void setMentor(String mentor) {
		this.mentor = mentor;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Course [cid=" + cid + ", cname=" + cname + ", description=" + description + ", mentor=" + mentor
				+ ", duration=" + duration + "]";
	}
	
}
