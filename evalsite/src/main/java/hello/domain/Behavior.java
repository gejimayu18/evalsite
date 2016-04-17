package hello.domain;

public class Behavior {
	
	private String name;
	private boolean ticked;
	
	public Behavior() {	}
	
	public Behavior(String name) {
		this.name = name;
		this.ticked = false;
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
	
	

}
