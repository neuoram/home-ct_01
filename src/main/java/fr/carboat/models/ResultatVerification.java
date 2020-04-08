package fr.carboat.models;

public class ResultatVerification {

	String reference;
	boolean scam;
	String[] rules;

	public ResultatVerification(String reference, boolean scam, String[] rules) {
		super();
		this.reference = reference;
		this.scam = scam;
		this.rules = rules;
	}

	public ResultatVerification(String reference) {
		super();
		this.reference = reference;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public boolean isScam() {
		return scam;
	}

	public void setScam(boolean scam) {
		this.scam = scam;
	}

	public String[] getRules() {
		return rules;
	}

	public void setRules(String[] rules) {
		this.rules = rules;
	}

}
