package com.djonesyking.evalsite.pdf;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.util.StringUtils;

import com.djonesyking.evalsite.domain.Behavior;
import com.djonesyking.evalsite.file.FileLocator;
import com.djonesyking.evalsite.submit.domain.AnimalTest;
import com.djonesyking.evalsite.submit.domain.BodyHandling;
import com.djonesyking.evalsite.submit.domain.Dolls;
import com.djonesyking.evalsite.submit.domain.Evaluation;
import com.djonesyking.evalsite.submit.domain.FoodResource;
import com.djonesyking.evalsite.submit.domain.Handling;
import com.djonesyking.evalsite.submit.domain.Header;
import com.djonesyking.evalsite.submit.domain.Noises;
import com.djonesyking.evalsite.submit.domain.Recommendations;
import com.djonesyking.evalsite.submit.domain.Resource;
import com.djonesyking.evalsite.submit.domain.Resources;
import com.djonesyking.evalsite.submit.domain.Sociability;
import com.djonesyking.evalsite.submit.domain.Treats;
import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class FirstPdf {
	private FileLocator fileLocator = new FileLocator();
	private final Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 24, Font.BOLD);
	private final Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
	private final Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
	private final Font normal = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);
	private final SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	private static final Map<String, String> backStrokeVerbiage = new HashMap<String, String>();
	
	public FirstPdf() {
		backStrokeVerbiage.put("indifferent", "Indifferent");
		backStrokeVerbiage.put("likes", "Likes it");
		backStrokeVerbiage.put("loves", "Loves it");
		backStrokeVerbiage.put("doesnt", "Doesn't like it");
		backStrokeVerbiage.put("scared", "Scared");
	}

	public String buildPDF(Evaluation eval) {
		try {
			Document document = new Document();
			String filename = fileLocator.getPDFFile(eval.getHeader().getDogid());
			PdfWriter.getInstance(document, new FileOutputStream(filename));
			document.open();
			addMetaData(document, eval);
			addTitlePage(document, eval);
//			 addContent(document);
			document.close();
			return filename;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void addMetaData(Document document, Evaluation eval) {
		document.addTitle(eval.getHeader().getDogid() + " " + eval.getHeader().getDogname() + " Evaluation");
		document.addSubject(eval.getHeader().getDogid() + " " + eval.getHeader().getDogname() + " Evaluation");
		document.addKeywords(eval.getHeader().getDogid() + ", " + eval.getHeader().getDogname() + ", Evaluation");
		document.addAuthor("Providence Animal Center");
		document.addCreator("Providence Animal Center");
	}

	private void addTitlePage(Document document, Evaluation eval) throws DocumentException {
		printHeader(document, eval.getHeader());
		document.add(new Paragraph(" ", normal));
		printSociability(document, eval.getSociability());
		document.add(new Paragraph(" ", normal));
		printBodyHandling(document, eval.getBh());
		document.add(new Paragraph(" ", normal));
		printResources(document, eval.getResources());
		document.add(new Paragraph(" ", normal));
		printNoises(document, eval.getNoises());
		document.add(new Paragraph(" ", normal));
		printDolls(document, eval.getDolls());
		document.add(new Paragraph(" ", normal));
		printAnimalTest(document, eval.getAnimaltest());
		document.add(new Paragraph(" ", normal));
		printRecommendations(document, eval);
		// Start a new page
		document.newPage();
	}

	private void printRecommendations(Document document, Evaluation eval) throws DocumentException {
		AnimalTest animaltest = eval.getAnimaltest();
		Recommendations recommendations = eval.getRecommendations();
		
		document.add(new Paragraph("Recommendations and requirements", subFont));
		document.add(new Paragraph(" ", normal));
		
		Paragraph paragraph = new Paragraph();
		addBoldInline(paragraph, "Did sociability change during evaluation? ");
		addInline(paragraph, recommendations.getSociabilitychanged());
		paragraph = new Paragraph();
		document.add(paragraph);
		
		paragraph = new Paragraph();
		addBoldInline(paragraph, "Walker: ");
		addBehaviors(paragraph, recommendations.getWalker(), recommendations.getWalkercomments());
		document.add(paragraph);
		paragraph = new Paragraph();
		addBoldInline(paragraph, "Dogs: ");
		addBehaviors(paragraph, animaltest.getDogrecommendations(), animaltest.getDogrecommendationsother());
		document.add(paragraph);
		paragraph = new Paragraph();
		paragraph = new Paragraph();
		addBoldInline(paragraph, "Cats: ");
		addBehaviors(paragraph, animaltest.getCatrecommendations(), animaltest.getCatrecommendationsother());
		document.add(paragraph);
		paragraph = new Paragraph();
		addBoldInline(paragraph, "Kids: ");
		addBehaviors(paragraph, recommendations.getKids(), recommendations.getKidscomments());
		document.add(paragraph);
		paragraph = new Paragraph();
		addBoldInline(paragraph, "Personality: ");
		addBehaviors(paragraph, recommendations.getPersonality(), recommendations.getPersonalitycomments());
		document.add(paragraph);
		paragraph = new Paragraph();
		addBoldInline(paragraph, "Household: ");
		addBehaviors(paragraph, recommendations.getHousehold(), recommendations.getHouseholdcomments());
		document.add(paragraph);
		paragraph = new Paragraph();
		addBoldInline(paragraph, "Required counselling/Behavior waiver: ");
		addBehaviors(paragraph, recommendations.getWaivers(), recommendations.getWaiverscomments());
		document.add(paragraph);
		
		document.add(new Paragraph(" ", normal));
		paragraph = new Paragraph();
		addBoldInline(paragraph, "Comments");
		addInline(paragraph, recommendations.getComments());
		document.add(paragraph);
	}

	private void printAnimalTest(Document document, AnimalTest animaltest) throws DocumentException {
		document.add(new Paragraph("Dog & Cat Test", subFont));
		document.add(new Paragraph(" ", normal));
		
		Paragraph paragraph = new Paragraph();
		addBoldInline(paragraph, "Dogs");
		paragraph = new Paragraph();
		addBoldInline(paragraph, "Previously tested? ");
		addInline(paragraph, animaltest.getDogprevtested());
		addBoldInline(paragraph, " Dog in playgroup? ");
		addInline(paragraph, animaltest.getDogplaygroup());
		addBoldInline(paragraph, " Needs further testing? ");
		addInline(paragraph, animaltest.getDogfurthertesting());
		document.add(paragraph);
		paragraph = new Paragraph();
		addBoldInline(paragraph, "Dog test #1: ");
		addInline(paragraph, animaltest.getDogtest1());
		document.add(paragraph);
		paragraph = new Paragraph();
		addBoldInline(paragraph, "Dog test #2: ");
		addInline(paragraph, animaltest.getDogtest2());
		document.add(paragraph);
		
		document.add(new Paragraph(" ", normal));
		
		paragraph = new Paragraph();
		addBoldInline(paragraph, "Cats");
		paragraph = new Paragraph();
		addBoldInline(paragraph, "Previously tested? ");
		addInline(paragraph, animaltest.getCatprevtested());
		addBoldInline(paragraph, " Dog friendly cat used? ");
		addInline(paragraph, animaltest.getCatdogfriendly());
		document.add(paragraph);
		paragraph = new Paragraph();
		addBoldInline(paragraph, "Initial Reaction: ");
		addBehaviors(paragraph, animaltest.getInitialcat(), animaltest.getInitialcatother());
		document.add(paragraph);
		paragraph = new Paragraph();
		addBoldInline(paragraph, "After meeting: ");
		addBehaviors(paragraph, animaltest.getAftercat(), animaltest.getAftercatother());
		document.add(paragraph);
		
	}

	private void printDolls(Document document, Dolls dolls) throws DocumentException {
		document.add(new Paragraph("Dolls", subFont));
		document.add(new Paragraph(" ", normal));
		
		Paragraph paragraph = new Paragraph();
		addBoldInline(paragraph, "Baby intro: ");
		addBehaviors(paragraph, dolls.getInitialbaby(), dolls.getInitialbabyother());
		document.add(paragraph);
		paragraph = new Paragraph();
		addBoldInline(paragraph, "After initial intro: ");
		addBehaviors(paragraph, dolls.getAfterbaby(), dolls.getAfterbabyeother());
		document.add(paragraph);

		document.add(new Paragraph(" ", normal));
		
		paragraph = new Paragraph();
		addBoldInline(paragraph, "Toddler intro: ");
		addBehaviors(paragraph, dolls.getInitialtoddler(), dolls.getInitialtoddlerother());
		document.add(paragraph);
		paragraph = new Paragraph();
		addBoldInline(paragraph, "After initial intro: ");
		addBehaviors(paragraph, dolls.getAftertoddler(), dolls.getAftertoddlereother());
		document.add(paragraph);
		
		document.add(new Paragraph(" ", normal));
		paragraph = new Paragraph();
		addBoldInline(paragraph, "Doll Summary");
		addInline(paragraph, dolls.getComments());
		document.add(paragraph);
	}

	private void printNoises(Document document, Noises noises) throws DocumentException {
		document.add(new Paragraph("Noises", subFont));
		document.add(new Paragraph(" ", normal));
		
		Paragraph paragraph = new Paragraph();
		addBoldInline(paragraph, "Loud noise ");
		document.add(paragraph);
		paragraph = new Paragraph();
		addBoldInline(paragraph, "Initial reaction: ");
		addBehaviors(paragraph, noises.getInitialloudnoise(), noises.getInitialloudnoiseother());
		document.add(paragraph);
		paragraph = new Paragraph();
		addBoldInline(paragraph, "Recovery: ");
		addBehaviors(paragraph, noises.getRecoverloudnoise(), noises.getRecoverloudnoiseother());
		document.add(paragraph);
		
		document.add(new Paragraph(" ", normal));
		
		paragraph = new Paragraph();
		addBoldInline(paragraph, "Scolding");
		document.add(paragraph);
		paragraph = new Paragraph();
		addBoldInline(paragraph, "Initial reaction: ");
		addBehaviors(paragraph, noises.getInitialscold(), noises.getInitialscoldother());
		document.add(paragraph);
		paragraph = new Paragraph();
		addBoldInline(paragraph, "Recovery: ");
		addBehaviors(paragraph, noises.getRecoverscold(), noises.getRecoverscoldother());
		document.add(paragraph);
		
		document.add(new Paragraph(" ", normal));
		
		paragraph = new Paragraph();
		addBoldInline(paragraph, "Knock at door");
		document.add(paragraph);
		paragraph = new Paragraph();
		addBoldInline(paragraph, "Initial reaction: ");
		addBehaviors(paragraph, noises.getInitialknockatdoor(), noises.getInitialknockatdoorother());
		document.add(paragraph);
		
		document.add(new Paragraph(" ", normal));
		
		paragraph = new Paragraph();
		addBoldInline(paragraph, "Stranger ");
		addInline(paragraph, '(' + noises.getStrangergender() + ')');
		document.add(paragraph);
		paragraph = new Paragraph();
		addBoldInline(paragraph, "Initial reaction: ");
		addBehaviors(paragraph, noises.getInitialstranger(), noises.getInitialstrangerother());
		document.add(paragraph);
		
		paragraph = new Paragraph();
		addBoldInline(paragraph, "Recovery: ");
		addBehaviors(paragraph, noises.getRecoverstranger(), noises.getRecoverstrangerother());
		document.add(paragraph);
		
		document.add(new Paragraph(" ", normal));
		paragraph = new Paragraph();
		addBoldInline(paragraph, "Resources Summary");
		addInline(paragraph, noises.getComment());
		document.add(paragraph);
		
	}

	private void printResources(Document document, Resources resources) throws DocumentException {
		document.add(new Paragraph("Resources", subFont));
		document.add(new Paragraph(" ", normal));
		
		Treats treats = resources.getTreats();
		Paragraph paragraph = new Paragraph();
		addBoldInline(paragraph, "Treats ");
		document.add(paragraph);
		paragraph = new Paragraph();
		addBoldInline(paragraph, "Taking treats: ");
		addBehaviors(paragraph, treats.getTakingtreatsbehaviors(), treats.getTakingtreatsbehaviorother());
		document.add(paragraph);
		
		paragraph = new Paragraph();
		addBoldInline(paragraph, "Treats used: ");
		addBehaviors(paragraph, treats.getTreatsused(), treats.getTreatsusedbehaviorother());
		document.add(paragraph);

		paragraph = new Paragraph();
		addBoldInline(paragraph, "Commands: ");
		addBehaviors(paragraph, treats.getCommands(), treats.getCommandsbehaviorother());
		document.add(paragraph);
		
		document.add(new Paragraph(" ", normal));
		
		paragraph = new Paragraph();
		Resource toys = resources.getToys();
		addBoldInline(paragraph, "Toys ");
		document.add(paragraph);
		paragraph = new Paragraph();
		addBoldInline(paragraph, "Toys used: 1: ");
		addInline(paragraph, toys.getUsed1());
		addBoldInline(paragraph, " 2: ");
		addInline(paragraph, toys.getUsed2());
		addInline(paragraph, "(");
		addBehaviors(paragraph, toys.getHands(), null);
		addInline(paragraph, ")");
		document.add(paragraph);
		
		paragraph = new Paragraph();
		addBoldBehaviors(paragraph, toys.getInterest(), null);
		document.add(paragraph);
		paragraph = new Paragraph();
		addBehaviors(paragraph, toys.getBehavior(), toys.getBehaviorother());
		document.add(paragraph);
		
		document.add(new Paragraph(" ", normal));
		
		paragraph = new Paragraph();
		Resource bones = resources.getBones();
		addBoldInline(paragraph, "Bones ");
		document.add(paragraph);
		paragraph = new Paragraph();
		addBoldInline(paragraph, "Bones used: 1: ");
		addInline(paragraph, bones.getUsed1());
		addBoldInline(paragraph, " 2: ");
		addInline(paragraph, bones.getUsed2());
		addInline(paragraph, " (");
		addBehaviors(paragraph, bones.getHands(), null);
		addInline(paragraph, ")");
		document.add(paragraph);
		
		paragraph = new Paragraph();
		addBoldBehaviors(paragraph, bones.getInterest(), null);
		document.add(paragraph);
		paragraph = new Paragraph();
		addBehaviors(paragraph, bones.getBehavior(), bones.getBehaviorother());
		document.add(paragraph);
		
		document.add(new Paragraph(" ", normal));
		
		paragraph = new Paragraph();
		FoodResource food = resources.getFood();
		addBoldInline(paragraph, "Food ");
		document.add(paragraph);
		paragraph = new Paragraph();
		addBoldInline(paragraph, "Were treats used to coax dog to eat? ");
		addInline(paragraph, food.getCoax());
		addInline(paragraph, " (");
		addBehaviors(paragraph, food.getHands(), null);
		addInline(paragraph, ")");
		document.add(paragraph);
		
		paragraph = new Paragraph();
		addBoldBehaviors(paragraph, food.getInterest(), null);
		document.add(paragraph);
		
		paragraph = new Paragraph();
		addBoldInline(paragraph, "Initial delivery: ");
		addBehaviors(paragraph, food.getDelivery(), food.getFoodinitdeliverybehaviorother());
		document.add(paragraph);
		
		paragraph = new Paragraph();
		addBoldInline(paragraph, "Initial approach");
		addBehaviors(paragraph, food.getInitialapproach(), food.getInitialapproachother());
		document.add(paragraph);
		
		paragraph = new Paragraph();
		addBoldInline(paragraph, "Touch dog: ");
		addBehaviors(paragraph, food.getTouchdog(), food.getTouchdogother());
		document.add(paragraph);
		
		paragraph = new Paragraph();
		addBoldInline(paragraph, "Touch bowl: ");
		addBehaviors(paragraph, food.getTouchbowl(), food.getTouchbowlother());
		document.add(paragraph);
		
		document.add(new Paragraph(" ", normal));
		paragraph = new Paragraph();
		addBoldInline(paragraph, "Resources Summary");
		addInline(paragraph, resources.getComments());
		document.add(paragraph);
		
		
	}

	private void printBodyHandling(Document document, BodyHandling bh) throws DocumentException {
		document.add(new Paragraph("Body Handling", subFont));
		
		document.add(new Paragraph(" ", normal));
		Paragraph paragraph = new Paragraph();
		addBoldInline(paragraph, "Teeth check: ");
		addInline(paragraph, "Completed ");
		addInline(paragraph, bh.getTeethCompleted());
		addInline(paragraph, " / ");
		addInline(paragraph, bh.getTeethAttempted());
		addInline(paragraph, " Had to be more assertive? ");
		addInline(paragraph, bh.getTeethCheckAssertive());
		document.add(paragraph);
		
		paragraph = new Paragraph();
		addBoldInline(paragraph, "Difficulty: TODO ADD DIFFICULTY");
		//TODO difficulty
		document.add(paragraph);
		
		paragraph = new Paragraph();
		addBoldInline(paragraph, "Dog's reaction: ");
		addBehaviors(paragraph, bh.getTeethcheckbehaviors(), bh.getTeethcheckbehaviorsother());
		document.add(paragraph);
		document.add(new Paragraph(" ", normal));
		
		paragraph = new Paragraph();
		addBoldInline(paragraph, "Handling: ");
		document.add(paragraph);
		
		paragraph = new Paragraph();
		PdfPTable table = new PdfPTable(4);
		table.setWidthPercentage(100);
		addBoldCell(table, "Tail tug: ");
		Handling handling = bh.getHandling();
		addBehaviorsToCell(table, handling.getTailtugbehaviors(), null);
		addBoldCell(table, "Ears L: ");
		addBehaviorsToCell(table, handling.getEarslbehaviors(), null);
		addBoldCell(table, "Ears R: ");
		addBehaviorsToCell(table, handling.getEarsrbehaviors(), null);
		addBoldCell(table, "Paws-front L: ");
		addBehaviorsToCell(table, handling.getPawsfrontlbehaviors(), null);
		addBoldCell(table, "Paws-front R: ");
		addBehaviorsToCell(table, handling.getPawsfrontrbehaviors(), null);
		addBoldCell(table, "Paws-back L: ");
		addBehaviorsToCell(table, handling.getPawsbacklbehaviors(), null);
		addBoldCell(table, "Paws-back R: ");
		addBehaviorsToCell(table, handling.getPawsbackrbehaviors(), null);
		addBoldCell(table, "Hug-front: ");
		addBehaviorsToCell(table, handling.getHugfrontbehaviors(), null);
		addBoldCell(table, "Hug-side: ");
		addBehaviorsToCell(table, handling.getHugsidebehaviors(), null);
		addBoldCell(table, "Pick Up: ");
		addBehaviorsToCell(table, handling.getPickupbehaviors(), null);
		addBoldCell(table, "Eye Contact: ");
		addBehaviorsToCell(table, handling.getEyecontactbehaviors(), null);
		addBoldCell(table, "Overall: ");
		addBehaviorsToCell(table, handling.getOverallbehaviors(), null);
		if (!StringUtils.isEmpty(handling.getHandlingother())) {
			addBoldCell(table, "Other: ");
			addNormalCell(table, handling.getHandlingother());
		}
		paragraph.add(table);
		document.add(paragraph);
		
		document.add(new Paragraph(" ", normal));
		paragraph = new Paragraph();
		addBoldInline(paragraph, "Handling Summary");
		addInline(paragraph, bh.getComments());
		document.add(paragraph);
	}

	private void printSociability(Document document, Sociability sociability) throws DocumentException {
		document.add(new Paragraph("Kennel Behavior", subFont));
		document.add(new Paragraph(" ", normal));

		Paragraph paragraph = new Paragraph();
		addBoldInline(paragraph, "Pulling dog: ");
		addBehaviors(paragraph, sociability.getPulldogbehaviors(),
				sociability.getPulldogbehaviorsother());
		addEmptyLine(paragraph, 1);

		addBoldInline(paragraph, "Walking: ");
		addBehaviors(paragraph, sociability.getWalkingbehaviors(),
				sociability.getWalkingbehaviorother());
		document.add(paragraph);
		
		document.add(new Paragraph(" ", normal));

		int totalScore = sociability.getEngageScore() + sociability.getIgnoreScore();
		document.add(new Paragraph("Sociability - Total Score: " + totalScore, subFont));
		document.add(new Paragraph(" ", normal));

		paragraph = new Paragraph();
		addBoldInline(paragraph, "1. Stand and ignore for 60 seconds ");
		addInline(paragraph, "Score: ");
		addInline(paragraph, sociability.getIgnoreScore());
		document.add(paragraph);
		
		paragraph = new Paragraph();
		addBoldInline(paragraph, "Behaviors: ");
		addBehaviors(paragraph, sociability.getIgnorebehaviors(), sociability.getIgnorebehaviorother());
		addEmptyLine(paragraph, 2);
		document.add(paragraph);
		
		paragraph = new Paragraph();
		addBoldInline(paragraph, "2. Three back strokes: ");
		addInline(paragraph, backStrokeVerbiage.get(sociability.getBackstrokes()));
		document.add(paragraph);
		paragraph = new Paragraph();
		addBoldInline(paragraph, "Behaviors: ");
		addBehaviors(paragraph, sociability.getBackstrokebehaviors(), null);
		addEmptyLine(paragraph, 2);
		document.add(paragraph);

		paragraph = new Paragraph();
		addBoldInline(paragraph, "3. Sit on: ");
		addInline(paragraph, sociability.getSiton());
		addBoldInline(paragraph, " Count 5 seconds. Did the dog come over to you? ");
		addInline(paragraph, sociability.getCameover());
		addEmptyLine(paragraph, 2);
		document.add(paragraph);
		
		paragraph = new Paragraph();
		addBoldInline(paragraph, "4. Call dog over and solicit attention for 20 seconds. ");
		addInline(paragraph, "Score: ");
		addInline(paragraph, sociability.getEngageScore());
		document.add(paragraph);
		
		paragraph = new Paragraph();
		addBoldInline(paragraph, "Behaviors: ");
		addBehaviors(paragraph, sociability.getEngagebehaviors(), sociability.getEngagebehaviorother());
		addEmptyLine(paragraph, 2);
		document.add(paragraph);
		
		paragraph = new Paragraph();
		addBoldInline(paragraph, "Sociability summary");
		addEmptyLine(paragraph, 1);
		addInline(paragraph, sociability.getComments());
		document.add(paragraph);
	}

	private void addBehaviors(Paragraph paragraph, java.util.List<Behavior> behaviorList, String otherBehavior) {
		int listSize = behaviorList.size();
		for (int i = 0; i < listSize; i++) {
			if (i > 0) {
				addInline(paragraph, ", ");
			}
			addInline(paragraph, behaviorList.get(i).getName());
		}
		if (otherBehavior != null && !"".equals(otherBehavior)) {
			if (listSize > 0) {
				addInline(paragraph, ", ");
			}
			addInline(paragraph, otherBehavior);
		}
	}
	
	private void addBoldBehaviors(Paragraph paragraph, java.util.List<Behavior> behaviorList, String otherBehavior) {
		int listSize = behaviorList.size();
		for (int i = 0; i < listSize; i++) {
			if (i > 0) {
				addInline(paragraph, ", ");
			}
			addBoldInline(paragraph, behaviorList.get(i).getName());
		}
		if (otherBehavior != null && !"".equals(otherBehavior)) {
			if (listSize > 0) {
				addBoldInline(paragraph, ", ");
			}
			addBoldInline(paragraph, otherBehavior);
		}
	}
	
	private void addBehaviorsToCell(PdfPTable table, java.util.List<Behavior> behaviorList, String otherBehavior) {
		int listSize = behaviorList.size();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < listSize; i++) {
			if (i > 0) {
				sb.append(", ");
			}
			sb.append(behaviorList.get(i).getName());
		}
		if (otherBehavior != null && !"".equals(otherBehavior)) {
			if (listSize > 0) {
				sb.append(", ");
			}
			sb.append(otherBehavior);
		}
		addNormalCell(table, sb.toString());
	}
	
	private void addInline(Paragraph paragraph, int value) {
		addInline(paragraph, String.valueOf(value), null);
	}
	
	private void addInline(Paragraph paragraph, String value) {
		addInline(paragraph, value, null);
	}
	
	private void addInline(Paragraph paragraph, Date value) {
		addInline(paragraph, dateFormat.format(value), null);
	}
	
	private void addBoldInline(Paragraph paragraph, String value) {
		addInline(paragraph, value, smallBold);
	}

	private void addInline(Paragraph paragraph, String value, Font font) {
		if (value != null) {
			if (font == null) {
				Chunk chunk = new Chunk(value, normal);
				paragraph.add(chunk);
			} else {
				Chunk chunk = new Chunk(value, font);
				paragraph.add(chunk);
			}
		}
	}

	private void printHeader(Document document, Header header) throws DocumentException {
		Paragraph headerPg = new Paragraph();
		headerPg.add(new Paragraph("Canine behavior evaluation", catFont));

		addEmptyLine(headerPg, 1);
		
		PdfPTable table = new PdfPTable(8);
		table.setWidthPercentage(100);
		addBoldCell(table, "Evaluator: ");
		addNormalCell(table, header.getEvaluator());
		addBoldCell(table, "Handler: ");
		addNormalCell(table, header.getHandler());
		addBoldCell(table, "Dog Name: ");
		addNormalCell(table, header.getDogname());
		addBoldCell(table, "ID#: ");
		addNormalCell(table, header.getDogid());
		addBoldCell(table, "Breed(s): ");
		addNormalCell(table, header.getBreed());
		addBoldCell(table, "Gender: ");
		addNormalCell(table, header.getGender().toUpperCase());
		addBoldCell(table, "Age Range: ");
		addNormalCell(table, header.getAge());
		addBoldCell(table, "");
		addNormalCell(table, "");
		addBoldCell(table, "Intake Date: ");
		addNormalCell(table, header.getIntakeDate());
		addBoldCell(table, "Today's Date: ");
		addNormalCell(table, header.getEvalDate());
		addBoldCell(table, "Re-eval? ");
		addNormalCell(table, header.getReeval());
		addBoldCell(table, "Pending? ");
		addNormalCell(table, header.getPending());
		headerPg.add(table);

		addEmptyLine(headerPg, 1);

		document.add(headerPg);
	}
	
	private void addBoldCell(PdfPTable table, String text) {
		addCell(table, text, smallBold);
	}
	private void addNormalCell(PdfPTable table, String text) {
		addCell(table, text, normal);
	}
	private void addNormalCell(PdfPTable table, Date text) {
		addCell(table, dateFormat.format(text), normal);
	}
	
	private void addCell(PdfPTable table, String text, Font font) {
		Chunk chunk = new Chunk(text, font);
		PdfPCell cell = new PdfPCell(new Phrase(chunk));
		cell.setBorder(Rectangle.NO_BORDER);
		table.addCell(cell);
	}

	private void addContent(Document document) throws DocumentException {
		Anchor anchor = new Anchor("First Chapter", catFont);
		anchor.setName("First Chapter");

		// Second parameter is the number of the chapter
		Chapter catPart = new Chapter(new Paragraph(anchor), 1);

		Paragraph subPara = new Paragraph("Subcategory 1", subFont);
		Section subCatPart = catPart.addSection(subPara);
		subCatPart.add(new Paragraph("Hello"));

		subPara = new Paragraph("Subcategory 2", subFont);
		subCatPart = catPart.addSection(subPara);
		subCatPart.add(new Paragraph("Paragraph 1"));
		subCatPart.add(new Paragraph("Paragraph 2"));
		subCatPart.add(new Paragraph("Paragraph 3"));

		// add a list
		createList(subCatPart);
		Paragraph paragraph = new Paragraph();
		addEmptyLine(paragraph, 5);
		subCatPart.add(paragraph);

		// add a table
		createTable(subCatPart);

		// now add all this to the document
		document.add(catPart);

		// Next section
		anchor = new Anchor("Second Chapter", catFont);
		anchor.setName("Second Chapter");

		// Second parameter is the number of the chapter
		catPart = new Chapter(new Paragraph(anchor), 1);

		subPara = new Paragraph("Subcategory", subFont);
		subCatPart = catPart.addSection(subPara);
		subCatPart.add(new Paragraph("This is a very important message"));

		// now add all this to the document
		document.add(catPart);

	}

	private void createTable(Section subCatPart) throws BadElementException {
		PdfPTable table = new PdfPTable(3);

		// t.setBorderColor(BaseColor.GRAY);
		// t.setPadding(4);
		// t.setSpacing(4);
		// t.setBorderWidth(1);

		PdfPCell c1 = new PdfPCell(new Phrase("Table Header 1"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("Table Header 2"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("Table Header 3"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		table.setHeaderRows(1);

		table.addCell("1.0");
		table.addCell("1.1");
		table.addCell("1.2");
		table.addCell("2.1");
		table.addCell("2.2");
		table.addCell("2.3");

		subCatPart.add(table);

	}

	private void createList(Section subCatPart) {
		List list = new List(true, false, 10);
		list.add(new ListItem("First point"));
		list.add(new ListItem("Second point"));
		list.add(new ListItem("Third point"));
		subCatPart.add(list);
	}

	private void addEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" ", normal));
		}
	}
}