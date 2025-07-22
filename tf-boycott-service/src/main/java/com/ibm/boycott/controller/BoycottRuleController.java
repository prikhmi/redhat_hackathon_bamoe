package com.ibm.boycott.controller;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ibm.boycott.client.GenAIHttpClient;
import com.ibm.boycott.dto.PromptRequest;
import com.ibm.boycott.dto.PromptResponse;
import com.ibm.boycott.engine.BoycottRuleEngine;
import com.ibm.boycott.mapper.DroolsMapper;
import com.ibm.boycott.model.DroolsRequest;
import com.ibm.boycott.model.LcEvaluationRequest;
import com.ibm.boycott.model.LcEvaluationResult;

@Path("/api/boycott")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BoycottRuleController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BoycottRuleController.class);

    @Inject
    @ConfigProperty(name = "quarkus.rest-client.genai-client.basic-auth.username")
    String genaiUsername;

    @Inject
    @ConfigProperty(name = "quarkus.rest-client.genai-client.basic-auth.password")
    String genaiPassword;

    @Inject
    BoycottRuleEngine ruleEngineExecutor;

    @Inject
    GenAIHttpClient genAIHttpClient;

    @POST
    @Path("/evaluate")
    public LcEvaluationResult evaluateBoycott(LcEvaluationRequest lcRequest) throws IOException {
        LOGGER.info("Received Boycott evaluation request: {}", lcRequest);
        PromptRequest promptRequest = new PromptRequest();
        promptRequest.setP_category("Boycott");
        promptRequest.setP_context(
                lcRequest.getLcDocumentRequired() + " " + lcRequest.getLcAdditionalCondition());
        promptRequest.setP_text(
                "Question: What are the prohibitions related to international trade finance that are mentioned in provided text?  . \n List all the prohibitions one by one without repeating and caegorize the same as 'Boycott', 'Sanction' or 'Others'. \n Return  response as a valid structured JSON Only with 'category' and 'prohibition_text' (WITHOUT ANY CHANGES TO ORIGINAL TEXT OR ANY SPELLING CORRECTIONS) for each prohibition. DO NOT ADD ANY OTHER DETAILS OF YOUR OWN. In case of no prohibitions are found return blank response.\n");

        LOGGER.info("Generated PromptRequest: {}", promptRequest);

        // PromptResponse promptResponse = genAIClient.callLLM(promptRequest);
        // PromptResponse promptResponse = genAIHttpClient.callLLM(promptRequest);
        // LOGGER.info("Received PromptResponse: {}", promptResponse);
       
        // TEMP MOCK: Hardcoded response
        PromptResponse promptResponse = new PromptResponse();
        promptResponse.setCategory("Boycott");
        promptResponse.setProhibition_text(List.of(
                "Prohibition on trade with specific countries",
                "Embargo on weapon sales"));
        LOGGER.info("Received PromptResponse (mocked): {}", promptResponse);

        DroolsRequest droolsRequest = DroolsMapper.mapFromPrompt(promptResponse);
        LOGGER.info("Mapped DroolsRequest: {}", droolsRequest);

        LcEvaluationResult result = ruleEngineExecutor.execute(lcRequest, droolsRequest);
        LOGGER.info("Boycott evaluation completed with result: {}", result);

        return result;
    }

}
