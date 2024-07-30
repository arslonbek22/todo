package uz.pdp.todo.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import uz.pdp.todo.entity.Todo;
import uz.pdp.todo.event.TodoEvent;
import uz.pdp.todo.repo.TodoRepo;
import uz.pdp.todo.service.TodoService;

import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/status")
@RequiredArgsConstructor
public class ChangeStatusTodoController {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    private final TodoRepo todoRepo;


    @PostMapping("{id}")
    public String changeStatus(@PathVariable UUID id) {
        System.out.println(id);
        Optional<Todo> byId = todoRepo.findById(id);
        if (byId.isPresent()) {
            Todo todo = byId.get();
            eventPublisher.publishEvent(new TodoEvent(this, todo));
        }
        return "redirect:/";
    }

}
