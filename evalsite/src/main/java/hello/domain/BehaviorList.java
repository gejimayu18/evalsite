package hello.domain;

import java.util.ArrayList;
import java.util.List;

public class BehaviorList {
	
	List<Behavior> behaviorList = new ArrayList<Behavior>();

	public List<Behavior> getBehaviorList() {
		return behaviorList;
	}

	public void setBehaviorList(List<Behavior> behaviorList) {
		this.behaviorList = behaviorList;
	}
	public void addBehavior(Behavior behavior) {
		this.behaviorList.add(behavior);
	}
	

}
