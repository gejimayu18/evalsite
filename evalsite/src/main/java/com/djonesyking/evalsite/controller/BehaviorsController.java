package com.djonesyking.evalsite.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.djonesyking.evalsite.domain.Behavior;
import com.djonesyking.evalsite.domain.BehaviorList;

@RestController
@RequestMapping("/rest/behaviors/")
public class BehaviorsController {

    @RequestMapping("pull")
    public BehaviorList getPullBehaviors() {
    	BehaviorList list = new BehaviorList();
    	list.addBehavior(new Behavior("calm"));
    	list.addBehavior(new Behavior("friendly"));
    	list.addBehavior(new Behavior("hyper"));
    	list.addBehavior(new Behavior("excited"));
    	list.addBehavior(new Behavior("shy"));
    	list.addBehavior(new Behavior("fearful"));
    	list.addBehavior(new Behavior("unsure"));
    	list.addBehavior(new Behavior("easy to leash"));
    	list.addBehavior(new Behavior("difficult to leash"));
    	list.addBehavior(new Behavior("excited barking"));
    	list.addBehavior(new Behavior("unsure barking"));
    	list.addBehavior(new Behavior("aggressive barking"));
    	list.addBehavior(new Behavior("runs away"));
    	list.addBehavior(new Behavior("cowers in corner"));
    	list.addBehavior(new Behavior("won't move"));
    	list.addBehavior(new Behavior("had to be coaxed out"));
    	list.addBehavior(new Behavior("had to be carried out"));
    	list.addBehavior(new Behavior("other"));
        return list;
    }
    @RequestMapping("walking")
    public BehaviorList getWalkingBehaviors() {
    	BehaviorList list = new BehaviorList();
    	list.addBehavior(new Behavior("walks nicely"));
    	list.addBehavior(new Behavior("hyper-jumping"));
    	list.addBehavior(new Behavior("leash biting"));
    	list.addBehavior(new Behavior("scared"));
    	list.addBehavior(new Behavior("reactive to dogs"));
    	list.addBehavior(new Behavior("pulls hard"));
    	list.addBehavior(new Behavior("won't walk"));
    	list.addBehavior(new Behavior("army crawling"));
    	list.addBehavior(new Behavior("won't walk outside - had to be carried"));
    	list.addBehavior(new Behavior("reactive when outside"));
    	list.addBehavior(new Behavior("wants to meet everyone"));
    	list.addBehavior(new Behavior("flailing on leash"));
    	list.addBehavior(new Behavior("other"));
    	return list;
    }
    @RequestMapping("ignore")
    public BehaviorList getIgnoreBehaviors() {
    	return buildSociabilityList();
    }
    @RequestMapping("engage")
    public BehaviorList getEngageBehaviors() {
    	return buildSociabilityList();
    }
	private BehaviorList buildSociabilityList() {
		BehaviorList list = new BehaviorList();
    	list.addBehavior(new Behavior("Soft Eyes"));
    	list.addBehavior(new Behavior("Hard Eyes"));
    	list.addBehavior(new Behavior("Whale Eyes"));
    	list.addBehavior(new Behavior("Ears Back"));
    	list.addBehavior(new Behavior("Ears Forward"));
    	list.addBehavior(new Behavior("Ears side"));
    	list.addBehavior(new Behavior("Low Tail"));
    	list.addBehavior(new Behavior("Medium Tail"));
    	list.addBehavior(new Behavior("High Tail"));
    	list.addBehavior(new Behavior("Tucked Tail"));
    	list.addBehavior(new Behavior("Wagging Tail"));
    	list.addBehavior(new Behavior("other"));
    	return list;
	}
	
	@RequestMapping("teethcheck")
    public BehaviorList getTeethCheckBehaviors() {
		BehaviorList list = new BehaviorList();
    	list.addBehavior(new Behavior("Playful"));
    	list.addBehavior(new Behavior("Enjoyed it"));
    	list.addBehavior(new Behavior("tolerant but didn't enjoy"));
    	list.addBehavior(new Behavior("Submitted"));
    	list.addBehavior(new Behavior("Pushy"));
    	list.addBehavior(new Behavior("Lip curl"));
    	list.addBehavior(new Behavior("Snap"));
    	list.addBehavior(new Behavior("Escalated intensity of corrections to handler"));
    	list.addBehavior(new Behavior("Tried to avoid"));
    	list.addBehavior(new Behavior("Shake off"));
    	list.addBehavior(new Behavior("Growl"));
    	list.addBehavior(new Behavior("other"));
    	return list;
    }
	
	@RequestMapping("bodyhandling")
	public BehaviorList getBodyHandlingBehaviors() {
		BehaviorList list = new BehaviorList();
		list.addBehavior(new Behavior("Playful/excited/silly"));
		list.addBehavior(new Behavior("calm/enjoys"));
		list.addBehavior(new Behavior("tolerant but unsure/didn't enjoy"));
		list.addBehavior(new Behavior("stiff/very unsure but tolerant"));
		list.addBehavior(new Behavior("Indifferent"));
		list.addBehavior(new Behavior("Snappy/Growly/Agitated"));
		list.addBehavior(new Behavior("other"));
		return list;
	}
    

}