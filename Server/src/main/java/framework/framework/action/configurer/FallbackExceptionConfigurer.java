package framework.framework.action.configurer;

import framework.framework.model.Prompt;
import org.springframework.stereotype.Service;

@Service
public interface FallbackExceptionConfigurer extends ActionConfigurer {

    FallbackActionConfigurer onNoInput();

    FallbackActionConfigurer onUnclearInput();

    FallbackActionConfigurer onMaxRetries();

    FallbackExceptionConfigurer repeat(Prompt prompt);

    FallbackExceptionConfigurer quit(Prompt prompt);

    FallbackExceptionConfigurer redirectOnMaxRetries(RedirectConfigurer redirectConfigurer);
}
