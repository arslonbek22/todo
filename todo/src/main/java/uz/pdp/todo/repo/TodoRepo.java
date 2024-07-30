package uz.pdp.todo.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.todo.entity.Todo;

import java.util.UUID;

public interface TodoRepo extends JpaRepository<Todo, UUID> {
}
