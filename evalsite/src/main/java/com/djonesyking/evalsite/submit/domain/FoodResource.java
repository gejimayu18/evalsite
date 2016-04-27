package com.djonesyking.evalsite.submit.domain;

import java.util.List;

import com.djonesyking.evalsite.domain.Behavior;

public class FoodResource {

	private String coax;
	private List<Behavior> hands;
	private List<Behavior> interest;
	private List<Behavior> delivery;
	private String foodinitdeliverybehaviorother;
	private List<Behavior> initialapproach;
	private String initialapproachother;
	private List<Behavior> touchdog;
	private String touchdogother;
	private List<Behavior> touchbowl;
	private String touchbowlother;
	public String getCoax() {
		return coax;
	}
	public void setCoax(String coax) {
		this.coax = coax;
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
	public List<Behavior> getDelivery() {
		return delivery;
	}
	public void setDelivery(List<Behavior> delivery) {
		this.delivery = delivery;
	}
	public String getFoodinitdeliverybehaviorother() {
		return foodinitdeliverybehaviorother;
	}
	public void setFoodinitdeliverybehaviorother(String foodinitdeliverybehaviorother) {
		this.foodinitdeliverybehaviorother = foodinitdeliverybehaviorother;
	}
	public List<Behavior> getTouchdog() {
		return touchdog;
	}
	public void setTouchdog(List<Behavior> touchdog) {
		this.touchdog = touchdog;
	}
	public String getTouchdogother() {
		return touchdogother;
	}
	public void setTouchdogother(String touchdogother) {
		this.touchdogother = touchdogother;
	}
	public List<Behavior> getTouchbowl() {
		return touchbowl;
	}
	public void setTouchbowl(List<Behavior> touchbowl) {
		this.touchbowl = touchbowl;
	}
	public String getTouchbowlother() {
		return touchbowlother;
	}
	public void setTouchbowlother(String touchbowlother) {
		this.touchbowlother = touchbowlother;
	}
	public List<Behavior> getInitialapproach() {
		return initialapproach;
	}
	public void setInitialapproach(List<Behavior> initialapproach) {
		this.initialapproach = initialapproach;
	}
	public String getInitialapproachother() {
		return initialapproachother;
	}
	public void setInitialapproachother(String initialapproachother) {
		this.initialapproachother = initialapproachother;
	}
	@Override
	public String toString() {
		return "FoodResource [coax=" + coax + ", hands=" + hands + ", interest=" + interest + ", delivery=" + delivery
				+ ", foodinitdeliverybehaviorother=" + foodinitdeliverybehaviorother + ", initialapproach="
				+ initialapproach + ", initialapproachother=" + initialapproachother + ", touchdog=" + touchdog
				+ ", touchdogother=" + touchdogother + ", touchbowl=" + touchbowl + ", touchbowlother=" + touchbowlother
				+ "]";
	}
	
	
}
