package framework.service;

import framework.framework.model.Action;
import framework.framework.model.Prompt;

public class ResponseService {

    public Action interact(Action action) {

        if (action.getContext().isEmpty()) {
            Action actionResponse = new Action();
            Prompt prompt = new Prompt("Hi how can I help you?");
            actionResponse.setPrompt(prompt);
            Action fallbackAction = new Action();
            Prompt fallbackPrompt = new Prompt("I'll repeat my question");
            fallbackAction.setPrompt(fallbackPrompt);
            fallbackAction.getErrors().add("unclear input");
            actionResponse.setActionType("playAndDetect");
            actionResponse.getContext().add(fallbackAction);
            return actionResponse;
        }

        //...

        Action actionResponse = new Action();
        Prompt prompt = new Prompt("Sorry I can't help you with that");
        actionResponse.setPrompt(prompt);
        Action redirectAction = new Action();
        redirectAction.setActionType("redirect");
        Prompt redirectPrompt = new Prompt("I'll transfer you to someone who can help");
        redirectAction.setPrompt(redirectPrompt);
        actionResponse.setPrompt(prompt);
        actionResponse.getContext().add(redirectAction);
        return actionResponse;
    }
}
