package com.nitish;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {
	
	public ArrayList<Todo> todoList;

	public TodoController() {
		
		todoList=new ArrayList<>();
		todoList.add(new Todo(1, 1, "delectus aut autem", false));
		todoList.add(new Todo(1, 2, "quis ut nam facilis et officia qui", true));
		todoList.add(new Todo(2, 3, "fugiat veniam minus", false));
		todoList.add(new Todo(2, 4, "et porro tempora", true));
		todoList.add(new Todo(3, 5, "laboriosam mollitia et enim quasi adipisci", false));	
		
	}
	@GetMapping("/todos")
	public ResponseEntity<List<Todo>> getTodos()
	{
		return ResponseEntity.ok(todoList);
	}
	
	@PostMapping("/todos")
	public ResponseEntity<Todo> createTodo(@RequestBody Todo newTodo)
	{
		todoList.add(newTodo);
		return ResponseEntity.status(HttpStatus.CREATED).body(newTodo) ;
	}
	
	
	@GetMapping("/todos/{todoId}")
	public ResponseEntity<Todo> getTodoById(@PathVariable Integer todoId) { 
	    for (Todo todo : todoList) {
	        if (todo.getId().equals(todoId)) { 
	            return ResponseEntity.ok(todo);
	        }
	    }
	    return ResponseEntity.notFound().build(); 
	}

	
	
	

}
