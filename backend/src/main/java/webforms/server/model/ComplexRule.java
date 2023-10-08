package webforms.server.model;

import java.util.List;

public class ComplexRule {
    private String type; // "AND" ou "OR" pour l'opérateur logique
    private List<Condition> conditions;

    public ComplexRule() {
    }

    public ComplexRule(String type, List<Condition> conditions) {
        this.type = type;
        this.conditions = conditions;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Condition> getConditions() {
        return conditions;
    }

    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }
}

