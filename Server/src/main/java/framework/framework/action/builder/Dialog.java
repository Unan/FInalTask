package framework.framework.action.builder;

import framework.framework.model.Action;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Dialog extends
        Tell,
        Ask,
        Redirect,
        Quit {

    List<Action> build();

}
