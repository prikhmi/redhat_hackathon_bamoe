package com.ibm.sanction.mapper;

import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ibm.sanction.dto.PromptResponse;
import com.ibm.sanction.model.DroolsRequest;

public class DroolsMapper {

    private static final Logger LOGGER = LoggerFactory.getLogger(DroolsMapper.class);

    private DroolsMapper() {
        // Prevent instantiation
    }

    public static DroolsRequest mapFromPrompt(PromptResponse promptResponse) {
        LOGGER.debug("🔁 Mapping PromptResponse to DroolsRequest: {}", promptResponse);

        DroolsRequest request = new DroolsRequest();

        if (promptResponse != null && "Sanction".equalsIgnoreCase(promptResponse.getCategory())) {
            boolean hasText = promptResponse.getProhibition_text() != null && !promptResponse.getProhibition_text().isEmpty();

            request.setSanctionStatus(hasText);
            request.setHighlightText(promptResponse.getProhibition_text());

            LOGGER.info("✅ Sanction detected. Highlight text set with {} entries.", 
                        promptResponse.getProhibition_text() != null ? promptResponse.getProhibition_text().size() : 0);
        } else {
            request.setSanctionStatus(false);
            request.setHighlightText(Collections.emptyList());

            LOGGER.info("🚫 No Sanction detected or invalid category. Default values set.");
        }

        LOGGER.debug("📦 Mapped DroolsRequest: {}", request);
        return request;
    }
}
