package uz.pdp.todo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import uz.pdp.todo.entity.Todo;
import uz.pdp.todo.repo.TodoRepo;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepo todoRepo;

    public List<Todo> getAll() {
        return todoRepo.findAll();
    }

    public void save(String title) {
        Todo todo = Todo.builder().name(title).status(false).build();
        todoRepo.save(todo);
    }



}
