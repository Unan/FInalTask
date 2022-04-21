package framework.framework.action.configurer;

import framework.framework.model.Action;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ActionConfigurer {

    Action buildAction();

    List<Action> buildActions();

}
