package com.djonesyking.evalsite.submit.domain;

public class Evaluation {
	private Header header;
	private Sociability sociability;
	private BodyHandling bh;
	private Resources resources;
	private Noises noises;
	private Dolls dolls;
	private AnimalTest animaltest;
	private Recommendations recommendations;

	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	public Sociability getSociability() {
		return sociability;
	}

	public void setSociability(Sociability sociability) {
		this.sociability = sociability;
	}

	public BodyHandling getBh() {
		return bh;
	}

	public void setBh(BodyHandling bh) {
		this.bh = bh;
	}

	public Resources getResources() {
		return resources;
	}

	public void setResources(Resources resources) {
		this.resources = resources;
	}

	public Noises getNoises() {
		return noises;
	}

	public void setNoises(Noises noises) {
		this.noises = noises;
	}

	public Dolls getDolls() {
		return dolls;
	}

	public void setDolls(Dolls dolls) {
		this.dolls = dolls;
	}

	public AnimalTest getAnimaltest() {
		return animaltest;
	}

	public void setAnimaltest(AnimalTest animaltest) {
		this.animaltest = animaltest;
	}

	public Recommendations getRecommendations() {
		return recommendations;
	}

	public void setRecommendations(Recommendations recommendations) {
		this.recommendations = recommendations;
	}

	@Override
	public String toString() {
		return "Evaluation [header=" + header + ", sociability=" + sociability + ", bh=" + bh + ", resources="
				+ resources + ", noises=" + noises + ", dolls=" + dolls + ", animaltest=" + animaltest
				+ ", recommendations=" + recommendations + "]";
	}

	
	

}
