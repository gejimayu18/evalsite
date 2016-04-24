package com.djonesyking.evalsite.submit.domain;

import java.util.List;

import com.djonesyking.evalsite.domain.Behavior;

public class Dolls {

	private List<Behavior> initialbaby;
	private String initialbabyother;
	private List<Behavior> afterbaby;
	private String afterbabyeother;
	private List<Behavior> initialtoddler;
	private String initialtoddlerother;
	private List<Behavior> aftertoddler;
	private String aftertoddlereother;
	private String comments;
	public List<Behavior> getInitialbaby() {
		return initialbaby;
	}
	public void setInitialbaby(List<Behavior> initialbaby) {
		this.initialbaby = initialbaby;
	}
	public String getInitialbabyother() {
		return initialbabyother;
	}
	public void setInitialbabyother(String initialbabyother) {
		this.initialbabyother = initialbabyother;
	}
	public List<Behavior> getAfterbaby() {
		return afterbaby;
	}
	public void setAfterbaby(List<Behavior> afterbaby) {
		this.afterbaby = afterbaby;
	}
	public String getAfterbabyeother() {
		return afterbabyeother;
	}
	public void setAfterbabyeother(String afterbabyeother) {
		this.afterbabyeother = afterbabyeother;
	}
	public List<Behavior> getInitialtoddler() {
		return initialtoddler;
	}
	public void setInitialtoddler(List<Behavior> initialtoddler) {
		this.initialtoddler = initialtoddler;
	}
	public String getInitialtoddlerother() {
		return initialtoddlerother;
	}
	public void setInitialtoddlerother(String initialtoddlerother) {
		this.initialtoddlerother = initialtoddlerother;
	}
	public List<Behavior> getAftertoddler() {
		return aftertoddler;
	}
	public void setAftertoddler(List<Behavior> aftertoddler) {
		this.aftertoddler = aftertoddler;
	}
	public String getAftertoddlereother() {
		return aftertoddlereother;
	}
	public void setAftertoddlereother(String aftertoddlereother) {
		this.aftertoddlereother = aftertoddlereother;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "Dolls [initialbaby=" + initialbaby + ", initialbabyother=" + initialbabyother + ", afterbaby="
				+ afterbaby + ", afterbabyeother=" + afterbabyeother + ", initialtoddler=" + initialtoddler
				+ ", initialtoddlerother=" + initialtoddlerother + ", aftertoddler=" + aftertoddler
				+ ", aftertoddlereother=" + aftertoddlereother + ", comments=" + comments + "]";
	}
	
	
}
