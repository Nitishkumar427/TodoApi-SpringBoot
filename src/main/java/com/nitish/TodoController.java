package com.nitish;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {
	
	public ArrayList<Todo> todoList;

	public TodoController() {
		
		todoList=new ArrayList<>();
		todoList.add(new Todo(1, 1, "Todo 1", true));
		todoList.add(new Todo(1, 2, "Todo 2", true));
		todoList.add(new Todo(2, 3, "Todo 3", false));
		todoList.add(new Todo(2, 4, "Todo 4 ", true));
		todoList.add(new Todo(3, 5, "Todo 5", false));	
		
	}
	@GetMapping("/todos")
	public ResponseEntity<List<Todo>> getTodos(@RequestParam(required = false,defaultValue = "true") Boolean  iscomplted)
	{
	    System.out.println("METHOD ENTERED");
	    System.out.println("incoming query param = " + iscomplted);

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
