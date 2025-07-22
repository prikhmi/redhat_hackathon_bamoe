package com.ibm.boycott.dto;

public class PromptRequest {
    private String p_text;
    private String p_context;
    private String p_category;

    public PromptRequest() {}

    public PromptRequest(String p_text, String p_context, String p_category) {
        this.p_text = p_text;
        this.p_context = p_context;
        this.p_category = p_category;
    }

    public String getP_text() {
        return p_text;
    }

    public void setP_text(String p_text) {
        this.p_text = p_text;
    }

    public String getP_context() {
        return p_context;
    }

    public void setP_context(String p_context) {
        this.p_context = p_context;
    }

    public String getP_category() {
        return p_category;
    }

    public void setP_category(String p_category) {
        this.p_category = p_category;
    }
}
