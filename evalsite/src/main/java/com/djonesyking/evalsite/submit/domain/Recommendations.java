package com.djonesyking.evalsite.submit.domain;

import java.util.List;

import com.djonesyking.evalsite.domain.Behavior;

public class Recommendations {
	
	private String sociabilitychanged;
	private List<Behavior> walker;
	private String walkercomments;
	private List<Behavior> kids;
	private String kidscomments;
	private List<Behavior> personality;
	private String personalitycomments;
	private List<Behavior> household;
	private String householdcomments;
	private List<Behavior> waivers;
	private String waiverscomments;
	private String comments;
	public String getSociabilitychanged() {
		return sociabilitychanged;
	}
	public void setSociabilitychanged(String sociabilitychanged) {
		this.sociabilitychanged = sociabilitychanged;
	}
	public List<Behavior> getWalker() {
		return walker;
	}
	public void setWalker(List<Behavior> walker) {
		this.walker = walker;
	}
	public String getWalkercomments() {
		return walkercomments;
	}
	public void setWalkercomments(String walkercomments) {
		this.walkercomments = walkercomments;
	}
	public List<Behavior> getKids() {
		return kids;
	}
	public void setKids(List<Behavior> kids) {
		this.kids = kids;
	}
	public String getKidscomments() {
		return kidscomments;
	}
	public void setKidscomments(String kidscomments) {
		this.kidscomments = kidscomments;
	}
	public List<Behavior> getPersonality() {
		return personality;
	}
	public void setPersonality(List<Behavior> personality) {
		this.personality = personality;
	}
	public String getPersonalitycomments() {
		return personalitycomments;
	}
	public void setPersonalitycomments(String personalitycomments) {
		this.personalitycomments = personalitycomments;
	}
	public List<Behavior> getHousehold() {
		return household;
	}
	public void setHousehold(List<Behavior> household) {
		this.household = household;
	}
	public String getHouseholdcomments() {
		return householdcomments;
	}
	public void setHouseholdcomments(String householdcomments) {
		this.householdcomments = householdcomments;
	}
	public List<Behavior> getWaivers() {
		return waivers;
	}
	public void setWaivers(List<Behavior> waivers) {
		this.waivers = waivers;
	}
	public String getWaiverscomments() {
		return waiverscomments;
	}
	public void setWaiverscomments(String waiverscomments) {
		this.waiverscomments = waiverscomments;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "Recommendations [sociabilitychanged=" + sociabilitychanged + ", walker=" + walker + ", walkercomments="
				+ walkercomments + ", kids=" + kids + ", kidscomments=" + kidscomments + ", personality=" + personality
				+ ", personalitycomments=" + personalitycomments + ", household=" + household + ", householdcomments="
				+ householdcomments + ", waivers=" + waivers + ", waiverscomments=" + waiverscomments + ", comments="
				+ comments + "]";
	}
	
	
}
