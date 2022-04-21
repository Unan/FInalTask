package framework.framework.action.configurer;

import framework.framework.action.builder.Quit;
import framework.framework.action.builder.Ask;
import framework.framework.action.builder.Tell;
import framework.framework.action.builder.Redirect;
import org.springframework.stereotype.Service;

@Service
public interface TellConfigurer extends Tell, Ask, Quit, Redirect, ActionConfigurer {

}
