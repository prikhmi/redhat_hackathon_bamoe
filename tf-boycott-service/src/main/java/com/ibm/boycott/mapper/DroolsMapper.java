package com.ibm.boycott.mapper;

import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ibm.boycott.dto.PromptResponse;
import com.ibm.boycott.model.DroolsRequest;

public class DroolsMapper {

    private static final Logger LOGGER = LoggerFactory.getLogger(DroolsMapper.class);

    private DroolsMapper() {
        // Prevent instantiation
    }

    public static DroolsRequest mapFromPrompt(PromptResponse promptResponse) {
        LOGGER.debug("🔁 Mapping PromptResponse to DroolsRequest: {}", promptResponse);

        DroolsRequest request = new DroolsRequest();

        if (promptResponse != null && "Boycott".equalsIgnoreCase(promptResponse.getCategory())) {
            boolean hasText = promptResponse.getProhibition_text() != null && !promptResponse.getProhibition_text().isEmpty();

            request.setBoycottStatus(hasText);
            request.setHighlightText(promptResponse.getProhibition_text());

            LOGGER.info("✅ Boycott detected. Highlight text set with {} entries.", 
                        promptResponse.getProhibition_text() != null ? promptResponse.getProhibition_text().size() : 0);
        } else {
            request.setBoycottStatus(false);
            request.setHighlightText(Collections.emptyList());

            LOGGER.info("🚫 No boycott detected or invalid category. Default values set.");
        }

        LOGGER.debug("📦 Mapped DroolsRequest: {}", request);
        return request;
    }
}
