package com.djonesyking.evalsite.submit.domain;

import java.util.List;

import com.djonesyking.evalsite.domain.Behavior;

public class Treats {
	
	private List<Behavior> takingtreatsbehaviors;
	private String takingtreatsbehaviorother;
	private List<Behavior> treatsused;
	private String treatsusedbehaviorother;
	private List<Behavior> commands;
	private String commandsbehaviorother;
	public List<Behavior> getTakingtreatsbehaviors() {
		return takingtreatsbehaviors;
	}
	public void setTakingtreatsbehaviors(List<Behavior> takingtreatsbehaviors) {
		this.takingtreatsbehaviors = takingtreatsbehaviors;
	}
	public String getTakingtreatsbehaviorother() {
		return takingtreatsbehaviorother;
	}
	public void setTakingtreatsbehaviorother(String takingtreatsbehaviorother) {
		this.takingtreatsbehaviorother = takingtreatsbehaviorother;
	}
	public List<Behavior> getTreatsused() {
		return treatsused;
	}
	public void setTreatsused(List<Behavior> treatsused) {
		this.treatsused = treatsused;
	}
	public String getTreatsusedbehaviorother() {
		return treatsusedbehaviorother;
	}
	public void setTreatsusedbehaviorother(String treatsusedbehaviorother) {
		this.treatsusedbehaviorother = treatsusedbehaviorother;
	}
	public List<Behavior> getCommands() {
		return commands;
	}
	public void setCommands(List<Behavior> commands) {
		this.commands = commands;
	}
	public String getCommandsbehaviorother() {
		return commandsbehaviorother;
	}
	public void setCommandsbehaviorother(String commandsbehaviorother) {
		this.commandsbehaviorother = commandsbehaviorother;
	}
	@Override
	public String toString() {
		return "Treats [takingtreatsbehaviors=" + takingtreatsbehaviors + ", takingtreatsbehaviorother="
				+ takingtreatsbehaviorother + ", treatsused=" + treatsused + ", treatsusedbehaviorother="
				+ treatsusedbehaviorother + ", commands=" + commands + ", commandsbehaviorother="
				+ commandsbehaviorother + "]";
	}

	
}
