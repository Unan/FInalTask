package framework.framework.action.configurer.service;

import framework.framework.action.configurer.FallbackExceptionConfigurer;
import framework.framework.model.Action;
import framework.framework.model.Prompt;
import framework.framework.action.DialogFactory;
import framework.framework.action.builder.Dialog;
import framework.framework.action.configurer.AskConfigurer;
import framework.framework.action.configurer.impl.AbstractActionConfigurer;
import org.springframework.stereotype.Service;

@Service
public class AskConfigurerService{

    private final FallbackConfigurerService fallbackConfigurerService;

    public AskConfigurerService(FallbackConfigurerService fallbackConfigurerService) {
        this.fallbackConfigurerService = fallbackConfigurerService;
    }

    public AskConfigurer configurer(Dialog dialog,
                                    DialogFactory dialogFactory,
                                    Prompt prompt) {

        return new AskConfigurerImpl(dialog, dialogFactory, prompt).withPrompt(prompt);
    }

    public class AskConfigurerImpl extends AbstractActionConfigurer implements AskConfigurer {

        private DialogFactory dialogFactory;

        private Prompt prompt;

        private FallbackExceptionConfigurer fallbackConfigurer;

        private AskConfigurerImpl(Dialog dialog,
                                  DialogFactory dialogFactory,
                                  Prompt prompt
        ) {
            super(dialog);
            this.dialogFactory = dialogFactory;
            this.prompt = prompt;
        }

        @Override
        protected String getActionName() {
            return "playAndDetect";
        }

        @Override
        public Action buildAction() {
            return super.buildAction();
        }

        private AskConfigurer withPrompt(Prompt prompt) {
            super.addPrompt(prompt);
            return this;
        }

        @Override
        public FallbackExceptionConfigurer fallback() {
            return fallbackConfigurerService.configurer(getDialog(), dialogFactory, prompt, getActionName());
        }
    }
}
