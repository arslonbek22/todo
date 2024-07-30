package uz.pdp.todo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.pdp.todo.entity.Todo;
import uz.pdp.todo.service.TodoService;

import java.util.List;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping
    public String home(Model model) {
        List<Todo>  todo = todoService.getAll();
        model.addAttribute("todos", todo);
        return "home";
    }

    @PostMapping
    public String create(@RequestParam String title) {

        todoService.save(title);
        return "redirect:/";
    }

    @GetMapping("/addTodo")
    public String addTodo() {
        return "add-todo";
    }
}
