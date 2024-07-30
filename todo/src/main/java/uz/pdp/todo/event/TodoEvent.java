package uz.pdp.todo.event;


import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import uz.pdp.todo.entity.Todo;
@Getter
public class TodoEvent extends ApplicationEvent {

    private final Todo todo;

    public TodoEvent(Object source, Todo todo) {
        super(source);
        this.todo = todo;
    }
    

}
