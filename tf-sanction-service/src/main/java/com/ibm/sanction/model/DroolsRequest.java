package com.ibm.sanction.model;

import java.util.List;

public class DroolsRequest {
    private boolean sanctionStatus;
    private List<String> highlightText;

    public boolean isSanctionStatus() {
        return sanctionStatus;
    }

    public void setSanctionStatus(boolean sanctionStatus) {
        this.sanctionStatus = sanctionStatus;
    }

    public List<String> getHighlightText() {
        return highlightText;
    }

    public void setHighlightText(List<String> highlightText) {
        this.highlightText = highlightText;
    }

    @Override
    public String toString() {
        return "DroolsRequest [sanctionStatus=" + sanctionStatus + ", highlightText=" + highlightText + "]";
    }

}
