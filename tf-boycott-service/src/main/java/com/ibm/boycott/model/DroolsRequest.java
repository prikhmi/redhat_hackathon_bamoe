package com.ibm.boycott.model;

import java.util.List;

public class DroolsRequest {
    private boolean boycottStatus;

    private List<String> highlightText;

    public List<String> getHighlightText() {
        return highlightText;
    }

    public void setHighlightText(List<String> highlightText) {
        this.highlightText = highlightText;
    }

    public boolean isBoycottStatus() {
        return boycottStatus;
    }

    public void setBoycottStatus(boolean boycottStatus) {
        this.boycottStatus = boycottStatus;
    }

    @Override
    public String toString() {
        return "DroolsRequest [boycottStatus=" + boycottStatus + ", highlightText=" + highlightText + "]";
    }

}
