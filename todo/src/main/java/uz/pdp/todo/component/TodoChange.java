package uz.pdp.todo.component;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import uz.pdp.todo.entity.Todo;
import uz.pdp.todo.event.TodoEvent;
import uz.pdp.todo.event.TodoLog;
import uz.pdp.todo.repo.TodoLogRepo;
import uz.pdp.todo.repo.TodoRepo;

@Component
@RequiredArgsConstructor
public class TodoChange {

    private final TodoLogRepo todoLogRepo;
    private final TodoRepo todoRepo;

    @EventListener
    public void handle(TodoEvent todoEvent){
        Todo todo = todoEvent.getTodo();
        TodoLog todoLog = new TodoLog();
        todoLog.setTodoId(todo.getId());
        todoLog.setName(todo.getName());
        todoLog.setStatus(todo.getStatus());
        todoLog.setNewStatus(!todo.getStatus());
        todo.setStatus(!todo.getStatus());
        todoRepo.save(todo);
        todoLogRepo.save(todoLog);
    }


}
