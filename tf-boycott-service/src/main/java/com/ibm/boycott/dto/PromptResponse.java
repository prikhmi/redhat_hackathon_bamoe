package com.ibm.boycott.dto;

import java.util.List;

public class PromptResponse {
    private String category;
    private List<String> prohibition_text;

    public PromptResponse() {}

    public PromptResponse(String category, List<String> prohibition_text) {
        this.category = category;
        this.prohibition_text = prohibition_text;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<String> getProhibition_text() {
        return prohibition_text;
    }

    public void setProhibition_text(List<String> prohibition_text) {
        this.prohibition_text = prohibition_text;
    }
}
