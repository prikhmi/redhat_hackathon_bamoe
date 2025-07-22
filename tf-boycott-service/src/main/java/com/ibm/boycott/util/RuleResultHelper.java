package com.ibm.boycott.util;

import java.util.ArrayList;
import java.util.List;

import com.ibm.boycott.model.LcEvaluationResult;

public class RuleResultHelper {

    public static void setValues(LcEvaluationResult result, String name, String status, String validationMessage, String referenceData) {
        setValues(result, name, status, validationMessage, referenceData, null);
    }

    public static void setValues(LcEvaluationResult result, String name, String status, String validationMessage, String referenceData, String highText) {
        if (result == null) {
            return;
        }

        result.setName(name);
        result.setStatus(status);
        result.setValidationMessage("Comment : " + validationMessage);
        result.setReferenceData(referenceData);

        if (highText != null && !highText.isEmpty()) {
            List<String> highlights = new ArrayList<>();
            highlights.add(highText);
            result.setHighLightedTexts(highlights);
        }
    }
}

