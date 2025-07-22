package com.ibm.boycott.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;


public class RuleResult {

	@JsonProperty("name")
	private String name = "";

	@JsonProperty("status")
	private String status = "";

	@JsonProperty("validationMessage")
	private String validationMessage = "";

	@JsonProperty("referenceData")
	private String referenceData = "";

	@JsonProperty("highLightedText")
	private List<String> highLightedTexts = new ArrayList<String>();


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	
	public String getStatus() {
		return status;
	}

	
	public void setStatus(String status) {
		this.status = status;
	}

	
	public String getValidationMessage() {
		return validationMessage;
	}

	
	public void setValidationMessage(String validationMessage) {
		this.validationMessage = validationMessage;
	}

	
	public String getReferenceData() {
		return referenceData;
	}

	
	public void setReferenceData(String referenceData) {
		this.referenceData = referenceData;
	}

	public List<String> getHighLightedTexts() {
		return highLightedTexts;
	}

	public void setHighLightedTexts(List<String> highLightedTexts) {
		this.highLightedTexts = highLightedTexts;
	}

	public RuleResult(String validationMessage) {
		super();
		this.validationMessage = validationMessage;
	}

	public RuleResult() {
		super();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		RuleResult that = (RuleResult) o;
		return Objects.equals(name, that.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	
	public RuleResult(String name, String status, String validationMessage, String referenceData) {
		super();
		this.name = name;
		this.status = status;
		this.validationMessage = validationMessage;
		this.referenceData = referenceData;
	}



	//with highlight and without advisory
	public RuleResult(String name, String status, String validationMessage, String referenceData,
			List<String> highLightedTexts) {
		super();
		this.name = name;
		this.status = status;
		this.validationMessage = validationMessage;
		this.referenceData = referenceData;
		this.highLightedTexts = highLightedTexts;
	}



	@Override
	public String toString() {
		return "RuleResult [name=" + name + ", status=" + status + ", validationMessage=" + validationMessage
				 + ", referenceData=" + referenceData + ", highLightedTexts="
				+ highLightedTexts + "]";
	}

}
