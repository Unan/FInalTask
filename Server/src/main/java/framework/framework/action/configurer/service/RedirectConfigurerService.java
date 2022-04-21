package framework.framework.action.configurer.service;

import framework.framework.action.builder.Dialog;
import framework.framework.action.configurer.RedirectConfigurer;
import framework.framework.action.configurer.impl.AbstractActionConfigurer;
import framework.framework.model.Action;
import framework.framework.model.Prompt;
import org.springframework.stereotype.Service;

@Service
public class RedirectConfigurerService {

    public RedirectConfigurer configurer(Dialog dialog, Prompt prompt) {
        return new RedirectConfigurerImpl(dialog).transferPrompt(prompt);
    }

    public RedirectConfigurer configurer(Dialog dialog) {
        return new RedirectConfigurerImpl(dialog);
    }

    public class RedirectConfigurerImpl extends AbstractActionConfigurer implements RedirectConfigurer {

        private static final String REDIRECT_MESSAGE_TEMPLATE = "Redirect to destination: %s, type: %s, extension: %s";

        private String extension;

        private String destinationName;

        private String destinationType;

        private RedirectConfigurerImpl(Dialog dialog) {
            super(dialog);
        }

        @Override
        public RedirectConfigurer extension(String extension) {
            this.extension = extension;
            return this;
        }

        @Override
        public RedirectConfigurer destinationName(String destinationName) {
            this.destinationName = destinationName;
            return this;
        }

        @Override
        public RedirectConfigurer destinationType(String destinationType) {
            this.destinationType = destinationType;
            return this;
        }

        @Override
        public Action buildAction() {
            String message = String.format(REDIRECT_MESSAGE_TEMPLATE, destinationName, destinationType, extension);
            Action action = getPrompts().isEmpty() ? buildDefaultAction() : super.buildAction();
            action.getErrors().add(message);
            return action;
        }

        @Override
        protected String getActionName() {
            return "transfer";
        }

        protected RedirectConfigurerImpl transferPrompt(Prompt prompt) {
            super.addPrompt(prompt);
            return this;
        }
    }
}
