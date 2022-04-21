package framework.framework.action.configurer;

import org.springframework.stereotype.Service;

@Service
public interface RedirectConfigurer extends ActionConfigurer{

    RedirectConfigurer extension(String extension);

    RedirectConfigurer destinationName(String destinationName);

    RedirectConfigurer destinationType(String destinationType);

}
