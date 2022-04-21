package framework.framework.action.configurer.impl;

import framework.framework.model.Action;
import framework.framework.model.Prompt;
import framework.framework.action.builder.Dialog;
import framework.framework.action.configurer.ActionConfigurer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public abstract class AbstractActionConfigurer implements ActionConfigurer {

    private Dialog dialog;

    private List<Prompt> prompts = new ArrayList<>();

    protected AbstractActionConfigurer(Dialog dialog) {
        this.dialog = dialog;
    }

    protected abstract String getActionName();

    @Override
    public Action buildAction() {
        return buildAction(prompts);
    }

    @Override
    public List<Action> buildActions() {
        return dialog.build();
    }

    protected Action buildDefaultAction() {
        return buildAction(Collections.emptyList());
    }

    private Action buildAction(List<Prompt> prompts) {
        Action action = new Action();
        action.setActionType(getActionName());
        action.setPrompt(prompts.get(prompts.size() - 1));
        return action;
    }

    protected void addPrompt(Prompt prompt) {
        prompts.add(prompt);
    }

    public Dialog getDialog() {
        return dialog;
    }

    public void setDialog(Dialog dialog) {
        this.dialog = dialog;
    }

    public List<Prompt> getPrompts() {
        return prompts;
    }

    public void setPrompts(List<Prompt> prompts) {
        this.prompts = prompts;
    }
}
