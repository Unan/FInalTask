package framework.framework.action.configurer.service;

import framework.framework.model.Prompt;
import framework.framework.action.builder.Dialog;
import framework.framework.action.configurer.AskConfigurer;
import framework.framework.action.configurer.QuitConfigurer;
import framework.framework.action.configurer.TellConfigurer;
import framework.framework.action.configurer.RedirectConfigurer;
import framework.framework.action.configurer.impl.AbstractActionConfigurer;
import org.springframework.stereotype.Service;

@Service
public class TellConfigurerService {

    public TellConfigurer configurer(Dialog dialog, Prompt prompt) {
        return new TellConfigurerImpl(dialog).withPrompt(prompt);
    }

    public class TellConfigurerImpl extends AbstractActionConfigurer implements TellConfigurer {

        private TellConfigurerImpl(Dialog dialog) {
            super(dialog);
        }

        @Override
        public AskConfigurer ask(Prompt prompt) {
            return getDialog()
                    .ask(prompt);
        }

        @Override
        public QuitConfigurer quit(Prompt prompt) {
            return getDialog()
                    .quit(prompt);
        }

        @Override
        public TellConfigurer tell(Prompt prompt) {
            return getDialog()
                    .tell(prompt);
        }

        @Override
        public RedirectConfigurer redirect(Prompt prompt) {
            return getDialog()
                    .redirect(prompt);
        }

        @Override
        public RedirectConfigurer redirect() {
            return getDialog()
                    .redirect();
        }

        @Override
        protected String getActionName() {
            return "playback";
        }

        private TellConfigurer withPrompt(Prompt prompt) {
            super.addPrompt(prompt);
            return this;
        }
    }
}
