package com.djonesyking.evalsite.submit.domain;

import java.util.List;

import com.djonesyking.evalsite.domain.Behavior;

public class Sociability {
	
	private int ignoreScore;
	private List<Behavior> ignorebehaviors;
	private String ignorebehaviorother;
	private int engageScore;
	private List<Behavior> engagebehaviors;
	private String engagebehaviorother;
	private String comments;
	private List<Behavior> pulldogbehaviors;
	private String pulldogbehaviorsother;
	private List<Behavior> walkingbehaviors;
	private String walkingbehaviorother;
	private String kennelbehaviorcomments;
	private String backstrokes;
	private List<Behavior> backstrokebehaviors;
	private String siton;
	private String cameover;
	
	public int getIgnoreScore() {
		return ignoreScore;
	}
	public void setIgnoreScore(int ignoreScore) {
		this.ignoreScore = ignoreScore;
	}
	public List<Behavior> getIgnorebehaviors() {
		return ignorebehaviors;
	}
	public void setIgnorebehaviors(List<Behavior> ignorebehaviors) {
		this.ignorebehaviors = ignorebehaviors;
	}
	public String getIgnorebehaviorother() {
		return ignorebehaviorother;
	}
	public void setIgnorebehaviorother(String ignorebehaviorother) {
		this.ignorebehaviorother = ignorebehaviorother;
	}
	public int getEngageScore() {
		return engageScore;
	}
	public void setEngageScore(int engageScore) {
		this.engageScore = engageScore;
	}
	public String getEngagebehaviorother() {
		return engagebehaviorother;
	}
	public void setEngagebehaviorother(String engagebehaviorother) {
		this.engagebehaviorother = engagebehaviorother;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public List<Behavior> getPulldogbehaviors() {
		return pulldogbehaviors;
	}
	public void setPulldogbehaviors(List<Behavior> pulldogbehaviors) {
		this.pulldogbehaviors = pulldogbehaviors;
	}
	public String getPulldogbehaviorsother() {
		return pulldogbehaviorsother;
	}
	public void setPulldogbehaviorsother(String pulldogbehaviorsother) {
		this.pulldogbehaviorsother = pulldogbehaviorsother;
	}
	public List<Behavior> getWalkingbehaviors() {
		return walkingbehaviors;
	}
	public void setWalkingbehaviors(List<Behavior> walkingbehaviors) {
		this.walkingbehaviors = walkingbehaviors;
	}
	public String getWalkingbehaviorother() {
		return walkingbehaviorother;
	}
	public void setWalkingbehaviorother(String walkingbehaviorother) {
		this.walkingbehaviorother = walkingbehaviorother;
	}
	public String getKennelbehaviorcomments() {
		return kennelbehaviorcomments;
	}
	public void setKennelbehaviorcomments(String kennelbehaviorcomments) {
		this.kennelbehaviorcomments = kennelbehaviorcomments;
	}
	public List<Behavior> getEngagebehaviors() {
		return engagebehaviors;
	}
	public void setEngagebehaviors(List<Behavior> engagebehaviors) {
		this.engagebehaviors = engagebehaviors;
	}
	public String getBackstrokes() {
		return backstrokes;
	}
	public void setBackstrokes(String backstrokes) {
		this.backstrokes = backstrokes;
	}
	public List<Behavior> getBackstrokebehaviors() {
		return backstrokebehaviors;
	}
	public void setBackstrokebehaviors(List<Behavior> backstrokebehaviors) {
		this.backstrokebehaviors = backstrokebehaviors;
	}
	public String getSiton() {
		return siton;
	}
	public void setSiton(String siton) {
		this.siton = siton;
	}
	public String getCameover() {
		return cameover;
	}
	public void setCameover(String cameover) {
		this.cameover = cameover;
	}
	@Override
	public String toString() {
		return "Sociability [ignoreScore=" + ignoreScore + ", ignorebehaviors=" + ignorebehaviors
				+ ", ignorebehaviorother=" + ignorebehaviorother + ", engageScore=" + engageScore + ", engagebehaviors="
				+ engagebehaviors + ", engagebehaviorother=" + engagebehaviorother + ", comments=" + comments
				+ ", pulldogbehaviors=" + pulldogbehaviors + ", pulldogbehaviorsother=" + pulldogbehaviorsother
				+ ", walkingbehaviors=" + walkingbehaviors + ", walkingbehaviorother=" + walkingbehaviorother
				+ ", kennelbehaviorcomments=" + kennelbehaviorcomments + ", backstrokes=" + backstrokes
				+ ", backstrokebehaviors=" + backstrokebehaviors + ", siton=" + siton + ", cameover=" + cameover + "]";
	}
	
	

}
