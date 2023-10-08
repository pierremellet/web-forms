package webforms.server.model;

import java.util.List;

public class Rule {
    private Condition condition;
    private String targetField;
    private String action;

    public Rule() {
    }

    public Rule(Condition condition, String targetField, String action) {
        this.condition = condition;
        this.targetField = targetField;
        this.action = action;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public String getTargetField() {
        return targetField;
    }

    public void setTargetField(String targetField) {
        this.targetField = targetField;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
