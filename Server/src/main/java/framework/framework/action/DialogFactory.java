package framework.framework.action;

import framework.framework.action.builder.Dialog;
import framework.framework.action.configurer.*;
import framework.framework.action.configurer.service.AskConfigurerService;
import framework.framework.action.configurer.service.QuitConfigurerService;
import framework.framework.action.configurer.service.RedirectConfigurerService;
import framework.framework.action.configurer.service.TellConfigurerService;
import framework.framework.model.Action;
import framework.framework.model.Prompt;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DialogFactory {

    private final AskConfigurerService askConfigurerService;

    private final TellConfigurerService tellConfigurerService;

    private final QuitConfigurerService quitConfigurerService;

    private final RedirectConfigurerService redirectConfigurerService;

    public DialogFactory(AskConfigurerService askConfigurerService,
                         TellConfigurerService tellConfigurerService,
                         QuitConfigurerService quitConfigurerService,
                         RedirectConfigurerService redirectConfigurerService
    ) {
        this.askConfigurerService = askConfigurerService;
        this.tellConfigurerService = tellConfigurerService;
        this.quitConfigurerService = quitConfigurerService;
        this.redirectConfigurerService = redirectConfigurerService;
    }

    public Dialog builder() {
        return new DialogImpl();
    }

    public class DialogImpl implements Dialog {

        private List<ActionConfigurer> configurers = new ArrayList<>();

        @Override
        public AskConfigurer ask(Prompt prompt) {
            return register(askConfigurerService.configurer(this, DialogFactory.this, prompt));
        }

        @Override
        public QuitConfigurer quit(Prompt prompt) {
            return register(quitConfigurerService.configurer(this, prompt));
        }

        @Override
        public TellConfigurer tell(Prompt prompt) {
            return register(tellConfigurerService.configurer(this, prompt));
        }

        @Override
        public RedirectConfigurer redirect(Prompt prompt) {
            return register(redirectConfigurerService.configurer(this, prompt));
        }

        @Override
        public RedirectConfigurer redirect() {
            return register(redirectConfigurerService.configurer(this));
        }

        @Override
        public List<Action> build() {
            return configurers.stream()
                    .map(ActionConfigurer::buildAction)
                    .collect(Collectors.toList());
        }

        private <T extends ActionConfigurer> T register(T configurer) {
            configurers.add(configurer);
            return configurer;
        }
    }
}
