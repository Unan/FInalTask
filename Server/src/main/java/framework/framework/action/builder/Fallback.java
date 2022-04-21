package framework.framework.action.builder;

import framework.framework.action.configurer.FallbackExceptionConfigurer;
import org.springframework.stereotype.Service;

@Service
public interface Fallback {

    FallbackExceptionConfigurer fallback();

}
