package uz.pdp.todo.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.todo.entity.Todo;
import uz.pdp.todo.event.TodoLog;

import java.util.UUID;

public interface TodoLogRepo extends JpaRepository<TodoLog, UUID> {
}
