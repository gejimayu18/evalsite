package com.djonesyking.evalsite.submit.domain;

import java.util.List;

import com.djonesyking.evalsite.domain.Behavior;

public class BodyHandling {

	private int teethCompleted;
	private int teethAttempted;
	private String teethCheckAssertive;
	private List<Behavior> teethcheckbehaviors;
	private String teethcheckbehaviorsother;
	private Handling handling;
	private String comments;
	public int getTeethCompleted() {
		return teethCompleted;
	}
	public void setTeethCompleted(int teethCompleted) {
		this.teethCompleted = teethCompleted;
	}
	public int getTeethAttempted() {
		return teethAttempted;
	}
	public void setTeethAttempted(int teethAttempted) {
		this.teethAttempted = teethAttempted;
	}
	public String getTeethCheckAssertive() {
		return teethCheckAssertive;
	}
	public void setTeethCheckAssertive(String teethCheckAssertive) {
		this.teethCheckAssertive = teethCheckAssertive;
	}
	public List<Behavior> getTeethcheckbehaviors() {
		return teethcheckbehaviors;
	}
	public void setTeethcheckbehaviors(List<Behavior> teethcheckbehaviors) {
		this.teethcheckbehaviors = teethcheckbehaviors;
	}
	public Handling getHandling() {
		return handling;
	}
	public void setHandling(Handling handling) {
		this.handling = handling;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getTeethcheckbehaviorsother() {
		return teethcheckbehaviorsother;
	}
	public void setTeethcheckbehaviorsother(String teethcheckbehaviorsother) {
		this.teethcheckbehaviorsother = teethcheckbehaviorsother;
	}
	@Override
	public String toString() {
		return "BodyHandling [teethCompleted=" + teethCompleted + ", teethAttempted=" + teethAttempted
				+ ", teethCheckAssertive=" + teethCheckAssertive + ", teethcheckbehaviors=" + teethcheckbehaviors
				+ ", teethcheckbehaviorsother=" + teethcheckbehaviorsother + ", handling=" + handling + ", comments="
				+ comments + "]";
	}
	
	
}
