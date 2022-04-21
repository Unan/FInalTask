package framework.framework.action.configurer.service;

import framework.framework.action.DialogFactory;
import framework.framework.action.configurer.ActionConfigurer;
import framework.framework.action.configurer.RedirectConfigurer;
import framework.framework.action.configurer.impl.AbstractActionConfigurer;
import framework.framework.action.builder.Dialog;
import framework.framework.action.configurer.FallbackActionConfigurer;
import framework.framework.action.configurer.FallbackExceptionConfigurer;
import framework.framework.model.Action;
import framework.framework.model.Prompt;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static framework.framework.model.Prompt.*;

@Service
public class FallbackConfigurerService {

    public FallbackExceptionConfigurer configurer(Dialog dialog,
                                                  DialogFactory dialogFactory,
                                                  Prompt prompt,
                                                  String fallbackActionName
    ) {
        return new FallbackExceptionConfigurerImpl(dialog, dialogFactory, fallbackActionName).withPrompt(prompt);
    }

    public class FallbackExceptionConfigurerImpl extends AbstractActionConfigurer implements FallbackExceptionConfigurer {

        private DialogFactory dialogFactory;

        private Map<String, List<Action>> fallbackActions = new HashMap<>();

        private String fallbackActionName;

        public FallbackExceptionConfigurerImpl(Dialog dialog, DialogFactory dialogFactory, String fallbackActionName) {
            super(dialog);
            this.fallbackActionName = fallbackActionName;
            this.dialogFactory = dialogFactory;
        }

        @Override
        public FallbackActionConfigurer onNoInput() {
            return new FallbackActionConfigurerImpl("no input");
        }

        @Override
        public FallbackActionConfigurer onUnclearInput() {
            return new FallbackActionConfigurerImpl("unclear input");
        }

        @Override
        public FallbackActionConfigurer onMaxRetries() {
            return new FallbackActionConfigurerImpl("max retries");
        }

        @Override
        public FallbackExceptionConfigurer repeat(Prompt prompt) {
            return onNoInput()
                    .repeat(prompt)
                    .onUnclearInput()
                    .repeat(prompt);
        }

        @Override
        public FallbackExceptionConfigurer quit(Prompt prompt) {
            return onNoInput()
                    .quit(prompt)
                    .onUnclearInput()
                    .quit(prompt);
        }

        @Override
        public FallbackExceptionConfigurer redirectOnMaxRetries(RedirectConfigurer redirectConfigurer) {
            return onMaxRetries()
                    .doAction(redirectConfigurer);
        }

        @Override
        protected String getActionName() {
            return fallbackActionName;
        }

        private FallbackExceptionConfigurer withPrompt(Prompt prompt) {
            addPrompt(prompt);
            return this;
        }

        public class FallbackActionConfigurerImpl implements FallbackActionConfigurer {

            private String exceptionType;

            public FallbackActionConfigurerImpl(String exceptionType) {
                this.exceptionType = exceptionType;
            }

            @Override
            public FallbackExceptionConfigurer repeat(Prompt prompt) {
                fallbackActions.put(exceptionType,
                        dialogFactory.builder()
                                .tell(prompt("I'll repeat my question"))
                                .ask(prompt)
                                .buildActions());
                return FallbackExceptionConfigurerImpl.this;
            }

            @Override
            public FallbackExceptionConfigurer quit(Prompt prompt) {
                fallbackActions.put(exceptionType,
                        dialogFactory.builder()
                                .quit(prompt)
                                .buildActions());
                return FallbackExceptionConfigurerImpl.this;
            }

            @Override
            public FallbackExceptionConfigurer doAction(ActionConfigurer actionConfigurer) {
                fallbackActions.put(exceptionType, actionConfigurer.buildActions());
                return FallbackExceptionConfigurerImpl.this;
            }
        }
    }

}
