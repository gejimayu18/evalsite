package com.djonesyking.evalsite.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.djonesyking.evalsite.domain.Behavior;
import com.djonesyking.evalsite.domain.BehaviorList;
import com.djonesyking.evalsite.domain.SubmitResponse;
import com.djonesyking.evalsite.file.FileLocator;
import com.djonesyking.evalsite.pdf.FirstPdf;
import com.djonesyking.evalsite.submit.domain.Evaluation;

@RestController
@RequestMapping("/rest/behaviors/")
public class BehaviorsController {
	
	private FileLocator fileLocator = new FileLocator();

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
    @RequestMapping("backstrokes")
    public BehaviorList getBackstrokeBehaviors() {
    	BehaviorList list = new BehaviorList();
    	list.addListOfBehaviors(getTailList());
		list.addListOfBehaviors(getEyeList());
    	list.addBehavior(new Behavior("Wants more"));
    	list.addBehavior(new Behavior("Head whips"));
    	list.addBehavior(new Behavior("Shy"));
    	list.addBehavior(new Behavior("Nervous"));
    	list.addBehavior(new Behavior("lip licks"));
    	list.addBehavior(new Behavior("stiff"));
    	return list;
    }
    @RequestMapping("engage")
    public BehaviorList getEngageBehaviors() {
    	return buildSociabilityList();
    }
	private BehaviorList buildSociabilityList() {
		BehaviorList list = new BehaviorList();
		list.addListOfBehaviors(getEyeList());
    	list.addBehavior(new Behavior("Ears Back"));
    	list.addBehavior(new Behavior("Ears Forward"));
    	list.addBehavior(new Behavior("Ears side"));
    	list.addListOfBehaviors(getTailList());
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
	@RequestMapping("treats/takingtreats")
	public BehaviorList getTakingTreatsBehaviors() {
		BehaviorList list = new BehaviorList();
		list.addBehavior(new Behavior("Gentle"));
		list.addBehavior(new Behavior("Grabby hard"));
		list.addBehavior(new Behavior("Grabby soft"));
		list.addBehavior(new Behavior("Grabby soft but intense"));
		list.addBehavior(new Behavior("Grabby hard and intense"));
		list.addBehavior(new Behavior("Gentle at first then grabby"));
		list.addBehavior(new Behavior("Food Motivated - hyper & pushy"));
		list.addBehavior(new Behavior("Food Motivated - attentive & respectful"));
		list.addBehavior(new Behavior("Food Motivated - hyper but respectful"));
		list.addBehavior(new Behavior("Wouldn't eat"));
		list.addBehavior(new Behavior("other"));
		return list;
	}
	
	@RequestMapping("treats/treatsused")
	public BehaviorList getTreats() {
		BehaviorList list = new BehaviorList();
		list.addBehavior(new Behavior("Hot dog"));
		list.addBehavior(new Behavior("Cheese"));
		list.addBehavior(new Behavior("Log food"));
		list.addBehavior(new Behavior("other"));
		return list;
	}
	@RequestMapping("treats/commands")
	public BehaviorList getCommands() {
		BehaviorList list = new BehaviorList();
		list.addBehavior(new Behavior("None"));
		list.addBehavior(new Behavior("Sit"));
		list.addBehavior(new Behavior("Down"));
		list.addBehavior(new Behavior("Paw"));
		list.addBehavior(new Behavior("Come"));
		list.addBehavior(new Behavior("Stay"));
		list.addBehavior(new Behavior("Speak"));
		list.addBehavior(new Behavior("other"));
		return list;
	}
	@RequestMapping("resources/handused")
	public BehaviorList getHandUsed() {
		BehaviorList list = new BehaviorList();
		list.addBehavior(new Behavior("Real Hand"));
		list.addBehavior(new Behavior("Fake Hand"));
		return list;
	}
	@RequestMapping("resources/interest")
	public BehaviorList getInterest() {
		BehaviorList list = new BehaviorList();
		list.addBehavior(new Behavior("No interest"));
		list.addBehavior(new Behavior("No guarding seen"));
		list.addBehavior(new Behavior("Guarded mildly"));
		list.addBehavior(new Behavior("Guarded intensely"));
		list.addBehavior(new Behavior("Guarded space"));
		return list;
	}
	@RequestMapping("toys")
	public BehaviorList getToysBehaviors() {
		BehaviorList list = new BehaviorList();
		list.addBehavior(new Behavior("Playful - hyper"));
		list.addBehavior(new Behavior("Playful - gentle"));
		list.addBehavior(new Behavior("Playful - intense"));
		list.addBehavior(new Behavior("Playful - average"));
		list.addBehavior(new Behavior("Engages with you"));
		list.addBehavior(new Behavior("Plays by self"));
		list.addBehavior(new Behavior("Chews like a bone"));
		list.addBehavior(new Behavior("Plays keep away"));
		list.addBehavior(new Behavior("other"));
		return list;
	}
	@RequestMapping("bones")
	public BehaviorList getBonesBehaviors() {
		BehaviorList list = new BehaviorList();
		list.addBehavior(new Behavior("Playful - hyper"));
		list.addBehavior(new Behavior("Playful - gentle"));
		list.addBehavior(new Behavior("Playful - intense"));
		list.addBehavior(new Behavior("Playful - average"));
		list.addBehavior(new Behavior("Engages with you"));
		list.addBehavior(new Behavior("Plays by self"));
		list.addBehavior(new Behavior("Chews like a bone"));
		list.addBehavior(new Behavior("Plays keep away"));
		list.addBehavior(new Behavior("other"));
		return list;
	}
	@RequestMapping("food/delivery")
	public BehaviorList getFoodDelivery() {
		BehaviorList list = new BehaviorList();
		list.addBehavior(new Behavior("Loose body"));
		list.addBehavior(new Behavior("Excited jumping"));
		list.addBehavior(new Behavior("Counter surfing"));
		list.addBehavior(new Behavior("Jumps for bowl mild"));
		list.addBehavior(new Behavior("Jumps for bowl intense"));
		list.addBehavior(new Behavior("Sits for bowl"));
		list.addBehavior(new Behavior("Sniffs and walks away"));
		list.addBehavior(new Behavior("Will not approach"));
		list.addBehavior(new Behavior("Eats slow"));
		list.addBehavior(new Behavior("Eats normal"));
		list.addBehavior(new Behavior("Eats fast"));
		return list;
	}
	@RequestMapping("food/behaviors")
	public BehaviorList getFoodBehaviors() {
		BehaviorList list = new BehaviorList();
		list.addBehavior(new Behavior("Loose body"));
		list.addBehavior(new Behavior("Tense and unsure"));
		list.addListOfBehaviors(getTailList());
		list.addBehavior(new Behavior("Pause - keeps eating"));
		list.addBehavior(new Behavior("Moves away from bowl"));
		list.addBehavior(new Behavior("Eats faster"));
		list.addBehavior(new Behavior("Body block"));
		list.addBehavior(new Behavior("Freeze"));
		list.addBehavior(new Behavior("Growl"));
		list.addBehavior(new Behavior("Snarl"));
		list.addBehavior(new Behavior("Snap"));
		list.addBehavior(new Behavior("Bite"));
		list.addBehavior(new Behavior("No change"));
		list.addBehavior(new Behavior("other"));
		return list;
	}
	@RequestMapping("noises/initial")
	public BehaviorList getInitialNoiseBehaviors() {
		BehaviorList list = new BehaviorList();
		list.addBehavior(new Behavior("Alert"));
		list.addBehavior(new Behavior("Curious"));
		list.addBehavior(new Behavior("Sits"));
		list.addBehavior(new Behavior("Startled"));
		list.addBehavior(new Behavior("Uneasy and nervous"));
		list.addBehavior(new Behavior("Runs away"));
		list.addBehavior(new Behavior("Submissive"));
		list.addBehavior(new Behavior("Submissive and unsure"));
		list.addBehavior(new Behavior("Oblivious"));
		list.addBehavior(new Behavior("Stiffens"));
		list.addBehavior(new Behavior("Barks"));
		list.addBehavior(new Behavior("Hackles up"));
		list.addBehavior(new Behavior("Hard stare"));
		list.addBehavior(new Behavior("other"));
		return list;
	}
	@RequestMapping("noises/recover")
	public BehaviorList getRecoveryNoiseBehaviors() {
		BehaviorList list = new BehaviorList();
		list.addBehavior(new Behavior("Investigatres"));
		list.addBehavior(new Behavior("Comes to people"));
		list.addBehavior(new Behavior("Cowers"));
		list.addBehavior(new Behavior("Hides behind handler"));
		list.addListOfBehaviors(getEyeList());
		list.addListOfBehaviors(getTailList());
		list.addBehavior(new Behavior("Needs food to relax"));
		list.addBehavior(new Behavior("Shake off"));
		list.addBehavior(new Behavior("Lip licks"));
		list.addBehavior(new Behavior("Will not relax"));
		list.addBehavior(new Behavior("other"));
		return list;
	}
	@RequestMapping("noises/stranger")
	public BehaviorList getStrangerNoisesBehaviors() {
		BehaviorList list = getRecoveryNoiseBehaviors();
		list.addBehavior(new Behavior("Playful"));
		list.addBehavior(new Behavior("Hyper"));
		list.addBehavior(new Behavior("Rough jumping"));
		list.addBehavior(new Behavior("Stands still"));
		list.addListOfBehaviors(getEyeList());
		list.addListOfBehaviors(getTailList());
		list.addBehavior(new Behavior("Needs food to relax"));
		list.addBehavior(new Behavior("Shake off"));
		list.addBehavior(new Behavior("Lip licks"));
		list.addBehavior(new Behavior("Will not relax"));
		list.addBehavior(new Behavior("other"));
		return list;
	}
	@RequestMapping("dolls")
	public BehaviorList getDollsBehaviors() {
		BehaviorList list = getRecoveryNoiseBehaviors();
		list.addBehavior(new Behavior("Friendly"));
		list.addBehavior(new Behavior("Sniffing"));
		list.addBehavior(new Behavior("Curious"));
		list.addBehavior(new Behavior("Loose body"));
		list.addListOfBehaviors(getEyeList());
		list.addListOfBehaviors(getTailList());
		list.addBehavior(new Behavior("Jumpy"));
		list.addBehavior(new Behavior("Hyper"));
		list.addBehavior(new Behavior("Sits"));
		list.addBehavior(new Behavior("Lays"));
		list.addBehavior(new Behavior("other"));
		return list;
	}
	@RequestMapping("animaltest/initialcat")
	public BehaviorList getInitialCatBehaviors() {
		BehaviorList list = new BehaviorList();
		list.addBehavior(new Behavior("Curious"));
		list.addBehavior(new Behavior("Startled"));
		list.addBehavior(new Behavior("Whining"));
		list.addBehavior(new Behavior("Barking"));
		list.addBehavior(new Behavior("Fixated"));
		list.addBehavior(new Behavior("Fearful"));
		list.addBehavior(new Behavior("Shy"));
		list.addBehavior(new Behavior("Friendly"));
		list.addBehavior(new Behavior("other"));
		return list;
	}
	@RequestMapping("animaltest/aftercat")
	public BehaviorList getAfterCatBehaviors() {
		BehaviorList list = new BehaviorList();
		list.addBehavior(new Behavior("Curious"));
		list.addBehavior(new Behavior("Friendly"));
		list.addBehavior(new Behavior("Fearful"));
		list.addBehavior(new Behavior("Playful"));
		list.addBehavior(new Behavior("Avoids"));
		list.addBehavior(new Behavior("Whining"));
		list.addBehavior(new Behavior("Barking"));
		list.addBehavior(new Behavior("Fixated"));
		list.addBehavior(new Behavior("Backs down"));
		list.addBehavior(new Behavior("Overwhelmed"));
		list.addBehavior(new Behavior("Stressed"));
		list.addBehavior(new Behavior("May challenge"));
		list.addBehavior(new Behavior("May pester"));
		list.addBehavior(new Behavior("May fight out of fear"));
		list.addBehavior(new Behavior("May hunt"));
		list.addBehavior(new Behavior("Slow intro best"));
		list.addBehavior(new Behavior("other"));
		return list;
	}
	@RequestMapping("animaltest/dogrecommendations")
	public BehaviorList getDogRecommendations() {
		BehaviorList list = new BehaviorList();
		list.addBehavior(new Behavior("No dogs"));
		list.addBehavior(new Behavior("Some dogs"));
		list.addBehavior(new Behavior("Slow intro"));
		list.addBehavior(new Behavior("All dogs"));
		list.addBehavior(new Behavior("Calm dogs"));
		list.addBehavior(new Behavior("Playful dogs"));
		list.addBehavior(new Behavior("Must go with another dog"));
		list.addBehavior(new Behavior("Similar sized dog"));
		list.addBehavior(new Behavior("In passing only"));
		list.addBehavior(new Behavior("Undetermined"));
		list.addBehavior(new Behavior("other"));
		return list;
	}
	@RequestMapping("animaltest/catrecommendations")
	public BehaviorList getCatRecommendations() {
		BehaviorList list = new BehaviorList();
		list.addBehavior(new Behavior("Can live with cats"));
		list.addBehavior(new Behavior("Slow intro for dog's sake"));
		list.addBehavior(new Behavior("Slow intro for cat's sake"));
		list.addBehavior(new Behavior("No cats"));
		list.addBehavior(new Behavior("Undetermined"));
		list.addBehavior(new Behavior("other"));
		return list;
	}
	@RequestMapping("recommendations/walker")
	public BehaviorList getWalkerRecommendation() {
		BehaviorList list = new BehaviorList();
		list.addBehavior(new Behavior("Red"));
		list.addBehavior(new Behavior("Orange"));
		list.addBehavior(new Behavior("Yellow"));
		list.addBehavior(new Behavior("Blue"));
		list.addBehavior(new Behavior("Green"));
		return list;
	}
	
	@RequestMapping("recommendations/kids")
	public BehaviorList getKidsRecommendation() {
		BehaviorList list = new BehaviorList();
		list.addBehavior(new Behavior("Young kids"));
		list.addBehavior(new Behavior("Older kids"));
		list.addBehavior(new Behavior("Adult only"));
		list.addBehavior(new Behavior("Any age"));
		return list;
	}
	@RequestMapping("recommendations/personality")
	public BehaviorList getPersonalityRecommendation() {
		BehaviorList list = new BehaviorList();
		list.addBehavior(new Behavior("Sweet"));
		list.addBehavior(new Behavior("Cuddly"));
		list.addBehavior(new Behavior("Playful"));
		list.addBehavior(new Behavior("Puppy-like"));
		list.addBehavior(new Behavior("Calm"));
		list.addBehavior(new Behavior("Gentle"));
		list.addBehavior(new Behavior("Hyper"));
		list.addBehavior(new Behavior("Sensitive"));
		list.addBehavior(new Behavior("Shy"));
		list.addBehavior(new Behavior("Food motivated"));
		list.addBehavior(new Behavior("Counter surfer"));
		list.addBehavior(new Behavior("other"));
		return list;
	}
	@RequestMapping("recommendations/household")
	public BehaviorList getHouseholdRecommendation() {
		BehaviorList list = new BehaviorList();
		list.addBehavior(new Behavior("Great for first time pet owner"));
		list.addBehavior(new Behavior("Home with few visitors"));
		list.addBehavior(new Behavior("Quiet and calm"));
		list.addBehavior(new Behavior("Needs experience: Similar behaviors"));
		list.addBehavior(new Behavior("Needs experience: Same size dogs"));
		list.addBehavior(new Behavior("Needs experience: Same energy level"));
		list.addBehavior(new Behavior("Needs experience: Same breed(s)"));
		list.addBehavior(new Behavior("Needs dog in home"));
		list.addBehavior(new Behavior("Needs cat in home"));
		list.addBehavior(new Behavior("Needs kids in home"));
		list.addBehavior(new Behavior("Adult only"));
		list.addBehavior(new Behavior("Highly experienced owners"));
		list.addBehavior(new Behavior("Moderately active home"));
		list.addBehavior(new Behavior("Extremely active home"));
		list.addBehavior(new Behavior("other"));
		return list;
	}
	@RequestMapping("recommendations/waivers")
	public BehaviorList getWaiversRecommendation() {
		BehaviorList list = new BehaviorList();
		list.addBehavior(new Behavior("Dog aggression"));
		list.addBehavior(new Behavior("Resource guarding"));
		list.addBehavior(new Behavior("Fearful behavior"));
		list.addBehavior(new Behavior("Jumpy/mouthy behavior"));
		list.addBehavior(new Behavior("Assertive behavior"));
		return list;
	}
	
	@RequestMapping("/eval/{id}")
	public Evaluation getEval(@PathVariable String id) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		File file = new File(fileLocator.getJSONFile(id));
		Evaluation eval = new Evaluation();
		if (file.exists()) {
			eval = mapper.readValue(file, Evaluation.class);
		}
		return eval;
	}
	
	@RequestMapping(value="submit", method = RequestMethod.POST)
	public SubmitResponse submit(@RequestBody Evaluation input) throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		String jsonFile = fileLocator.getJSONFile(input.getHeader().getDogid());
		mapper.writeValue(new File(jsonFile), input);
		FirstPdf pdf = new FirstPdf();
		String buildPDF = pdf.buildPDF(input);
		SubmitResponse response = new SubmitResponse();
		response.setFilepath(buildPDF);
		return response;
	}
	
	private List<Behavior> getTailList() {
		List<Behavior> list = new ArrayList<Behavior>();
		list.add(new Behavior("Low Tail"));
    	list.add(new Behavior("Medium Tail"));
    	list.add(new Behavior("High Tail"));
    	list.add(new Behavior("Tucked Tail"));
    	list.add(new Behavior("Wagging Tail"));
    	list.add(new Behavior("Relaxed Tail"));
    	return list;
	}
	
	private List<Behavior> getEyeList() {
		List<Behavior> list = new ArrayList<Behavior>();
		list.add(new Behavior("Soft eyes"));
		list.add(new Behavior("Hard eyes"));
		list.add(new Behavior("Whale eyes"));
		return list;
	}

}