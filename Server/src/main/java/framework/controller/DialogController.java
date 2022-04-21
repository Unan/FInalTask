package framework.controller;

import framework.framework.model.Action;
import framework.service.InteractionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DialogController {

    private final InteractionService interactionService;

    public DialogController(InteractionService interactionService) {
        this.interactionService = interactionService;
    }

    @PostMapping("/interact")
    public Action interact(@RequestBody Action action) {
        return interactionService.interact(action);
    }
}
