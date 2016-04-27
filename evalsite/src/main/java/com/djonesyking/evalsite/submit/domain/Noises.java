package com.djonesyking.evalsite.submit.domain;

import java.util.List;

import com.djonesyking.evalsite.domain.Behavior;

public class Noises {
	
	private List<Behavior> initialloudnoise;
	private String initialloudnoiseother;
	private List<Behavior> recoverloudnoise;
	private String recoverloudnoiseother;
	private List<Behavior> initialscold;
	private String initialscoldother;
	private List<Behavior> recoverscold;
	private String recoverscoldother;
	private List<Behavior> initialknockatdoor;
	private String initialknockatdoorother;
	private String strangergender;
	private List<Behavior> initialstranger;
	private String initialstrangerother;
	private List<Behavior> recoverstranger;
	private String recoverstrangerother;
	private String comment;
	public List<Behavior> getInitialloudnoise() {
		return initialloudnoise;
	}
	public void setInitialloudnoise(List<Behavior> initialloudnoise) {
		this.initialloudnoise = initialloudnoise;
	}
	public String getInitialloudnoiseother() {
		return initialloudnoiseother;
	}
	public void setInitialloudnoiseother(String initialloudnoiseother) {
		this.initialloudnoiseother = initialloudnoiseother;
	}
	public List<Behavior> getRecoverloudnoise() {
		return recoverloudnoise;
	}
	public void setRecoverloudnoise(List<Behavior> recoverloudnoise) {
		this.recoverloudnoise = recoverloudnoise;
	}
	public String getRecoverloudnoiseother() {
		return recoverloudnoiseother;
	}
	public void setRecoverloudnoiseother(String recoverloudnoiseother) {
		this.recoverloudnoiseother = recoverloudnoiseother;
	}
	public List<Behavior> getInitialscold() {
		return initialscold;
	}
	public void setInitialscold(List<Behavior> initialscold) {
		this.initialscold = initialscold;
	}
	public String getInitialscoldother() {
		return initialscoldother;
	}
	public void setInitialscoldother(String initialscoldother) {
		this.initialscoldother = initialscoldother;
	}
	public List<Behavior> getRecoverscold() {
		return recoverscold;
	}
	public void setRecoverscold(List<Behavior> recoverscold) {
		this.recoverscold = recoverscold;
	}
	public String getRecoverscoldother() {
		return recoverscoldother;
	}
	public void setRecoverscoldother(String recoverscoldother) {
		this.recoverscoldother = recoverscoldother;
	}
	public List<Behavior> getInitialknockatdoor() {
		return initialknockatdoor;
	}
	public void setInitialknockatdoor(List<Behavior> initialknockatdoor) {
		this.initialknockatdoor = initialknockatdoor;
	}
	public String getInitialknockatdoorother() {
		return initialknockatdoorother;
	}
	public void setInitialknockatdoorother(String initialknockatdoorother) {
		this.initialknockatdoorother = initialknockatdoorother;
	}
	public String getStrangergender() {
		return strangergender;
	}
	public void setStrangergender(String strangergender) {
		this.strangergender = strangergender;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public List<Behavior> getInitialstranger() {
		return initialstranger;
	}
	public void setInitialstranger(List<Behavior> initialstranger) {
		this.initialstranger = initialstranger;
	}
	public String getInitialstrangerother() {
		return initialstrangerother;
	}
	public void setInitialstrangerother(String initialstrangerother) {
		this.initialstrangerother = initialstrangerother;
	}
	public List<Behavior> getRecoverstranger() {
		return recoverstranger;
	}
	public void setRecoverstranger(List<Behavior> recoverstranger) {
		this.recoverstranger = recoverstranger;
	}
	public String getRecoverstrangerother() {
		return recoverstrangerother;
	}
	public void setRecoverstrangerother(String recoverstrangerother) {
		this.recoverstrangerother = recoverstrangerother;
	}
	@Override
	public String toString() {
		return "Noises [initialloudnoise=" + initialloudnoise + ", initialloudnoiseother=" + initialloudnoiseother
				+ ", recoverloudnoise=" + recoverloudnoise + ", recoverloudnoiseother=" + recoverloudnoiseother
				+ ", initialscold=" + initialscold + ", initialscoldother=" + initialscoldother + ", recoverscold="
				+ recoverscold + ", recoverscoldother=" + recoverscoldother + ", initialknockatdoor="
				+ initialknockatdoor + ", initialknockatdoorother=" + initialknockatdoorother + ", strangergender="
				+ strangergender + ", initialstranger=" + initialstranger + ", initialstrangerother="
				+ initialstrangerother + ", recoverstranger=" + recoverstranger + ", recoverstrangerother="
				+ recoverstrangerother + ", comment=" + comment + "]";
	}
	
	

}
