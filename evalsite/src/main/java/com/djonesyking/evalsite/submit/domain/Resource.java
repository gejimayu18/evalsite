package com.djonesyking.evalsite.submit.domain;

import java.util.List;

import com.djonesyking.evalsite.domain.Behavior;

public class Resource {

	private String used1;
	private String used2;
	private List<Behavior> hands;
	private List<Behavior> interest;
	private List<Behavior> behavior;
	private String behaviorother;
	public String getUsed1() {
		return used1;
	}
	public void setUsed1(String used1) {
		this.used1 = used1;
	}
	public String getUsed2() {
		return used2;
	}
	public void setUsed2(String used2) {
		this.used2 = used2;
	}
	public List<Behavior> getHands() {
		return hands;
	}
	public void setHands(List<Behavior> hands) {
		this.hands = hands;
	}
	public List<Behavior> getInterest() {
		return interest;
	}
	public void setInterest(List<Behavior> interest) {
		this.interest = interest;
	}
	public List<Behavior> getBehavior() {
		return behavior;
	}
	public void setBehavior(List<Behavior> behavior) {
		this.behavior = behavior;
	}
	public String getBehaviorother() {
		return behaviorother;
	}
	public void setBehaviorother(String behaviorother) {
		this.behaviorother = behaviorother;
	}
	@Override
	public String toString() {
		return "Resource [used1=" + used1 + ", used2=" + used2 + ", hands=" + hands + ", interest=" + interest
				+ ", behavior=" + behavior + ", behaviorother=" + behaviorother + "]";
	}
	
	
}
