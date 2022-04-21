package framework.framework.action.builder;

import framework.framework.action.configurer.TellConfigurer;
import framework.framework.model.Prompt;
import org.springframework.stereotype.Service;

@Service
public interface Tell {

    TellConfigurer tell(Prompt prompt);

}
