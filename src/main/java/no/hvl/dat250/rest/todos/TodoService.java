package no.hvl.dat250.rest.todos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TodoService {


    private final Map<Long, Todo> todoMap = new HashMap();

    private Long idCount = 0L;

    public List<Todo> getAllTodos() {
        return todoMap.values().stream().toList();
    }

    public Todo insertTodo(Todo todo) {
        todo.setId(idCount++);
        todoMap.put(todo.getId(), todo);
        return todoMap.get(todo.getId());
    }

    public Todo getTodo(Long id) {
        return todoMap.get(id);
    }

    public Todo delete(Long id) {
        if (!todoMap.containsKey(id)) {
            return null;
        }
        return todoMap.remove(id);
    }

    public Todo updateTodo(Long id, Todo todo) {
        if (!todoMap.containsKey(id)) {
            return null;
        }
        Todo old = todoMap.get(id);
        old.setSummary(todo.getSummary());
        old.setDescription(todo.getDescription());
        return old;
    }
}
