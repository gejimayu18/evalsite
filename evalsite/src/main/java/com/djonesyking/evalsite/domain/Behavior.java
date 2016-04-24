package com.djonesyking.evalsite.domain;

public class Behavior {
	
	private String name;
	private String category;
	private boolean ticked;
	
	public Behavior() {	}
	
	public Behavior(String name) {
		this(name, "");
	}
	
	public Behavior(String name, String category) {
		this.name = name;
		this.ticked = false;
		this.category = category;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isTicked() {
		return ticked;
	}
	public void setTicked(boolean ticked) {
		this.ticked = ticked;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (ticked ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Behavior other = (Behavior) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (ticked != other.ticked)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Behavior [name=" + name + ", category=" + category + ", ticked=" + ticked + "]";
	}
	
	

}
