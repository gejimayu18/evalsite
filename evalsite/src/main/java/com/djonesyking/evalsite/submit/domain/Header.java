package com.djonesyking.evalsite.submit.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Header {
	private String evaluator;
	private String handler;
	private String dogname;
	private String dogid;
	private String breed;
	private String gender;
	private String age;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date intakeDate;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date evalDate;
	private String reeval;
	private String pending;
	
	public String getEvaluator() {
		return evaluator;
	}
	public void setEvaluator(String evaluator) {
		this.evaluator = evaluator;
	}
	public String getHandler() {
		return handler;
	}
	public void setHandler(String handler) {
		this.handler = handler;
	}
	public String getDogname() {
		return dogname;
	}
	public void setDogname(String dogname) {
		this.dogname = dogname;
	}
	public String getDogid() {
		return dogid;
	}
	public void setDogid(String dogid) {
		this.dogid = dogid;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	public Date getIntakeDate() {
		return intakeDate;
	}
	public void setIntakeDate(Date intakeDate) {
		this.intakeDate = intakeDate;
	}
	public Date getEvalDate() {
		return evalDate;
	}
	public void setEvalDate(Date evalDate) {
		this.evalDate = evalDate;
	}
	public String getReeval() {
		return reeval;
	}
	public void setReeval(String reeval) {
		this.reeval = reeval;
	}
	public String getPending() {
		return pending;
	}
	public void setPending(String pending) {
		this.pending = pending;
	}
	@Override
	public String toString() {
		return "Header [evaluator=" + evaluator + ", handler=" + handler + ", dogname=" + dogname + ", dogid=" + dogid
				+ ", breed=" + breed + ", gender=" + gender + ", age=" + age + ", intakeDate=" + intakeDate
				+ ", evalDate=" + evalDate + ", reeval=" + reeval + ", pending=" + pending + "]";
	}
	
	

}
