package framework.framework.action.configurer;

import framework.framework.action.builder.Fallback;
import org.springframework.stereotype.Service;

@Service
public interface AskConfigurer extends ActionConfigurer, Fallback {

}
