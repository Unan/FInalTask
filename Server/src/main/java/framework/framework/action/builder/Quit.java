package framework.framework.action.builder;

import framework.framework.action.configurer.QuitConfigurer;
import framework.framework.model.Prompt;
import org.springframework.stereotype.Service;

@Service
public interface Quit {

    QuitConfigurer quit(Prompt prompt);

}
