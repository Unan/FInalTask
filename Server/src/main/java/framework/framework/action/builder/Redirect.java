package framework.framework.action.builder;

import framework.framework.action.configurer.RedirectConfigurer;
import framework.framework.model.Prompt;
import org.springframework.stereotype.Service;

@Service
public interface Redirect {

    RedirectConfigurer redirect(Prompt prompt);

    RedirectConfigurer redirect();

}
