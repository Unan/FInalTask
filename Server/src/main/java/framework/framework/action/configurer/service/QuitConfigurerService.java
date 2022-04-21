package framework.framework.action.configurer.service;

import framework.framework.action.builder.Dialog;
import framework.framework.action.configurer.QuitConfigurer;
import framework.framework.action.configurer.impl.AbstractActionConfigurer;
import framework.framework.model.Prompt;
import org.springframework.stereotype.Service;

@Service
public class QuitConfigurerService {

    public QuitConfigurer configurer(Dialog dialog, Prompt prompt) {
        return new QuitConfigurerImpl(dialog).withPrompt(prompt);
    }

    public class QuitConfigurerImpl extends AbstractActionConfigurer implements QuitConfigurer {
        private QuitConfigurerImpl(Dialog dialog) {
            super(dialog);
        }

        @Override
        protected String getActionName() {
            return "quit";
        }

        private QuitConfigurer withPrompt(Prompt prompt) {
            super.addPrompt(prompt);
            return this;
        }
    }

}
