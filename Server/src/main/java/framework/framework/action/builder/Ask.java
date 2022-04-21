package framework.framework.action.builder;

import framework.framework.action.configurer.AskConfigurer;
import framework.framework.model.Prompt;
import org.springframework.stereotype.Service;

@Service
public interface Ask {

    AskConfigurer ask(Prompt prompt);

}
