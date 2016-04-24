package com.djonesyking.evalsite.submit.domain;

public class Resources {
	
	private Treats treats;
	private Resource toys;
	private Resource bones;
	private String comments;
	public Treats getTreats() {
		return treats;
	}
	public void setTreats(Treats treats) {
		this.treats = treats;
	}
	public Resource getToys() {
		return toys;
	}
	public void setToys(Resource toys) {
		this.toys = toys;
	}
	public Resource getBones() {
		return bones;
	}
	public void setBones(Resource bones) {
		this.bones = bones;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "Resources [treats=" + treats + ", toys=" + toys + ", bones=" + bones + ", comments=" + comments + "]";
	}
	
	
	

}
