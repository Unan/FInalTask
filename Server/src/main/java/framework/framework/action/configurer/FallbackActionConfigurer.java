package framework.framework.action.configurer;

import framework.framework.model.Prompt;
import org.springframework.stereotype.Service;

@Service
public interface FallbackActionConfigurer {

    FallbackExceptionConfigurer repeat(Prompt prompt);

    FallbackExceptionConfigurer quit(Prompt prompt);

    FallbackExceptionConfigurer doAction(ActionConfigurer actionConfigurer);

}
