package no.hvl.dat250.rest.todos;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Rest-Endpoint for todos.
 */
@RestController
@RequestMapping("/todos")
public class TodoController {

  public static final String TODO_WITH_THE_ID_X_NOT_FOUND = "Todo with the id %s not found!";

  public final TodoService service = new TodoService();

  @GetMapping
  public List<Todo> getAllTodos() {
    return service.getAllTodos();
  }

  @PostMapping
  public Todo insertTodo(@RequestBody Todo todo) {
    return service.insertTodo(todo);
  }

  @GetMapping("/{id}")
  public Todo getTodo(@PathVariable Long id) {
    Todo t = service.getTodo(id);
    if (t == null) {
      throw new RuntimeException(TODO_WITH_THE_ID_X_NOT_FOUND.formatted(id));
    }
    return t;
  }

  @DeleteMapping("/{id}")
  public Todo deleteTodo(@PathVariable Long id) {
    Todo t = service.delete(id);
    if (t == null) {
      throw new RuntimeException(TODO_WITH_THE_ID_X_NOT_FOUND.formatted(id));
    }
    return t;
  }

  @PutMapping("/{id}")
  public Todo updateTodo(@PathVariable Long id, @RequestBody Todo todo) {
    Todo t = service.updateTodo(id, todo);
    if (t == null) {
      throw new RuntimeException(TODO_WITH_THE_ID_X_NOT_FOUND.formatted(id));
    }
    return t;
  }
}
