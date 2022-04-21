package framework.framework.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class Action implements Serializable {

    private Prompt prompt;

    private String actionType;

    private List<Action> context;

    private List<String> errors;

    private Redirect redirect;

    public Action() {
        this.context = Collections.emptyList();
        this.errors = Collections.emptyList();
    }

    public Action(Prompt prompt, String actionType, List<Action> context, List<String> errors) {
        this.prompt = prompt;
        this.actionType = actionType;
        this.context = context;
        this.errors = errors;
    }

    @Override
    public String toString() {
        return "Action{" +
                "prompt=" + prompt +
                ", actionType='" + actionType + '\'' +
                ", context=" + context +
                ", errors=" + errors +
                '}';
    }

    public Prompt getPrompt() {
        return prompt;
    }

    public void setPrompt(Prompt prompt) {
        this.prompt = prompt;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public List<Action> getContext() {
        return context;
    }

    public void setContext(List<Action> context) {
        this.context = context;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
