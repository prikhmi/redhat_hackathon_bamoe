package com.ibm.boycott.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LcEvaluationRequest {

	@JsonProperty("LCSender")
	private String lcSender;

	@JsonProperty("LCReceiver")
	private String lcReceiver;

	@JsonProperty("LCMsgType")
	private String lcMsgType;

	@JsonProperty("LCMsgAdvice")
	private String lcMsgAdvice;

	@JsonProperty("LCDate")
	private String lcDate;

	@JsonProperty("LCRefNo")
	private String lcRefNo;

	@JsonProperty("LCSequenceOfTotal")
	private List<String> lcSequenceOfTotal;

	@JsonProperty("LCFormOfDocumentaryCredit")
	private String lcFormOfDocumentaryCredit;

	@JsonProperty("LCTransRefNo")
	private String lcTransRefNo;

	@JsonProperty("LCDateOfIsuue")
	private String lcDateOfIssue;

	@JsonProperty("LCApplicableRules")
	private String lcApplicableRules;

	@JsonProperty("LCDateExpiry")
	private String lcDateExpiry;

	@JsonProperty("LCPlaceExpiry")
	private String lcPlaceExpiry;

	@JsonProperty("LCIssuingBank")
	private String lcIssuingBank;

	@JsonProperty("LCApplicantNameAndAddress")
	private String lcApplicantNameAndAddress;

	@JsonProperty("LCBeneNameAndAddress")
	private String lcBeneficiaryNameAndAddress;

	@JsonProperty("LCCurrencyCode")
	private String lcCurrencyCode;

	@JsonProperty("LCAmount")
	private String lcAmount;

	@JsonProperty("LCCreditAmtTolerance1")
	private String lcCreditAmtTolerance1;

	@JsonProperty("LCAvailableWithBy")
	private String lcAvailableWithBy;

	@JsonProperty("LCDraftAt")
	private String lcDraftAt;

	@JsonProperty("LCDrawee")
	private String lcDrawee;

	@JsonProperty("LCPartialsShipment")
	private String lcPartialsShipment;

	@JsonProperty("LCTranshipmentCode")
	private String lcTranshipmentCode;

	@JsonProperty("LCPortOfLoading")
	private String lcPortOfLoading = "";

	@JsonProperty("LCPortOfDischage")
	private String lcPortOfDischarge = "";

	@JsonProperty("LCPlaceOfDispatch")
	private String lcPlaceOfDispatch = "";

	@JsonProperty("LCPlaceOfDelivery")
	private String lcPlaceOfDelivery = "";

	@JsonProperty("LCLatestDateOfShipment")
	private String lcLatestDateOfShipment;

	@JsonProperty("LCDescriptionOfGoods")
	private String lcDescriptionOfGoods;

	@JsonProperty("LCDocumentRequired")
	private String lcDocumentRequired;

	@JsonProperty("LCAdditionalCondition")
	private String lcAdditionalCondition;

	@JsonProperty("LCCharges")
	private String lcCharges;

	@JsonProperty("LCPeriodForPresentationDays")
	private String lcPeriodForPresentationDays;

	@JsonProperty("LCConfirmationInstruction")
	private String lcConfirmationInstruction;

	@JsonProperty("LCInstructionToThePaying")
	private String lcInstructionToThePaying;

	@JsonProperty("LCAdviseThroughBank")
	private String lcAdviseThroughBank;

	@JsonProperty("LCSenderToReceiverInfo")
	private String lcSenderToReceiverInfo;

	@JsonProperty("LCReimbursingBank")
	private String lcReimbursingBank;

	public String getLcSender() {
		return lcSender;
	}

	public void setLcSender(String lcSender) {
		this.lcSender = lcSender;
	}

	public String getLcReceiver() {
		return lcReceiver;
	}

	public void setLcReceiver(String lcReceiver) {
		this.lcReceiver = lcReceiver;
	}

	public String getLcMsgType() {
		return lcMsgType;
	}

	public void setLcMsgType(String lcMsgType) {
		this.lcMsgType = lcMsgType;
	}

	public String getLcMsgAdvice() {
		return lcMsgAdvice;
	}

	public void setLcMsgAdvice(String lcMsgAdvice) {
		this.lcMsgAdvice = lcMsgAdvice;
	}

	public String getLcDate() {
		return lcDate;
	}

	public void setLcDate(String lcDate) {
		this.lcDate = lcDate;
	}

	public String getLcRefNo() {
		return lcRefNo;
	}

	public void setLcRefNo(String lcRefNo) {
		this.lcRefNo = lcRefNo;
	}

	public List<String> getLcSequenceOfTotal() {
		return lcSequenceOfTotal;
	}

	public void setLcSequenceOfTotal(List<String> lcSequenceOfTotal) {
		this.lcSequenceOfTotal = lcSequenceOfTotal;
	}

	public String getLcFormOfDocumentaryCredit() {
		return lcFormOfDocumentaryCredit;
	}

	public void setLcFormOfDocumentaryCredit(String lcFormOfDocumentaryCredit) {
		this.lcFormOfDocumentaryCredit = lcFormOfDocumentaryCredit;
	}

	public String getLcTransRefNo() {
		return lcTransRefNo;
	}

	public void setLcTransRefNo(String lcTransRefNo) {
		this.lcTransRefNo = lcTransRefNo;
	}

	public String getLcDateOfIssue() {
		return lcDateOfIssue;
	}

	public void setLcDateOfIssue(String lcDateOfIssue) {
		this.lcDateOfIssue = lcDateOfIssue;
	}

	public String getLcApplicableRules() {
		return lcApplicableRules;
	}

	public void setLcApplicableRules(String lcApplicableRules) {
		this.lcApplicableRules = lcApplicableRules;
	}

	public String getLcDateExpiry() {
		return lcDateExpiry;
	}

	public void setLcDateExpiry(String lcDateExpiry) {
		this.lcDateExpiry = lcDateExpiry;
	}

	public String getLcPlaceExpiry() {
		return lcPlaceExpiry;
	}

	public void setLcPlaceExpiry(String lcPlaceExpiry) {
		this.lcPlaceExpiry = lcPlaceExpiry;
	}

	public String getLcIssuingBank() {
		return lcIssuingBank;
	}

	public void setLcIssuingBank(String lcIssuingBank) {
		this.lcIssuingBank = lcIssuingBank;
	}

	public String getLcApplicantNameAndAddress() {
		return lcApplicantNameAndAddress;
	}

	public void setLcApplicantNameAndAddress(String lcApplicantNameAndAddress) {
		this.lcApplicantNameAndAddress = lcApplicantNameAndAddress;
	}

	public String getLcBeneficiaryNameAndAddress() {
		return lcBeneficiaryNameAndAddress;
	}

	public void setLcBeneficiaryNameAndAddress(String lcBeneficiaryNameAndAddress) {
		this.lcBeneficiaryNameAndAddress = lcBeneficiaryNameAndAddress;
	}

	public String getLcCurrencyCode() {
		return lcCurrencyCode;
	}

	public void setLcCurrencyCode(String lcCurrencyCode) {
		this.lcCurrencyCode = lcCurrencyCode;
	}

	public String getLcAmount() {
		return lcAmount;
	}

	public void setLcAmount(String lcAmount) {
		this.lcAmount = lcAmount;
	}

	public String getLcCreditAmtTolerance1() {
		return lcCreditAmtTolerance1;
	}

	public void setLcCreditAmtTolerance1(String lcCreditAmtTolerance1) {
		this.lcCreditAmtTolerance1 = lcCreditAmtTolerance1;
	}

	public String getLcAvailableWithBy() {
		return lcAvailableWithBy;
	}

	public void setLcAvailableWithBy(String lcAvailableWithBy) {
		this.lcAvailableWithBy = lcAvailableWithBy;
	}

	public String getLcDraftAt() {
		return lcDraftAt;
	}

	public void setLcDraftAt(String lcDraftAt) {
		this.lcDraftAt = lcDraftAt;
	}

	public String getLcDrawee() {
		return lcDrawee;
	}

	public void setLcDrawee(String lcDrawee) {
		this.lcDrawee = lcDrawee;
	}

	public String getLcPartialsShipment() {
		return lcPartialsShipment;
	}

	public void setLcPartialsShipment(String lcPartialsShipment) {
		this.lcPartialsShipment = lcPartialsShipment;
	}

	public String getLcTranshipmentCode() {
		return lcTranshipmentCode;
	}

	public void setLcTranshipmentCode(String lcTranshipmentCode) {
		this.lcTranshipmentCode = lcTranshipmentCode;
	}

	public String getLcPortOfLoading() {
		return lcPortOfLoading;
	}

	public void setLcPortOfLoading(String lcPortOfLoading) {
		this.lcPortOfLoading = lcPortOfLoading;
	}

	public String getLcPortOfDischarge() {
		return lcPortOfDischarge;
	}

	public void setLcPortOfDischarge(String lcPortOfDischarge) {
		this.lcPortOfDischarge = lcPortOfDischarge;
	}

	public String getLcPlaceOfDispatch() {
		return lcPlaceOfDispatch;
	}

	public void setLcPlaceOfDispatch(String lcPlaceOfDispatch) {
		this.lcPlaceOfDispatch = lcPlaceOfDispatch;
	}

	public String getLcPlaceOfDelivery() {
		return lcPlaceOfDelivery;
	}

	public void setLcPlaceOfDelivery(String lcPlaceOfDelivery) {
		this.lcPlaceOfDelivery = lcPlaceOfDelivery;
	}

	public String getLcLatestDateOfShipment() {
		return lcLatestDateOfShipment;
	}

	public void setLcLatestDateOfShipment(String lcLatestDateOfShipment) {
		this.lcLatestDateOfShipment = lcLatestDateOfShipment;
	}

	public String getLcDescriptionOfGoods() {
		return lcDescriptionOfGoods;
	}

	public void setLcDescriptionOfGoods(String lcDescriptionOfGoods) {
		this.lcDescriptionOfGoods = lcDescriptionOfGoods;
	}

	public String getLcDocumentRequired() {
		return lcDocumentRequired;
	}

	public void setLcDocumentRequired(String lcDocumentRequired) {
		this.lcDocumentRequired = lcDocumentRequired;
	}

	public String getLcAdditionalCondition() {
		return lcAdditionalCondition;
	}

	public void setLcAdditionalCondition(String lcAdditionalCondition) {
		this.lcAdditionalCondition = lcAdditionalCondition;
	}

	public String getLcCharges() {
		return lcCharges;
	}

	public void setLcCharges(String lcCharges) {
		this.lcCharges = lcCharges;
	}

	public String getLcPeriodForPresentationDays() {
		return lcPeriodForPresentationDays;
	}

	public void setLcPeriodForPresentationDays(String lcPeriodForPresentationDays) {
		this.lcPeriodForPresentationDays = lcPeriodForPresentationDays;
	}

	public String getLcConfirmationInstruction() {
		return lcConfirmationInstruction;
	}

	public void setLcConfirmationInstruction(String lcConfirmationInstruction) {
		this.lcConfirmationInstruction = lcConfirmationInstruction;
	}

	public String getLcInstructionToThePaying() {
		return lcInstructionToThePaying;
	}

	public void setLcInstructionToThePaying(String lcInstructionToThePaying) {
		this.lcInstructionToThePaying = lcInstructionToThePaying;
	}

	public String getLcAdviseThroughBank() {
		return lcAdviseThroughBank;
	}

	public void setLcAdviseThroughBank(String lcAdviseThroughBank) {
		this.lcAdviseThroughBank = lcAdviseThroughBank;
	}

	public String getLcSenderToReceiverInfo() {
		return lcSenderToReceiverInfo;
	}

	public void setLcSenderToReceiverInfo(String lcSenderToReceiverInfo) {
		this.lcSenderToReceiverInfo = lcSenderToReceiverInfo;
	}

	public String getLcReimbursingBank() {
		return lcReimbursingBank;
	}

	public void setLcReimbursingBank(String lcReimbursingBank) {
		this.lcReimbursingBank = lcReimbursingBank;
	}

	@Override
	public String toString() {
		return "RuleRequest [lcSender=" + lcSender + ", lcReceiver=" + lcReceiver + ", lcMsgType=" + lcMsgType
				+ ", lcMsgAdvice=" + lcMsgAdvice + ", lcDate=" + lcDate + ", lcRefNo=" + lcRefNo
				+ ", lcSequenceOfTotal=" + lcSequenceOfTotal + ", lcFormOfDocumentaryCredit="
				+ lcFormOfDocumentaryCredit + ", lcTransRefNo=" + lcTransRefNo + ", lcDateOfIssue=" + lcDateOfIssue
				+ ", lcApplicableRules=" + lcApplicableRules + ", lcDateExpiry=" + lcDateExpiry + ", lcPlaceExpiry="
				+ lcPlaceExpiry + ", lcIssuingBank=" + lcIssuingBank + ", lcApplicantNameAndAddress="
				+ lcApplicantNameAndAddress + ", lcBeneficiaryNameAndAddress=" + lcBeneficiaryNameAndAddress
				+ ", lcCurrencyCode=" + lcCurrencyCode + ", lcAmount=" + lcAmount + ", lcCreditAmtTolerance1="
				+ lcCreditAmtTolerance1 + ", lcAvailableWithBy=" + lcAvailableWithBy + ", lcDraftAt=" + lcDraftAt
				+ ", lcDrawee=" + lcDrawee + ", lcPartialsShipment=" + lcPartialsShipment + ", lcTranshipmentCode="
				+ lcTranshipmentCode + ", lcPortOfLoading=" + lcPortOfLoading + ", lcPortOfDischarge="
				+ lcPortOfDischarge + ", lcPlaceOfDispatch=" + lcPlaceOfDispatch + ", lcPlaceOfDelivery="
				+ lcPlaceOfDelivery + ", lcLatestDateOfShipment=" + lcLatestDateOfShipment + ", lcDescriptionOfGoods="
				+ lcDescriptionOfGoods + ", lcDocumentRequired=" + lcDocumentRequired + ", lcAdditionalCondition="
				+ lcAdditionalCondition + ", lcCharges=" + lcCharges + ", lcPeriodForPresentationDays="
				+ lcPeriodForPresentationDays + ", lcConfirmationInstruction=" + lcConfirmationInstruction
				+ ", lcInstructionToThePaying=" + lcInstructionToThePaying + ", lcAdviseThroughBank="
				+ lcAdviseThroughBank + ", lcSenderToReceiverInfo=" + lcSenderToReceiverInfo + ", lcReimbursingBank="
				+ lcReimbursingBank + "]";
	}


}