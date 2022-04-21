package framework.service;

import framework.framework.action.DialogFactory;
import framework.framework.model.Action;
import org.springframework.stereotype.Service;

import static framework.framework.model.Prompt.prompt;

@Service
public class InteractionService {

    public static final String UNCLEAR_INPUT_REDIRECT = "Sorry I didn't get that, but I'll transfer you to someone who can";

    private final DialogFactory dialogFactory;

    public InteractionService(DialogFactory dialogFactory) {
        this.dialogFactory = dialogFactory;
    }

    public Action interact(Action action) {

        if (action.getContext().isEmpty()) {
            return dialogFactory.builder()
                    .ask(prompt("Hi how can I help you?"))
                    .fallback()
                    .repeat(prompt("Hi how can I help you?"))
                    .buildAction();
        }

        if (action.getActionType().equals("question")) {
            return dialogFactory.builder()
                    .tell(prompt("SSU founded in June 10, 1909"))
                    .ask(prompt("Anything else?"))
                    .fallback()
                    .onUnclearInput()
                    .repeat(prompt("Anything else?"))
                    .buildAction();
        }

        if (action.getErrors().contains("unclearInput")) {
            return dialogFactory.builder()
                    .tell(prompt(UNCLEAR_INPUT_REDIRECT))
                    .redirect()
                    .extension("99")
                    .destinationType("person")
                    .destinationName("contact center")
                    .buildAction();
        }

        if (action.getErrors().contains("noInput")
                && action.getContext().contains("greeting")) {
            return dialogFactory.builder()
                    .quit(prompt("Feel free to contact me again. Goodbye!"))
                    .buildAction();
        }

        return dialogFactory.builder()
                .tell(prompt("Sorry I can't help you with that"))
                .tell(prompt("I'll transfer you to someone who can help"))
                .redirect(action.getPrompt())
                .buildAction();
    }
}
